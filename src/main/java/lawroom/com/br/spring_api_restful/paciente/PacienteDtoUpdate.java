package lawroom.com.br.spring_api_restful.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lawroom.com.br.spring_api_restful.domains.EnderecoDtoUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDtoUpdate {

  @NotNull
  private Long id;

  private String nome;
  private String telefone;

  @Valid
  private EnderecoDtoUpdate endereco;

}
