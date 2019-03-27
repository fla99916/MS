package presentacion.vistas.vistaCalendario;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateLabelFormatter extends AbstractFormatter {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String datePattern = "yyyy-MM-dd";
	//Formato en español (para el usuario). 
	//private String datePattern = "dd-MM-yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
    
    //Formato en ingles (para base de datos). 
    private String datePatternEN = "yyyy-MM-dd"; 
    private SimpleDateFormat dateFormatterEN = new SimpleDateFormat(datePatternEN);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

    public static Calendar toCalendar(Date date) {
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	return cal;
    }
    
    public static Date toDate (Calendar cal) {
    	return new java.sql.Date(cal.getTimeInMillis());
    }
    
    public Object stringToValueEN(String text) throws ParseException {
    	return dateFormatterEN.parseObject(text);
    }
    
    public String valueToStringEN(Object value) {
    	if (value != null) {
    		Calendar cal = (Calendar) value;
    		return dateFormatterEN.format(cal.getTime());
    	}
		return "";
    	
    }
}