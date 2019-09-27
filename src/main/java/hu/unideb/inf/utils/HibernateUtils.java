package hu.unideb.inf.utils;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



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

}
