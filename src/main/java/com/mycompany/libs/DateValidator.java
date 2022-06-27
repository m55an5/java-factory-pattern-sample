/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manjotssandhu
 */
public class DateValidator {

    public String BANNER_DATE_FORMAT = "yyyy/MM/dd";
    public String CAMPAIGN_DATE_FORMAT = "yyyy-MM-dd";
    
    public Date converToDate(String givenDateStr, String givenFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(givenFormat, Locale.ENGLISH);
        Date returnDate = null;
        try {
            returnDate = formatter.parse(givenDateStr);
        } catch (ParseException ex) {
            Logger.getLogger(DateValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
            return returnDate;
    }
}
