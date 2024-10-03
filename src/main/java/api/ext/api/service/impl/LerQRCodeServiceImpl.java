package api.ext.api.service.impl;

import api.ext.api.model.Enum.TipoQRCode;
import api.ext.api.model.LerQRCode;
import api.ext.api.model.Request.LerQRCodeRequest;
import api.ext.api.model.Response.LerResponse;
import api.ext.api.repository.LerQRCodeRepository;
import api.ext.api.service.services.LerQRCodeService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LerQRCodeServiceImpl implements LerQRCodeService {

    private final LerQRCodeRepository lerQRCodeRepository;

    public LerQRCodeServiceImpl(LerQRCodeRepository lerQRCodeRepository) {
        this.lerQRCodeRepository = lerQRCodeRepository;
    }

    @Override
    public LerResponse lerQRCode(LerQRCodeRequest request) {
        LerResponse response = new LerResponse();
        LerQRCode lerQRCode = new LerQRCode();

        if (!isValidRequest(request)) {
            response.setSucesso(false);
            response.setMensagem("Requisição inválida.");
            return response;
        }

        // Preenche os campos da entidade LerQRCode
        lerQRCode.setRequest(request);
        lerQRCode.setSucesso(true);
        lerQRCode.setMensagem("QR Code lido com sucesso!");
        lerQRCode.setCodigoLeituraQRCode(UUID.randomUUID().toString()); // Armazena o código como String

        // Salva a entidade no banco de dados
        lerQRCodeRepository.save(lerQRCode);

        // Preenche a resposta com informações que você deseja retornar
        response.setSucesso(true);
        response.setMensagem("QR Code lido com sucesso!");
        response.setTipoQRCode("Estatico");
        response.setCodigoLeituraQRCode(UUID.fromString(lerQRCode.getCodigoLeituraQRCode()));
        response.setTpQRCode(TipoQRCode.Estatico);
        response.setChave("chave_exemplo"); // Exemplos, substitua conforme necessário
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
