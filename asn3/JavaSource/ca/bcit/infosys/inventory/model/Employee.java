package ca.bcit.infosys.inventory.model;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Class that contains information about Employee.
 * @author Calvin Yee
 * @author Soran Shim
 */
@Named
@SessionScoped
public class Employee implements Serializable {
    /**
     * Whether the field is in editable mode or not.
     */
    private boolean editable;
    /** Employee ID. */
    private int employeeId;
    /**
     * Employee first name.
     */
    private String fname;
    /**
     * Employee last name.
     */
    private String lname;
    /**
     * Employee password.
     */
    private String password;
    /**
     * Employee login user name.
     */
    private String username;
    /**
     * Whether or not employee is supervisor.
     */
    private boolean isSupervisor;

    /**
     * Employee constructor.
     */
    public Employee() { }

    /**
     * Employee constructor.
     */
    public Employee(int employeeId, String fname, String lname,
            String password, String username) {
        this.setEmployeeId(employeeId);
        this.setFname(fname);
        this.setLname(lname);
        this.setPassword(password);
        this.setUsername(username);
    }

    /**
     * ToString.
     * @return Employee Information
     */
    public String toString() {
        return "[" + getEmployeeId() + ", " + getFname() + ", " +  getLname()
        + ", " + getPassword() + ", " + getUsername() + "]";
    }

    /**
     * Gets whether the field is in editable mode.
     * @return editable Is the field editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * Sets whether the fields are in editable mode.
     * @param editable New editable boolean
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * Gets the employee id.
     * @return employeeId ID of the employee
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the employee id.
     * @param employeeId ID to be set
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the first name.
     * @return fname First name of employee
     */
    public String getFname() {
        return fname;
    }

    /**
     * Sets the first name.
     * @param fname First Name you want to set it to
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Gets the last name.
     * @return lname Last name of employee
     */
    public String getLname() {
        return lname;
    }

    /**
     * Sets the last name.
     * @param lname Last Name you want to set it to
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * Gets the password.
     * @return password Password of the employee
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * @param password Password to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the username.
     * @return username Username of the employee
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     * @param username to be set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets if employee is supervisor or not.
     * @return if the employee is a supervisor
     */
    public boolean isSupervisor() {
        return isSupervisor;
    }

    /**
     * Sets if the employee is supervisor.
     * @param isSupervisor whether employee is supervisor or not
     */
    public void setSupervisor(boolean isSupervisor) {
        this.isSupervisor = isSupervisor;
    }
}
