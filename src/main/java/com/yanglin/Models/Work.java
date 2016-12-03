package com.yanglin.Models;

/**
 * Created by yanglin on 1/12/16.
 */
public enum Work
{
    Vroeg("info"), Late("primary"), Nacht("success"), None("default");

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
