package ca.bcit.infosys.inventory;

import ca.bcit.infosys.inventory.model.Employee;

/**
 * Product which has fields indicating it is editable or to be deleted.
 * @author blink
 * @version 1
 */
public class EditableEmployee {
    /** Indicates associated employee can be edited on a form.*/
    private boolean editable;
    /** Holds employee to be displayed, edited or deleted.*/
    private Employee employee;
    /**
     * Convenience constructor.
     * @param employee employee to be displayed, edited or deleted.
     */
    public EditableEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Returns true if associated employee is editable.
     * @return the editable state
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * Set whether associated employee is editable.
     * @param editable the state of editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setProduct(Employee employee) {
        this.employee = employee;
    }
}