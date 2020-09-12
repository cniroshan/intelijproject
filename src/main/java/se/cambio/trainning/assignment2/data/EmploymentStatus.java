package se.cambio.trainning.assignment2.data;

public enum EmploymentStatus
{
  FullTime(0), PartTime(1), Retired(2), Student(3), Unemployed(4);

  private int value;

  private EmploymentStatus(int value)
  {
    this.value = value;
  }

  public int getValue()
  {
    return value;
  }

}
