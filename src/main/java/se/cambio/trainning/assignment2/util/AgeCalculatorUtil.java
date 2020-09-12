package se.cambio.trainning.assignment2.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class AgeCalculatorUtil
{

  public static String calculateAgeAndGenerateFormattedString(Date birthday)
  {
    Calendar bornTime = Calendar.getInstance();
    Calendar todayTime = Calendar.getInstance();
    LocalDate bday = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate today = LocalDate.now();
    Period periodBetweenBdayAndToday = Period.between(bday, today);

    int yearsBetweenBdayAndToday = periodBetweenBdayAndToday.getYears();
    int monthsBetweenBdayAndToday = periodBetweenBdayAndToday.getMonths();
    int age = 0;

    return getAgeString(birthday, todayTime, bornTime, yearsBetweenBdayAndToday, age, monthsBetweenBdayAndToday);
  }

  private static String getAgeString(Date birthday, Calendar todayTime, Calendar bornTime, int yearsBetweenBdayAndToday,
                                     int age, int monthsBetweenBdayAndToday)
  {
    String ageString = "";
    if (birthday != null)
    {
      todayTime.setTime(new Date());
      bornTime.setTime(birthday);
      if (bornTime.after(todayTime))
      {
        throw new IllegalArgumentException("Can't be born in the future");
      }
      else
      {
        if (todayTime.get(Calendar.YEAR) == bornTime.get(Calendar.YEAR))
        {
          age = todayTime.get(Calendar.MONTH) - bornTime.get(Calendar.MONTH);
          ageString = age + " Months";
        }
        else if (yearsBetweenBdayAndToday < 3)
        {
          ageString = yearsBetweenBdayAndToday + " Years and " + monthsBetweenBdayAndToday + " Months";
        }
        else
        {
          age = todayTime.get(Calendar.YEAR) - bornTime.get(Calendar.YEAR);
          ageString = age + " Years";
        }
      }
    }
    return ageString;
  }

}
