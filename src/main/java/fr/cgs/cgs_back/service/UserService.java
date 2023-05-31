package fr.cgs.cgs_back.service;

import fr.cgs.cgs_back.entity.Site;
import fr.cgs.cgs_back.entity.User;
import fr.cgs.cgs_back.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        User user = null;
        try {
            user = userRepository.findByEmail(email);
        } catch (Exception e) {
            throw e;
        }
        return user;
    }

    @Transactional(readOnly = true)
    public User findByEmailAndPassword(String email, String password) {
        User user = null;
        try {
            user = userRepository.findByEmailAndPassword(email, password);
        } catch (Exception e) {
            throw e;
        }
        return user;
    }

    public User findById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(()->new EntityNotFoundException("User not found with id " + id));
    }


    public List<User> findAll(){
       List<User> result = userRepository.findAll();
       return result;
    }

}
