package se.cambio.trainning.assignment2.gui;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import se.cambio.trainning.assignment2.data.*;
import se.cambio.trainning.assignment2.manager.PatientDataManagerImpl;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainWindow extends JFrame
{

  private JPanel mainPanel;

  private JPanel inputPanel;

  private JPanel searchPanel;

  private JPanel genderPanel;

  private JPanel gridPanel;

  private JPanel buttonPanel;

  private JLabel lblName;

  private JLabel lblPhoneNumber;

  private JLabel lblGender;

  private JLabel lblBirthday;

  private JLabel lblSearchName;

  private JLabel lblBirthYear;

  private JLabel lblAddress;

  private JLabel lblEmploymentStatus;

  private JScrollPane scrollPaneTableDataGrid;

  private JScrollPane scrollPane1;

  private JButton btnSave;

  private JButton btnClear;

  private JButton btnSearch;

  private JButton btnClose;

  private JRadioButton rdbtnFemale;

  private JRadioButton rdbtnMale;

  private ButtonGroup genderGroup;

  private JTextField txtName;

  private JTextField txtPhone;

  private JTextField txtBirthYear;

  private JTextField txtSearchName;

  private JTextField txtRow;

  private JTextArea txtAreaAddress;

  private JDatePickerImpl birthdayDatePicker;

  private JTable table;

  private JComboBox cmbEmpStatus;

  private JComboBox cmbEditableGridEmpStatus;

  private JCheckBox chckbxFemale;

  private JCheckBox chckbxMale;

  private Gender gender;

  private PatientTableModel patientTableModel;

  private List<PatientData> patients;

  private PatientDataManagerImpl patientDataManagerImpl;

  private List<PatientData> filteredPatients;

  private int rowSelected = 0;

  public MainWindow()
  {
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(500, 600);
    setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    setTitle("Patient registration");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setupWindowData();
    getContentPane().add(getMainPanel());
    disableButton(btnSave);
  }

  private JScrollPane getScrollPane()
  {
    if (scrollPaneTableDataGrid == null)
    {
      scrollPaneTableDataGrid = new JScrollPane();
      scrollPaneTableDataGrid.setViewportView(getTable());
    }
    return scrollPaneTableDataGrid;
  }

  private JScrollPane getScrollPane1()
  {
    if (scrollPane1 == null)
    {
      scrollPane1 = new JScrollPane();
      scrollPane1.setViewportView(getTxtAreaAddress());
    }
    return scrollPane1;
  }

  private JLabel getLblName()
  {
    if (lblName == null)
    {
      lblName = new JLabel("Name");
    }
    return lblName;
  }

  private JLabel getLblPhoneNumber()
  {
    if (lblPhoneNumber == null)
    {
      lblPhoneNumber = new JLabel("Phone Number");
    }
    return lblPhoneNumber;
  }

  private JLabel getLblBirthday()
  {
    if (lblBirthday == null)
    {
      lblBirthday = new JLabel("Birthday");
    }
    return lblBirthday;
  }

  private JLabel getLblGender()
  {
    if (lblGender == null)
    {
      lblGender = new JLabel("Gender");
    }
    return lblGender;
  }

  private JLabel getLblAddress()
  {
    if (lblAddress == null)
    {
      lblAddress = new JLabel("Address");
    }
    return lblAddress;
  }

  private JTextArea getTxtAreaAddress()
  {
    if (txtAreaAddress == null)
    {
      txtAreaAddress = new JTextArea();
    }
    return txtAreaAddress;
  }

  private JComboBox getCmbEmpStatus()
  {
    if (cmbEmpStatus == null)
    {
      cmbEmpStatus = new JComboBox(EmploymentStatus.values());
      cmbEmpStatus.setSelectedIndex(-1);
    }
    return cmbEmpStatus;
  }

  private JLabel getLblEmploymentStatus()
  {
    if (lblEmploymentStatus == null)
    {
      lblEmploymentStatus = new JLabel("Employment Status");
    }
    return lblEmploymentStatus;
  }

  private JTextField getTxtRow()
  {
    if (txtRow == null)
    {
      txtRow = new JTextField();
      txtRow.setVisible(false);
    }
    return txtRow;
  }

  private JLabel getLblSearchName()
  {
    if (lblSearchName == null)
    {
      lblSearchName = new JLabel("Name");
    }
    return lblSearchName;
  }

  private JLabel getLblBirthYear()
  {
    if (lblBirthYear == null)
    {
      lblBirthYear = new JLabel("Birth Year");
    }
    return lblBirthYear;
  }

  private JCheckBox getChckbxFemale()
  {
    if (chckbxFemale == null)
    {
      chckbxFemale = new JCheckBox("Female");
    }
    return chckbxFemale;
  }

  private JCheckBox getChckbxMale()
  {
    if (chckbxMale == null)
    {
      chckbxMale = new JCheckBox("Male");
    }
    return chckbxMale;
  }

  private JTextField getTxtBirthYear()
  {
    if (txtBirthYear == null)
    {
      txtBirthYear = new JTextField();
    }
    return txtBirthYear;
  }

  private JTextField getTxtSearchName()
  {
    if (txtSearchName == null)
    {
      txtSearchName = new JTextField();
    }
    return txtSearchName;
  }

  private JComboBox getCmbEditableGridEmpStatus()
  {
    if (cmbEditableGridEmpStatus == null)
    {
      cmbEditableGridEmpStatus = new JComboBox(EmploymentStatus.values());
    }
    return cmbEditableGridEmpStatus;
  }

  private JPanel getMainPanel()
  {
    if (mainPanel == null)
    {
      mainPanel = new JPanel();
      mainPanel.setLayout(new GridBagLayout());
    }
    setupMainPanel();
    return mainPanel;
  }

  private JPanel getTableGridPanel()
  {
    if (gridPanel == null)
    {
      gridPanel = new JPanel();
      gridPanel.setLayout(new GridBagLayout());
    }
    setupTableGridPanel();
    return gridPanel;
  }

  private JPanel getSearchPanel()
  {
    if (searchPanel == null)
    {
      searchPanel = new JPanel();
      searchPanel.setLayout(new GridBagLayout());
    }
    setupSearchPanel();
    return searchPanel;
  }

  private JPanel getButtonPanel()
  {
    if (buttonPanel == null)
    {
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridBagLayout());
    }
    setupButtonPanel();
    return buttonPanel;
  }

  private JPanel getGenderPanel()
  {
    if (genderPanel == null)
    {
      genderPanel = new JPanel();
      genderPanel.setLayout(new GridBagLayout());
    }
    setupGenderPanel();
    return genderPanel;
  }

  private JPanel getInputPanel()
  {
    if (inputPanel == null)
    {
      inputPanel = new JPanel();
      inputPanel.setLayout(new GridBagLayout());
    }
    setupInputPanel();
    return inputPanel;
  }

  private JTable getTable()
  {
    if (table == null)
    {
      patientTableModel.setData(patients);
      table = new JTable();
      table.setModel(patientTableModel);
      TableColumn editColumn = table.getColumnModel().getColumn(4);
      editColumn.setCellEditor(new DefaultCellEditor(getCmbEditableGridEmpStatus()));
    }
    addDataTableListners();
    return table;
  }

  private JTextField getTxtName()
  {
    if (txtName == null)
    {
      txtName = new JTextField();
    }
    txtName.addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent e)
      {
        if (!txtName.getText().isEmpty())
        {
          btnSave.setEnabled(true);
        }
        else
        {
          btnSave.setEnabled(false);
        }

      }
    });

    txtName.getDocument().addDocumentListener(new DocumentListener()
    {
      public void removeUpdate(DocumentEvent e)
      {
      }

      public void insertUpdate(DocumentEvent e)
      {
        if (!txtName.getText().isEmpty())
        {
          btnSave.setEnabled(true);
        }
      }

      public void changedUpdate(DocumentEvent e)
      {
      }
    });
    return txtName;
  }

  private JTextField getTxtPhone()
  {
    if (txtPhone == null)
    {
      txtPhone = new JTextField();
    }
    txtPhone.addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent e)
      {
        validateInputIsNumber(e);
      }
    });
    return txtPhone;
  }

  private JDatePickerImpl getDatePicker()
  {
    UtilDateModel dateModel = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(dateModel);
    birthdayDatePicker = new JDatePickerImpl(datePanel);
    birthdayDatePicker.getJFormattedTextField().setLocation(0, 57);
    birthdayDatePicker.addActionListener(new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        Date d = (Date) birthdayDatePicker.getModel().getValue();
        if (d.after(new Date()))
        {
          JOptionPane.showMessageDialog(null, "Birthday cannot be a future date. Please enter a valid date!");
          birthdayDatePicker.getModel().setValue(null);
          birthdayDatePicker.setButtonFocusable(true);
        }

      }
    });
    return birthdayDatePicker;
  }

  private JRadioButton getRdbtnFemale()
  {
    if (rdbtnFemale == null)
    {
      rdbtnFemale = new JRadioButton("Female");
    }
    rdbtnFemale.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if (rdbtnFemale.isSelected())
        {
          gender = Gender.Female;
        }
      }
    });
    return rdbtnFemale;
  }

  private JRadioButton getRdbtnMale()
  {
    if (rdbtnMale == null)
    {
      rdbtnMale = new JRadioButton("Male");
    }
    rdbtnMale.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if (rdbtnMale.isSelected())
        {
          gender = Gender.Male;
        }
      }
    });
    return rdbtnMale;
  }

  private JButton getBtnClear()
  {
    if (btnClear == null)
    {
      btnClear = new JButton("Clear");
    }
    btnClear.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        clearForm();
        refreshTable();
        disableButton(btnSave);
      }
    });
    return btnClear;
  }

  private JButton getBtnSearch()
  {
    if (btnSearch == null)
    {
      btnSearch = new JButton("Search");
    }
    btnSearch.addActionListener(new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        doSearchAction();
      }
    });
    return btnSearch;
  }

  private JButton getBtnClose()
  {
    if (btnClose == null)
    {
      btnClose = new JButton("Close");
    }
    btnClose.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    });
    return btnClose;
  }

  private JButton getBtnSave()
  {
    if (btnSave == null)
    {
      btnSave = new JButton("Save");
    }
    btnSave.addMouseListener(new MouseAdapter()
    {
      @Override
      public void mouseClicked(MouseEvent e)
      {
        doSaveAction();
      }
    });
    return btnSave;
  }

  private void setupWindowData()
  {
    genderGroup = new ButtonGroup();
    genderGroup.add(getRdbtnFemale());
    genderGroup.add(getRdbtnMale());
    patientTableModel = new PatientTableModel();
    patientDataManagerImpl = new PatientDataManagerImpl();
    patients = patientDataManagerImpl.getPatientDataList();
  }

  protected void validateInputIsNumber(KeyEvent e)
  {
    char c = e.getKeyChar();
    if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))
    {
      getToolkit().beep();
      e.consume();
    }
  }

  protected void setRowSelectedData()
  {
    rowSelected = table.getSelectedRow();
    txtRow.setText(Integer.toString(rowSelected));
    Object object = patientTableModel.getValueAt(rowSelected, 0);
    int id = Integer.parseInt(object.toString());
    PatientData patientData = patientDataManagerImpl.getPatientById(id);
    setPatientDataToFields(patientData);
  }

  protected void generatePopUp(MouseEvent e)
  {
    int rowClicked = table.rowAtPoint(e.getPoint());
    if (rowClicked >= 0 && rowClicked < table.getRowCount())
    {
      table.setRowSelectionInterval(rowClicked, rowClicked);
    }
    else
    {
      table.clearSelection();
    }

    int rowindex = table.getSelectedRow();
    if (rowindex < 0)
    {
      return;
    }
    if (e.isPopupTrigger() && e.getComponent() instanceof JTable)
    {
      JPopupMenu popup = getTableRowRightClickPopUpMenu();
      popup.show(e.getComponent(), e.getX(), e.getY());
    }

  }

  protected void doDeleteAction()
  {
    rowSelected = table.getSelectedRow();
    int empNum = (Integer) table.getModel().getValueAt(rowSelected, 0);
    patientDataManagerImpl.deletePatientData(empNum);
    refreshTable();
  }

  protected void setPatientDataToFields(PatientData patientData)
  {
    txtName.setText(patientData.getName());
    txtPhone.setText(patientData.getTelephoneNumber());
    txtAreaAddress.setText(patientData.getAddress());
    cmbEmpStatus.setSelectedIndex(patientData.getEmploymentStatus().getValue());
    setDateToDatePicker(patientData.getBirthday());
    setSelectedRowGenderToOptionButton(patientData);

  }

  protected JPopupMenu getTableRowRightClickPopUpMenu()
  {
    final JPopupMenu popup = new JPopupMenu();
    JMenuItem menuItem = new JMenuItem("Delete");
    menuItem.setMnemonic(KeyEvent.VK_P);
    menuItem.getAccessibleContext().setAccessibleDescription("Grid Row Delete Menu Item");
    menuItem.addActionListener(new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        doDeleteAction();
      }
    });
    popup.add(menuItem);
    return popup;
  }

  protected void refreshTable()
  {
    patientTableModel.setData(patientDataManagerImpl.getPatientDataList());
    table.setModel(patientTableModel);
    scrollPaneTableDataGrid.setViewportView(table);
  }

  private void setDateToDatePicker(Date date)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    birthdayDatePicker.getModel()
        .setDate(calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
    birthdayDatePicker.getModel().setSelected(true);
  }

  private void setSelectedRowGenderToOptionButton(PatientData patientData)
  {
    if (patientData.getGender() == gender.Female)
    {
      rdbtnFemale.setSelected(true);
    }
    else if (patientData.getGender() == gender.Male)
    {
      rdbtnMale.setSelected(true);
    }
  }

  protected void doSaveAction()
  {
    PatientData patientData = setupPatientDataObject();
    patientDataManagerImpl.savePatientData(patientData);
    refreshTable();
    disableButton(btnSave);
  }

  private PatientData setupPatientDataObject()
  {
    PatientData patientData = new PatientData();
    patientData.setAddress(txtAreaAddress.getText());
    patientData.setBirthday((Date) birthdayDatePicker.getModel().getValue());
    patientData.setEmploymentStatus((EmploymentStatus) getCmbEmpStatus().getSelectedItem());
    patientData.setGender(getGender());
    patientData.setName(txtName.getText());
    patientData.setTelephoneNumber(txtPhone.getText());
    return patientData;
  }

  private void disableButton(JButton button)
  {
    button.setEnabled(false);
  }

  private Gender getGender()
  {
    return gender;
  }

  protected void clearForm()
  {
    txtAreaAddress.setText("");
    txtName.setText("");
    txtPhone.setText("");
    genderGroup.clearSelection();
    setDateToDatePicker(new Date());
    birthdayDatePicker.getJFormattedTextField().setText("");
    cmbEmpStatus.setSelectedIndex(-1);
  }

  protected void doSearchAction()
  {
    SearchCriteria criteria = getSearchCriteria();
    filteredPatients = patientDataManagerImpl.getFilteredPatientDataList(criteria);
    patientTableModel.setData(filteredPatients);
    table.setModel(patientTableModel);
    scrollPaneTableDataGrid.setViewportView(table);
  }

  private SearchCriteria getSearchCriteria()
  {
    SearchCriteria criteria = new SearchCriteria();
    if (!txtBirthYear.getText().equals(""))
    {
      criteria.setBirthYear(Integer.parseInt(txtBirthYear.getText()));
    }
    criteria.setIncludeFemale(chckbxFemale.isSelected());
    criteria.setIncludeMale(chckbxMale.isSelected());
    criteria.setName(txtSearchName.getText());
    return criteria;
  }

  private void setupSearchPanel()
  {
    searchPanel.add(getLblSearchName(),
        new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.WEST,
            new Insets(5, 5, 5, 2), 0, 0));
    searchPanel.add(getTxtSearchName(),
        new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(5, 0, 5, 5), 0, 0));
    searchPanel.add(getLblBirthYear(),
        new GridBagConstraints(2, 0, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.WEST,
            new Insets(5, 5, 5, 2), 0, 0));
    searchPanel.add(getTxtBirthYear(),
        new GridBagConstraints(3, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(5, 0, 5, 0), 0, 0));
    searchPanel.add(getChckbxFemale(),
        new GridBagConstraints(4, 0, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.EAST,
            new Insets(5, 5, 5, 0), 0, 0));
    searchPanel.add(getChckbxMale(),
        new GridBagConstraints(5, 0, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.EAST,
            new Insets(5, 0, 5, 0), 0, 0));
    searchPanel.add(getBtnSearch(),
        new GridBagConstraints(6, 0, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.EAST,
            new Insets(5, 5, 5, 5), 0, 0));
  }

  private void setupInputPanel()
  {
    inputPanel.add(getLblName(),
        new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST,
            new Insets(5, 5, 5, 5), 0, 0));
    inputPanel.add(getTxtName(),
        new GridBagConstraints(1, 0, 2, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
            new Insets(5, 5, 5, 5), 0, 0));
    inputPanel.add(getLblPhoneNumber(),
        new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST,
            new Insets(5, 5, 5, 5), 0, 0));
    inputPanel.add(getTxtPhone(),
        new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
            new Insets(5, 5, 5, 5), 0, 0));
    inputPanel.add(getLblBirthday(),
        new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST,
            new Insets(5, 5, 5, 5), 0, 0));
    inputPanel.add(getDatePicker(),
        new GridBagConstraints(1, 2, 1, 1, 0, 1, GridBagConstraints.WEST, GridBagConstraints.WEST,
            new Insets(5, 5, 5, 5), 0, 0));
    inputPanel.add(getLblGender(),
        new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST,
            new Insets(5, 5, 5, 5), 0, 0));
    inputPanel.add(getGenderPanel(),
        new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
    inputPanel.add(getGenderPanel(),
        new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
    inputPanel.add(getLblAddress(),
        new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST,
            new Insets(5, 5, 5, 5), 0, 0));
    inputPanel.add(getScrollPane1(),
        new GridBagConstraints(1, 4, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH,
            new Insets(5, 5, 5, 5), 0, 0));
    inputPanel.add(getLblEmploymentStatus(),
        new GridBagConstraints(0, 5, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST,
            new Insets(5, 5, 5, 5), 0, 0));
    inputPanel.add(getCmbEmpStatus(),
        new GridBagConstraints(1, 5, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST,
            new Insets(5, 5, 5, 5), 0, 0));
    inputPanel.add(getButtonPanel(),
        new GridBagConstraints(1, 6, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.EAST,
            new Insets(0, 5, 5, 5), 0, 0));

    Component[] s = inputPanel.getComponents();
    for (Component component : s)
    {
      component.addKeyListener(new KeyListener()
      {
        public void keyTyped(KeyEvent e)
        {
          btnSave.setEnabled(true);
        }

        public void keyReleased(KeyEvent e)
        {

        }

        public void keyPressed(KeyEvent e)
        {
          btnSave.setEnabled(true);
        }
      });
    }
  }

  private void setupMainPanel()
  {
    mainPanel.add(getTxtRow());
    mainPanel.add(getInputPanel(),
        new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
    mainPanel.add(getSearchPanel(),
        new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
            new Insets(10, 0, 0, 0), 0, 0));
    mainPanel.add(getTableGridPanel(),
        new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
    mainPanel.add(getBtnClose(),
        new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.EAST,
            new Insets(10, 0, 10, 5), 0, 0));
  }

  private void setupButtonPanel()
  {
    buttonPanel.add(getBtnClear(),
        new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.EAST, GridBagConstraints.EAST,
            new Insets(0, 5, 5, 5), 0, 0));
    buttonPanel.add(getBtnSave(),
        new GridBagConstraints(1, 0, 1, 1, 0, 1, GridBagConstraints.EAST, GridBagConstraints.EAST,
            new Insets(0, 5, 5, 0), 0, 0));
  }

  private void setupGenderPanel()
  {
    genderPanel.add(getRdbtnFemale(),
        new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.WEST, GridBagConstraints.WEST,
            new Insets(5, 5, 5, 5), 0, 0));
    genderPanel.add(getRdbtnMale(),
        new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.WEST,
            new Insets(5, 0, 5, 5), 0, 0));
  }

  private void setupTableGridPanel()
  {
    gridPanel.add(getScrollPane(),
        new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH,
            new Insets(5, 5, 5, 5), 0, 0));
  }

  private void addDataTableListners()
  {
    table.addMouseListener(new MouseAdapter()
    {
      @Override
      public void mouseClicked(MouseEvent e)
      {
        setRowSelectedData();
      }

      @Override
      public void mouseReleased(MouseEvent e)
      {
        generatePopUp(e);
      }
    });
    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
    {
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                     int row, int col)
      {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        String status = (String) table.getModel().getValueAt(row, 2);
        int age = Integer.parseInt(status.split(" ")[0]);
        String month = status.split(" ")[1];
        if (age < 3 && "Months".equals(month))
        {
          setBackground(Color.RED);
          setForeground(Color.WHITE);
        }
        else
        {
          setBackground(table.getBackground());
          setForeground(table.getForeground());
        }
        return this;
      }
    });

    table.addKeyListener(new KeyListener()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == KeyEvent.VK_DELETE)
        {
          doDeleteAction();
        }
      }

      public void keyReleased(KeyEvent e)
      {
      }

      public void keyTyped(KeyEvent e)
      {
      }
    });

  }

}
