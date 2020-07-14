package cst438hw3.domain;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TempAndTime {
	public double temp;
	public long time;
	public int timezone;
	
	public TempAndTime(double temp, long time, int timezone){
		this.temp = temp;
		this.time = time;
		this.timezone = timezone;
	}
	
	public double getTemp() { return temp; }
	public void setTemp(double temp) { this.temp = temp; }
	
	public double getFormTemp() {
		Double tempF = (temp-273.15) * (9.0/5.0) + 32;
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.valueOf(df.format(tempF));
	}
	
	
	public long getTime() { return time; }
	public void setTime(long time) { this.time = time; }
	
	public String getFormTime() {
	    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTimeInMillis(time * 1000);
	    return formatter.format(calendar.getTime());
	}

	
	public int getTimezone() { return timezone; } 
	public void seTimezone(int timezone) { this.timezone = timezone; }
	
 }