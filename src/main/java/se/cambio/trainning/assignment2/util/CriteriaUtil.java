package se.cambio.trainning.assignment2.util;

import se.cambio.trainning.assignment2.data.PatientData;
import se.cambio.trainning.assignment2.data.SearchCriteria;

import java.util.Calendar;

public class CriteriaUtil
{

  public static boolean isCriteriaAndPatientDataMatched(SearchCriteria criteria, PatientData patientData,
                                                        int criteriaType)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(patientData.getBirthday());

    switch (criteriaType)
    {
      case 1:
        if (criteria.getBirthYear() == calendar.get(Calendar.YEAR) && criteria.getName()
            .equalsIgnoreCase(patientData.getName()))
        {
          return true;
        }
        break;
      case 2:
        if (criteria.getBirthYear() == calendar.get(Calendar.YEAR) && criteria.getName()
            .equalsIgnoreCase(patientData.getName()) && patientData.getGender().getValue() == 0)
        {
          return true;
        }
        break;
      case 3:
        if (criteria.getBirthYear() == calendar.get(Calendar.YEAR) && criteria.getName()
            .equalsIgnoreCase(patientData.getName()) && patientData.getGender().getValue() == 1)
        {
          return true;
        }
        break;
      case 4:
        if (criteria.getName().equalsIgnoreCase(patientData.getName()))
        {
          return true;
        }
        break;
      case 5:
        if (criteria.getBirthYear() == calendar.get(Calendar.YEAR))
        {
          return true;
        }
        break;
      case 6:
        if (criteria.isIncludeFemale() == (patientData.getGender().getValue() == 1))
        {
          return true;
        }
        break;
      case 7:
        if (criteria.isIncludeMale() == (patientData.getGender().getValue() == 0))
        {
          return true;
        }
        break;
      case 8:
        if (criteria.getBirthYear() == calendar.get(Calendar.YEAR) && (patientData.getGender().getValue() == 1))
        {
          return true;
        }
        break;
      case 9:
        if (criteria.getBirthYear() == calendar.get(Calendar.YEAR) && (patientData.getGender().getValue() == 0))
        {
          return true;
        }
        break;
      case 10:
        if (criteria.getName().equalsIgnoreCase(patientData.getName()) && (patientData.getGender().getValue() == 0))
        {
          return true;
        }
        break;
      case 11:
        if (criteria.getName().equalsIgnoreCase(patientData.getName()) && (patientData.getGender().getValue() == 1))
        {
          return true;
        }
        break;
      default:
        break;
    }
    return false;
  }

}
