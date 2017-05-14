package com.yanglin.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yanglin.Models.SettingModel;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by yanglin on 1/01/17.
 */
@Repository
public class SettingRepo
{
    private final String FILENAME = "setting.json";
    private final String homeDir = System.getProperty("user.home")+File.separator+"MyCalendar";

    public SettingRepo()
    {

    }

    public SettingModel readSetting()
    {
        try
        {
            FileReader fileReader = new FileReader(this.getPathToSettingFile());
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(fileReader,SettingModel.class);
        } catch (FileNotFoundException e)
        {
            return createSetting();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private SettingModel createSetting()
    {
        SettingModel settingModel = new SettingModel("http://yanglin.ddns.net",8080);
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            Path path = Paths.get(homeDir);
            if (!Files.exists(path))
                Files.createDirectory(path);
            objectMapper.writeValue(new FileOutputStream(this.getPathToSettingFile()),settingModel);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return settingModel;
    }

    private String getPathToSettingFile()
    {
        return homeDir+File.separator+FILENAME;
    }


}
