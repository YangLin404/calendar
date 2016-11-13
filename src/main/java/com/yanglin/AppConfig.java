package com.yanglin;

import com.yanglin.Controllers.CalendarController;
import com.yanglin.Repository.DayRepo;
import com.yanglin.Service.CalendarManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig
{

    @Bean
    DayRepo dayRepo()
    {
        return new DayRepo();
    }

    @Bean
    CalendarManager calendarManager()
    {
        return new CalendarManager(dayRepo());
    }

    @Bean
    CalendarController calendarController()
    {
        return new CalendarController(calendarManager());
    }
}
