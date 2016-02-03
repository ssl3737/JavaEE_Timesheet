package ca.bcit.infosys.inventory.access;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import ca.bcit.infosys.inventory.model.Credentials;
import ca.bcit.infosys.inventory.model.Timesheet;

/**
 * Handle CRUD actions for Timesheet class.
 * @author Soran Shim
 * @author Calvin Yee
 */
@SessionScoped
public class TimesheetManager implements Serializable {
    /** dataSource for connection pool on JBoss AS 7 or higher. */
    @Resource(mappedName = "java:jboss/datasources/inventory")
    private DataSource dataSource;
    /** Inject login bean. */
    @Inject private Credentials login;

    /**
     * Find Inventory2 record from database.
     * @param id
     *            primary key of record to be returned.
     * @return the Inventory record with key = id, null if not found.
     */
    public Timesheet find(int id) {
        Connection connection = null;
        Statement stmt = null;
        try {
            try {
                connection = dataSource.getConnection();
                try {
                    stmt = connection.createStatement();
                    ResultSet result = stmt.executeQuery(
                            "SELECT * FROM Inventory2 where EmployeeID = '"
                                    + id + "'");
                    if (result.next()) {
                        return new Timesheet(
                                result.getInt("EmployeeID"),
                                result.getString("WeekDate"),
                                result.getString("ProjectID"),
                                result.getString("WorkPackage"),
                                result.getInt("Sat"),
                                result.getInt("Sun"),
                                result.getInt("Mon"),
                                result.getInt("Tue"),
                                result.getInt("Wed"),
                                result.getInt("Thu"),
                                result.getInt("Fri"),
                                result.getString("Notes"));
                    } else {
                        return null;
                    }
                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in find " + id);
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Persist Timesheet record to database.
     * @param timesheet
     *            the record to be persisted.
     */
   public void persist(Timesheet timesheet) {
        //order of fields in INSERT statement
       final int employeeID = 1;
       final int weekDate = 2;
       final int projectID = 3;
       final int workPackage = 4;
       final int sat = 5;
       final int sun = 6;
       final int mon = 7;
       final int tue = 8;
       final int wed = 9;
       final int thu = 10;
       final int fri = 11;
       final int notes = 12;
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            try {
                connection = dataSource.getConnection();
                try {
                    stmt = connection
                            .prepareStatement("INSERT INTO Inventory2 "
                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    stmt.setInt(employeeID, timesheet.getEmployeeId());
                    stmt.setString(weekDate, timesheet.getEndWeek());
                    stmt.setString(projectID, timesheet.getProjectId());
                    stmt.setString(workPackage, timesheet.getWorkPackage());
                    stmt.setInt(sat, timesheet.getSat());
                    stmt.setInt(sun, timesheet.getSun());
                    stmt.setInt(mon, timesheet.getMon());
                    stmt.setInt(tue, timesheet.getTue());
                    stmt.setInt(wed, timesheet.getWed());
                    stmt.setInt(thu, timesheet.getThu());
                    stmt.setInt(fri, timesheet.getFri());
                    stmt.setString(notes, timesheet.getNotes());
                    stmt.executeUpdate();
                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in persist " + timesheet);
            ex.printStackTrace();
        }
    }

    /**
     * merge Timesheet record fields into existing inventory2 database record.
     * @param timesheet
     *            the record to be merged.
     */
    public void merge(Timesheet timesheet) {
        //order of fields in UPDATE statement
        final int projectID = 1;
        final int workPackage = 2;
        final int sat = 3;
        final int sun = 4;
        final int mon = 5;
        final int tue = 6;
        final int wed = 7;
        final int thu = 8;
        final int fri = 9;
        final int notes = 10;
        final int employeeID = 11;
        final int weekDate = 12;

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            try {
                connection = dataSource.getConnection();

                try {
                    stmt = connection.prepareStatement("UPDATE Inventory2 "
                           + "SET  ProjectID = ?, "
                           + "WorkPackage = ?, Sat = ?, "
                           + "Sun = ?, Mon = ?, "
                           + "Tue = ?, Wed = ?, "
                           + "Thu = ?, Fri = ?, "
                           + "Notes = ? WHERE EmployeeID = ? AND WeekDate = ?");
                    stmt.setString(projectID, timesheet.getProjectId());
                    stmt.setString(workPackage, timesheet.getWorkPackage());
                    stmt.setInt(sat, timesheet.getSat());
                    stmt.setInt(sun, timesheet.getSun());
                    stmt.setInt(mon, timesheet.getMon());
                    stmt.setInt(tue, timesheet.getTue());
                    stmt.setInt(wed, timesheet.getWed());
                    stmt.setInt(thu, timesheet.getThu());
                    stmt.setInt(fri, timesheet.getFri());
                    stmt.setString(notes, timesheet.getNotes());
                    stmt.setInt(employeeID, timesheet.getEmployeeId());
                    stmt.setString(weekDate, timesheet.getEndWeek());
                    stmt.executeUpdate();
                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in merge " + timesheet);
            ex.printStackTrace();
        }
    }

    /**
     * Remove timesheet item from database.
     * @param timesheet
     *            record to be removed from database
     */
    public void remove(Timesheet timesheet) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            try {
                connection = dataSource.getConnection();
                try {
                    stmt = connection.prepareStatement(
                            "DELETE FROM Inventory2 "
                            + "WHERE EmployeeID = ? AND WeekDate= ?");
                    stmt.setInt(1, timesheet.getEmployeeId());
                    stmt.executeUpdate();
                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in remove " + timesheet);
            ex.printStackTrace();
        }
    }

    /**
     * Return Inventory table as array of Timesheet.
     * @return Timesheet[] of all records in Inventory2 table
     */
    public Timesheet[] getAll() {
        ArrayList<Timesheet> inventory2 = new ArrayList<Timesheet>();
        Connection connection = null;
        Statement stmt = null;
        try {
            try {
                connection = dataSource.getConnection();
                try {
                    stmt = connection.createStatement();
                    ResultSet result = stmt
                            .executeQuery("SELECT * FROM Inventory2 "
                             + "WHERE EmployeeID = " + login.getEmployeeId());
                    while (result.next()) {
                        inventory2.add(new Timesheet(
                                result.getInt("EmployeeID"),
                                result.getString("WeekDate"),
                                result.getString("ProjectID"),
                                result.getString("WorkPackage"),
                                result.getInt("Sat"),
                                result.getInt("Sun"),
                                result.getInt("Mon"),
                                result.getInt("Tue"),
                                result.getInt("Wed"),
                                result.getInt("Thu"),
                                result.getInt("Fri"),
                                result.getString("Notes")));
                    }
                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in getAll");
            //ex.printStackTrace();
            return null;
        }
        Timesheet[] invarray = new Timesheet[inventory2.size()];
        return inventory2.toArray(invarray);
    }
}