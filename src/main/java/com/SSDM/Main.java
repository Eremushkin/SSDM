package com.SSDM;

import com.SSDM.model.entity.StudentGroup;
import com.SSDM.model.service.StudentGroupSpringDataService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        StudentGroupSpringDataService bean = applicationContext.getBean(StudentGroupSpringDataService.class);
        bean.addOrUpdate(new StudentGroup("141"));
        bean.addOrUpdate(new StudentGroup("241"));
        bean.addOrUpdate(new StudentGroup("341"));


    }
}
