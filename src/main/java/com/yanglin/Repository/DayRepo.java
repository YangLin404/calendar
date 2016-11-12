package com.yanglin.Repository;

public class DayRepo
{
    private static DayRepo ourInstance = new DayRepo();

    public static DayRepo getInstance()
    {
        return ourInstance;
    }

    private DayRepo()
    {
    }
}
