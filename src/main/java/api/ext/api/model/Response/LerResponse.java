package api.ext.api.model.Response;

import api.ext.api.model.Enum.TipoQRCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LerResponse {

    boolean sucesso;
    String mensagem;
    String tipoQRCode;
    UUID codigoLeituraQRCode;
    TipoQRCode tpQRCode;
    String chave;
    Boolean reutilizavel;
    Boolean reutilizavelEspecificado;
    Double valor;
    Boolean valorEspecificado;
    String documentoFederal;
    String informacoesAdicionais;
    String idConciliacaoRecebedor;
    String nome;
    String cidade;
    String url;
    String nomeParticipante;
    String numeroBanco;
    String ispbParticipante;
}
