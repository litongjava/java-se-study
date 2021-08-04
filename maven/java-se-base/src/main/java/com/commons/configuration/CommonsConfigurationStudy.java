package com.commons.configuration;

import java.net.URL;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @author Administrator
 * @date 2019年1月10日_上午10:42:54 
 * @version 1.0 
 */
public class CommonsConfigurationStudy {
  public static void main(String[] args) {
    URL resource = CommonsConfigurationStudy.class.getResource("/config.properties");
    System.out.println(resource);
    PropertiesConfiguration propertiesConfiguration = null;
    try {
      propertiesConfiguration = new PropertiesConfiguration(resource);
    } catch (ConfigurationException e) {
      e.printStackTrace();
    }
    propertiesConfiguration.setProperty("robot_dir", "key");
    propertiesConfiguration.setProperty("key", "value");
    try {
      propertiesConfiguration.save();
    } catch (ConfigurationException e) {
      e.printStackTrace();
    }
    Object property = propertiesConfiguration.getProperty("key");
  }
}
