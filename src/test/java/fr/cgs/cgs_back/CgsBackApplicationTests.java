package fr.cgs.cgs_back;

//import fr.cgs.cgs_back.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CgsBackApplicationTests {

	@Test
	void contextLoads() {
	}

	/* Plutôt Mocker les Services utilisés pour effectuer les tests pour ne pas créer une instance réelle de la classe appelée */
//	@Autowired
//	private UserService userService;

//	@Test
//	void testUserExist(){
//		String testedEmail = "grigmand0@theatlantic.com";
//		User result = userService.findByEmail(testedEmail);
//		UserDto user = new UserDto(result);
//		assert user.getEmail().equals(testedEmail);
//	}
//
//	@Test
//	void testLogin() {
//		String testedEmail = "grigmand0@theatlantic.com"; // On vas éviter de faire des tests avec des données existantes en Base.
//		String testedPassword = "al9BAGMDXW5";
//		User result = userService.findByEmailAndPassword(testedEmail, testedPassword);
//		UserDto user = new UserDto(result);
//		assert user.getEmail().equals(testedEmail);
//	}

}
