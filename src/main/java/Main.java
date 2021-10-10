import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    private static StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private static Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    private static SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
    private static Session session = sessionFactory.openSession();
    
    public static void main(String[] args) {



        Transaction transaction = session.beginTransaction();
        System.out.println("\n*************************************************************************************\n");
        Course course = session.get(Course.class, 3);
        Student student = session.get(Student.class, 5);
        System.out.printf("Course name -> %s. Sensei: %s%n", course.getName(), course.getTeacher().getName());
        System.out.printf("Course name -> %s. Gakkysei: %d%n", course.getName(), course.getStudents().size());
        System.out.printf("Student name -> %s. Courses: %d%n", student.getName(), student.getCourseList().size());
        System.out.println("\n*************************************************************************************\n");
        transaction.commit();

        session.close();
        sessionFactory.close();
    }


}

