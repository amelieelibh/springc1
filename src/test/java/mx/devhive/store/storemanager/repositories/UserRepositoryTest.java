package mx.devhive.store.storemanager.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;
import mx.devhive.store.storemanager.model.User;
import mx.devhive.store.storemanager.model.dto.UserType;

@Slf4j
@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("dev")
//@SpringBootTest(classes = {UserRepository.class})
@DataMongoTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	private User user1; 
	
	@BeforeEach
	public void insertInit() {
		user1 = User.builder()
				.email("a@b.com")
				.pass("abc")
				.type(UserType.CLIENT)
				.build();
		userRepository.save(user1);
	}
	
	@Order(2)
	@Test
	public void findUser1() {
		User found = userRepository.findByEmail(user1.getEmail());
		assertThat(found).isNotNull();
		log.info("user = " + found.toString());
	}
	
	@Order(1)
	@Test
	public void findUser2() {
		User found = userRepository.findByEmail(user1.getEmail());
		assertThat(found).isNotNull();
		log.info("user = " + found.toString());
	}
	
	@AfterEach
	public void deleteInit() {
		userRepository.delete(user1);
	}
}
