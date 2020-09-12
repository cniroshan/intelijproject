package se.cambio.trainning.assignment2.dao;

import org.joda.time.DateTime;

import se.cambio.trainning.assignment2.data.EmploymentStatus;
import se.cambio.trainning.assignment2.data.Gender;
import se.cambio.trainning.assignment2.data.PatientData;
import se.cambio.trainning.assignment2.data.SearchCriteria;
import se.cambio.trainning.assignment2.util.CriteriaUtil;

import java.util.*;
import java.util.Map.Entry;

public class PatientDataDAOImpl
{
  PatientData patient1 = new PatientData(1, "Nimal", new DateTime(new Date()).minusYears(20).toDate(),
      "No 15, Maharagama", Gender.Male, "0714525125", EmploymentStatus.FullTime);

  PatientData patient2 = new PatientData(2, "Billy", new DateTime(new Date()).minusYears(25).toDate(), "No 17, Kottawa",
      Gender.Female, "0718745125", EmploymentStatus.PartTime);

  PatientData patient3 = new PatientData(3, "Saman", new DateTime(new Date()).minusMonths(8).toDate(),
      "No 16, Bambalapitiya", Gender.Male, "071852364", EmploymentStatus.Student);

  PatientData patient4 = new PatientData(4, "Kamal", new DateTime(new Date()).minusMonths(2).toDate(),
      "No 18, Nugegoda", Gender.Male, "0718423658", EmploymentStatus.Unemployed);

  Map<Integer, PatientData> patientsMap = new HashMap<Integer, PatientData>();

  public PatientDataDAOImpl()
  {
    patientsMap.put(patient1.getId(), patient1);
    patientsMap.put(patient2.getId(), patient2);
    patientsMap.put(patient3.getId(), patient3);
    patientsMap.put(patient4.getId(), patient4);
  }

  public Map<Integer, PatientData> getPatientDataList()
  {
    return patientsMap;
  }

  public PatientData getPatientById(int id)
  {
    return patientsMap.get(id);
  }

  public int savePatientData(PatientData patientData)
  {
    patientData.setId(patientsMap.size() + 1);
    patientsMap.put(patientData.getId(), patientData);
    return patientData.getId();
  }

  public void deletePatientData(int rowSelected)
  {
    patientsMap.remove(rowSelected);
  }

  public List<PatientData> getFilteredPatientDataList(SearchCriteria criteria, int criteriaType)
  {
    List<PatientData> list = new ArrayList<PatientData>();

    for (Entry<Integer, PatientData> entry : patientsMap.entrySet())
    {
      if (CriteriaUtil.isCriteriaAndPatientDataMatched(criteria, entry.getValue(), criteriaType))
      {
        list.add(entry.getValue());
      }
    }
    return list;
  }

}
