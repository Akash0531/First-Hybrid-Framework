package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	 
	Properties prop;
	
	public ConfigDataProvider()
	{
	  File src = new File("./Configuration/config.properties");
	  try {
		FileInputStream fis = new FileInputStream(src);
        prop = new Properties();
		prop.load(fis);
	} catch (Exception e) {
		System.out.println("Exception is"+e.getMessage());
	}
	  
	}
	
	public String getBrowser(){
		String URL =prop.getProperty("browser");
	    return URL;
	}
	
    public String getApplicationURL()
    {
    	String URL = prop.getProperty("url");
    	return URL;
    }
    
    public String getIEPath()
    {
    	String URL = prop.getProperty("IEPath");
    	return URL;
    }
    
    public String getchromePath()
    {
    	String URL = prop.getProperty("chromePath");
    	return URL;
    }
}
