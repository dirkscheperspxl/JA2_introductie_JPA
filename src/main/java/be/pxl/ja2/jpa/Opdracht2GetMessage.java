package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Message;

import javax.persistence.*;
import java.util.Scanner;

public class Opdracht2GetMessage {
    private static final String SQL_STRING = "SELECT m from Message m where m.id = :id";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the message you are looking for");
        Long id = scanner.nextLong();
        scanner.nextLine();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Message message = entityManager.find(Message.class, id);
        System.out.println("this is the message: " + message.getText());
        TypedQuery<Message> query = entityManager.createQuery(SQL_STRING, Message.class);
        query.setParameter("id",id);
        Message message1 = query.getSingleResult();
        System.out.println("------------- via query ---------------");
        System.out.println("query-result: " + message1.getText());


    }

}
