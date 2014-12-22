package functional.forms;

import functional.BaseTestPage;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import wheel.annotations.Persist;

public class DateInput extends BaseTestPage {
    private Calendar date1;
    private Date date2;
    @Persist
    private Calendar date3;

    @Override
    public void preBuild() {
        date1 = new GregorianCalendar();
        date1.set(Calendar.MONTH, 0);
        date1.set(Calendar.YEAR, 2008);
        date1.set(Calendar.DAY_OF_MONTH, 1);
    }

    public void buildComponent() {
        form("dateInputForm").
                dateInput("basic", "MM/dd/yy").end().
                dateInput("date1", "MM/dd/yy").fieldBinding("date1").end().
                dateInput("date2", "dd.MM.yyyy").fieldBinding("date2").end().
                dateInput("date3", "dd.MM.yyyy").fieldBinding("date3");
    }
}
