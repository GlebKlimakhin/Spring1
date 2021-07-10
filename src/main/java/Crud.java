import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Crud {

    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            init();
            update();
//        create();
//        delete();
//        readAllProducts();
//        showProduct();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            shutdown();
        }
    }

    public static void init(){
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void shutdown(){
        factory.close();
    }

    public static void showProduct(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            System.out.println(product);
            session.getTransaction().commit();
        }
    }

    public static void update(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            product.setCost(31);
            session.getTransaction().commit();
        }
    }

    public static void delete(){
        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public static void create(){
        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = new Product(12L, "door", 490);
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
    }
