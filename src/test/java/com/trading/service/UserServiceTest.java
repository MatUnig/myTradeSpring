//package pl.coderslab.service;
//
//import com.trading.repository.RoleRepository;
//import com.trading.repository.UserRepository;
//import com.trading.service.UserService;
//import com.trading.service.UserServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import UserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//
//public class UserServiceTest {
//
//    private UserService userService;
//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public UserServiceTest(UserService userService, UserRepository userRepository) {
//        this.userService = userService;
//        this.userRepository = userRepository;
//    }
//
//    @Before
//    public void setUp() {
//        userRepository = mock(UserRepository.class);
//        userService = new UserServiceImpl(userRepository, roleRepository, bCryptPasswordEncoder);
//    }
//
//    @Test
//    public void findByUserName() {
//    }
//
//    @Test
//    public void saveUser() {
//    }
//}