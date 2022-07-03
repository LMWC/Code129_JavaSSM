package com.itheima.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        if (source.contains("-")){
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }else if(source.contains(".")){
            sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        }else if(source.contains("年")){
            sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        }
        Date date = null;
        try {
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("日期格式转换失败！");
        }
        return date;
    }
}
