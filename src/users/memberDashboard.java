/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package users;

import java.sql.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class memberDashboard extends javax.swing.JFrame {

    /**
     * Creates new form memberDashboard
     */
    public memberDashboard(String email) {
    this.email = email;
    initComponents();
    loadReservations();
    loadBorrowedBooks();
    loadUpcomingDues();
    loadTotalFines();
    fetchBooks(userId);
    loadToTables("ORDER BY ");
}


    public void fetchBooks(int userId) {
    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    String query1 = """
        SELECT b.title, br.due_date, br.return_date, br.fine, br.isPaid
        FROM borrow_records br 
        JOIN books b ON b.book_id = br.book_id 
        WHERE br.user_id = ?;
    """;

    String query2 = """
        SELECT b.title, br.borrow_date, br.due_date 
        FROM borrow_records br 
        JOIN books b ON b.book_id = br.book_id 
        WHERE br.user_id = ? AND br.return_date IS NULL;
    """;

    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement stmt1 = conn.prepareStatement(query1);
         PreparedStatement stmt2 = conn.prepareStatement(query2)) {

        stmt1.setInt(1, userId);
        stmt2.setInt(1, userId);

        try (ResultSet rs = stmt1.executeQuery()) {
            DefaultTableModel model = (DefaultTableModel) borrowedBookList1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                        rs.getString("title"),
                        rs.getDate("due_date"),
                        rs.getDate("return_date"),
                        rs.getFloat("fine"),
                        rs.getString("isPaid")
                };
                model.addRow(row);
            }
        }

        try (ResultSet rs = stmt2.executeQuery()) {
            DefaultTableModel model = (DefaultTableModel) borrowedBookList.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                        rs.getString("title"),
                        rs.getDate("borrow_date"),
                        rs.getDate("due_date")
                };
                model.addRow(row);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    borrowedBookList.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            LocalDate today = LocalDate.now();
            LocalDate dueDate = ((java.sql.Date) model.getValueAt(row, 2)).toLocalDate();
            long diff = ChronoUnit.DAYS.between(today, dueDate);

            if (diff >= 3) {
                cell.setForeground(Color.GREEN);
            } else if (diff < 3 && diff >= 0) {
                cell.setForeground(Color.YELLOW);
            } else {
                cell.setForeground(Color.RED);
            }
            return cell;
        }
    });
}

    
    public String userName(String email) {
        String query = "SELECT user_id, name FROM users WHERE email = ?";
        String name = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");
                userId = rs.getInt("user_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
    
    
    
    public void updateUserReservations() {
    DefaultListModel<String> listModel = new DefaultListModel<>(); // Model for JList

    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    String query = "SELECT b.title FROM reservations r " +
               "JOIN books b ON r.book_id = b.book_id " +
               "JOIN users u ON r.user_id = u.user_id " +
               "WHERE u.email = ? AND r.status = 'Confirmed'";

    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setString(1, email); // Use stored email directly
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            listModel.addElement(rs.getString("title")); // Add book title to list
        }

        reservationList.setModel(listModel); // Update JList

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading reservations: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    
    public void loadToTables(String sortBy) {
        DefaultTableModel model = (DefaultTableModel) browseTable.getModel();
        model.setRowCount(0);
        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "";
        String validSortColumn;
        switch (sortBy.toLowerCase()) {
            case "title":
            case "author":
            case "genre":
            case "publication_year":
            case "location":
                validSortColumn = sortBy;
                break;
            default:
                validSortColumn = "title"; 
        }

        String fetchBooksSql = "SELECT b.title, b.author, b.genre, b.publication_year, b.location FROM books b ORDER BY " + validSortColumn;

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(fetchBooksSql)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("genre"),
                    rs.getInt("publication_year"),
                    rs.getString("location")
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error refreshing book list: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void loadMostBorrowedBooks() {
        DefaultTableModel model = (DefaultTableModel) browseTable.getModel();
        model.setRowCount(0);

        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "";

        String fetchMostBorrowedSql = 
            "SELECT b.title, b.author, b.genre, b.publication_year, b.location, " +
            "(SELECT COUNT(br.book_id) FROM borrow_records br WHERE br.book_id = b.book_id) AS borrow_count " +
            "FROM books b " +
            "JOIN borrow_records br ON b.book_id = br.book_id " +
            "GROUP BY b.book_id, b.title, b.author, b.genre, b.publication_year, b.location " +
            "ORDER BY borrow_count DESC";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(fetchMostBorrowedSql)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("genre"),
                    rs.getInt("publication_year"),
                    rs.getString("location")
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading most borrowed books: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void searchAndSort(String searchText, String sortBy) {
        DefaultTableModel model = (DefaultTableModel) browseTable.getModel();
        model.setRowCount(0); // Clear the table before searching

        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "";

        // Validate and sanitize sortBy to prevent SQL Injection
        String validSortColumn;
        switch (sortBy.toLowerCase()) {
            case "title":
            case "author":
            case "genre":
            case "publication_year":
            case "location":
                validSortColumn = sortBy;
                break;
            default:
                validSortColumn = "title"; // Default sorting column
        }

        // SQL query to search books and sort results
        String searchQuery = "SELECT title, author, genre, publication_year, location FROM books " +
                             "WHERE title LIKE ? OR author LIKE ? OR genre LIKE ? " +
                             "ORDER BY " + validSortColumn;

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pst = conn.prepareStatement(searchQuery)) {

            String searchPattern = "%" + searchText.trim() + "%";
            pst.setString(1, searchPattern);
            pst.setString(2, searchPattern);
            pst.setString(3, searchPattern);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getInt("publication_year"), // Use getInt() for better handling
                        rs.getString("location")
                    });
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching books: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void searchAndSortWithDate(String searchText, String sortBy, Date fromDate, Date toDate) {
        DefaultTableModel model = (DefaultTableModel) browseTable.getModel();
        model.setRowCount(0);

        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "";

        String validSortColumn;
        switch (sortBy.toLowerCase()) {
            case "title":
            case "author":
            case "genre":
            case "publication_year":
            case "location":
                validSortColumn = sortBy;
                break;
            default:
                validSortColumn = "title";
        }

        String searchQuery = "SELECT b.title, b.author, b.genre, b.publication_year, b.location " +
                             "FROM books b " +
                             "LEFT JOIN reservations r ON b.book_id = r.book_id " +
                             "WHERE (title LIKE ? OR author LIKE ? OR genre LIKE ?) " +
                             "AND (r.status = 'available' OR r.reservation_id IS NULL " +
                             "     OR NOT (r.reservation_date <= ? AND r.reservation_end_date >= ?)) " +
                             "ORDER BY " + validSortColumn;

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pst = conn.prepareStatement(searchQuery)) {

            String searchPattern = "%" + searchText.trim() + "%";
            pst.setString(1, searchPattern);
            pst.setString(2, searchPattern);
            pst.setString(3, searchPattern);

            java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
            java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());

            pst.setDate(4, sqlToDate);
            pst.setDate(5, sqlFromDate);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getInt("publication_year"),
                        rs.getString("location")
                    });
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error searching books: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void insertReservation(int userId, String title, String author, String genre, java.sql.Date reservationDate, java.sql.Date reservationEndDate) {
        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "";

        String getBookIdQuery = "SELECT book_id FROM books WHERE title = ? AND author = ? AND genre = ?";
        String insertReservationQuery = "INSERT INTO reservations (user_id, book_id, reservation_date, reservation_end_date, status) VALUES (?, ?, ?, ?, 'Pending')";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement getBookStmt = conn.prepareStatement(getBookIdQuery);
             PreparedStatement insertReservationStmt = conn.prepareStatement(insertReservationQuery)) {

            getBookStmt.setString(1, title);
            getBookStmt.setString(2, author);
            getBookStmt.setString(3, genre);

            ResultSet rs = getBookStmt.executeQuery();

            if (rs.next()) {
                int bookId = rs.getInt("book_id");

                insertReservationStmt.setInt(1, userId);
                insertReservationStmt.setInt(2, bookId);
                insertReservationStmt.setDate(3, reservationDate);
                insertReservationStmt.setDate(4, reservationEndDate);

                int rowsAffected = insertReservationStmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Reservation successfully added!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to insert reservation.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Book not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inserting reservation: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        welcomeMsg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservationList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        borrowedList = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        upcomingDues = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        finesField = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        browseTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        sortByBox = new javax.swing.JComboBox<>();
        reserveButton = new javax.swing.JButton();
        toDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        borrowedBookList = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        borrowedBookList1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MEMBER DASHBOARD");
        setBackground(new java.awt.Color(44, 57, 48));
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(1080, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(44, 57, 48));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 228, 217));
        jLabel1.setText("BALAYAN PUBLIC LIBRARY");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1030, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/libraryMembers.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -50, 1800, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 70));

        jTabbedPane1.setBackground(new java.awt.Color(44, 57, 48));
        jTabbedPane1.setForeground(new java.awt.Color(242, 228, 217));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFocusTraversalPolicyProvider(true);
        jTabbedPane1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(245, 236, 213));
        jPanel2.setForeground(new java.awt.Color(162, 123, 92));

        welcomeMsg.setFont(new java.awt.Font("Bahnschrift", 0, 48)); // NOI18N
        welcomeMsg.setText("Welcome, " + userName(email) + "!");

        reservationList.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        reservationList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        reservationList.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(reservationList);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 28)); // NOI18N
        jLabel3.setText("BOOK RESERVATIONS");

        borrowedList.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        borrowedList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(borrowedList);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 26)); // NOI18N
        jLabel4.setText("BOOKS BORROWED");

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("YOUR FINES: ₱ ");

        upcomingDues.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        upcomingDues.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(upcomingDues);

        jLabel7.setText(" ");

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 26)); // NOI18N
        jLabel8.setText("UPCOMING DUE DATES");

        jLabel9.setText(" ");

        jLabel10.setText(" ");

        jLabel11.setText(" ");

        finesField.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        finesField.setText("COST");

        jLabel14.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(341, 341, 341)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(359, 359, 359)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel4)
                        .addGap(99, 99, 99)
                        .addComponent(jLabel8))
                    .addComponent(welcomeMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(340, 340, 340)
                                    .addComponent(finesField, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(welcomeMsg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane3)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(finesField))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Member Dashboard", jPanel2);

        jPanel3.setBackground(new java.awt.Color(245, 236, 213));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        browseTable.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        browseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title", "Authors", "Genre", "Year Published", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(browseTable);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 34, 770, 493));

        searchField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        searchField.setForeground(new java.awt.Color(153, 153, 153));
        searchField.setText("search keywords, titles, authors...");
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFieldFocusLost(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        jPanel3.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 0, 580, 30));

        sortByBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort by Year", "Sort by Title", "Sort by Author", "Sort by Genre", "Sort by Popularity" }));
        sortByBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortByBoxActionPerformed(evt);
            }
        });
        sortByBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                sortByBoxPropertyChange(evt);
            }
        });
        jPanel3.add(sortByBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 0, 190, 30));

        reserveButton.setText("RESERVE");
        reserveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveButtonActionPerformed(evt);
            }
        });
        jPanel3.add(reserveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, 125, -1));
        jPanel3.add(toDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 220, 30));

        jLabel12.setText("TO DATE:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, -1, -1));
        jPanel3.add(fromDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 220, 30));

        jLabel15.setText("FROM DATE:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, -1, -1));

        jTabbedPane1.addTab("Browse Books and Reserve", jPanel3);

        jPanel4.setBackground(new java.awt.Color(245, 236, 213));

        borrowedBookList.setAutoCreateRowSorter(true);
        borrowedBookList.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        borrowedBookList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Borrowed Books", "Borrow Date", "Due Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        borrowedBookList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(borrowedBookList);

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel13.setText("LOANED BOOKS");

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel16.setText("RETURNED BOOKS");

        borrowedBookList1.setAutoCreateRowSorter(true);
        borrowedBookList1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        borrowedBookList1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Borrowed Books", "Due Date", "Return Date", "Fines", "Paid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        borrowedBookList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(borrowedBookList1);
        if (borrowedBookList1.getColumnModel().getColumnCount() > 0) {
            borrowedBookList1.getColumnModel().getColumn(3).setResizable(false);
            borrowedBookList1.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Borrowed, Overdues & Fines", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 649));
        jTabbedPane1.setUI(new BasicTabbedPaneUI() {
            @Override
            protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
                return jTabbedPane1.getWidth() / jTabbedPane1.getTabCount();
            }
        });

        setBounds(0, 0, 1105, 694);
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        if (searchField.getText().equals("search keywords, titles, authors...")) {
            searchField.setText("");
            searchField.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchFieldFocusGained

    private void searchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusLost
        if (searchField.getText().isEmpty()) {
            searchField.setText("search keywords, titles, authors...");
            searchField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_searchFieldFocusLost
       
    private void sortByBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortByBoxActionPerformed
        int index = sortByBox.getSelectedIndex();
        switch (index) {
            case 0:
                loadToTables("publication_year");
                break;
            case 1:
                loadToTables("title");
                break;
            case 2:
                loadToTables("author");
                break;
            case 3:
                loadToTables("genre");
                break;
            case 4:
                loadMostBorrowedBooks();
                break;
            default:
                loadToTables("title");
        }
    }//GEN-LAST:event_sortByBoxActionPerformed

    private void sortByBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_sortByBoxPropertyChange
        
    }//GEN-LAST:event_sortByBoxPropertyChange

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        java.util.Date fromDate = fromDateChooser.getDate();
        java.util.Date toDate = toDateChooser.getDate();

        if (fromDate == null || toDate == null) { 
            if (fromDate == null && toDate == null) { 
                searchAndSort(searchField.getText(), sortByBox.getSelectedItem().toString());
            } else { 
                JOptionPane.showMessageDialog(null, "Please select both start and end dates.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
            java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
            searchAndSortWithDate(searchField.getText(), sortByBox.getSelectedItem().toString(), sqlFromDate, sqlToDate);
        }

    }//GEN-LAST:event_searchFieldKeyReleased

    private void reserveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveButtonActionPerformed
        int selectedRow = browseTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a book to reserve.", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String selectedTitle = browseTable.getValueAt(selectedRow, 0).toString();
    String selectedAuthor = browseTable.getValueAt(selectedRow, 1).toString();
    String selectedGenre = browseTable.getValueAt(selectedRow, 2).toString();

    if (fromDateChooser.getDate() == null || toDateChooser.getDate() == null) {
        JOptionPane.showMessageDialog(null, "Please select both start and end dates.", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    java.sql.Date sqlFromDate = new java.sql.Date(fromDateChooser.getDate().getTime());
    java.sql.Date sqlToDate = new java.sql.Date(toDateChooser.getDate().getTime());

    // Insert reservation into database
    insertReservation(userId, selectedTitle, selectedAuthor, selectedGenre, sqlFromDate, sqlToDate);

    // Clear date choosers
    fromDateChooser.setDate(null);
    toDateChooser.setDate(null);

    // Fetch updated reservations and populate JList
    DefaultListModel<String> listModel = new DefaultListModel<>();
    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    try (Connection conn = DriverManager.getConnection(url, user, pass)) {
        String query = "SELECT books.title " +
                       "FROM reservations " +
                       "JOIN books ON reservations.book_id = books.book_id " +
                       "WHERE reservations.user_id = ? AND reservations.status <> 'Cancelled';";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                
                boolean hasReservations = false;

                while (rs.next()) {
                    String bookTitle = rs.getString("title");
                    listModel.addElement(bookTitle);
                    hasReservations = true;
                }
                if (!hasReservations) {
                    System.out.println("No reservations found for user: " + userId);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Set updated model to the JList
    reservationList.setModel(listModel);
    reservationList.revalidate();
    reservationList.repaint();
    
    }//GEN-LAST:event_reserveButtonActionPerformed
private void loadReservations() {
    DefaultListModel<String> listModel = new DefaultListModel<>();
    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    try (Connection conn = DriverManager.getConnection(url, user, pass)) {
        String query = "SELECT books.title " +
                       "FROM reservations " +
                       "JOIN books ON reservations.book_id = books.book_id " +
                       "WHERE reservations.user_id = ? AND reservations.status <> 'Cancelled';";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                
                System.out.println("Fetching reservations for user: " + userId);
                boolean hasReservations = false;

                while (rs.next()) {
                    String bookTitle = rs.getString("title");
                    System.out.println("Book found: " + bookTitle);
                    listModel.addElement(bookTitle);
                    hasReservations = true;
                }

                if (!hasReservations) {
                    System.out.println("No reservations found for user: " + userId);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Set updated model to the JList
    reservationList.setModel(listModel);
    reservationList.revalidate();
    reservationList.repaint();
    System.out.println("Updated reservation list in JList.");
}


    private void loadBorrowedBooks() {
    DefaultListModel<String> listModel = new DefaultListModel<>();
    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    try (Connection conn = DriverManager.getConnection(url, user, pass)) {
        // Modify this query based on how your system tracks borrowed books
        String query = "SELECT books.title " +
               "FROM borrow_records " +
               "JOIN books ON borrow_records.book_id = books.book_id " +
               "WHERE borrow_records.user_id = ?;";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                
                System.out.println("Fetching borrowed books for user: " + userId);
                boolean hasBorrowedBooks = false;

                while (rs.next()) {
                    String bookTitle = rs.getString("title");
                    System.out.println("Borrowed book found: " + bookTitle);
                    listModel.addElement(bookTitle);
                    hasBorrowedBooks = true;
                }

                if (!hasBorrowedBooks) {
                    System.out.println("No borrowed books found for user: " + userId);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Set updated model to the JList
    borrowedList.setModel(listModel);
    borrowedList.revalidate();
    borrowedList.repaint();
    System.out.println("Updated borrowed book list in JList.");
}

        private void loadUpcomingDues() {
    DefaultListModel<String> listModel = new DefaultListModel<>();
    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    try (Connection conn = DriverManager.getConnection(url, user, pass)) {
        // SQL query to fetch book titles and due dates
        String query = "SELECT books.title, borrow_records.due_date " +
                       "FROM borrow_records " +
                       "JOIN books ON borrow_records.book_id = books.book_id " +
                       "WHERE borrow_records.user_id = ? " +
                       "ORDER BY borrow_records.due_date ASC;";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId); // Bind the user ID

            try (ResultSet rs = pstmt.executeQuery()) {
                boolean hasUpcomingDues = false;

                while (rs.next()) {
                    String bookTitle = rs.getString("title");
                    Date dueDate = rs.getDate("due_date");
                    String formattedDue = bookTitle + " - Due: " + dueDate.toString();
                    listModel.addElement(formattedDue);
                    hasUpcomingDues = true;
                }

                if (!hasUpcomingDues) {
                    listModel.addElement("No upcoming dues.");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Update JList
    upcomingDues.setModel(listModel);
    upcomingDues.revalidate();
    upcomingDues.repaint();
}

        private void loadTotalFines() {
    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";
    double totalFines = 0.0; // Initialize total fines

    try (Connection conn = DriverManager.getConnection(url, user, pass)) {
        // SQL query to calculate total fines for the user
        String query = "SELECT SUM(amount_paid) AS total_fines FROM fine_payments WHERE user_id = ?;";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId); // Bind the user ID

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    totalFines = rs.getDouble("total_fines"); // Retrieve the sum of fines
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Set the total fines in the finesField text field
    finesField.setText(String.format("%.2f", totalFines)); // Format to 2 decimal places
}


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(memberDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(memberDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(memberDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(memberDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new memberDashboard("ella.davis@example.com").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable borrowedBookList;
    private javax.swing.JTable borrowedBookList1;
    private javax.swing.JList<String> borrowedList;
    private javax.swing.JTable browseTable;
    private javax.swing.JLabel finesField;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> reservationList;
    private javax.swing.JButton reserveButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> sortByBox;
    private com.toedter.calendar.JDateChooser toDateChooser;
    private javax.swing.JList<String> upcomingDues;
    private javax.swing.JLabel welcomeMsg;
    // End of variables declaration//GEN-END:variables
    private String email;
    private int userId;
    private static final String URL = "jdbc:mysql://localhost:3306/lms_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
}
