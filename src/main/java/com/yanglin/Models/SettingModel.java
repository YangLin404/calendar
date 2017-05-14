package com.yanglin.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by yanglin on 6/01/17.
 */
public class SettingModel
{
    private String url;
    private int port;

    public SettingModel()
    {

    }

    public SettingModel(String url, int port)
    {
        this.url = url;
        this.port = port;
    }


    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    @JsonIgnore
    public String getConnectionStr()
    {
        return this.url+":"+this.port;
    }
}
