package com.rawmobility.blender.demo;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {

    public Date unmarshal(String date) throws Exception {
        if (date.isEmpty())
            return null;
        return DateFormatter.parse(date);
    }

    public String marshal(Date date) throws Exception {
        if (date == null)
            return null;
        return DateFormatter.toString(date);
    }
}
