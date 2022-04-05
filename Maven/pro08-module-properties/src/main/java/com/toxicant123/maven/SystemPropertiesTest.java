package com.toxicant123.maven;

import java.util.Properties;
import java.util.Set;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-04-05 18:42
 */
public class SystemPropertiesTest {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Set<Object> propNameSet = properties.keySet();
        for (Object propName : propNameSet) {
            String propValue = properties.getProperty((String) propName);
            System.out.println(propName + " = " + propValue);
        }
    }
}
