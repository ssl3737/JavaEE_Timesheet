package ca.bcit.infosys.inventory.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * Login Credentials.
 * @author blink
 */
@Named("login") // or @ManagedBean(name="user")
@SessionScoped
public class Credentials implements Serializable {

    private static final long serialVersionUID = 1L;
    /** The login ID. */
    private String userName;
    /** The password. */
    private String password;
    /** Employee ID. */
    private int employeeId;
    /** Whether or not employee is supervisor. */
    private boolean isSupervisor;
    /**
     * Employee first name.
     */
    private String firstName;
    /**
     * Employee last name.
     */
    private String lastName;
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     * @param id the userName to set
     */
    public void setUserName(final String id) {
        userName = id;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param pw the password to set
     */
    public void setPassword(final String pw) {
        password = pw;
    }

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.
                getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "/login?faces-redirect=true";
    }

    /**
     * Gets if employee is supervisor or not.
     * @return if the employee is a supervisor
     */
    public boolean getSupervisor() {
        return isSupervisor;
    }

    /**
     * Sets if the employee is supervisor.
     * @param newSupervisor whether employee is supervisor or not
     */
    public void setSupervisor(boolean newSupervisor) {
        isSupervisor = newSupervisor;
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
     * Gets the last name.
     * @return lastName Last name of employee
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the last name.
     * @param lastName Last Name you want to set it to
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Gets the first name.
     * @return firstName First name of employee
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Sets the first name.
     * @param firstName First Name you want to set it to
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}