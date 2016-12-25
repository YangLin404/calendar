package com.yanglin.Repository;

import com.yanglin.Models.DataDay;
import com.yanglin.Models.DayModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    @Autowired
    public DayRepo(DayConvertor dayConvertor)
    {
        this.restTemplate = new RestTemplate();
        this.dayConvertor = dayConvertor;
    }


    @Override
    public SortedSet<DayModel> readDaysByYear(int year)
    {
        DataDay[] datadays = restTemplate.getForObject("http://localhost:8080/readDaysByYear?Year="+year, DataDay[].class);
        return dayConvertor.convert(datadays);
    }

    @Override
    public void updateDay(DayModel d)
    {
        DataDay dataDay = this.dayConvertor.convert(d);
        restTemplate.postForObject("http://localhost:8080/updateDay",dataDay,DataDay.class);
    }
}
