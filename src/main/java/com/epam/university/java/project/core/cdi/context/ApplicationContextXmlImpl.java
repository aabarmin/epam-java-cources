package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionDocument;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionImpl;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReader;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReaderXmlImpl;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistryImpl;
import com.epam.university.java.project.core.cdi.bean.BeanFactory;
import com.epam.university.java.project.core.cdi.bean.BeanFactoryImpl;
import com.epam.university.java.project.core.cdi.bean.BeanPropertyDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanPropertyDefinitionImpl;
import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.ListDefinition.ListItemDefinition;
import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl.ListItemDefinitionImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 * Created by ilya on 24.09.17.
 */
public class ApplicationContextXmlImpl implements ApplicationContext {

    private BeanDefinitionRegistry beanRegistry = new BeanDefinitionRegistryImpl();
    private BeanDefinitionReader beanReader = new BeanDefinitionReaderXmlImpl(beanRegistry);
    private BeanFactory beanFactory = new BeanFactoryImpl(beanRegistry);

    public static void main(String[] args) {
        BeanDefinitionDocument beanDefinitionDocument = new BeanDefinitionDocument();
        BeanDefinition beanOne = new BeanDefinitionImpl();
        beanOne.setClassName("someClass");
        beanOne.setId("One");
        beanOne.setScope("NotSingleton");

        BeanPropertyDefinition prop = new BeanPropertyDefinitionImpl();
        ListDefinition structure = new ListDefinitionImpl();

        List<ListItemDefinition> list = new ArrayList<>();
        ListItemDefinition defOne = new ListItemDefinitionImpl();
        defOne.setValue("one");
        ListItemDefinition defTwo = new ListItemDefinitionImpl();
        defTwo.setValue("two");
        Collections.addAll(list, defOne, defTwo);

        structure.setItems(list);

        prop.setData(structure);
        prop.setName("itemList");

        BeanPropertyDefinition propOne = new BeanPropertyDefinitionImpl();

        propOne.setName("someString");
        propOne.setValue("someString");

        List<BeanPropertyDefinition> props = new ArrayList<>();
        Collections.addAll(props, prop, propOne);

        beanOne.setProperties(props);

        List<BeanDefinition> beans = new ArrayList<>();
        Collections.addAll(beans, beanOne);

        beanDefinitionDocument.setDefinitions(beans);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BeanDefinitionDocument.class);
            final Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(beanDefinitionDocument, new File("test_jaxb.xml"));
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            BeanDefinitionDocument unmarshal = (BeanDefinitionDocument) unmarshaller
                .unmarshal(new File("test_jaxb.xml"));
            System.out.println("");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        return beanFactory.getBean(beanClass);
    }

    @Override
    public Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return beanFactory.getBean(beanName, beanClass);
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        return beanReader.loadBeanDefinitions(resource);
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return beanReader.loadBeanDefinitions(resources);
    }
}
