package com.mysolutions.startrisk.repository;

import com.mysolutions.startrisk.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository users;

    private User rostyslavMazepa = new User("Rostyslav","Y.", "Mazepa", "rmazepa","MR", true);
    private User olgaBataeva = new User("Olga","I.", "Bataeva", "obataeva","BO", true);

    @Before
    public void fillSomeDataIntoOurDb() {
        // Add new Users to Database
        entityManager.persist(rostyslavMazepa);
        entityManager.persist(olgaBataeva);
    }

    @Test
    public void testFindByLastName() throws Exception {
        // Search for specific User in Database according to lastname
        List<User> usersWithLastNameMazepa = users.findByLastName("Mazepa");

        assertThat(usersWithLastNameMazepa, contains(rostyslavMazepa));
    }


    @Test
    public void testFindByFirstName() throws Exception {
        // Search for specific User in Database according to firstname
        List<User> usersWithFirstNameBataeva = users.findByFirstName("Olga");

        assertThat(usersWithFirstNameBataeva, contains(olgaBataeva));
    }

}