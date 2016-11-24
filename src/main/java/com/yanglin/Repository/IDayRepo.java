package com.yanglin.Repository;

import com.yanglin.Models.DayModel;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by yanglin on 17/11/16.
 */
public interface IDayRepo
{
    public SortedSet<DayModel> getDays();
}
