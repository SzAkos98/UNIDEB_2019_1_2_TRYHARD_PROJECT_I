package hu.unideb.inf.utils;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class HibernateUtils {

    private static SessionFactory factory= null;
    private static Configuration conf;


    private static  SessionFactory buildSessionFancotry(){
        try {
            conf = new Configuration(); {

                conf.configure("hibernate.cfg.xml").addProperties(getPropertyFile());

                System.out.println("Configuration Load Socces...");
                factory = conf.buildSessionFactory();

                System.out.println("Sessionfactory Load Socces.. ");
                return factory;
            }

        }
        catch(Throwable ex){
            ex.printStackTrace();

            throw  new ExceptionInInitializerError(ex);
        }
    }


    public static  SessionFactory getSessionFactory(){
        if(factory ==null )

            factory = buildSessionFancotry();
        return factory;
    }


        private static Properties getPropertyFile() throws IOException {
            java.util.Properties properties = new Properties();
            properties.load(new FileInputStream(System.getProperty("user.home") + "/try-hard-fx/db.properties"));

            return properties;



    }
}
