package presentacion.vistas.vistaCalendario;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


public class Calendario{
	
	private JDatePickerImpl cal; 
	
	public Calendario() {
		cal = createCalendario();
	}
	private JDatePickerImpl createCalendario() {
		UtilDateModel model = new UtilDateModel();
    	//model.setDate(20,04,2014);
    	// Need this...
    	Properties p = new Properties();
    	p.put("text.today", "Today");
    	p.put("text.month", "Month");
    	p.put("text.year", "Year");
    	JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    	// Don't know about the formatter, but there it is...
    	return new JDatePickerImpl(datePanel, new DateLabelFormatter());
	}
	
	public JDatePickerImpl getCal() {
		return cal;
	}
	public void setCal(JDatePickerImpl cal) {
		this.cal = cal;
	}
	
	public void limpiaFechaSel() {
		cal.getJFormattedTextField().setText("");
	}
	
	public Calendar getFecha() {
		DateLabelFormatter dlf = new DateLabelFormatter();
		Calendar c = Calendar.getInstance(); 
		Date d = null; 
		try {
			d =  (java.util.Date) dlf.stringToValue(cal.getJFormattedTextField().getText());
			c =  DateLabelFormatter.toCalendar(d);
		} catch (ParseException e) {
			System.out.println("Error al parsear fecha a Calendar");
			e.printStackTrace();
		}
		return c; 
	}
	
	public String getFechaString() {
		return cal.getJFormattedTextField().getText();
		
	}
	
	
	public boolean isEmpty() {
		return cal.getJFormattedTextField().getText().isEmpty();
	}
}
