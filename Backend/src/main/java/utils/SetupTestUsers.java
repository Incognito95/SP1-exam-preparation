package utils;


import entities.Boat;
import entities.Owner;
import entities.Role;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

    // user / admin
    User user = new User(1, "user", "1234");
    User admin = new User(2, "admin", "12345");

    // boats
    Boat boat1 = new Boat(1, "Bertram", "Bertram", "Bertram", "");
    Boat boat2 = new Boat(2, "Bertram", "Bertram", "Bertram", "");
    Boat boat3 = new Boat(3, "Bertram", "Bertram", "Bertram", "");
    Boat boat4 = new Boat(4, "Bertram", "Bertram", "Bertram", "");
    Boat boat5 = new Boat(5, "Bertram", "Bertram", "Bertram", "");
    Boat boat6 = new Boat(6, "Bertram", "Bertram", "Bertram", "");
    Boat boat7 = new Boat(7, "Bertram", "Bertram", "Bertram", "");
    Boat boat8 = new Boat(8, "Bertram", "Bertram", "Bertram", "");
    Boat boat9 = new Boat(9, "Bertram", "Bertram", "Bertram", "");
    Boat boat10 = new Boat(10, "Bertram", "Bertram", "Bertram", "");


    Owner owner = new Owner();



    if (admin.getUserPass().equals("test")||user.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");


    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");

    // boats
    em.persist(boat1);
    em.persist(boat2);
    em.persist(boat3);
    em.persist(boat4);
    em.persist(boat5);
    em.persist(boat6);
    em.persist(boat7);
    em.persist(boat8);
    em.persist(boat9);
    em.persist(boat10);

    em.persist(owner);
    user.addRole(userRole);
    admin.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
    System.out.println("Created 4 movies in database for test");


  }

}
