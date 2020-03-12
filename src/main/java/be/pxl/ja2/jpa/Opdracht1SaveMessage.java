package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Scanner;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Opdracht1SaveMessage {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter your message");
		String inputMessage = scanner.nextLine();
		Message message = new Message(inputMessage);

		entityManagerFactory=Persistence.createEntityManagerFactory("musicdb_pu");
		entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(message);
		entityTransaction.commit();


	}

}
