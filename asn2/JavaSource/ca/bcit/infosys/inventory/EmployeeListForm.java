package ca.bcit.infosys.inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ca.bcit.infosys.inventory.access.EmployeeManager;
import ca.bcit.infosys.inventory.model.Credentials;
import ca.bcit.infosys.inventory.model.Employee;

/**
 * Helper class for display Employee page.
 * @author Soran Shim
 * @author Calvin Yee
 */
 @Named
 @SessionScoped
public class EmployeeListForm implements Serializable {

     /** The employeeManager bean. */
     @Inject private EmployeeManager employeeManager;

     /** The conversation bean. */
     @Inject private Conversation conversation;

     /** The list of editableEmployees in the database. */
     private List<EditableEmployee> list;

     /** Manager from Credentials objects.*/
     @Inject
     private Credentials login;

     /** EmployeeListFrom Supervisor is.*/
     private boolean isSupervisor;

     /**
      * Gets the List of EditableEmployee.
      * @return list
      */
    public List<EditableEmployee> getList() {
        if (list == null) {
            refreshList();
        }
        return list;
    }

    /**
     * Refresh List of Emloyees.
     */
    private void refreshList() {
        isSupervisor = login.getSupervisor();
        if (!isSupervisor) {
            Employee[] employees = employeeManager.getEmployeeForPassword();
            list = new ArrayList<EditableEmployee>();
            for (int i = 0; i < employees.length; i++) {
                list.add(new EditableEmployee(employees[i]));
            }
        }
        if (isSupervisor) {
            Employee[] employees = employeeManager.getAll();
            list = new ArrayList<EditableEmployee>();
            for (int i = 0; i < employees.length; i++) {
                list.add(new EditableEmployee(employees[i]));
            }
        }
    }

    /**
     * Sets the List of editableEmployee.
     * @param ep to be set
     */
    public void setList(List<EditableEmployee> ep) {
        list = ep;
    }

     /**
      * Delete the employee and return to the same page.
      * @param e the employee to be deleted
      */
    public String deleteRow(EditableEmployee e) {
         employeeManager.remove(e.getEmployee());
         list.remove(e);
         return null;
     }

    /**
     * Adds Employee.
     */
     public String addEmployee() {
         employeeManager.addEmployee();
         refreshList();
         return "createdEmployee";
     }

     /**
      * Changeds password of Employee.
      */
     public String changePassword() {
         for (EditableEmployee e : list) {
             if (e.isEditable()) {
                 employeeManager.changePassword(e.getEmployee());
                 e.setEditable(false);
             }
         }
         return "changePassword";
     }

     /**
      * Saves updated employee's infomation.
      */
     public String save() {
         for (EditableEmployee e : list) {
             if (e.isEditable()) {
                 employeeManager.merge(e.getEmployee());
                 e.setEditable(false);
             }
         }
         return null;
     }

     /**
      * Validate Employees.
      */
     public String validateEmployee() {
         String navigation = employeeManager.validateEmployee();
         return navigation;
     }
}