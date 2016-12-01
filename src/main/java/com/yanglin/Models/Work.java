package com.yanglin.Models;

/**
 * Created by yanglin on 1/12/16.
 */
public enum Work
{
    Vroeg("btn-info"), Late("btn-primary"), Nacht("btn-success");

    private String styleClass;

    Work(String own)
    {
        this.styleClass = own;
    }

    public String getStyleClass()
    {
        return this.styleClass;
    }
}
