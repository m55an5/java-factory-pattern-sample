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
public class Campaign {
        
    private Integer campaignId;
    private String name;
    private Date startDate;
    private Date endDate;
    private int advertiserId;
    private int active;
    private int priority;
    
    public Campaign(Integer campaignId, String name, Date startDate, Date
            endDate, int advertiserId, int active, int priority) {
        this.campaignId = campaignId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.advertiserId = advertiserId;
        this.active = active;
        this.priority = priority;
        
    }

    /**
     * @return the campaignId
     */
    public Integer getCampaignId() {
        return campaignId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
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

    /**
     * @return the advertiserId
     */
    public int getAdvertiserId() {
        return advertiserId;
    }

    /**
     * @return the active
     */
    public int getActive() {
        return active;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

}
