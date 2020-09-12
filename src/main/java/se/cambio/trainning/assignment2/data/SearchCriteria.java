package se.cambio.trainning.assignment2.data;

public class SearchCriteria
{
  private String name;

  private int birthYear;

  private boolean includeMale;

  private boolean includeFemale;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getBirthYear()
  {
    return birthYear;
  }

  public void setBirthYear(int birthYear)
  {
    this.birthYear = birthYear;
  }

  public boolean isIncludeMale()
  {
    return includeMale;
  }

  public void setIncludeMale(boolean includeMale)
  {
    this.includeMale = includeMale;
  }

  public boolean isIncludeFemale()
  {
    return includeFemale;
  }

  public void setIncludeFemale(boolean includeFemale)
  {
    this.includeFemale = includeFemale;
  }

}
