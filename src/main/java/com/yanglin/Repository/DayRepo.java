package com.yanglin.Repository;

import com.yanglin.Models.DataDay;
import com.yanglin.Models.DayModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Repository
public class DayRepo implements IDayRepo
{

    private RestTemplate restTemplate;
    private DayConvertor dayConvertor;
    private String connectieStr;

    @Autowired
    public DayRepo(DayConvertor dayConvertor)
    {
        this.restTemplate = new RestTemplate();
        this.dayConvertor = dayConvertor;
    }


    @Override
    public SortedSet<DayModel> readDaysByYear(int year)
    {
        DataDay[] datadays = restTemplate.getForObject(this.connectieStr+"/readDaysByYear?Year="+year, DataDay[].class);
        return dayConvertor.convert(datadays);
    }

    @Override
    public void updateDay(DayModel d)
    {
        DataDay dataDay = this.dayConvertor.convert(d);
        restTemplate.postForObject(this.connectieStr+"/updateDay",dataDay,DataDay.class);
    }

    public void setConnectieStr(String conn)
    {
        this.connectieStr = conn;
    }
}
