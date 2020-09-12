package se.cambio.trainning.assignment2.data;

import se.cambio.trainning.assignment2.util.AgeCalculatorUtil;

import java.util.Date;

public class PatientData
{
  private int id;

  private String name;

  private Date birthday;

  private String age;

  private String address;

  private Gender gender;

  private String telephoneNumber;

  private EmploymentStatus employmentStatus;

  public PatientData()
  {
  }

  public PatientData(int id, String name, Date birthday, String address, Gender gender, String telephoneNumber,
                     EmploymentStatus employmentStatus)
  {
    super();
    this.id = id;
    this.name = name;
    this.birthday = birthday;
    this.address = address;
    this.gender = gender;
    this.telephoneNumber = telephoneNumber;
    this.employmentStatus = employmentStatus;
    this.age = AgeCalculatorUtil.calculateAgeAndGenerateFormattedString(birthday);
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Date getBirthday()
  {
    return birthday;
  }

  public void setBirthday(Date birthday)
  {
    this.birthday = birthday;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public Gender getGender()
  {
    return gender;
  }

  public void setGender(Gender gender)
  {
    this.gender = gender;
  }

  public String getTelephoneNumber()
  {
    return telephoneNumber;
  }

  public void setTelephoneNumber(String telephoneNumber)
  {
    this.telephoneNumber = telephoneNumber;
  }

  public EmploymentStatus getEmploymentStatus()
  {
    return employmentStatus;
  }

  public void setEmploymentStatus(EmploymentStatus employmentStatus)
  {
    this.employmentStatus = employmentStatus;
  }

  public String getAge()
  {
    return age;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setAge(String age)
  {
    this.age = age;
  }

}
