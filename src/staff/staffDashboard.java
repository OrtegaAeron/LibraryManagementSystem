package staff;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class staffDashboard extends javax.swing.JFrame {

    public staffDashboard() {
        initComponents();
        updateBookList();
        loadReservations();
        updateMemberList();
        updateBookConditionList();
        updateDueDateList();
        fetchBooks();
        fetchFines();
        memberList.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            populateFieldsFromTable();
        }
    });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        bookCondition = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        duedateList = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listBook = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookList = new javax.swing.JTable();
        addBook = new javax.swing.JButton();
        deleteBook = new javax.swing.JButton();
        updateBook = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bookPublisher = new javax.swing.JTextField();
        bookGenre = new javax.swing.JTextField();
        bookIsbn = new javax.swing.JTextField();
        bookAuthor = new javax.swing.JTextField();
        bookTitle = new javax.swing.JTextField();
        bookYear = new javax.swing.JTextField();
        bookQuantity = new javax.swing.JTextField();
        bookLocation = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        loanedBooks = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        overDueBooks = new javax.swing.JTable();
        returnedButton = new javax.swing.JButton();
        borrowerName = new javax.swing.JTextField();
        titleName = new javax.swing.JTextField();
        dateField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        memberList = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        deleteUser = new javax.swing.JButton();
        updateUser = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        memberName = new javax.swing.JTextField();
        memberEmail = new javax.swing.JTextField();
        memberPassword = new javax.swing.JTextField();
        memberAddress = new javax.swing.JTextField();
        memberContact = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        memberRole = new javax.swing.JComboBox<>();
        addUser = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        finesTable = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        addUser1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        reservationList = new javax.swing.JTable();
        confirmReservation = new javax.swing.JButton();
        deleteReservation = new javax.swing.JButton();
        cancelReservation = new javax.swing.JButton();
        searchPending = new javax.swing.JTextField();
        title1 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Management System");
        setBackground(new java.awt.Color(44, 57, 48));
        setLocationByPlatform(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(44, 57, 48));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedPane.setBackground(new java.awt.Color(63, 79, 68));
        tabbedPane.setForeground(new java.awt.Color(239, 241, 238));
        tabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(220, 215, 201));

        jPanel9.setBackground(new java.awt.Color(220, 215, 201));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        bookCondition.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Book", "Condition", "Notes", "Last Checked"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(bookCondition);
        applyRenderer();

        duedateList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Borrower", "Book", "Borrow Date", "Return Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(duedateList);

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel17.setText("BOOK CONDITION");

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel18.setText("BORROWING HISTORY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        tabbedPane.addTab("Book Status Reports", jPanel2);

        jPanel3.setBackground(new java.awt.Color(220, 215, 201));

        jScrollPane5.setViewportView(listBook);

        bookList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title", "Author", "ISBN", "Genre", "Publisher", "Publication Year ", "Quantity", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bookList);

        addBook.setText("ADD BOOK");
        addBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookActionPerformed(evt);
            }
        });

        deleteBook.setText("DELETE BOOK");
        deleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookActionPerformed(evt);
            }
        });

        updateBook.setText("UPDATE BOOK");
        updateBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBookActionPerformed(evt);
            }
        });

        jLabel1.setText("Title: ");

        jLabel2.setText("Author:");

        jLabel3.setText("ISBN:");

        jLabel4.setText("Genre:");

        jLabel5.setText("Publisher:");

        jLabel6.setText("Publication Year:");

        jLabel7.setText("Quantity:");

        jLabel8.setText("Location:");

        bookTitle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bookTitleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bookTitleFocusLost(evt);
            }
        });
        bookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTitleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(6, 6, 6)
                                        .addComponent(bookIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bookLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel1))
                                            .addComponent(jLabel2))
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel6)
                                                .addGap(2, 2, 2))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(bookYear)
                                            .addComponent(bookQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jLabel4)
                                .addGap(7, 7, 7)
                                .addComponent(bookGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6)
                                .addComponent(bookPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBook)))
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(bookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bookYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(bookIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4))
                            .addComponent(bookGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5))
                            .addComponent(bookPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBook)
                            .addComponent(deleteBook)
                            .addComponent(updateBook))))
                .addGap(34, 34, 34))
        );

        tabbedPane.addTab("Book List Management", jPanel3);

        jPanel6.setBackground(new java.awt.Color(220, 215, 201));

        loanedBooks.setAutoCreateRowSorter(true);
        loanedBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title", "Borrower", "Borrow Date", "Due Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loanedBooks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        loanedBooks.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                loanedBooksFocusLost(evt);
            }
        });
        loanedBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loanedBooksMouseClicked(evt);
            }
        });
        loanedBooks.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                loanedBooksPropertyChange(evt);
            }
        });
        jScrollPane4.setViewportView(loanedBooks);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        overDueBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title", "Borrower", "Email", "Due Date", "Borrow Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        overDueBooks.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                overDueBooksFocusLost(evt);
            }
        });
        overDueBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                overDueBooksMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(overDueBooks);

        returnedButton.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        returnedButton.setText("RETURNED");
        returnedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnedButtonActionPerformed(evt);
            }
        });

        borrowerName.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        borrowerName.setForeground(new java.awt.Color(204, 204, 204));
        borrowerName.setText("Enter Borrower's Name...");
        borrowerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                borrowerNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                borrowerNameFocusLost(evt);
            }
        });

        titleName.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        titleName.setForeground(new java.awt.Color(204, 204, 204));
        titleName.setText("Enter Book Title...");
        titleName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                titleNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                titleNameFocusLost(evt);
            }
        });
        titleName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleNameActionPerformed(evt);
            }
        });
        titleName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                titleNameKeyReleased(evt);
            }
        });

        dateField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        dateField.setForeground(new java.awt.Color(204, 204, 204));
        dateField.setText("Due Date: YYYY-MM-DD");
        dateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateFieldFocusLost(evt);
            }
        });
        dateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFieldActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("OVERDUE BORROWED BOOKS");

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("BORROWED BOOKS");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleName, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(borrowerName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(returnedButton)
                                .addGap(13, 13, 13))
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(returnedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(borrowerName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2583, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Loaned and Overdues", jPanel6);

        jPanel4.setBackground(new java.awt.Color(220, 215, 201));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        memberList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Role", "Email", "Password", "Address", "Contact Info"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        memberList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memberListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(memberList);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 652, 320));

        jPanel5.setLayout(new java.awt.GridBagLayout());
        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 492, -1, -1));

        deleteUser.setText("DELETE ");
        deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserActionPerformed(evt);
            }
        });
        jPanel4.add(deleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, -1, -1));

        updateUser.setText("UPDATE ");
        updateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserActionPerformed(evt);
            }
        });
        jPanel4.add(updateUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 80, -1));

        jLabel9.setText("Name:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 37, -1));

        jLabel10.setText("Email:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 37, -1));

        jLabel11.setText("Password:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, -1, -1));

        jLabel12.setText("Address:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

        jLabel13.setText("Contact:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, -1));

        memberName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberNameActionPerformed(evt);
            }
        });
        jPanel4.add(memberName, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 100, -1));
        jPanel4.add(memberEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 100, -1));
        jPanel4.add(memberPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 100, -1));

        memberAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberAddressActionPerformed(evt);
            }
        });
        jPanel4.add(memberAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 100, -1));
        jPanel4.add(memberContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 100, -1));

        jLabel14.setText("Role:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, -1, -1));

        memberRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Member" }));
        jPanel4.add(memberRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 100, -1));

        addUser.setText("ADD");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });
        jPanel4.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, -1, -1));

        finesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Borrower Name", "Book Title", "Late Days", "Fine Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(finesTable);

        jPanel4.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 760, 240));

        jLabel19.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel19.setText("Fines");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 70, 30));

        jButton1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jButton1.setText("PAID");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 380, 90, 40));

        addUser1.setText("ADD");
        addUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUser1ActionPerformed(evt);
            }
        });
        jPanel4.add(addUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, -1, -1));

        tabbedPane.addTab("Manage Users", jPanel4);

        jPanel8.setBackground(new java.awt.Color(220, 215, 201));

        reservationList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Borrrower ", "Book Title", "Author", "Status", "From Date", "To Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(reservationList);

        confirmReservation.setText("Confirm Reservation");
        confirmReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmReservationActionPerformed(evt);
            }
        });

        deleteReservation.setText("Delete Reservation");
        deleteReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteReservationActionPerformed(evt);
            }
        });

        cancelReservation.setText("Cancel Reservation");
        cancelReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelReservationActionPerformed(evt);
            }
        });

        searchPending.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        searchPending.setForeground(new java.awt.Color(204, 204, 204));
        searchPending.setText("Search Pending Reservations...");
        searchPending.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchPendingFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchPendingFocusLost(evt);
            }
        });
        searchPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPendingActionPerformed(evt);
            }
        });
        searchPending.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchPendingKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(searchPending)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(confirmReservation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteReservation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelReservation))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchPending, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmReservation)
                    .addComponent(deleteReservation)
                    .addComponent(cancelReservation))
                .addContainerGap(2598, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Pending Reservations", jPanel8);

        jPanel1.add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1010, -1));
        tabbedPane.setUI(new BasicTabbedPaneUI() {
            @Override
            protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
                return tabbedPane.getWidth() / tabbedPane.getTabCount();
            }
        });

        title1.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("LIBRARY MANAGEMENT SYSTEM DASHBOARD");
        jPanel1.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 999, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void updateBookList() {
    DefaultTableModel model = (DefaultTableModel) bookList.getModel();
    model.setRowCount(0); // Clear the table

    DefaultListModel<String> listModel = new DefaultListModel<>(); // Model for JList

    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    try (Connection conn = DriverManager.getConnection(url, user, pass);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT title, author, isbn, genre, publisher, YEAR(publication_year) AS pub_year, quantity_available, location FROM books")) {
        
        while (rs.next()) {
            // Add book data to JTable
            model.addRow(new Object[]{
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("isbn"),
                rs.getString("genre"),
                rs.getString("publisher"),
                rs.getString("pub_year"), // Display only year
                rs.getInt("quantity_available"),
                rs.getString("location")
            });

            // Add book title to JList
            listModel.addElement(rs.getString("title"));
        }

        // Update the JList with the book titles
        listBook.setModel(listModel);

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating book list: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    public void fetchBooks() {
        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "";

        String query1 = """
            SELECT b.title, u.name, br.borrow_date, br.due_date
            FROM borrow_records br
            JOIN books b ON b.book_id = br.book_id
            JOIN users u ON u.user_id = br.user_id
            WHERE br.return_date IS NULL AND br.due_date > DATE(NOW())
            ORDER BY br.due_date;
        """;

        String query2 = """
            SELECT b.title, u.name, u.email, br.borrow_date, br.due_date
            FROM borrow_records br
            JOIN books b ON b.book_id = br.book_id
            JOIN users u ON u.user_id = br.user_id
            WHERE br.return_date IS NULL AND br.due_date < DATE(NOW())
            ORDER BY br.due_date;
        """;

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement()) {

            // Fetch loaned books
            try (ResultSet rs = stmt.executeQuery(query1)) {
                DefaultTableModel model = (DefaultTableModel) loanedBooks.getModel();
                model.setRowCount(0); // Clear existing data

                while (rs.next()) {
                    Object[] row = {
                            rs.getString("title"),
                            rs.getString("name"),
                            rs.getDate("borrow_date"),
                            rs.getDate("due_date")
                    };
                    model.addRow(row);
                }
            } 

            
            try (ResultSet rs = stmt.executeQuery(query2)) {
                DefaultTableModel model = (DefaultTableModel) overDueBooks.getModel();
                model.setRowCount(0); // Clear existing data

                while (rs.next()) {
                    Object[] row = {
                            rs.getString("title"),
                            rs.getString("name"),
                            rs.getString("email"),                          
                            rs.getDate("due_date"),
                            rs.getDate("borrow_date")
                    };
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void fetchFines(){
        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "";

        String fines = """
            SELECT br.record_id, u.name, b.title, DATEDIFF(br.return_date, br.due_date) 
            AS overdue_days, br.fine FROM borrow_records br JOIN users u ON u.user_id = br.user_id 
            JOIN books b ON b.book_id = br.book_id WHERE br.return_date IS NOT NULL AND br.isPaid = 0 AND br.fine > 0;
        """;


        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement()) {

            try (ResultSet rs = stmt.executeQuery(fines)) {
                DefaultTableModel model = (DefaultTableModel) finesTable.getModel();
                model.setRowCount(0); 

                while (rs.next()) {
                    
                    Object[] row = {
                            rs.getString("name"),
                            rs.getString("title"),
                            rs.getInt("overdue_days"),
                            rs.getFloat("fine")
                    };
                    model.addRow(row);
                }
            } 

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void filterBooks() {
        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "";

        // Get input values for filtering
        String titleFilter = titleName.getText().trim();
        String borrowerFilter = borrowerName.getText().trim();

        // Base queries
        String query1 = """
            SELECT b.title, u.name, br.borrow_date, br.due_date
            FROM borrow_records br
            JOIN books b ON b.book_id = br.book_id
            JOIN users u ON u.user_id = br.user_id 
            WHERE br.return_date IS NULL AND br.due_date > DATE(NOW())
        """;

        String query2 = """
            SELECT b.title, u.name, u.email, br.borrow_date, br.due_date
            FROM borrow_records br
            JOIN books b ON b.book_id = br.book_id
            JOIN users u ON u.user_id = br.user_id
            WHERE br.return_date IS NULL AND br.due_date < DATE(NOW())
        """;

        // Modify queries based on input fields
        if (!titleFilter.isEmpty()) {
            query1 += " AND b.title LIKE ?";
            query2 += " AND b.title LIKE ?";
        } else if (!borrowerFilter.isEmpty()) {
            query1 += " AND u.name LIKE ?";
            query2 += " AND u.name LIKE ?";
        }

        query1 += " ORDER BY br.due_date";
        query2 += " ORDER BY br.due_date";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt1 = conn.prepareStatement(query1);
             PreparedStatement stmt2 = conn.prepareStatement(query2)) {

            // Set filter values if necessary
            if (!titleFilter.isEmpty()) {
                stmt1.setString(1, "%" + titleFilter + "%");
                stmt2.setString(1, "%" + titleFilter + "%");
            } else if (!borrowerFilter.isEmpty()) {
                stmt1.setString(1, "%" + borrowerFilter + "%");
                stmt2.setString(1, "%" + borrowerFilter + "%");
            }

            // Fetch loaned books
            try (ResultSet rs = stmt1.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) loanedBooks.getModel();
                model.setRowCount(0); // Clear existing data

                while (rs.next()) {
                    Object[] row = {
                            rs.getString("title"),
                            rs.getString("name"),
                            rs.getDate("borrow_date"),
                            rs.getDate("due_date")
                    };
                    model.addRow(row);
                }
            }

            // Fetch overdue books
            try (ResultSet rs = stmt2.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) overDueBooks.getModel();
                model.setRowCount(0); // Clear existing data

                while (rs.next()) {
                    Object[] row = {
                            rs.getString("title"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getDate("borrow_date"),
                            rs.getDate("due_date")
                    };
                    model.addRow(row);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBookConditionList() {
        DefaultTableModel model = (DefaultTableModel) bookCondition.getModel();
        model.setRowCount(0);

        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "";

        String query = "SELECT b.title, bc.condition_status, bc.notes, bc.last_checked " +
                "FROM book_condition bc " +
                "JOIN books b ON bc.book_id = b.book_id";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("title"),          // Book title
                        rs.getString("condition_status"), // Condition
                        rs.getString("notes"),         // Notes
                        rs.getDate("last_checked")     // Last Checked
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating book condition list: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    class ConditionCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            String condition = (String) table.getValueAt(row, 1);

            if ("Good".equalsIgnoreCase(condition)) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else if ("Damaged".equalsIgnoreCase(condition)) {
                cell.setBackground(Color.ORANGE);
                cell.setForeground(Color.BLACK);
            } else if ("Lost".equalsIgnoreCase(condition)) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.WHITE);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }

            return cell;
        }
    }

    public void applyRenderer() {
        bookCondition.setDefaultRenderer(Object.class, (TableCellRenderer) new ConditionCellRenderer());
    }

    public void updateDueDateList() {
    DefaultTableModel model = (DefaultTableModel) duedateList.getModel();
    model.setRowCount(0); // Clear the table

    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    String query = "SELECT u.name AS borrower, b.title AS book, br.borrow_date, br.return_date " +
                   "FROM borrow_records br " +
                   "JOIN users u ON br.user_id = u.user_id " +
                   "JOIN books b ON br.book_id = b.book_id";  

    try (Connection conn = DriverManager.getConnection(url, user, pass);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("borrower"),  // Borrower's name
                rs.getString("book"),      // Book title
                rs.getDate("borrow_date"), // Borrow date
                rs.getDate("return_date")  // Return date
            });
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating due date list: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public void loadReservations() {
    DefaultTableModel model = (DefaultTableModel) reservationList.getModel();
    model.setRowCount(0); 

    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";
    
    String query = "SELECT u.name AS Borrower, b.title AS BookTitle, b.author AS Author, " +
               "r.status, r.reservation_date AS FromDate, r.reservation_end_date AS ToDate " +
               "FROM reservations r " +
               "JOIN users u ON r.user_id = u.user_id " +
               "JOIN books b ON r.book_id = b.book_id"; 
    
    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = conn.prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("Borrower"),
                rs.getString("BookTitle"),
                rs.getString("Author"),
                rs.getString("status"),
                rs.getString("FromDate"),
                rs.getString("ToDate")
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading reservations: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void addBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookActionPerformed
            String title = bookTitle.getText();
    String author = bookAuthor.getText();
    String isbn = bookIsbn.getText();
    String genre = bookGenre.getText();
    String publisher = bookPublisher.getText();
    String year = bookYear.getText();
    String quantity = bookQuantity.getText();
    String location = bookLocation.getText();

    if (title.isEmpty() || author.isEmpty() || isbn.isEmpty() || genre.isEmpty() || 
        publisher.isEmpty() || year.isEmpty() || quantity.isEmpty() || location.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate that the year is a four-digit number
    if (!year.matches("\\d{4}")) {
        JOptionPane.showMessageDialog(this, "Publication year must be a valid 4-digit year (e.g., 2024).", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    Connection conn = null;
    PreparedStatement pst = null;

    String insertBookSql = "INSERT INTO books (title, author, isbn, genre, publisher, publication_year, quantity_available, location) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pass);
        pst = conn.prepareStatement(insertBookSql);

        pst.setString(1, title);
        pst.setString(2, author);
        pst.setString(3, isbn);
        pst.setString(4, genre);
        pst.setString(5, publisher);
        pst.setInt(6, Integer.parseInt(year));  // Convert year to integer for YEAR type
        pst.setInt(7, Integer.parseInt(quantity)); // Convert quantity to integer
        pst.setString(8, location);

        int rowsInserted = pst.executeUpdate();

        if (rowsInserted > 0) {
            bookTitle.setText("");
            bookAuthor.setText("");
            bookIsbn.setText("");
            bookGenre.setText("");
            bookPublisher.setText("");
            bookYear.setText("");
            bookQuantity.setText("");
            bookLocation.setText("");
            JOptionPane.showMessageDialog(this, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            updateBookList();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add book.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Driver not found: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_addBookActionPerformed

    private void bookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookTitleActionPerformed

    private void deleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookActionPerformed
        int selectedRow = bookList.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a book to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    String title = bookList.getValueAt(selectedRow, 0).toString(); // Title is in the first column
    
    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";
    
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this book?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }
    
    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = conn.prepareStatement("DELETE FROM books WHERE title = ?")) {
        
        pst.setString(1, title);
        int rowsDeleted = pst.executeUpdate();
        
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(this, "Book deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            updateBookList();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete book.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_deleteBookActionPerformed

    private void updateBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBookActionPerformed
         int selectedRow = bookList.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a book to update.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String title = bookTitle.getText();
    String author = bookAuthor.getText();
    String isbn = bookIsbn.getText();
    String genre = bookGenre.getText();
    String publisher = bookPublisher.getText();
    String year = bookYear.getText();
    String quantity = bookQuantity.getText();
    String location = bookLocation.getText();

    if (title.isEmpty() || author.isEmpty() || isbn.isEmpty() || genre.isEmpty() || 
        publisher.isEmpty() || year.isEmpty() || quantity.isEmpty() || location.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = conn.prepareStatement("UPDATE books SET isbn = ?, author = ?, genre = ?, publisher = ?, publication_year = ?, quantity_available = ?, location = ? WHERE title = ?")) {

        pst.setString(1, isbn); // Update order of parameters
        pst.setString(2, author);
        pst.setString(3, genre);
        pst.setString(4, publisher);
        pst.setString(5, year);
        pst.setInt(6, Integer.parseInt(quantity));
        pst.setString(7, location);
        String selectedTitle = bookList.getValueAt(selectedRow, 0).toString(); // Assuming title is in the first column
        pst.setString(8, selectedTitle); 
        
        int rowsUpdated = pst.executeUpdate();
        
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Book updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            updateBookList(); 
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update book.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_updateBookActionPerformed
    
    public void fillBookDetails() {
        int selectedRow = bookList.getSelectedRow();
        if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a book first.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }

        bookTitle.setText(bookList.getValueAt(selectedRow, 0).toString());
        bookAuthor.setText(bookList.getValueAt(selectedRow, 1).toString());
        bookIsbn.setText(bookList.getValueAt(selectedRow, 2).toString());
        bookGenre.setText(bookList.getValueAt(selectedRow, 3).toString());
        bookPublisher.setText(bookList.getValueAt(selectedRow, 4).toString());
        bookYear.setText(bookList.getValueAt(selectedRow, 5).toString());
        bookQuantity.setText(bookList.getValueAt(selectedRow, 6).toString());
        bookLocation.setText(bookList.getValueAt(selectedRow, 7).toString());
}
    
    private void bookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookListMouseClicked
        bookList.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
        fillBookDetails();
    }
});       
    }//GEN-LAST:event_bookListMouseClicked
    
    private void populateFieldsFromTable() {
    int selectedRow = memberList.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a user to update.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    memberName.setText(memberList.getValueAt(selectedRow, 0).toString());
    memberRole.setSelectedItem(memberList.getValueAt(selectedRow, 1).toString());
    memberEmail.setText(memberList.getValueAt(selectedRow, 2).toString());
    memberPassword.setText(memberList.getValueAt(selectedRow, 3).toString());
    memberAddress.setText(memberList.getValueAt(selectedRow, 4).toString());
    memberContact.setText(memberList.getValueAt(selectedRow, 5).toString());
}
    
    private void updateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserActionPerformed
    int selectedRow = memberList.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a user to update.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String originalName = memberList.getValueAt(selectedRow, 0).toString(); 
    String name = memberName.getText();
    String email = memberEmail.getText();
    String password = memberPassword.getText();
    String address = memberAddress.getText();
    String contact = memberContact.getText();
    String role = memberRole.getSelectedItem().toString();

    String updateUserSql = "UPDATE users SET name = ?, email = ?, password = ?, address = ?, contact_info = ?, role = ? WHERE name = ?";

    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = conn.prepareStatement(updateUserSql)) {

        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, password);
        pst.setString(4, address);
        pst.setString(5, contact);
        pst.setString(6, role);
        pst.setString(7, originalName); // Use original name for WHERE clause

        int rowsUpdated = pst.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "User updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            updateMemberList();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update user.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_updateUserActionPerformed

    private void bookTitleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bookTitleFocusGained
       
    }//GEN-LAST:event_bookTitleFocusGained

    private void bookTitleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bookTitleFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bookTitleFocusLost

    private void memberNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberNameActionPerformed

    private void deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserActionPerformed
            int selectedRow = memberList.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    String selectedName = memberList.getValueAt(selectedRow, 0).toString(); // Get selected name
    
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }
    
    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";
    
    String deleteUserSql = "DELETE FROM users WHERE name = ?";
    
    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = conn.prepareStatement(deleteUserSql)) {
        
        pst.setString(1, selectedName);
        int rowsDeleted = pst.executeUpdate();
        
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(this, "User deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            updateMemberList();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete user.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_deleteUserActionPerformed

    private void updateMemberList() {
    DefaultTableModel model = (DefaultTableModel) memberList.getModel();
    model.setRowCount(0); // Clear existing data
    
    String fetchUsersSql = "SELECT name, role, email, password, address, contact_info FROM users";
    
    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";
    try (Connection conn = DriverManager.getConnection(url, user, pass);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(fetchUsersSql)) {
        
        while (rs.next()) {
            String name = rs.getString("name");
            String role = rs.getString("role");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String address = rs.getString("address");
            String contact = rs.getString("contact_info");
            
            model.addRow(new Object[]{name, role, email, password, address, contact});
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating member list: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
            String name = memberName.getText();
            String email = memberEmail.getText();
            String password = memberPassword.getText();
            String address = memberAddress.getText();
            String contact = memberContact.getText();
            String role = memberRole.getSelectedItem().toString();

if (name.isEmpty() || email.isEmpty() || password.isEmpty() || address.isEmpty() || contact.isEmpty() || role.isEmpty()) {
    JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

String url = "jdbc:mysql://localhost:3306/lms_db";
String user = "root";
String pass = "";

Connection conn = null;
PreparedStatement pst = null;

String insertUserSql = "INSERT INTO users (name, email, password, address, contact_info, role) VALUES (?, ?, ?, ?, ?, ?)";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(url, user, pass);
    pst = conn.prepareStatement(insertUserSql);
    
    pst.setString(1, name);
    pst.setString(2, email);
    pst.setString(3, password);
    pst.setString(4, address);
    pst.setString(5, contact);
    pst.setString(6, role);
    
    int rowsInserted = pst.executeUpdate();
    
    if (rowsInserted > 0) {
        memberName.setText("");
        memberEmail.setText("");
        memberPassword.setText("");
        memberAddress.setText("");
        memberContact.setText("");
        memberRole.setSelectedIndex(0); // Reset combo box
        
        JOptionPane.showMessageDialog(this, "User added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        updateMemberList();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to add user.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
} catch (ClassNotFoundException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Driver not found: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
} finally {
    try {
        if (pst != null) pst.close();
        if (conn != null) conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    }//GEN-LAST:event_addUserActionPerformed

    private void memberListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_memberListMouseClicked

    private void memberAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberAddressActionPerformed

    private void confirmReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmReservationActionPerformed
        int selectedRow = reservationList.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a reservation to confirm.", "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String borrower = reservationList.getValueAt(selectedRow, 0).toString();
    String bookTitle = reservationList.getValueAt(selectedRow, 1).toString();
    String currentStatus = reservationList.getValueAt(selectedRow, 3).toString(); // Status column

    // Check if status is 'Pending'
    if (!currentStatus.equals("Pending")) {
        JOptionPane.showMessageDialog(null, "Only 'Pending' reservations can be confirmed.", "Invalid Action", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    String updateQuery = "UPDATE reservations r " +
                         "JOIN users u ON r.user_id = u.user_id " +
                         "JOIN books b ON r.book_id = b.book_id " +
                         "SET r.status = 'Confirmed' " +
                         "WHERE u.name = ? AND b.title = ? AND r.status = 'Pending'";

    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = conn.prepareStatement(updateQuery)) {
        
        pst.setString(1, borrower);
        pst.setString(2, bookTitle);
        
        int affectedRows = pst.executeUpdate();
        
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Reservation confirmed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadReservations(); // Refresh table
        } else {
            JOptionPane.showMessageDialog(null, "No changes made. The reservation might have already been updated.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating reservation: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_confirmReservationActionPerformed

    private void deleteReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteReservationActionPerformed
        int selectedRow = reservationList.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a reservation to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String borrower = reservationList.getValueAt(selectedRow, 0).toString();
    String bookTitle = reservationList.getValueAt(selectedRow, 1).toString();

    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this reservation?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return; // User canceled the deletion
    }

    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    String deleteQuery = "DELETE r FROM reservations r " +
                         "JOIN users u ON r.user_id = u.user_id " +
                         "JOIN books b ON r.book_id = b.book_id " +
                         "WHERE u.name = ? AND b.title = ?";

    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = conn.prepareStatement(deleteQuery)) {
        
        pst.setString(1, borrower);
        pst.setString(2, bookTitle);
        
        int affectedRows = pst.executeUpdate();
        
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Reservation deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadReservations(); // Refresh table
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete reservation.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error deleting reservation: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_deleteReservationActionPerformed

    private void cancelReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelReservationActionPerformed
        int selectedRow = reservationList.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a reservation to cancel.", "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String borrower = reservationList.getValueAt(selectedRow, 0).toString();
    String bookTitle = reservationList.getValueAt(selectedRow, 1).toString();
    String currentStatus = reservationList.getValueAt(selectedRow, 3).toString();

    if (!currentStatus.equals("Pending") && !currentStatus.equals("Confirmed")) {
        JOptionPane.showMessageDialog(null, "Only 'Pending' or 'Confirmed' reservations can be cancelled.", "Invalid Action", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this reservation?", "Confirm Cancellation", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return; 
    }

    String url = "jdbc:mysql://localhost:3306/lms_db";
    String user = "root";
    String pass = "";

    String updateQuery = "UPDATE reservations r " +
                         "JOIN users u ON r.user_id = u.user_id " +
                         "JOIN books b ON r.book_id = b.book_id " +
                         "SET r.status = 'Cancelled' " +
                         "WHERE u.name = ? AND b.title = ? AND (r.status = 'Pending' OR r.status = 'Confirmed')";

    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = conn.prepareStatement(updateQuery)) {
        
        pst.setString(1, borrower);
        pst.setString(2, bookTitle);
        
        int affectedRows = pst.executeUpdate();
        
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Reservation cancelled successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadReservations(); // Refresh table
        } else {
            JOptionPane.showMessageDialog(null, "Failed to cancel reservation.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating reservation: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_cancelReservationActionPerformed

    private void titleNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titleNameFocusLost
        if (titleName.getText().isEmpty()) {
            titleName.setText("Enter Book Title...");
            titleName.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_titleNameFocusLost

    private void titleNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titleNameFocusGained
        if (titleName.getText().equals("Enter Book Title...")) {
            titleName.setText("");
            titleName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_titleNameFocusGained

    private void borrowerNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_borrowerNameFocusLost
        if (borrowerName.getText().isEmpty()) {
            borrowerName.setText("Enter Borrower's Name...");
            borrowerName.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_borrowerNameFocusLost

    private void borrowerNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_borrowerNameFocusGained
        if (borrowerName.getText().equals("Enter Borrower's Name...")) {
            borrowerName.setText("");
            borrowerName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_borrowerNameFocusGained

    private void loanedBooksFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loanedBooksFocusLost
        loanedBooks.clearSelection();
    }//GEN-LAST:event_loanedBooksFocusLost

    private void overDueBooksFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_overDueBooksFocusLost
        overDueBooks.clearSelection();
    }//GEN-LAST:event_overDueBooksFocusLost

    private void loanedBooksPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_loanedBooksPropertyChange
        int row = loanedBooks.getSelectedRow(); 
        if (row != -1) { 
            String title = loanedBooks.getValueAt(row, 0).toString();
            String borrower = loanedBooks.getValueAt(row, 1).toString();

            titleName.setText(title);
            borrowerName.setText(borrower);
        }
    }//GEN-LAST:event_loanedBooksPropertyChange

    private void loanedBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loanedBooksMouseClicked
        int row = loanedBooks.getSelectedRow(); 
        if (row != -1) { 
            String title = loanedBooks.getValueAt(row, 0).toString();
            String borrower = loanedBooks.getValueAt(row, 1).toString();
            String dueDate = loanedBooks.getValueAt(row, 3).toString();

            titleName.setText(title);
            titleName.setForeground(Color.black);
            borrowerName.setText(borrower);
            borrowerName.setForeground(Color.black);
            dateField.setText(dueDate);
            dateField.setForeground(Color.black);
        }
    }//GEN-LAST:event_loanedBooksMouseClicked

    private void overDueBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_overDueBooksMouseClicked
        int row = overDueBooks.getSelectedRow(); 
        if (row != -1) { 
            String title = overDueBooks.getValueAt(row, 0).toString();
            String borrower = overDueBooks.getValueAt(row, 1).toString();
            String dueDate = overDueBooks.getValueAt(row, 3).toString();

            titleName.setText(title);
            titleName.setForeground(Color.BLACK);
            borrowerName.setText(borrower);
            borrowerName.setForeground(Color.black);       
            dateField.setText(dueDate);
            dateField.setForeground(Color.black);
        }
    }//GEN-LAST:event_overDueBooksMouseClicked

    private void titleNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titleNameKeyReleased
        if(titleName.getText().isEmpty()){fetchBooks();}else{filterBooks();}
    }//GEN-LAST:event_titleNameKeyReleased

    private void searchPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPendingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchPendingActionPerformed

    private void searchPendingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchPendingKeyReleased
        DefaultTableModel model = (DefaultTableModel) reservationList.getModel();
        model.setRowCount(0); 

        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "";
        String search = "%" + searchPending.getText().trim().toLowerCase() + "%";

        String query = "SELECT u.name AS Borrower, b.title AS BookTitle, b.author AS Author, " +
                   "r.status, r.reservation_date AS FromDate, r.reservation_end_date AS ToDate " +
                   "FROM reservations r " +
                   "JOIN users u ON r.user_id = u.user_id " +
                   "JOIN books b ON r.book_id = b.book_id WHERE u.name LIKE ? OR b.title LIKE ?"; 

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pst = conn.prepareStatement(query);)
              {
              pst.setString(1, search);
              pst.setString(2, search);
              ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("Borrower"),
                    rs.getString("BookTitle"),
                    rs.getString("Author"),
                    rs.getString("status"),
                    rs.getString("FromDate"),
                    rs.getString("ToDate")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading reservations: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchPendingKeyReleased

    private void searchPendingFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchPendingFocusGained
        if (searchPending.getText().equals("Search Pending Reservations...")) {
            searchPending.setText("");
            searchPending.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchPendingFocusGained

    private void searchPendingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchPendingFocusLost
        if (searchPending.getText().isEmpty()) {
            searchPending.setText("Search Pending Reservations...");
            searchPending.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_searchPendingFocusLost

    private void titleNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleNameActionPerformed

    private void dateFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFieldFocusGained
        if (dateField.getText().equals("Due Date: YYYY-MM-DD")) {
            dateField.setText("");
            dateField.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_dateFieldFocusGained

    private void dateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFieldFocusLost
        if (dateField.getText().isEmpty()) {
            dateField.setText("Due Date: YYYY-MM-DD");
            dateField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_dateFieldFocusLost

    private void dateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFieldActionPerformed

    private void returnedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnedButtonActionPerformed
        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "";

        String borrowerName = this.borrowerName.getText().trim();
        String bookTitle = titleName.getText().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date dueDate = null;
        try {
            dueDate = sdf.parse(dateField.getText().trim());
        } catch (ParseException ex) {
            Logger.getLogger(staffDashboard.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Invalid date format. Please enter in yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // If parsing failed, return early
        if (dueDate == null || dateField.getText().isEmpty() || borrowerName.isEmpty() || bookTitle.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all details correctly.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Date today = new Date();
        long diff = today.getTime() - dueDate.getTime();
        int penaltyDays = (int) (diff / (1000 * 60 * 60 * 24));
        penaltyDays = Math.max(penaltyDays, 0);

        float fine = penaltyDays * 20;

        String query = """
            UPDATE borrow_records br
            JOIN users u ON br.user_id = u.user_id
            JOIN books b ON br.book_id = b.book_id
            SET br.return_date = CURDATE(), br.fine = ?
            WHERE u.name = ? AND b.title = ? AND br.return_date IS NULL;
        """;

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setFloat(1, fine);
            pst.setString(2, borrowerName);
            pst.setString(3, bookTitle);

            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Book returned successfully. Fine: ₱" + fine, "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating record: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_returnedButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int selectedRow = finesTable.getSelectedRow(); 

    if (selectedRow != -1) { // Ensure a row is selected
        String name = finesTable.getValueAt(selectedRow, 0).toString(); // Borrower Name
        String title = finesTable.getValueAt(selectedRow, 1).toString(); // Book Title
        String fine = finesTable.getValueAt(selectedRow, 3).toString(); 

        System.out.println("Selected Borrower: " + name);
        System.out.println("Selected Book: " + title);
        System.out.println("Fine: " + fine);

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root";
        String pass = "";

        Connection conn = null;
        PreparedStatement updateStmt = null;
        PreparedStatement insertStmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, pass);
            conn.setAutoCommit(false); // Start transaction

            // Get user_id based on the borrower name
            String getUserQuery = "SELECT user_id FROM users WHERE name = ?";
            PreparedStatement getUserStmt = conn.prepareStatement(getUserQuery);
            getUserStmt.setString(1, name);
            rs = getUserStmt.executeQuery();

            int userId = -1;
            if (rs.next()) {
                userId = rs.getInt("user_id");
            } else {
                JOptionPane.showMessageDialog(null, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update borrow_records to set isPaid = 1
            String updateQuery = """
                UPDATE borrow_records br
                JOIN users u ON br.user_id = u.user_id
                JOIN books b ON br.book_id = b.book_id
                SET br.isPaid = 1
                WHERE u.name = ? AND b.title = ? AND br.fine = ? AND br.isPaid = 0;
            """;
            updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setString(1, name);
            updateStmt.setString(2, title);
            updateStmt.setString(3, fine);

            int rowsUpdated = updateStmt.executeUpdate();

            if (rowsUpdated > 0) {
                // Insert into fine_payments
                String insertQuery = """
                    INSERT INTO fine_payments (user_id, amount_paid, payment_date)
                    VALUES (?, ?, NOW());
                """;
                insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setInt(1, userId);
                insertStmt.setFloat(2, Float.parseFloat(fine));

                insertStmt.executeUpdate();

                conn.commit(); // Commit transaction
                JOptionPane.showMessageDialog(null, "Fine paid successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Fine updated and recorded in payments.");
            } else {
                conn.rollback(); // Rollback if no records updated
                JOptionPane.showMessageDialog(null, "No matching record found or fine is already paid.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            try {
                if (conn != null) conn.rollback(); // Rollback in case of error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (updateStmt != null) updateStmt.close();
                if (insertStmt != null) insertStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row first.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addUser1ActionPerformed
        
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(staffDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staffDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staffDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staffDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staffDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBook;
    private javax.swing.JButton addUser;
    private javax.swing.JButton addUser1;
    private javax.swing.JTextField bookAuthor;
    private javax.swing.JTable bookCondition;
    private javax.swing.JTextField bookGenre;
    private javax.swing.JTextField bookIsbn;
    private javax.swing.JTable bookList;
    private javax.swing.JTextField bookLocation;
    private javax.swing.JTextField bookPublisher;
    private javax.swing.JTextField bookQuantity;
    private javax.swing.JTextField bookTitle;
    private javax.swing.JTextField bookYear;
    private javax.swing.JTextField borrowerName;
    private javax.swing.JButton cancelReservation;
    private javax.swing.JButton confirmReservation;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton deleteBook;
    private javax.swing.JButton deleteReservation;
    private javax.swing.JButton deleteUser;
    private javax.swing.JTable duedateList;
    private javax.swing.JTable finesTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JList<String> listBook;
    private javax.swing.JTable loanedBooks;
    private javax.swing.JTextField memberAddress;
    private javax.swing.JTextField memberContact;
    private javax.swing.JTextField memberEmail;
    private javax.swing.JTable memberList;
    private javax.swing.JTextField memberName;
    private javax.swing.JTextField memberPassword;
    private javax.swing.JComboBox<String> memberRole;
    private javax.swing.JTable overDueBooks;
    private javax.swing.JTable reservationList;
    private javax.swing.JButton returnedButton;
    private javax.swing.JTextField searchPending;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel title1;
    private javax.swing.JTextField titleName;
    private javax.swing.JButton updateBook;
    private javax.swing.JButton updateUser;
    // End of variables declaration//GEN-END:variables
}
