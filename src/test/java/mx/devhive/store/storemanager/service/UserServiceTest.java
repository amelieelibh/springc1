package mx.devhive.store.storemanager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import mx.devhive.store.storemanager.model.User;
import mx.devhive.store.storemanager.model.dto.UserType;
import mx.devhive.store.storemanager.repositories.UserRepository;
import mx.devhive.store.storemanager.services.UserService;

@Slf4j
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
@ContextConfiguration(classes = {UserService.class, UserRepository.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("dev")
@SpringBootTest(classes = {UserService.class})
@AutoConfigureMockMvc
public class UserServiceTest {
	
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;
    
    
    @BeforeEach
    public void init(){
    	final List<User> users = Lists.newArrayList();
    	User user1 = User.builder()
				.email("a@b.com")
				.pass("abc")
				.type(UserType.CLIENT)
				.build();
    	User user2 = User.builder()
				.email("patito@patito.com")
				.pass("1234567890")
				.type(UserType.CLIENT)
				.build();
		users.add(user1);
		users.add(user2);
    	
    	Mockito.when(userRepository.findAll()).thenReturn(users);
    	Mockito.when(userRepository.findByEmail("a@b.com"))
    		.thenReturn(user1);
    	
    }

    @Order(1)
    @Test
    public void findByEmailTest() throws Exception{
    	String email = "a@b.com";
		log.info("email: " + email);
    	User item = userService.findUserByEmail(email);
    	assertNotNull(item, "items were null but not null expected");
    	log.info("user found > " + item.toString());
    	Mockito.verify(userRepository, Mockito.times(1)).findByEmail(email);
    }
    
    @Order(2)
    @Test
    public void findAllTest() throws Exception{
    	List<User> items = userService.getAllUsers();
    	assertNotNull(items, "items were null but not null expected");
    	items.forEach((item) -> log.debug("item :" + item.toString()));
    	Mockito.verify(userRepository, Mockito.times(1)).findAll();
    	assertEquals(items.size(), 2);
    }
    
}
