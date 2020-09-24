package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.context.ApplicationContext;
import com.epam.university.java.project.core.cdi.context.ApplicationContextFactory;
import com.epam.university.java.project.core.cdi.context.ApplicationContextFactoryImpl;
import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBException;

/**
 * Created by Romin Nuro on 24.09.2020 14:28.
 */
public class TestUnmarshaller {
    public static void main(String[] args) throws JAXBException {
        String testFilePath = TestUnmarshaller.class.getResource("/project/project001.xml").getFile();
        Resource source = new XmlResource(testFilePath);
        ApplicationContextFactory factory = new ApplicationContextFactoryImpl();
        ApplicationContext context = factory.newInstance();
        int y = context.loadBeanDefinitions(source);
        int x= 10;
        //todo delete before final commit
    }
}
