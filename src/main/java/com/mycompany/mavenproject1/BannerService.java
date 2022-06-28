/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.entities.Banner;
import com.mycompany.libs.AdServerFileTypes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author manjotssandhu
 */
public class BannerService {

    private HashMap<Integer, Banner> banners = new HashMap<>();
    
    public HashMap<Integer, Banner> getBanners() {
        return banners;
    }
    
    public void setBanners(HashMap<Integer, Banner> banners) {
        this.banners = banners;
    }
    
    public void readBannerFile(String file){
        ReadFile rf = MiniAdServerFileReaderFactory.
                    buildFileReader(AdServerFileTypes.BANNER, file);
        rf.readFile();
        this.setBanners(((BannerFileReader) rf).getBanners());
        
    }
    
    public ArrayList<Banner> getBannersObjForCampaign(int campaignId, int max) {
        ArrayList<Banner> tmpBanners = new ArrayList<>();
        
        int counter = 0;
        
        for(Map.Entry<Integer, Banner> set: this.getBanners().entrySet()) {
            if(set.getValue().getCampaignId() == campaignId) {
                if(counter < max) {
                    tmpBanners.add(set.getValue());
                    counter++;
                }
            }
        }
        
        return tmpBanners;
    }
    
    
    public ArrayList<Integer> getBannersIDForCampaign(int campaignId, int max) {
        ArrayList<Integer> tmpBanners = new ArrayList<>();
        
        int counter = 0;
        
        for(Map.Entry<Integer, Banner> set: this.getBanners().entrySet()) {
            if(set.getValue().getCampaignId() == campaignId) {
                if(counter < max) {
                    tmpBanners.add(set.getValue().getBannerId());
                    counter++;
                }
            }
        }
        
        return tmpBanners;
    }
    
    
    
    public void printCampaingsList(ArrayList<Banner> bannersList) {
        
        bannersList.forEach(banner -> {
            System.out.println(banner.toString());
        });
    }
    

    

    
    
    
    
    
    
    
    
    
}
