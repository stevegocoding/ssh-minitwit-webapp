package com.stevegocoding.minitwit.persist;

import com.stevegocoding.minitwit.model.User;
import com.stevegocoding.minitwit.persist.config.PersistenceConfig;
import com.stevegocoding.minitwit.persist.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by magkbdev on 7/21/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = PersistenceConfig.class,
        loader = AnnotationConfigContextLoader.class)
public class JdbcUserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllUsers() {
        Iterable<User> users = userRepository.getAll();
        int count = 0;
        for (User user : users) {
            ++count;
        }
        assertEquals(count, 6);
    }

    @Test
    public void findUserByEmail() {
        final String email = "steve@minitwit.com";
        User user = userRepository.findByEmail(email);
        assertTrue(user.getEmail().equals(email));
    }

}

