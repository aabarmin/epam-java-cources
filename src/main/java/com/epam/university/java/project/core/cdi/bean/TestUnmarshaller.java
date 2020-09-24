package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by Romin Nuro on 24.09.2020 14:28.
 */
public class TestUnmarshaller {
    public static void main(String[] args) throws JAXBException {
        final String testFilePath = TestUnmarshaller.class.getResource("/project/project003.xml").getFile();
        JAXBContext context = JAXBContext.newInstance(BeanDefinitionsList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        BeanDefinitionsList bean = (BeanDefinitionsList) unmarshaller.unmarshal(new File(testFilePath));
        List<BeanDefinition> list = bean.getList();
        System.out.println(list);

        //todo delete before final commit
    }
}
