/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddStaff.java
 *
 * Created on Mar 14, 2012, 5:48:48 PM
 */
package gui;

import core.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class AddStaff extends javax.swing.JFrame {

    /** Creates new form AddStaff */
    public AddStaff() throws SQLException {
        initComponents();

        // load Dept *****
        Vector v = new Vector();
        v.add("Select Dept");
        ResultSet r = DB.executeQuery("select id from departments");
        if (r != null) {
            while (r.next()) {
                v.add(r.getString("id"));
            }
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(v));
        DB.flushStatementOnly();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Staff");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane6.setViewportView(jTextArea3);

        jLabel10.setText("Description");

        jLabel9.setText("Dept");

        jButton9.setText("Cancel");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelmp(evt);
            }
        });

        jLabel7.setText("Name");

        jLabel8.setText("Id");

        jButton8.setText("Add");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addmp(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, 288, Short.MAX_VALUE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(382, 284));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelmp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelmp
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cancelmp

    private void addmp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addmp
        if (jTextField10.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Enter Staff Name !!!");
        }
        else if (jTextField9.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Enter Staff ID !!!");
        }
        else if (jComboBox1.getSelectedItem().toString().contentEquals("Select Dept")) {
            JOptionPane.showMessageDialog(rootPane, "Select a Department !!!");
        }
        else {
            try {
                ResultSet r = DB.executeQuery("select * from staffs where id='" + jTextField9.getText() + "'");
                if (r != null && r.next()) {
                    JOptionPane.showMessageDialog(rootPane, "Staff ID Already Exists !!!");
                } 
                else {
                    if (DB.executeUpdate("insert into staffs values('" + jTextField9.getText() + "','" + jTextField10.getText() + "','" + jComboBox1.getSelectedItem().toString() + "','" + jTextArea3.getText() + "')")) {
                        JOptionPane.showMessageDialog(rootPane, "Staffs Added Susseccfully");
                    } 
                    else {
                        JOptionPane.showMessageDialog(rootPane, "Staffs Addition Failed !!!");
                    }
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(AddStaff.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                DB.flushStatementOnly();
            }
        }
    }//GEN-LAST:event_addmp

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddStaff().setVisible(true);
                } 
                catch (SQLException ex) {
                    Logger.getLogger(AddStaff.class.getName()).log(Level.SEVERE, null, ex);
                }
                finally {
                    DB.flushStatementOnly();
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
