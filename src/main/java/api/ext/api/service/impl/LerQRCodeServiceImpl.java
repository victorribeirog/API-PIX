package api.ext.api.service.impl;

import api.ext.api.model.Enum.TipoQRCode;
import api.ext.api.model.Request.LerQRCodeRequest;
import api.ext.api.model.Response.LerResponse;
import api.ext.api.service.services.LerQRCodeService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LerQRCodeServiceImpl implements LerQRCodeService {

    @Override
    public LerResponse lerQRCode(LerQRCodeRequest request) {
        LerResponse response = new LerResponse();

        if (!isValidRequest(request)) {
            response.setSucesso(false);
            response.setMensagem("Requisição inválida.");
            return response;
        }

        response.setSucesso(true);
        response.setMensagem("QR Code lido com sucesso!");
        response.setTipoQRCode("Estatico");
        response.setCodigoLeituraQRCode(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6")); // UUID exemplo
        response.setTpQRCode(TipoQRCode.Estatico);
        response.setChave("chave_exemplo");
        response.setReutilizavel(true);
        response.setReutilizavelEspecificado(true);
        response.setValor(0.0);
        response.setValorEspecificado(true);
        response.setDocumentoFederal("documento_exemplo");
        response.setInformacoesAdicionais("Informações adicionais sobre a leitura.");
        response.setIdConciliacaoRecebedor("conciliacao_exemplo");
        response.setNome("Nome Participante");
        response.setCidade("Cidade Exemplo");
        response.setUrl("http://exemplo.com");
        response.setNomeParticipante("Nome Participante");
        response.setNumeroBanco("001");
        response.setIspbParticipante("12345678");

        return response;
    }

    private boolean isValidRequest(LerQRCodeRequest request) {
        return request.getAgencia() != null && !request.getAgencia().isEmpty()
                && request.getConta() != null && !request.getConta().isEmpty()
                && request.getAgenciaDigito() != null && !request.getAgenciaDigito().isEmpty()
                && request.getContaDigito() != null && !request.getContaDigito().isEmpty()
                && request.getContaPgto() != null && !request.getContaPgto().isEmpty()
                && request.getTipoConta() != null
                && request.getModeloConta() != null
                && request.getEmv() != null && !request.getEmv().isEmpty();
    }
}
