package lawroom.com.br.spring_api_restful.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lawroom.com.br.spring_api_restful.domain.account.AccountRepository;

@Service
public class AuthenticationService implements UserDetailsService {

  @Autowired
  private AccountRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return repository.findByUsername(username);
  }

}
