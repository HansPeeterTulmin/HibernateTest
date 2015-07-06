import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

/**
 * Created by Hans Peeter Tulmin on 1.07.2015.
 */
public class Main {

    public static void printEntity(EntityManager entityManager) {
        try {
            List<PlainEntity> list = entityManager.createNamedQuery("PlainEntity.getByBar", PlainEntity.class).setParameter("bar", "b").getResultList();
            for (PlainEntity e : list) {
                System.out.println(e.toString());
                //System.out.println("TEST");
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) throws InterruptedException {

		EntityManagerFactory entityManagerFactory;

		entityManagerFactory = Persistence.createEntityManagerFactory("org.zeroturnaround.JPA.test");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for(int i=0;i<1000;i++) {
            System.out.println(i);
            printEntity(entityManager);
        }
        entityManager.close();
        entityManagerFactory.close();
	}
}
