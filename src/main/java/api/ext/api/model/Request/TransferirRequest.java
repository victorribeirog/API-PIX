package api.ext.api.model.Request;

import api.ext.api.model.Enum.PrioridadePix;
import api.ext.api.model.Enum.TipoQRCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TransferirRequest {
    EnvioPorChaveRequest dadosEnvioPorChave;
    Double valor;
    String codigoOperacaoCliente;
    String descricaoCliente;
    PrioridadePix prioridadePix;
    String informacoesAdicionais;
    String idConciliacaoRecebedor;
    TipoQRCode tipoQRCode;
    String codigoLeituraQRCode;
}
