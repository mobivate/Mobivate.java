package com.rawmobility.blender.demo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lettuce on 6/11/15.
 */
@XmlRootElement(name = "deliveryreceipt")
public class DeliveryReceipt {
    public String created;
    public String deliveryMessageId;
    public String status;
    public String clientReference;
    public String part;
    public String parts;

    public String toString() {
        return "My ref [" + clientReference + "] Upstream Ref [" + deliveryMessageId + "] Status: " + status;
    }
}
