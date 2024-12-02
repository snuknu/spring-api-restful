package lawroom.com.br.spring_api_restful.domain.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager manager;

  @PostMapping
  public ResponseEntity<?> login(@RequestBody @Valid AccountDto account) {
    
    var token = new UsernamePasswordAuthenticationToken(
        account.getUsername(),
        account.getPassword());
    
    var authentication = manager.authenticate(token);

    return ResponseEntity.ok().build();
  }
}
