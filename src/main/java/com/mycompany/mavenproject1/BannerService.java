/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.entities.Banner;
import com.mycompany.libs.AdServerFileTypes;
import java.util.HashMap;

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
    

    

    
    
    
    
    
    
    
    
    
}
