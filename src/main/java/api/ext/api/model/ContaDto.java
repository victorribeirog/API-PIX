package api.ext.api.model;

import api.ext.api.model.Enum.TipoConta;
import api.ext.api.model.Enum.ModeloConta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaDto {
    String agencia;
    String agenciaDigito;
    String conta;
    String contaDigito;
    String contaPgto;
    TipoConta tipoConta;
    ModeloConta modeloConta;
}
