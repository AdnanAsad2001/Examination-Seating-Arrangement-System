/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ExamSeatingArranger.java
 *
 */
package gui;

import core.DB;
import core.SeatingArranger;
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
public class ExamSeatingArranger_DutyStaffsSelect extends javax.swing.JFrame {

    /** Creates new form ExamSeatingArranger */
    public ExamSeatingArranger_DutyStaffsSelect() {
        try {
            initComponents();
            loadDataToField();
        } 
        catch (SQLException ex) {
            Logger.getLogger(ExamSeatingArranger_DutyStaffsSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            DB.flushStatementOnly();
        }
    }

    private void loadDataToField() throws SQLException {
        // Staff list
        Vector v = new Vector();
        ResultSet r = DB.executeQuery("select name,id from staffs");
        if (r != null) {
            while (r.next()) {
                v.add(r.getString("name")+"-"+r.getString("id"));
            }
        }
        jList3.setListData(v);
        //................. loading previous data ..............................
        v = new Vector();
        ResultSet r2;
        r = DB.executeQuery("select staffid from examdutystaffs where examid=" + SeatingArranger.ExamID );
        DB.flushStatementOnly();
        if (r != null) {
            while (r.next()) {
                r2=DB.executeQuery("select name from staffs where id='"+r.getString("staffid")+"'");
                r2.next();
                v.add(r2.getString("name")+"-"+r.getString("staffid"));
            }
            DB.flushStatementOnly();
        }
        jList4.setListData(v);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jButton9 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Duty Staff Selection");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ExamSeatingArranger_DutyStaffsSelect.this.windowClosing(evt);
            }
        });

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected Staffs"));

        jScrollPane4.setViewportView(jList4);

        jButton9.setText("Add");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add_mp(evt);
            }
        });

        jButton16.setText("Remove");
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                removeMp(evt);
            }
        });

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Staff List"));

        jScrollPane3.setViewportView(jList3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(387, 434));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void add_mp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_mp
        if (jList3.getSelectedValue() != null) {
            String selectedClass = jList3.getSelectedValue().toString();

            // checking whether the class has been already added...
            boolean isAddedAlready = false;
            for (int i = 0; i < jList4.getModel().getSize(); i++) {
                if (jList4.getModel().getElementAt(i).toString().contentEquals(selectedClass)) {
                    isAddedAlready = true;
                    break;
                }
            }

            // if already added the notify ...
            if (isAddedAlready) {
                JOptionPane.showMessageDialog(rootPane, "Staff '" + selectedClass + "' has already added");
            } 
            else {
                // add it to the added list ...

                // storing previous values to a vector ..
                Vector v = new Vector();
                for (int i = 0; i < jList4.getModel().getSize(); i++) {
                    v.add(jList4.getModel().getElementAt(i).toString());
                }
                // add the newely selected class to vector ...
                v.add(selectedClass);
                // load the vector to the list ...
                jList4.setListData(v);
            }
        } 
        else {
            JOptionPane.showMessageDialog(rootPane, "Select Staff to Add");
        }
}//GEN-LAST:event_add_mp

    private void removeMp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMp
        if (jList4.getSelectedValue() != null) {
            String selectedClass = jList4.getSelectedValue().toString();

            // storing previous values to a vector ..
            Vector v = new Vector();
            for (int i = 0; i < jList4.getModel().getSize(); i++) {
                if (!jList4.getModel().getElementAt(i).toString().contentEquals(selectedClass)) {
                    v.add(jList4.getModel().getElementAt(i).toString());
                }
            }
            // load the vector to the list ...
            jList4.setListData(v);
        } 
        else {
            JOptionPane.showMessageDialog(rootPane, "Select a Staff To Be Removed");
        }
}//GEN-LAST:event_removeMp

    private void windowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosing
        // clear previous data......................
        //DB.executeUpdate("delete from examdutystaffs where examid=" + SeatingArranger.ExamID );
        DB.flushStatementOnly();
            // ......................................... SAVE ALL DATA .........................
            for (int i = 0; i < jList4.getModel().getSize(); i++) {
                //--------------------------------------------------------------------------------------------- here <down> saving only the staffid ---
                if (!DB.executeUpdate("insert into examdutystaffs values(null,'" + jList4.getModel().getElementAt(i).toString().split("-")[1] + "'," + SeatingArranger.ExamID + ")")) {
                    JOptionPane.showMessageDialog(rootPane, "Error !!! Cannot Insert Selected Staff to DB !!!");
                }
                DB.flushStatementOnly();
            }
    }//GEN-LAST:event_windowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamSeatingArranger_DutyStaffsSelect().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton9;
    private javax.swing.JList jList3;
    private javax.swing.JList jList4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
