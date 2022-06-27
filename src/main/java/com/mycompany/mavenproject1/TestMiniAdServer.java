/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.libs.AdServerFileTypes;
import com.mycompany.libs.DateValidator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author manjotssandhu
 */
public class TestMiniAdServer {
    
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("Missing arguments");
        } else {
      
            System.out.println("Arg 1: " + args[0]);
            System.out.println("Arg 2: " + args[1]);
      
            CampaignService csv = new CampaignService();
            csv.readCampaignFile(args[0]);
            
//            BannerService bsv = new BannerService();
//            bsv.readBannerFile(args[1]);
            
            DateValidator dv = new DateValidator();
            Date date = dv.converToDate("2019-06-01", dv.CAMPAIGN_DATE_FORMAT);
            csv.activeByStatusAndDate(date,true);
            
        }
    }
    
}
