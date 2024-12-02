package lawroom.com.br.spring_api_restful.domain.account;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
  
  @NotBlank
  private String username;
  
  @NotBlank
  private String password;
  
}
