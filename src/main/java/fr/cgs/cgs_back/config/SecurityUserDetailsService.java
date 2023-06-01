package fr.cgs.cgs_back.config;

import fr.cgs.cgs_back.entity.User;
import fr.cgs.cgs_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> account = userRepository.findByEmail(username);
        if (account.isPresent()){
            return account.get();
        }
        throw new UsernameNotFoundException("The username $username doesn't exist");
    }
}
