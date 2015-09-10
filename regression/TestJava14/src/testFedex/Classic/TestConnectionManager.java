package testFedex.Classic;
//package com.rps.tms.sql;

import java.util.Properties;

import junit.extensions.ConfigurableTestCase;

/**
 * Description of TestConnectionManager and its usage.
 * 
 * <h3>Property Of <font color="#3333ff">FedEx </font> <font
 * color="#00ff00">Ground </font> Package System, Inc. </b></h3>
 * <p>
 * 
 * @author Andre, <a href="mailto:akaan@ground.fedex.com">akaan@ground.fedex.com
 *         </a>
 * @since Creation date: (4/3/2002 16:19:07)
 * @version <code>$Id: TestConnectionManager.java,v 1.1 2005/01/22 04:06:55 akaan Exp $ </code>
 * @version <code>$Revision: 1.1 $</code>
 */
public class TestConnectionManager extends ConfigurableTestCase
{
  private Properties properties = null;

  /**
   * Insert the method's description here. Creation date: (4/3/2002 16:19:40)
   * 
   * @return java.util.Properties
   */
  public java.util.Properties getProperties()
  {
    if (properties == null)
    {
      properties = new Properties();

      properties.put("test.driver", getString("test.driver"));
      properties.put("test.url", getString("test.url"));
      properties.put("test.user", getString("test.user"));
      properties.put("test.password", getString("test.password"));
      properties.put("test.application", getString("test.application"));
      properties.put("test.securer.context", getString("test.securer.context"));
      properties.put("test.pool.autocommit", "true"); // must be turned on for
                                                      // MSAccess
    }
    return properties;
  }
}
