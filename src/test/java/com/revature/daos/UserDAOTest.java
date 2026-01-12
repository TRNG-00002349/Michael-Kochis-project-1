package com.revature.daos;

import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.revature.models.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDAOTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private User mockUser;

    //SUT
    private UserDAO userDAO;


    @BeforeEach
    //This annotated method will be invoked before each test.
    public void setUp() {
        userDAO = new UserDAO(userRepository);
        mockUser = new User(123L, "testUser", "password1", "first", "last", "test@test.com");
    }

    @Test
    public void emptyInitSucceeds() {
        userDAO = new UserDAO();
    }

    @Test
    public void updateUserPlain() {
        when(userRepository.updateUser(mockUser)).thenReturn(true);

        assertEquals(true, userDAO.updateUser(mockUser));
    }

}