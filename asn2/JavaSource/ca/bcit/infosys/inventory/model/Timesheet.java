package ca.bcit.infosys.inventory.model;

/**
 * A class representing a single row of a Timesheet.
 *
 * @author Soran Shim
 * @author Calvin Yee
 */
public class Timesheet {
    /** Editable. */
    private boolean editable;
    /** Employee ID. */
    private int employeeId;
    /** The projectID. */
    private String projectId;
    /** The WorkPackage. Must be a unique for a given projectID. */
    private String workPackage;
    /** Saturday. */
    private int sat;
    /** Sunday. */
    private int sun;
    /** Monday. */
    private int mon;
    /** Tuesday. */
    private int tue;
    /** Wednesday. */
    private int wed;
    /** Thursday. */
    private int thu;
    /** Friday. */
    private int fri;
    /** Notes. */
    private String notes;
    /** TotalDay. */
    private int totalDay;
    /** The date of Friday for the week of the timesheet. */
    private String endWeek;

    /**
     * Constructor for Timesheet.
     */
    public Timesheet() { }

    /**
     * Constructor for Timesheet.
     * Initialize a Timesheet with no rows and
     * for the current date.
     */
    public Timesheet(int employeeId, String endWeek, String projectId,
            String workPackage, int sat, int sun, int mon, int tue,
            int wed, int thu, int fri, String notes) {
        this.setEmployeeId(employeeId);
        this.setEndWeek(endWeek);
        this.setProjectId(projectId);
        this.setWorkPackage(workPackage);
        this.setSat(sat);
        this.setSun(sun);
        this.setMon(mon);
        this.setTue(tue);
        this.setWed(wed);
        this.setThu(thu);
        this.setFri(fri);
        this.setNotes(notes);
    }

     /**
      * ToString.
      * @return Timesheet Information
      */
    public String toString() {
        return "[" + getEmployeeId() + ", " + getEndWeek() + ", "
    + getProjectId() + ", " + getWorkPackage() + ", " +  getSat() + ", "
    + getSun() + ", " + getMon() + ", " + getTue() + ", " + getWed()
    + ", " + getThu() + ", " + getFri() + ", " + getNotes() + "]";
    }

    /**
     * @return the weekly hours
     */
    public int getTotalDay() {
        return fri + thu + tue + wed + mon + sun + sat;
    }

    /**
     * @param totalDay the totalDay to set
     */
    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
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
     * @return the projectID
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectID to set
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the workPackage
     */
    public String getWorkPackage() {
        return workPackage;
    }

    /**
     * @param workPackage the workPackage to set
     */
    public void setWorkPackage(String workPackage) {
        this.workPackage = workPackage;
    }
    /**
    *
    * @return the sat
    */
    public int getSat() {
        return sat;
    }

    /**
     *
     * @param sat the sat to set
     */
    public void setSat(int sat) {
        this.sat = sat;
    }
    /**
    *
    * @return the sun
    */
    public int getSun() {
        return sun;
    }

    /**
    *
    * @param sun the sun to set
    */
    public void setSun(int sun) {
        this.sun = sun;
    }

    /**
     *
     * @return the mon
     */
    public int getMon() {
        return mon;
    }

    /**
     *
     * @param mon the mon to set
     */
    public void setMon(int mon) {
        this.mon = mon;
    }

    /**
     *
     * @return the tue to set
     */
    public int getTue() {
        return tue;
    }

    /**
     *
     * @param tue the tue to set
     */
    public void setTue(int tue) {
        this.tue = tue;
    }

    /**
     *
     * @return the wed
     */
    public int getWed() {
        return wed;
    }

    /**
    *
    * @param wed the wed to set
    */
    public void setWed(int wed) {
        this.wed = wed;
    }

    /**
     * @return the thu
     */
    public int getThu() {
        return thu;
    }

    /**
     * @param thu the thu to set
     */
    public void setThu(int thu) {
        this.thu = thu;
    }

    /**
     * @return the fri
     */
    public int getFri() {
        return fri;
    }

    public void setFri(int fri) {
        this.fri = fri;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the endWeek
     */
    public String getEndWeek() {
        return endWeek;
    }

    /**
     * @param endWeek the endWeek to set
     */
    public void setEndWeek(String endWeek) {
        this.endWeek = endWeek;
    }
}