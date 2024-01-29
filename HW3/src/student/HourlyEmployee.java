package student;


public class HourlyEmployee {
  private String name;
  private String id;
  private double hourlySalary;
  private double normalHours;

  public HourlyEmployee(String name, String id, double hourlySalary, double normalHours) {
    if (name == null || name.trim().isEmpty() || id == null ||id.trim().isEmpty()) {
      throw new IllegalArgumentException("Name and ID should not be empty, please check again!");
    }
    if (normalHours < 0 || normalHours > 80) {
      throw new IllegalArgumentException("The normal weekly hours are beyond the  constraint!");
    }
    if() {

    }


    this.name = name;
    this.id = id;
    this.hourlySalary = hourlySalary;
    this.normalHours = normalHours;

  }
  /**
   * This method allows HourlyEmployees to supersede the number of hours worked for the week.
   */
  public void setSpecialHours(double hours) {

  }






}
