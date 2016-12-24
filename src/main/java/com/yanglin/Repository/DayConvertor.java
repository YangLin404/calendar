package com.yanglin.Repository;

import com.yanglin.Models.DataDay;
import com.yanglin.Models.DayModel;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by yanglin on 24/12/16.
 */

@Component
public class DayConvertor
{
    DayConvertor()
    {

    }

    public DayModel convert(DataDay d)
    {
        DayModel dayModel = new DayModel(d.getId(),d.getDay(),d.getMonth().getDigit(),d.getYear(),d.getWeekday(),d.getWork());
        return dayModel;
    }

    public SortedSet<DayModel> convert(SortedSet<DataDay> ds)
    {
        SortedSet<DayModel> days = new TreeSet<>();
        ds.forEach(d -> days.add(this.convert(d)));

        return days;
    }

    public SortedSet<DayModel> convert(DataDay[] ds)
    {
        SortedSet<DataDay> days = Arrays.stream(ds).collect(Collectors.toCollection(TreeSet::new));
        return this.convert(days);
    }
}
