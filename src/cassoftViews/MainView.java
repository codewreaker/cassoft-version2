/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassoftViews;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Israel Agyeman-Premp
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        dbOn = new javax.swing.JLabel();
        searchBox = new javax.swing.JComboBox();
        searchLabel = new javax.swing.JLabel();
        minimise = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        maximise = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        settings = new javax.swing.JLabel();
        addStudent = new javax.swing.JLabel();
        studName = new javax.swing.JLabel();
        viewHistory = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        amountPaidLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        studImage = new javax.swing.JLabel();
        studView = new javax.swing.JLabel();
        studHistory = new javax.swing.JLabel();
        studDelete = new javax.swing.JLabel();
        pay = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        amtPaidTxtField = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setMinimumSize(new java.awt.Dimension(688, 760));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainTable.setBackground(new java.awt.Color(255, 255, 255));
        mainTable.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        mainTable.setEditingColumn(1);
        mainTable.setEditingRow(1);
        mainTable.setInheritsPopupMenu(true);
        mainTable.setIntercellSpacing(new java.awt.Dimension(1, 2));
        mainTable.setSelectionBackground(new java.awt.Color(0, 102, 204));
        jScrollPane1.setViewportView(mainTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 1100, 660));

        dbOn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/db_on.png"))); // NOI18N
        getContentPane().add(dbOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 690, -1, 60));

        searchBox.setEditable(true);
        searchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoxActionPerformed(evt);
            }
        });
        getContentPane().add(searchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, 310, 20));

        searchLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        getContentPane().add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, 380, 40));

        minimise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimise.png"))); // NOI18N
        getContentPane().add(minimise, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, -1, 30));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, -1, 30));

        maximise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/maximise.png"))); // NOI18N
        getContentPane().add(maximise, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, -1, 30));

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, 80));

        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings.png"))); // NOI18N
        settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, 80));

        addStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_student.png"))); // NOI18N
        addStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(addStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, 80));

        studName.setText("No name selected");
        getContentPane().add(studName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 150, 30));

        viewHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/summary.png"))); // NOI18N
        viewHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(viewHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, 80));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 160, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Payment History");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        amountPaidLabel.setBackground(new java.awt.Color(255, 255, 255));
        amountPaidLabel.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        amountPaidLabel.setForeground(new java.awt.Color(255, 255, 255));
        amountPaidLabel.setText("Amount Paid");
        getContentPane().add(amountPaidLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("View Student");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Delete Student");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        studImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/placeholder.png"))); // NOI18N
        getContentPane().add(studImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 110));

        studView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view.png"))); // NOI18N
        studView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(studView, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        studHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/history.png"))); // NOI18N
        studHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(studHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        studDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        studDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(studDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        pay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pay.png"))); // NOI18N
        pay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Feeding Fee", "School Fees", "Classes Fee" }));
        getContentPane().add(categoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 210, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Make Payment");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, -1, -1));

        amtPaidTxtField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        amtPaidTxtField.setMinimumSize(new java.awt.Dimension(59, 25));
        amtPaidTxtField.setPreferredSize(new java.awt.Dimension(59, 25));
        amtPaidTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtPaidTxtFieldActionPerformed(evt);
            }
        });
        getContentPane().add(amtPaidTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 210, 40));

        saveBtn.setBackground(new java.awt.Color(243, 117, 32));
        saveBtn.setText("Save");
        getContentPane().add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 210, 40));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/UI-01.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amtPaidTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtPaidTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtPaidTxtFieldActionPerformed

    private void searchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoxActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MainView().setVisible(true);

            }
        });
    }

    /**
     * This returns the minimise button
     *
     * @return minimise
     */
    public JLabel minimise() {
        return minimise;
    }

    /**
     * This returns the maximise button
     *
     * @return maximise
     */
    public JLabel maximise() {
        return maximise;
    }

    /**
     * This returns the close button
     *
     * @return close
     */
    public JLabel close() {
        return close;
    }

    /**
     * This returns the student history button
     *
     * @return student history
     */
    public JLabel studHistory() {
        return studHistory;
    }

    /**
     * This returns the minimise button
     *
     * @return student view
     */
    public JLabel studView() {
        return studView;
    }

    /**
     * This returns the delete button
     *
     * @return delete
     */
    public JLabel studDelete() {
        return studDelete;
    }

    /**
     * This returns the settings button
     *
     * @return settings
     */
    public JLabel settingsBtn() {
        return settings;
    }

    /**
     * This returns the add student button
     *
     * @return add student
     */
    public JLabel addStudent() {
        return addStudent;
    }

    /**
     * This returns the view history button
     *
     * @return view history
     */
    public JLabel viewHistory() {
        return viewHistory;
    }
    
    /**
     * This button causes the payment buttons to appear
     * @return pay
     */
    public JLabel studPay(){
        return pay;
    }

    /**
     * returns the search label
     * @return searchLabel
     */
    public JLabel search() {
        return searchLabel;
    }

//    /**
//     * returns the search area
//     *
//     * @return
//     */
//    public JTextField searchTextField() {
//        return searchName;
//    }

    /**
     * A button to save a transaction
     *
     * @return saveBtn
     */
    public JButton saveButton() {
        return saveBtn;
    }

    /**
     * Returns the draggable area
     *
     * @return
     */
    public JLabel bg() {
        return bg;
    }

    /**
     * Returns an icon which is yellow when the database is connected
     *
     * @return Jlabel dbOn
     */
    public JLabel dbOn() {
        return dbOn;
    }

    /**
     * returns the table
     *
     * @return
     */
    public JTable mainTable() {
        return mainTable;
    }

    /**
     * Search COmbo Box for searching the db
     *
     * @return JComboBox
     */
    public JComboBox searchComboBox() {
        return searchBox;
    }

    /**
     * The category combo box for type of fee to be paid
     *
     * @return JComboBox
     */
    public JComboBox getCategoryComboBox() {
        return categoryComboBox;
    }
    
    /**
     * The amount that is being paid by current student under question
     * @return amtPaidTxtField
     */
     public JTextField getAmountPaidField() {
        return amtPaidTxtField;
    }
     
     public JLabel amountPaidLabel(){
         return amountPaidLabel;
     }

    /**
     * Returns the name of the currently displaying student This was made a
     * JLabel in order to fit design
     *
     * @return studName
     */
    public JLabel studName() {
        return studName;
    }
    
    /**
     * Returns the home button of the Main View
     * @return JLabel home
     */
    public JLabel home(){
        return home;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addStudent;
    private javax.swing.JLabel amountPaidLabel;
    private javax.swing.JTextField amtPaidTxtField;
    private javax.swing.JLabel bg;
    private javax.swing.JComboBox categoryComboBox;
    private javax.swing.JLabel close;
    private javax.swing.JLabel dbOn;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mainTable;
    private javax.swing.JLabel maximise;
    private javax.swing.JLabel minimise;
    private javax.swing.JLabel pay;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox searchBox;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel settings;
    private javax.swing.JLabel studDelete;
    private javax.swing.JLabel studHistory;
    private javax.swing.JLabel studImage;
    private javax.swing.JLabel studName;
    private javax.swing.JLabel studView;
    private javax.swing.JLabel viewHistory;
    // End of variables declaration//GEN-END:variables

   

}
