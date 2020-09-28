package com.bestseller.wss.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.bestseller.wss.constant.Constant;

public class DateTools {
	public static String getDateTime(Date currentdate, int offset) { 
        SimpleDateFormat format = new SimpleDateFormat(Constant.TIME_FORMAT);
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(currentdate);  
        calendar.add(Calendar.DAY_OF_MONTH, offset);  
        currentdate = calendar.getTime();
        String dateTime=format.format(currentdate);
        return dateTime;  
}
}
