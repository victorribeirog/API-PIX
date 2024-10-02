package api.ext.api.model.Request;

import api.ext.api.model.Enum.PrioridadePix;
import api.ext.api.model.Enum.TipoQRCode;
import api.ext.api.model.ContaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferirRequest {
    private EnvioPorChaveRequest dadosEnvioPorChave;
    private Double valor;
    private String codigoOperacaoCliente;
    private String descricaoCliente;
    private PrioridadePix prioridadePix;
    private ContaDto contaOrigem;
    private  String informacoesAdicionais;
    private  String idConciliacaoRecebedor;
    private TipoQRCode tipoQRCode;
    private  String codigoLeituraQRCode;
}
