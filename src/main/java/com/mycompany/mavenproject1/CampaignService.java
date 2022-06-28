/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.entities.Campaign;
import com.mycompany.libs.AdServerFileTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author manjotssandhu
 */
public class CampaignService {
    
    private HashMap<Integer, Campaign> campaigns = new HashMap<>();

    public HashMap<Integer, Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(HashMap<Integer, Campaign> campaigns) {
        this.campaigns = campaigns;
    }
    
    public void readCampaignFile(String file) {
        ReadFile rf = MiniAdServerFileReaderFactory.
                    buildFileReader(AdServerFileTypes.CAMPAIGN, file);
        rf.readFile();
        
        this.setCampaigns(((CampaignFileReader) rf).getCampaings());
        
    }
    
    public ArrayList<Campaign> activeByStatus() {
        ArrayList<Campaign> activeCampaigns = new ArrayList<>();
        
        this.campaigns.forEach((campaignId, campaign) -> {
            if(campaign.getActive() == 1) {
                activeCampaigns.add(campaign);
            }
        });
       
        return activeCampaigns;
    }
    
    public ArrayList<Campaign> activeByStatusAndDate(Date date, boolean sort, int max) {
        ArrayList<Campaign> activeCampaigns = new ArrayList<>();
        
//        System.out.println("Date: " + date);
        this.campaigns.forEach((key, campaign) -> {
            if(campaign.getEndDate().after(date)) {
                activeCampaigns.add(campaign);
            }
        });
        
        if (sort) {
            Collections.sort(activeCampaigns, 
                        Comparator.comparing(Campaign::getPriority).reversed());
        }
                
        if (activeCampaigns.size() >= max) {    
            ArrayList<Campaign> tmpList = 
                    new ArrayList<>(activeCampaigns.subList(0, max));
            return tmpList;
        } else {
            return activeCampaigns;
        }
        
    }
 
    
    public void printCampaingsList(ArrayList<Campaign> campaignsList) {
        
        campaignsList.forEach(campaign -> {
            System.out.println(campaign.getCampaignId() + "--" + campaign.getPriority());
        });
    }
}
