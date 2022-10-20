package com.example.vote.Utils;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class Util {
    public static long getTimeIntervalToTomorrow(){
        Calendar cal= Calendar.getInstance();
        cal.add(Calendar.DATE,1);//这里改为1
        Date tomorrow=cal.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date();

        long diff = tomorrow.getTime() - currentTime.getTime();//这样得到的差值是毫秒级别
        long minutesLeft = diff / (1000 * 60);
        return minutesLeft+1;
    }

    public static void triggerAop(){

    }

}
