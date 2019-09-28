package hu.unideb.inf.utils;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;


public class HibernateUtils {

    private static SessionFactory factory= null;
    private static Configuration conf;


    private static  SessionFactory buildSessionFancotry(){
        try {
            conf = new Configuration(); {

                conf.configure("hibernate.cfg.xml");

                System.out.println("Configuration Load Secces...");
                factory = conf.buildSessionFactory();

                System.out.println("Sessionfactory Load Secces.. ");
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

    private static File getPropertyFile() {
        File file = null;
        try {
            file = new File(System.getProperty("user.home") + "/try-hard-fx/db.properties");
            if (file.exists()) {
            } else {
                file = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;

    }
}
