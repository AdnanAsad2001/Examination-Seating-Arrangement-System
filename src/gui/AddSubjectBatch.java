/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddSubjectBatch.java
 *
 * Created on Mar 22, 2012, 12:22:41 PM
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
public class AddSubjectBatch extends javax.swing.JFrame {
    static String ExamID;

    /* Creates new form AddSubjectBatch
     * @throws java.sql.SQLException */
    public AddSubjectBatch() throws SQLException {
        initComponents();

        // load subjects *****
        Vector v = new Vector();
        v.add("Select Subject");
        ResultSet r = DB.executeQuery("select id from subjects");
        if (r != null) {
            while (r.next()) {
                v.add(r.getString("id"));
            }
        }
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(v));
        DB.flushStatementOnly();
        // load batch *****
        Vector v2 = new Vector();
        v2.add("Select Batch");
        ResultSet r2 = DB.executeQuery("select id from batches");
        if (r2 != null) {
            while (r2.next()) {
                v2.add(r2.getString("id"));
            }
        }
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(v2));
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

        jButton12 = new javax.swing.JButton();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox8 = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Subject-Batch");

        jButton12.setText("Cancel");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelMP(evt);
            }
        });

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Batch" }));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Subject" }));

        jLabel22.setText("Batch");

        jLabel23.setText("Subject");

        jButton11.setText("Add");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Save_MP(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox8, 0, 206, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox6, 0, 206, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton11, jButton12});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton11))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(279, 166));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelMP(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMP
        this.setVisible(false);
        this.dispose();
}//GEN-LAST:event_cancelMP

    private void Save_MP(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_MP
        if (jComboBox8.getSelectedItem().toString().contentEquals("Select Subject")) {
            JOptionPane.showMessageDialog(rootPane, "Select a Subject !!!");
        }
        else if (jComboBox6.getSelectedItem().toString().contentEquals("Select Batch")) {
            JOptionPane.showMessageDialog(rootPane, "Select a Batch !!!");
        }
        else {
            ResultSet r = DB.executeQuery("select * from examsubjectandbatches where "+
                                                                            "examid="+ExamID+" and  "+
                                                                            "subjectid="+jComboBox8.getSelectedItem().toString()+" and "+
                                                                            "batchid="+jComboBox6.getSelectedItem().toString());
            DB.flushStatementOnly();
            try {
                if (r != null && r.next()) {
                    JOptionPane.showMessageDialog(rootPane, "Subject-Batches Already Exists !!!");
                } 
                else {
                    if (DB.executeUpdate("insert into examsubjectandbatches values(" + "null" + "," + ExamID + "," + jComboBox8.getSelectedItem().toString() + ", " + jComboBox6.getSelectedItem().toString() + ")")) {
                        JOptionPane.showMessageDialog(rootPane, "Subject-Batches Added Susseccfully");
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "Subject-Batches Addition Failed !!!");
                    }
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(AddSubjectBatch.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                DB.flushStatementOnly();
            }
        }
}//GEN-LAST:event_Save_MP

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddSubjectBatch().setVisible(true);
                }
                catch (SQLException ex) {
                    Logger.getLogger(AddSubjectBatch.class.getName()).log(Level.SEVERE, null, ex);
                }
                finally {
                    DB.flushStatementOnly();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    // End of variables declaration//GEN-END:variables

}
