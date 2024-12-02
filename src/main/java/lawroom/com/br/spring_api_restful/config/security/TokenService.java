package lawroom.com.br.spring_api_restful.config.security;

import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import lawroom.com.br.spring_api_restful.domain.account.Account;

@Service
public class TokenService {

  public String generateToken(Account account) {

    try {
      Algorithm algorithm = Algorithm.HMAC256("12345678");

      return JWT.create()
          .withIssuer("API Filla")
          .withSubject(account.getUsername())
          .withClaim("id", account.getId())
          .sign(algorithm);

    } catch (JWTCreationException exception) {
      throw new RuntimeException("The token cannot be generated.", exception);
    }

  }

}
