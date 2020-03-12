package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo2Persist {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Contact sophie = new Contact("ellen", 465465, "ellen@pxl.be");
			Contact vera = new Contact("elma", 472825117, "elma@pxl.be");
			entityManager.persist(vera);

			entityManager.persist(sophie);
			entityTransaction.commit();
		}
		finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
			}
		}
	}
}
