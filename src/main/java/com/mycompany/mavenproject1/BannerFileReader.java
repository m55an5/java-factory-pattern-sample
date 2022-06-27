/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;
import com.mycompany.entities.Banner;
import com.mycompany.libs.DateValidator;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author manjotssandhu
 */
public class BannerFileReader implements ReadFile{
    
    String bannerFile;
    HashMap<Integer, Banner> bannersMap = new HashMap<Integer, Banner>();    
    
    public BannerFileReader(String bannerFile) {
        this.bannerFile = bannerFile;
    }
    
    @Override
    public void readFile(){
        JSONParser jsonParser = new JSONParser();
        try {    
            FileReader reader = new FileReader(this.bannerFile);
            
            Object obj = jsonParser.parse(reader);
            JSONArray banners = (JSONArray) obj;
            banners.forEach(banner -> {
                createBannerObject((JSONObject) banner);
            });
            
        } catch (IOException | ParseException ex ) {
            ex.printStackTrace(System.err);
        } 
    }
    
    public void createBannerObject(JSONObject banner) {
        
        JSONObject bannerObject = (JSONObject) banner;
        
        String bannerIDString = String.valueOf(bannerObject.get("bannerId"));
        String campaignIDString = String.valueOf(bannerObject.get("campaignId"));
        
        Integer bannerID = Integer.parseInt(bannerIDString);
        Integer campaignID = Integer.parseInt(campaignIDString);
        String url = (String) bannerObject.get("url");
        
        String startDateString = (String) bannerObject.get("startDate");
        String endDateString = (String) bannerObject.get("endDate");
        
        DateValidator dv = new DateValidator();
        Date startDate = dv.converToDate(startDateString, dv.BANNER_DATE_FORMAT);
        Date endDate = dv.converToDate(endDateString, dv.BANNER_DATE_FORMAT);
        
        Banner b = new Banner(bannerID, campaignID, url, startDate, endDate);
        bannersMap.put(bannerID, b); 
    }
    
    public HashMap<Integer, Banner> getBanners(){
        return this.bannersMap;
    }
}
