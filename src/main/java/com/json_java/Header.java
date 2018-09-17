package com.json_java;

public class Header {

	    private String trackingNumber;

	    private String locale;

	    private String info1;

	    private String info2;

	    public String getTrackingNumber ()
	    {
	        return trackingNumber;
	    }

	    public void setTrackingNumber (String trackingNumber)
	    {
	        this.trackingNumber = trackingNumber;
	    }

	    public String getLocale ()
	    {
	        return locale;
	    }

	    public void setLocale (String locale)
	    {
	        this.locale = locale;
	    }

	    public String getInfo1 ()
	    {
	        return info1;
	    }

	    public void setInfo1 (String info1)
	    {
	        this.info1 = info1;
	    }

	    public String getInfo2 ()
	    {
	        return info2;
	    }

	    public void setInfo2 (String info2)
	    {
	        this.info2 = info2;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [trackingNumber = "+trackingNumber+", locale = "+locale+", info1 = "+info1+", info2 = "+info2+"]";
	    }
	}

