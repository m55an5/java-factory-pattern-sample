/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.libs.AdServerFileTypes;

/**
 *
 * @author manjotssandhu
 */
public class MiniAdServerFileReaderFactory {
    
    public static ReadFile buildFileReader(AdServerFileTypes fileType, 
                                                            String file){
        ReadFile rf = null;
        
        switch(fileType) {
            case CAMPAIGN:
                rf = new CampaignFileReader(file);
                break;
            
            case BANNER:
                rf = new BannerFileReader(file);
                break;
                
            default:
                System.err.println("File type not supported");
                break;
        }
        return rf;
    }
    
}
