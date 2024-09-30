package api.ext.api.model.Request;

import api.ext.api.model.Enum.TipoChavePix;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnvioPorChaveRequest {
    UUID ticket;
    String chave;
    TipoChavePix tipoChavePix;
}
