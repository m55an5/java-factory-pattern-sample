/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.entities.Campaign;
import com.mycompany.libs.DateValidator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author manjotssandhu
 */
public class CampaignFileReader implements ReadFile{
    
    private final String csvFile;
    private final int MAX_COLUMNS_IN_FILE = 7;
    HashMap<Integer, Campaign> campaignsMap = new HashMap<Integer, Campaign>();    
    
    public CampaignFileReader(String csvFile) {
        this.csvFile = csvFile;
    }
    
    @Override
    public void readFile(){
        BufferedReader br = null;
        String line;
        String splitOn = ",";
        
        try {
            
            File file = new File(this.csvFile);
            if (file.exists()) {
                br = new BufferedReader(new FileReader(file));
                
                br.readLine(); //skip headers in the csv file
                while ( (line = br.readLine()) != null) {
                    String[] lineContents = line.split(splitOn);
                    if (lineContents.length == MAX_COLUMNS_IN_FILE) {
                        createCampaignObject(lineContents);
                    }
                }
            } else {
                System.err.println("FILE NOT FOUND");
            }
            
        } catch (IOException e) {
            e.printStackTrace(System.err);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        
    }
    
    public void createCampaignObject(String[] lineContent) {
        Integer campaignId = Integer.parseInt(lineContent[0]);
        String name = lineContent[1];
        
        String startDateString = lineContent[2];
        String endDateString = lineContent[3];
        DateValidator dv = new DateValidator();
        Date startDate = dv.converToDate(startDateString, dv.CAMPAIGN_DATE_FORMAT);
        Date endDate = dv.converToDate(endDateString, dv.CAMPAIGN_DATE_FORMAT);
        
        int advertiserId = Integer.parseInt(lineContent[4]);
        int active = Integer.parseInt(lineContent[5]);
        int priority = Integer.parseInt(lineContent[6]);
                
        Campaign c = new Campaign(campaignId, name, startDate, endDate, advertiserId,
                    active, priority);
        campaignsMap.put(campaignId, c);
    }
    
    public HashMap<Integer, Campaign> getCampaings() {
        return this.campaignsMap;
    }
    
}
