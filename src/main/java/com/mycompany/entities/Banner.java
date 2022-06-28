/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.Date;


/**
 *
 * @author manjotssandhu
 */
public class Banner {

    private Integer bannerId;
    private Integer campaignId;
    private String url;
    private Date startDate;
    private Date endDate;

    public Banner(Integer bannerId, Integer campaignId, String url, 
            Date startDate, Date endDate) {
        this.bannerId = bannerId;
        this.campaignId = campaignId;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
    }
            
    /**
     * @return the bannerId
     */
    public Integer getBannerId() {
        return bannerId;
    }

    /**
     * @return the campaignId
     */
    public Integer getCampaignId() {
        return campaignId;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }
    
    @Override
    public String toString() {
        return "\tBanner{" + "bannerId=" + bannerId + ", campaignId=" + campaignId + ", url=" + url + '}';
    }
    
}
