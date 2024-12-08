package uz.ksan.backend.Auth_service.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.ksan.backend.Auth_service.model.AuthEntity;
import uz.ksan.backend.Auth_service.model.UserPrincipal;
import uz.ksan.backend.Auth_service.repository.AuthRepository;
import uz.ksan.backend.Auth_service.service.AuthService;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;


    @Override
    public UserDetails loadUserByUsername(String authEmail) throws UsernameNotFoundException {

        AuthEntity auth = authRepository.findByAuthEmail(authEmail);

        if (auth == null) {
            throw new UsernameNotFoundException("User not found: " + authEmail);
        }
        return new UserPrincipal(auth);
    }
}
