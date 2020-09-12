package se.cambio.trainning.assignment2.manager;

import se.cambio.trainning.assignment2.dao.PatientDataDAOImpl;
import se.cambio.trainning.assignment2.data.PatientData;
import se.cambio.trainning.assignment2.data.SearchCriteria;
import se.cambio.trainning.assignment2.util.AgeCalculatorUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PatientDataManagerImpl
{
  PatientDataDAOImpl patientDataDAOImpl = new PatientDataDAOImpl();

  public List<PatientData> getPatientDataList()
  {
    List<PatientData> list = new ArrayList<PatientData>();
    Map<Integer, PatientData> map = patientDataDAOImpl.getPatientDataList();
    for (Entry<Integer, PatientData> entry : map.entrySet())
    {
      list.add(entry.getValue());
    }
    return list;
  }

  public PatientData getPatientById(int id)
  {
    return patientDataDAOImpl.getPatientById(id);
  }

  public int savePatientData(PatientData patientData)
  {
    patientData.setAge(AgeCalculatorUtil.calculateAgeAndGenerateFormattedString(patientData.getBirthday()));
    return patientDataDAOImpl.savePatientData(patientData);
  }

  public void deletePatientData(int rowSelected)
  {
    patientDataDAOImpl.deletePatientData(rowSelected);

  }

  public List<PatientData> getFilteredPatientDataList(SearchCriteria criteria)
  {
    int criteriaType = 0;
    if (!(criteria.getName().equals("")) && (criteria.getBirthYear() > 0) && !criteria.isIncludeMale() // name,bday
        && !criteria.isIncludeFemale())
    {
      criteriaType = 1;
    }
    else if (!(criteria.getName().equals("")) && (criteria.getBirthYear() > 0) && criteria.isIncludeMale())
    {// name,bday,male
      criteriaType = 2;
    }
    else if (!(criteria.getName().equals("")) && (criteria.getBirthYear() > 0) && criteria.isIncludeFemale())
    {// name,bday,female
      criteriaType = 3;
    }
    else if (!(criteria.getName().equals("")) && (criteria.getBirthYear() == 0) && !criteria.isIncludeFemale()
        && !criteria.isIncludeMale())
    {// name
      criteriaType = 4;
    }
    else if ((criteria.getName().equals("")) && (criteria.getBirthYear() > 0) && !criteria.isIncludeFemale()
        && !criteria.isIncludeMale())
    {// bday
      criteriaType = 5;
    }
    else if ((criteria.getName().equals("")) && (criteria.getBirthYear() == 0) && criteria.isIncludeFemale()
        && !criteria.isIncludeMale())
    {// female
      criteriaType = 6;
    }
    else if ((criteria.getName().equals("")) && (criteria.getBirthYear() == 0) && criteria.isIncludeMale() && !criteria
        .isIncludeFemale())
    {// male
      criteriaType = 7;
    }
    else if ((criteria.getName().equals("")) && (criteria.getBirthYear() > 0) && criteria.isIncludeFemale() && !criteria
        .isIncludeMale())
    {// bday,female
      criteriaType = 8;
    }
    else if ((criteria.getName().equals("")) && (criteria.getBirthYear() > 0) && !criteria.isIncludeFemale() && criteria
        .isIncludeMale())
    {// bday,male
      criteriaType = 9;
    }
    else if (!(criteria.getName().equals("")) && (criteria.getBirthYear() == 0) && !criteria.isIncludeFemale()
        && criteria.isIncludeMale())
    {// name,male
      criteriaType = 10;
    }
    else if (!(criteria.getName().equals("")) && (criteria.getBirthYear() == 0) && criteria.isIncludeFemale()
        && !criteria.isIncludeMale())
    {// name,female
      criteriaType = 11;
    }

    return patientDataDAOImpl.getFilteredPatientDataList(criteria, criteriaType);
  }
}
