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
public class ExamSeatingArranger extends javax.swing.JFrame {

    /** Creates new form ExamSeatingArranger */
    public ExamSeatingArranger() {
        try {
            initComponents();
            loadDataToField();
        } 
        catch (SQLException ex) {
            Logger.getLogger(ExamSeatingArranger.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            DB.flushStatementOnly();
        }
    }

    private void loadDataToField() throws SQLException {
        // calculating total no of subjects..........................
        ResultSet r = DB.executeQuery("select count(distinct subjectid) from examsubjectandbatches where examid=" + SeatingArranger.ExamID);
        if (r != null && r.next()) {
            jTextField1.setText(r.getString(1));
        } 
        else {
            jTextField1.setText("NO DATA FOUND");
        }
        DB.flushStatementOnly();
        // calculating total no of batches.........................
        r = DB.executeQuery("select count(distinct batchid) from examsubjectandbatches where examid=" + SeatingArranger.ExamID);
        if (r != null && r.next()) {
            jTextField2.setText(r.getString(1));
        } 
        else {
            jTextField2.setText("NO DATA FOUND");
        }
        DB.flushStatementOnly();
        // calculating total no of students..........................
        r = DB.executeQuery("select distinct batchid from examsubjectandbatches where examid=" + SeatingArranger.ExamID);
        Vector<String> v = new Vector<String>();
        while (r != null && r.next()) {
            v.add(r.getString(1));
        }
        DB.flushStatementOnly();
        int TotNoOfStudents = 0;

        for (String s : v) {
            r = DB.executeQuery("select count(*) from students where batchid=" + s);
            if (r != null && r.next()) {
                TotNoOfStudents += Integer.parseInt(r.getString(1));
            }
            DB.flushStatementOnly();
        }
        jTextField3.setText("" + TotNoOfStudents);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exam Seating Arranger");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Exam Details"));

        jLabel1.setText("No. of Subjects");

        jLabel2.setText("No. of Batches");

        jTextField1.setEditable(false);

        jTextField2.setEditable(false);

        jLabel3.setText("No. of Students");

        jTextField3.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Halls");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hallsMP(evt);
            }
        });

        jButton2.setText("Non Registered Students");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nonRegStudentsMP(evt);
            }
        });

        jButton3.setText("Exam Duty Staffs");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                examDutyStaffsMP(evt);
            }
        });

        jButton4.setText("START SEATING ARRANGEMENT");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                startSeatingArrangementMP(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(428, 335));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void hallsMP(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hallsMP
        ExamSeatingArranger_HallSelect.main(null);
    }//GEN-LAST:event_hallsMP

    private void nonRegStudentsMP(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nonRegStudentsMP
        ExamSeatingArranger_NonRegStudentsSelect.main(null);
    }//GEN-LAST:event_nonRegStudentsMP

    private void examDutyStaffsMP(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_examDutyStaffsMP
        ExamSeatingArranger_DutyStaffsSelect.main(null);
    }//GEN-LAST:event_examDutyStaffsMP

    private void startSeatingArrangementMP(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startSeatingArrangementMP
        try {
            if (checkRequirements()) {
                if (JOptionPane.showConfirmDialog(rootPane, "Arrange Seating For Exam: " + SeatingArranger.ExamID, "Seat Arrange", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    try {
                        SeatingArranger.Arrange();
                    } 
                    catch (SQLException ex) {
                        Logger.getLogger(ExamSeatingArranger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    finally {
                        DB.flushStatementOnly();
                    }
                }
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(ExamSeatingArranger.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            DB.flushStatementOnly();
        }
    }//GEN-LAST:event_startSeatingArrangementMP

    private boolean checkRequirements() throws SQLException {
        
        // ###################### no of students for exan = tot no of students in batch - no of non reg stdents
        int noOfStudentsForExam = 0, totNoOfStudentsInBatches = 0, noOfNonRegStudents = 0;
        ResultSet r;
        // ...................select all batches for the exam...
        Vector<String> Batches = new Vector<String>();
        r = DB.executeQuery("select distinct batchid from examsubjectandbatches where examid=" + SeatingArranger.ExamID);
        while (r != null && r.next()) {
            Batches.add(r.getString("batchid"));
        }
        DB.flushStatementOnly();
        // ...................select students of that batch ...
        for (String batch : Batches) {
            r = DB.executeQuery("select count(*) from students where batchid=" + batch);
            if (r != null && r.next()) {
                totNoOfStudentsInBatches += Integer.parseInt(r.getString(1));
            }
            DB.flushStatementOnly();
        }
        
        r = DB.executeQuery("select count(*) from nonregisteredstudents where examid=" + SeatingArranger.ExamID);
        if (r != null && r.next()) {
            noOfNonRegStudents = Integer.parseInt(r.getString(1));
        }
        noOfStudentsForExam = totNoOfStudentsInBatches - noOfNonRegStudents;
        DB.flushStatementOnly();
        // #################### total no of seats ..............................
        Vector<String> Halls = new Vector<String>();
        r = DB.executeQuery("select hallname from selectedexamhalls where examid=" + SeatingArranger.ExamID);
        while (r != null && r.next()) {
            Halls.add(r.getString("hallname"));
        }
        int row = 0, col = 0, totNoOfSeat = 0;
        DB.flushStatementOnly();
        
        for (String hall : Halls) {
            r = DB.executeQuery("select noofrow,noofcol from halls where name ='" + hall + "'");
            if (r != null && r.next()) {
                row = Integer.parseInt(r.getString("noofrow"));
                col = Integer.parseInt(r.getString("noofcol"));
                totNoOfSeat += (row * col * 2);
            }
        }

        int totNoOfHalls = Halls.size();
        DB.flushStatementOnly();
        // find total no of duty staffs for the exam....
        int totNoOfDutyStaffs = 0;
        r = DB.executeQuery("select count(*) from examdutystaffs where examid=" + SeatingArranger.ExamID);
        if (r != null && r.next()) {
            totNoOfDutyStaffs = Integer.parseInt(r.getString(1));
        }
        DB.flushStatementOnly();
        // if tot no of seats < no of students = error need more halls
        if (totNoOfSeat < totNoOfStudentsInBatches) {
            JOptionPane.showMessageDialog(rootPane, "Halls Insufficiant ! Add More Halls !!!");
            return false;
        } // tot no of halls > tot no of staffs = error need more staffs
        else if (totNoOfDutyStaffs < totNoOfHalls) {
            JOptionPane.showMessageDialog(rootPane, "Duty Staffs Insufficiant ! Add More Duty Staffs !!!");
            return false;
        } // else = ok
        else {
            return true;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DB.flushStatementOnly();
                new ExamSeatingArranger().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
