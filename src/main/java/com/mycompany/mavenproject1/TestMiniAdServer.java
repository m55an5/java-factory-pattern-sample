/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.entities.Banner;
import com.mycompany.entities.Campaign;
import com.mycompany.libs.DateValidator;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author manjotssandhu
 */
public class TestMiniAdServer {
    
    private static Logger logger = Logger.getLogger(TestMiniAdServer.class.getName());
    
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("Missing arguments");
        } else {
      
//            System.out.println("Arg 1: " + args[0]);
//            System.out.println("Arg 2: " + args[1]);
      
            CampaignService csv = new CampaignService();
            csv.readCampaignFile(args[0]);
            
            BannerService bsv = new BannerService();
            bsv.readBannerFile(args[1]);
            
            DateValidator dv = new DateValidator();
            Date date = dv.converToDate("2019-01-01", dv.CAMPAIGN_DATE_FORMAT);
            
            ServicesHandler svc = new ServicesHandler(csv, bsv);
            HashMap<Campaign, ArrayList<Integer>> campaignBannerMap =
                           svc.getActiveCampaignsWithSize(date, true, 3, bsv);
           
            logger.info("Campaign IDs and associated Banner IDs");
   
            campaignBannerMap.entrySet().forEach(set -> {
                Campaign campaign = set.getKey();
                ArrayList<Integer> campaignBannerIDs = set.getValue();
                
                logger.log(Level.INFO, "Campaign ID: {0} - Banner ID: {1}",
                        new Object[] {campaign.getCampaignId(),  
                            campaignBannerIDs
                        }) ;
            });
            
            
        }
    }
    
}



//         campaignBannerMap.entrySet().stream().map(set -> {
//                Campaign campaign = set.getKey();
//                ArrayList<Banner> campaignBanners = set.getValue();
//                logger.log(Level.INFO, "Campaign ID: {0}", campaign.getCampaignId());
//                return campaignBanners;
//            }).forEachOrdered(campaignBanners -> {
//                campaignBanners.forEach(banner -> {
//                    logger.log(Level.FINEST, "Banner ID: {0}", banner.getBannerId());
//                });
//            });
            