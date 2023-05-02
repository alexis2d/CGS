package fr.cgs.cgs_back;

import fr.cgs.cgs_back.dto.UserDto;
import fr.cgs.cgs_back.entity.User;
import fr.cgs.cgs_back.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CgsBackApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserService userService;

	@Test
	void testUserExist(){
		String testedEmail = "grigmand0@theatlantic.com";
		User result = userService.findByEmail(testedEmail);
		UserDto user = new UserDto(result);
		assert user.getEmail().equals(testedEmail);
	}

	@Test
	void testLogin() {
		String testedEmail = "grigmand0@theatlantic.com";
		String testedPassword = "al9BAGMDXW5";
		User result = userService.findByEmailAndPassword(testedEmail, testedPassword);
		UserDto user = new UserDto(result);
		assert user.getEmail().equals(testedEmail);
	}

}
