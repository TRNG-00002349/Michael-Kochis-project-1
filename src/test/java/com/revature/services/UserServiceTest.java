package com.revature.services;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.revature.daos.UserDAO;
import com.revature.exceptions.UsernameValidationException;
import com.revature.models.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDAO mockUserDao;

    //SUT
    private UserService userService;


    @BeforeEach
    //This annotated method will be invoked before each test.
    public void setUp() {
        userService = new UserService(mockUserDao);
    }

    @Test
    public void testGoodUserSucceeds() throws SQLException, UsernameValidationException {
        //arrange
        Long resultUserId = 999L;
        String username = "testuser";
        String email = "testuser@email.com";
        String password = "testPass123!";
        String firstName = "Test";
        String lastName = "User";
        User testUser = new User(username, email, password, firstName, lastName);
        User resultUser = new User(resultUserId, username, email, password, firstName, lastName);
        when(mockUserDao.saveUser(testUser)).thenReturn(resultUser);

        //act
        User ActualResultUser = userService.saveUser(testUser);

        //assert
        assertEquals(resultUser, ActualResultUser);
    }

    @Test
    public void testShortUsernameThrowsException() {
        //arrange
        String tooShortUsername = "al";
        User testUser = new User();
        testUser.setUsername(tooShortUsername);
        User resultUser = new User();
        resultUser.setUsername(tooShortUsername);
        resultUser.setId(999L);
        // when(mockUserDao.saveUser(testUser)).thenReturn(resultUser);

        //act
        assertThrows(UsernameValidationException.class, () -> {
            userService.saveUser(testUser);
        });

        //assert
        //The assertion part happens to be up on the same line as the action in this case
    }

    @Test
    public void testUpdateUserSucceeds() {
        //arrange
        Long userId = 55L;
        boolean expectedResult = true;

        //update user
        String newUserName = "testuser2";
        String newEmail = "testuser1@email.com";
        String newPassword = "testPass456!";
        String newFirstName = "Test2";
        String newLastName = "User2";
        User updateUser = new User(userId, newUserName, newPassword, newEmail, newFirstName, newLastName);

        when(mockUserDao.updateUser(updateUser)).thenReturn(true);

        //act
        boolean actualResult = userService.updateUser(updateUser);

        //assert
        assertEquals(expectedResult, actualResult);
    }

}