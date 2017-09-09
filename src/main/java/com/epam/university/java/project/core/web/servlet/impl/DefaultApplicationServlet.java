package com.epam.university.java.project.core.web.servlet.impl;

import com.epam.university.java.project.core.cdi.context.ApplicationContext;
import com.epam.university.java.project.core.cdi.impl.WebXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author ABarmin
 */
public class DefaultApplicationServlet extends HttpServlet {
    private ApplicationContext applicationContext;

    @Override
    public void init(ServletConfig config) throws ServletException {
        applicationContext = new WebXmlApplicationContext(config);
    }
}
