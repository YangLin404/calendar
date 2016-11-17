package com.yanglin.Repository;

import com.yanglin.Models.DayFactory;
import com.yanglin.Models.DayModel;
import com.yanglin.Models.Month;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.TreeSet;

/**
 * Created by yanglin on 17/11/16.
 */
public class DayRepoHC
{
    //just for testing
    private TreeSet<DayModel> fakeDays;

    public DayRepoHC()
    {
        fakeDays = new TreeSet<>();
        for (Month m : Month.values())
        {
            for (int i=1; i<=m.getTotaaldays(); i++)
            {
                fakeDays.add(DayFactory.getInstance().createDay(i,m.getDigit(),2016));
            }
        }
    }

    public TreeSet<DayModel> getFakeDays()
    {
        return fakeDays;
    }

    private void setupEvents()
    {
        for (DayModel d : fakeDays)
        {

        }
    }
}
