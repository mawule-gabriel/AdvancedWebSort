package org.example.advancedwebsort;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.example.advancedwebsort.config.AppConfigClass;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class Websort implements WebApplicationInitializer {


    public static void main(String[] args) {
        System.out.println("HelloWorld");
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(AppConfigClass.class);
        applicationContext.setServletContext(servletContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "SpringDispatcher", new DispatcherServlet(applicationContext)

        );
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }




}
