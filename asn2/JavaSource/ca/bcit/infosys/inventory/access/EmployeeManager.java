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
import ca.bcit.infosys.inventory.model.Employee;

/**
 * Handle CRUD actions for Employee class.
 * @author Soran Shim
 * @author Calvin Yee
 */
@SessionScoped
public class EmployeeManager implements Serializable {
    /** dataSource for connection pool on JBoss AS 7 or higher. */
    @Resource(mappedName = "java:jboss/datasources/inventory")
    private DataSource dataSource;
    /** Inject login bean. */
    @Inject
    private Credentials login;
    /** Inject employee bean. */
    @Inject
    private Employee theEmployee;
    /**
     * EmployeeManager loggedIn.
     */
    private boolean loggedIn = false;

    /**
     * Find Inventory record from database.
     * @param id
     *            primary key of record to be returned.
     * @return the Inventory record with key = id, null if not found.
     */
    public Employee find(int id) {
        Connection connection = null;
        Statement stmt = null;
        try {
            try {
                connection = dataSource.getConnection();
                try {
                    stmt = connection.createStatement();
                    ResultSet result = stmt.executeQuery(
                            "SELECT * FROM Inventory where EmployeeID = '"
                                    + id + "'");
                    if (result.next()) {
                        return new Employee(result.getInt("EmployeeID"),
                                result.getString("FName"),
                                result.getString("LName"),
                                result.getString("Password"),
                                result.getString("Username"));
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
     * Persist Employee record to database.
     * @param employee
     *            the record to be persisted.
     */
   public void persist(Employee employee) {
        //order of fields in INSERT statement
        final int employeeID = 1;
        final int fName = 2;
        final int lName = 3;
        final int password = 4;
        final int username = 5;
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            try {
                connection = dataSource.getConnection();
                try {
                    stmt = connection
                            .prepareStatement("INSERT INTO Inventory "
                                    + "VALUES (?, ?, ?, ?, ?)");
                    stmt.setInt(employeeID, employee.getEmployeeId());
                    stmt.setString(fName, employee.getFname());
                    stmt.setString(lName, employee.getLname());
                    stmt.setString(password, employee.getPassword());
                    stmt.setString(username, employee.getUsername());
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
            System.out.println("Error in persist " + employee);
            ex.printStackTrace();
        }
    }

   /**
    * Add Employee record to database.
    *            primary key of record to be returned.
    */
   public void addEmployee() {
       //order of fields in INSERT statement
       final int employeeID = 1;
       final int fName = 2;
       final int lName = 3;
       final int password = 4;
       final int username = 5;
       final int supervisor = 6;

       Connection connection = null;
       PreparedStatement stmt = null;
       try {
           try {
               connection = dataSource.getConnection();
               try {
                   stmt = connection
                           .prepareStatement("INSERT INTO Inventory "
                                   + "VALUES (?, ?, ?, ?, ?, ?)");
                   stmt.setInt(employeeID, theEmployee.getEmployeeId());
                   stmt.setString(fName, theEmployee.getFname());
                   stmt.setString(lName, theEmployee.getLname());
                   stmt.setString(password, theEmployee.getPassword());
                   stmt.setString(username, theEmployee.getUsername());
                   stmt.setBoolean(supervisor, false);
                   stmt.executeUpdate();
                   System.out.println("Executed addEmployee");
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
           System.out.println("Error in persist " + theEmployee);
           ex.printStackTrace();
       }
   }

   /**
    * Chanage Password of Employee record to database.
    */
   public void changePassword(Employee employee) {
       //order of fields in INSERT statement
       final int employeeID = 2;
       final int password = 1;

       Connection connection = null;
       PreparedStatement stmt = null;
       try {
           try {
               connection = dataSource.getConnection();
               try {
                   stmt = connection
                           .prepareStatement("UPDATE Inventory "
                                   + "SET Password = ? WHERE EmployeeID = ?");
                   stmt.setString(password, employee.getPassword());
                   stmt.setInt(employeeID, employee.getEmployeeId());
                   stmt.executeUpdate();
                   System.out.println("Executed addEmployee");
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
           System.out.println("Error in persist " + employee);
           ex.printStackTrace();
       }
   }
   /**
     * merge Employee record fields into existing inventory database record.
     * @param employee
     *            the record to be merged.
     */
    public void merge(Employee employee) {
        //order of fields in UPDATE statement

        final int fName = 1;
        final int lName = 2;
        final int password = 3;
        final int username = 4;
        final int employeeID = 5;
        Connection connection = null;
        PreparedStatement stmt = null;

        System.out.println("Dataconnection");
        try {
            try {
                connection = dataSource.getConnection();

                try {
                    stmt = connection.prepareStatement("UPDATE Inventory "
                            + "SET FName = ?, "
                            + "LName = ?, Password = ?, "
                            + "Username = ? WHERE EmployeeID =  ?");
                    stmt.setString(fName, employee.getFname());
                    stmt.setString(lName, employee.getLname());
                    stmt.setString(password, employee.getPassword());
                    stmt.setString(username, employee.getUsername());
                    stmt.setInt(employeeID, employee.getEmployeeId());
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
            System.out.println("Error in merge " + employee);
            ex.printStackTrace();
        }
    }

    /**
     * Remove employee item from database.
     * @param employee
     *            record to be removed from database
     */
    public void remove(Employee employee) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            try {
                connection = dataSource.getConnection();
                try {
                    stmt = connection.prepareStatement(
                            "DELETE FROM Inventory WHERE EmployeeID =  ?");
                    stmt.setInt(1, employee.getEmployeeId());
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
            System.out.println("Error in remove " + employee);
            ex.printStackTrace();
        }
    }

   /**
     * Return Inventory table as array of Inventory.
     *
     * @return Employee[] of all records in Inventory table
     */
    public Employee[] getEmployeeForPassword() {
        ArrayList<Employee> inventory = new ArrayList<Employee>();
        Connection connection = null;
        Statement stmt = null;
        try {
            try {
                connection = dataSource.getConnection();

                try {
                    stmt = connection.createStatement();
                    ResultSet result = stmt
                            .executeQuery("SELECT * FROM Inventory "
                             + "WHERE EmployeeID = " + login.getEmployeeId());
                    while (result.next()) {
                        inventory.add(new Employee(
                                result.getInt("EmployeeID"),
                                result.getString("FName"),
                                result.getString("LName"),
                                result.getString("Password"),
                                result.getString("Username")));

                        System.out.println("getEmployeeForPassword");
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
            System.out.println("Error in getEmployeeForPassword");
            //ex.printStackTrace();
            return null;
        }

        Employee[] invarray = new Employee[inventory.size()];
        return inventory.toArray(invarray);
    }

    /**
     * Return Inventory table as array of Employee.
     *
     * @return Employee[] of all records in Inventory table
     */
    public Employee[] getAll() {
        ArrayList<Employee> inventory = new ArrayList<Employee>();
        Connection connection = null;
        Statement stmt = null;
        try {
            try {
                connection = dataSource.getConnection();

                try {
                    stmt = connection.createStatement();
                    ResultSet result = stmt
                            .executeQuery("SELECT * FROM Inventory "
                                    + "ORDER BY EmployeeID");
                    while (result.next()) {
                        inventory.add(new Employee(
                                result.getInt("EmployeeID"),
                                result.getString("FName"),
                                result.getString("LName"),
                                result.getString("Password"),
                                result.getString("Username")));
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

        Employee[] invarray = new Employee[inventory.size()];
        return inventory.toArray(invarray);
    }

    /**
     * Validate Employee.
     *
     * @return loggedIn
     */
    public String validateEmployee() {
        Connection connection = null;
        Statement stmt = null;
        try {
            try {
                connection = dataSource.getConnection();

                try {
                    stmt = connection.createStatement();
                    ResultSet result = stmt
                            .executeQuery("SELECT * FROM Inventory "
                            + "WHERE Username = '" + login.getUserName()
                            + "' AND Password = '" + login.getPassword() + "'");
                    System.out.println("Username and Password");
                    System.out.println(login.getUserName());
                    System.out.println(login.getPassword());
                    if (result.next()) {
                        login.setSupervisor(result.getBoolean("SuperUser"));
                        login.setEmployeeId(result.getInt("EmployeeID"));
                        login.setFirstName(result.getString("FName"));
                        login.setLastName(result.getString("LName"));
                        return "loggedIn";
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
            System.out.println("Error in validate employee");
            ex.printStackTrace(System.out);
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
