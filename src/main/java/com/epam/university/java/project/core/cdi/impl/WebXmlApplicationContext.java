package com.epam.university.java.project.core.cdi.impl;

import javax.servlet.ServletConfig;

/**
 * Application context which provides resources from web.xml configuration.
 */
public class WebXmlApplicationContext extends XmlApplicationContext {
    public WebXmlApplicationContext(ServletConfig servletConfig) {
        // extract context configuration files form servlet config
    }
}
