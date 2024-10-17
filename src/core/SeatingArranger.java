/*
 * SeatArranger.java
 *
 * this class contains the methods for arranging the seats
 */
package core;

import gui.ExamSeatingArranger_WaitScreen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class SeatingArranger {

    public static String ExamID;

    public static void Arrange() throws SQLException {
        // showing wait screen ...
        ExamSeatingArranger_WaitScreen waitScreen = new ExamSeatingArranger_WaitScreen();
        waitScreen.Show();
        //........... commom variables ..................
        ResultSet r;
        // ####### delete previous seating arrangements ................
        DB.executeUpdate("delete from seatings where examid=" + SeatingArranger.ExamID);
        // ####### select all students...
        Vector<String> Students = new Vector<String>();
        int StudentIndex = 0;
        // ...................select all batches for the exam...
        Vector<String> Batches = new Vector<String>();
        r = DB.executeQuery("select distinct batchid from examsubjectandbatches where examid=" + SeatingArranger.ExamID);
        while (r != null && r.next()) {
            Batches.add(r.getString("batchid"));
        }
        DB.flushStatementOnly();
        // ...................select students of that batch ...
        for (String batch : Batches) {
            r = DB.executeQuery("select regno from students where batchid=" + batch + " order by regno");
            while (r != null && r.next()) {
                Students.add(r.getString("regno"));
            }
            DB.flushStatementOnly();
        }
        // ####### select all halls...
        Vector<String> Halls = new Vector<String>();
        r = DB.executeQuery("select hallname from selectedexamhalls where examid=" + SeatingArranger.ExamID);
        while (r != null && r.next()) {
            Halls.add(r.getString("hallname"));
        }
        DB.flushStatementOnly();
        // ###### select all non registered students ................
        Vector<String> NonRegStudents = new Vector<String>();
        r = DB.executeQuery("select studentregno from nonregisteredstudents where examid=" + SeatingArranger.ExamID);
        while (r != null && r.next()) {
            NonRegStudents.add(r.getString("studentregno"));
        }
        DB.flushStatementOnly();
        // ####### arrange...
        // ................ removing non registered students ..............
        for (String nrs : NonRegStudents) {
            Students.removeElement(nrs);
        }
        //................. shuffling the halls ................
        Collections.shuffle(Halls);
        // .....................................................

        // arrange for left side seat ......
        for (String hall : Halls) {
            // seat no initialisation ....
            int SeatNo = 1;

            r = DB.executeQuery("select noofrow,noofcol from halls where name='" + hall + "'");
            r.next();
            // get no of rows
            int noofrow = Integer.parseInt(r.getString("noofrow"));
            // get no og cols
            int noofcol = Integer.parseInt(r.getString("noofcol"));
            DB.flushStatementOnly();
            // for rows*cols
            for (int i = 1; i <= noofcol; i++) {
                for (int j = 1; j <= noofrow; j++) {
                    // seat no L
                    DB.executeUpdate("insert into seatings values("
                            + "null" + ","
                            + SeatingArranger.ExamID + ",'"
                            + Students.elementAt(StudentIndex) + "','"
                            + hall + "','"
                            + SeatNo + "L" + "'"
                            + ")");
                    SeatNo++;
                    StudentIndex++;
                    // break if students are finished .....
                    if (StudentIndex == Students.size()) {
                        j = noofrow + 10;
                        i = noofcol + 10;
                        break;
                    }
                }
            }
            // break if students are finished .....
            if (StudentIndex == Students.size()) {
                break;
            }
        }

        // arrange for right side seat ......
        for (String hall : Halls) {
            // break if students are finished .....
            if (StudentIndex == Students.size()) {
                break;
            }
            // seat no initialisation ....
            int SeatNo = 1;

            r = DB.executeQuery("select noofrow,noofcol from halls where name='" + hall + "'");
            r.next();
            // get no of rows
            int noofrow = Integer.parseInt(r.getString("noofrow"));
            // get no og cols
            int noofcol = Integer.parseInt(r.getString("noofcol"));
            // for rows*cols
            DB.flushStatementOnly();
            for (int i = 1; i <= noofcol; i++) {
                for (int j = 1; j <= noofrow; j++) {
                    // seat no L
                    DB.executeUpdate("insert into seatings values("
                            + "null" + ","
                            + SeatingArranger.ExamID + ",'"
                            + Students.elementAt(StudentIndex) + "','"
                            + hall + "','"
                            + SeatNo + "R" + "'"
                            + ")");
                    SeatNo++;
                    StudentIndex++;
                    // break if students are finished .....
                    if (StudentIndex == Students.size()) {
                        j = noofrow + 10;
                        i = noofcol + 10;
                        break;
                    }
                }
            }
        }
        DB.flushStatementOnly();
        // on finishing arrangement closing the wait screen ....
        JOptionPane.showMessageDialog(waitScreen, "Seating Arrangment Completed");
        waitScreen.Close();

    }
}
