/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.entities.Campaign;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author manjotssandhu
 */
public class ServicesHandler {
    
    private final BannerService bsv;
    private final CampaignService csv;
    private final int MAX_BANNERS_PER_CAMPAIGN = 2;
    
    public ServicesHandler(CampaignService csv, BannerService bsv) {
        this.csv = csv;
        this.bsv = bsv;
    }
    
    public HashMap<Campaign, ArrayList<Integer>> 
                        getActiveCampaignsWithSize(Date date, boolean sort, 
                                            int max, BannerService bsv) {
        
        LinkedHashMap<Campaign, ArrayList<Integer>> campaignBannerMap = new LinkedHashMap<>();
        
        ArrayList<Campaign> campaigns ;
        ArrayList<Integer> bannerIDs ;
        
        // proritized list of active campaigns            
        campaigns = this.csv.activeByStatusAndDate(date, sort, max);
        
        // get maximum 2 banners for each campaingn        
        for (int i=0; i< campaigns.size(); i++) {
            bannerIDs = this.bsv.
                    getBannersIDForCampaign(campaigns.get(i).getCampaignId(), 
                                                        MAX_BANNERS_PER_CAMPAIGN);
            
            campaignBannerMap.put(campaigns.get(i), bannerIDs);
        }
        
        return campaignBannerMap;
    }
    
}
