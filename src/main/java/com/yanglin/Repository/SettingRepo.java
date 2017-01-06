package com.yanglin.Repository;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yanglin.Models.SettingModel;
import org.springframework.stereotype.Repository;

import java.io.*;

/**
 * Created by yanglin on 1/01/17.
 */
@Repository
public class SettingRepo
{
    private final String FILENAME = "setting.json";

    public SettingRepo()
    {

    }

    public SettingModel readSetting()
    {
        try
        {
            FileReader fileReader = new FileReader(FILENAME);
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
        SettingModel settingModel = new SettingModel("http://yanglin.ddns.net",8888);
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            objectMapper.writeValue(new FileOutputStream(FILENAME),settingModel);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return settingModel;
    }


}
