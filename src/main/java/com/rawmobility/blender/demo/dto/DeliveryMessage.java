package com.rawmobility.blender.demo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lettuce on 6/11/15.
 */
@XmlRootElement(name = "deliverymessage")
public class DeliveryMessage {
    public String created;
    // Our ID
    public String id;
    public String body;
    // If matched with a previous outgoing message, this is the id
    public String inReplyTo;
    // If matched with a previous outgoing message, this is the batch id
    public String logicalMessageId;
    public String originator;
    public String recipient;

    public String toString() {
        return originator + "->" + recipient + " : " + body;
    }
}
