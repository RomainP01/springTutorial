package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieControllerInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan(basePackages = {
        "com.mycompany.dvdstore.controller",
        "com.mycompany.dvdstore.service",
        "com.mycompany.dvdstore.repository.file"
})
@PropertySource("classpath:application.properties")
//@ImportResource("classpath:applicationContext.xml")
public class App 
{
    public static void main( String[] args )
    {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        MovieControllerInterface movieController = context.getBean(MovieControllerInterface.class);
        movieController.addUsingConsole();

    }
}
