package com.yanglin.Repository;

import com.yanglin.Models.DataDay;
import com.yanglin.Models.DayModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class DayRepo implements IDayRepo
{
    private final static Logger LOGGER = Logger.getLogger(DayRepo.class.getName());

    private RestTemplate restTemplate;
    @Autowired
    private DayConvertor dayConvertor;
    private String connectieStr;
    @Autowired
    private SettingRepo settingRepo;

    public DayRepo(DayConvertor dayConvertor)
    {
        this.restTemplate = new RestTemplate();
        this.dayConvertor = dayConvertor;
    }

    @PostConstruct
    private void init()
    {
        this.connectieStr = settingRepo.readSetting().getConnectionStr();
    }


    @Override
    public SortedSet<DayModel> readDaysByYear(int year)
    {
        String url = this.connectieStr+"/readDaysByYear?Year="+year;
        LOGGER.log(Level.INFO, "reading days of year " + year + ". url: " + url);
        DataDay[] datadays = restTemplate.getForObject(url, DataDay[].class);
        LOGGER.log(Level.INFO, datadays.length + " days retrieved.");
        return dayConvertor.convert(datadays);
    }

    @Override
    public void updateDay(DayModel d)
    {
        String url = this.connectieStr+"/updateDay";
        DataDay dataDay = this.dayConvertor.convert(d);
        LOGGER.log(Level.INFO, "updating day: " + d.toString() + ". url: " + url);
        restTemplate.postForObject(url,dataDay,DataDay.class);
    }
}
