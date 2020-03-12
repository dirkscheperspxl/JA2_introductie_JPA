package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.MedicalFile;
import be.pxl.ja2.jpa.model.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Demo5RelationsOneToOne {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
			entityManager = entityManagerFactory.createEntityManager();
			Patient patient = new Patient();
			patient.setName("Sheldon Cooper");
			MedicalFile medicalFile = new MedicalFile();
			medicalFile.setHeight(186);
			medicalFile.setWeight(65.7);
			patient.setMedicalFile(medicalFile);
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(patient);
			tx.commit();
			entityManager.clear();

			TypedQuery<Patient> query = entityManager.createQuery("SELECT p FROM Patient p WHERE p.name = :name", Patient.class);
			tx.begin();
			query.setParameter("name", "Sheldon Cooper");
			Patient result = query.getSingleResult();
			System.out.println(patient.getMedicalFile().getHeight());
			patient.getMedicalFile().setWeight(65.9);
			entityManager.merge(patient);
			tx.commit();
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
