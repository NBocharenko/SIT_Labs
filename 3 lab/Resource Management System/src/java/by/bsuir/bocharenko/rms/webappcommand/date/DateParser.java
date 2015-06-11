/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author user
 */
public class DateParser {
    public static Date parseStandartDate(HttpServletRequest request, String attributeName) throws ParseException{
        DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        return format.parse(request.getParameter(attributeName));
    }
    
    public static Date parseChromeDate(HttpServletRequest request, String attributeName) throws ParseException{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return format.parse(request.getParameter(attributeName));
    }
}
