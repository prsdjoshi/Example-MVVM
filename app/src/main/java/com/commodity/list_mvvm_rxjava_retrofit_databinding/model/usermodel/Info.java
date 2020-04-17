package com.commodity.list_mvvm_rxjava_retrofit_databinding.model.usermodel;

public class Info
{
    private String seed;

    private String page;

    private String results;

    private String version;

    public String getSeed ()
    {
        return seed;
    }

    public void setSeed (String seed)
    {
        this.seed = seed;
    }

    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

    public String getResults ()
    {
        return results;
    }

    public void setResults (String results)
    {
        this.results = results;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [seed = "+seed+", page = "+page+", results = "+results+", version = "+version+"]";
    }
}
