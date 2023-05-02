package fr.cgs.cgs_back.repository;

import fr.cgs.cgs_back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email=:email")
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
    User findByEmailAndPassword(String email, String password);

}
