package se.cambio.trainning.assignment2.data;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.List;

public class PatientTableModel extends AbstractTableModel
{

  private String headers[] = { "id", "name", "age", "address", "employeeStatus" };

  private List<PatientData> dataList = new ArrayList<PatientData>();

  private List<PatientData> filteredDataList = new ArrayList<PatientData>();

  public void setData(List<PatientData> data)
  {
    this.dataList = data;
  }

  public int getRowCount()
  {
    return dataList.size();
  }

  public int getColumnCount()
  {
    return headers.length;
  }

  public Object getValueAt(int rowIndex, int columnIndex)
  {
    PatientData patientData = dataList.get(rowIndex);
    if (patientData != null)
    {
      switch (columnIndex)
      {
        case 0:
          return patientData.getId();
        case 1:
          return patientData.getName();
        case 2:
          return patientData.getAge();
        case 3:
          return patientData.getAddress();
        case 4:
          return patientData.getEmploymentStatus();
      }
    }
    return "";
  }

  @Override
  public String getColumnName(int column)
  {
    return headers[column];
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex)
  {
    switch (columnIndex)
    {
      case 4:
        return true;
      default:
        return false;
    }
  }

}
