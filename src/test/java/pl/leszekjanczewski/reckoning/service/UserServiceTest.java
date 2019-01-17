package pl.leszekjanczewski.reckoning.service;

import lombok.Builder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.leszekjanczewski.reckoning.model.User;
import pl.leszekjanczewski.reckoning.repository.RoleRepo;
import pl.leszekjanczewski.reckoning.repository.UserRepo;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    @Mock
    private UserRepo mockUserRepo;

    @Mock
    private RoleRepo mockRoleRepo;

    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceUnderTest;
    private User user;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        userServiceUnderTest = new UserServiceImpl(mockUserRepo, mockRoleRepo, mockBCryptPasswordEncoder);

        user = User.builder()
                .userId(1L)
                .firstName("Jan")
                .lastName("Testowy")
                .email("jan.testowy@test.com")
                .login("jan.testowy")
                .build();

        Mockito.when(mockUserRepo.save(any())).thenReturn(user);
        Mockito.when(mockUserRepo.findByLogin(anyString())).thenReturn(user);
    }

    @Test
    public void testFindUserByEmail() {
        // given
        final String login = "jan.testowy";

        //when
        final User result = userServiceUnderTest.findUserByLogin(login);

        //then
        assertEquals(login, result.getLogin());
    }

    /*@Test
    public void testSaveUser() {
        // given
        final String login = "jan.testowy";

        //when
        User result = userServiceUnderTest.saveUser(User.builder().build());

        //then
        assertEquals(login, result.getLogin());
    }*/
}