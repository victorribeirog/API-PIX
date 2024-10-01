package api.ext.api.model.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferirResponse {
    private Boolean sucesso;
    private String mensagem;
    UUID codigoTransacao;

    public boolean isSucesso(){
        return sucesso;
    }
}