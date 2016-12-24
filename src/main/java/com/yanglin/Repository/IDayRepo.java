package com.yanglin.Repository;

import com.yanglin.Models.DayModel;

import java.util.Set;
import java.util.SortedSet;

/**
 * Created by yanglin on 17/11/16.
 */
public interface IDayRepo
{
    SortedSet<DayModel> readDaysByYear(int year);

    void updateDay(DayModel d);
}
