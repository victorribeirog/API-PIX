package api.ext.api.model;

import api.ext.api.model.Enum.PrioridadePix;
import api.ext.api.model.Enum.TipoQRCode;
import api.ext.api.model.Request.EnvioPorChaveRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PagamentoPixChave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private EnvioPorChaveRequest dadosEnvioPorChave;

    private Double valor;
    private String codigoOperacaoCliente;
    private String descricaoCliente;
    private PrioridadePix prioridadePix;

    @Embedded
    private ContaDto contaOrigem;

    private String informacoesAdicionais;
    private String idConciliacaoRecebedor;
    private TipoQRCode tipoQRCode;

    private String codigoLeituraQRCode;
    private String idempotencyKey;
    private boolean ignoraHandshake;

    private boolean sucesso;
    private String mensagem;
    private String codigoTransacao;
}
