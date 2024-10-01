package api.ext.api.service.impl;

import api.ext.api.model.Response.TransferirResponse;
import api.ext.api.model.Request.TransferirRequest;
import api.ext.api.service.services.PagarPixChaveService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PagarPixChaveServiceImpl implements PagarPixChaveService {

    @Override
    public TransferirResponse transferir(TransferirRequest transferirRequest) {
        TransferirResponse transferirResponse = new TransferirResponse();


        UUID codigoTransacao = UUID.randomUUID();


        transferirResponse.setSucesso(true);
        transferirResponse.setMensagem("Pagamento via chave Pix realizado com sucesso.");
        transferirResponse.setCodigoTransacao(codigoTransacao);

        return transferirResponse;
    }

    @Override
    public Optional<TransferirResponse> findByIdempotencyKey(String idempotencyKey) {
        return Optional.empty();
    }

    @Override
    public void saveTransaction(String idempotencyKey, TransferirResponse response) {

    }
}
