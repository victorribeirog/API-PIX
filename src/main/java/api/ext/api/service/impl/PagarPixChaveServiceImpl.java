package api.ext.api.service.impl;

import api.ext.api.model.PagamentoPixChave;
import api.ext.api.model.Response.TransferirResponse;
import api.ext.api.repository.PagamentoPixChaveRepository;
import api.ext.api.service.services.PagarPixChaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.ext.api.model.Request.TransferirRequest;

import java.util.Optional;
import java.util.UUID;

@Service
public class PagarPixChaveServiceImpl implements PagarPixChaveService {

    private final PagamentoPixChaveRepository pixChaveRepository;

    @Autowired
    public PagarPixChaveServiceImpl(PagamentoPixChaveRepository pixChaveRepository) {
        this.pixChaveRepository = pixChaveRepository;
    }

    @Override
    public TransferirResponse transferir(String idempotencyKey, boolean ignoraHandshake, TransferirRequest transferirRequest) {
        // Verifica se a transação já foi realizada com a mesma idempotencyKey
        Optional<PagamentoPixChave> existingPagamentoPixChave = pixChaveRepository.findByIdempotencyKey(idempotencyKey);

        if (existingPagamentoPixChave.isPresent()) {
            PagamentoPixChave pagamentoPixChave = existingPagamentoPixChave.get();

            if (pagamentoPixChave.isSucesso()) {
                throw new IllegalStateException("A operação com esta IdempotencyKey já foi realizada.");
            } else {
                throw new IllegalStateException("A operação com esta IdempotencyKey já foi tentada anteriormente e falhou.");
            }
        }


        PagamentoPixChave transferencia = new PagamentoPixChave();
        transferencia.setDadosEnvioPorChave(transferirRequest.getDadosEnvioPorChave());
        transferencia.setValor(transferirRequest.getValor());
        transferencia.setCodigoOperacaoCliente(transferirRequest.getCodigoOperacaoCliente());
        transferencia.setDescricaoCliente(transferirRequest.getDescricaoCliente());
        transferencia.setPrioridadePix(transferirRequest.getPrioridadePix());
        transferencia.setContaOrigem(transferirRequest.getContaOrigem());
        transferencia.setInformacoesAdicionais(transferirRequest.getInformacoesAdicionais());
        transferencia.setIdConciliacaoRecebedor(transferirRequest.getIdConciliacaoRecebedor());
        transferencia.setTipoQRCode(transferirRequest.getTipoQRCode());
        transferencia.setCodigoLeituraQRCode(transferirRequest.getCodigoLeituraQRCode());
        transferencia.setIdempotencyKey(idempotencyKey);
        transferencia.setIgnoraHandshake(ignoraHandshake);


        transferencia.setSucesso(true);
        transferencia.setMensagem("Pagamento via chave Pix realizado com sucesso.");
        transferencia.setCodigoTransacao(UUID.randomUUID().toString());

        pixChaveRepository.save(transferencia);

        return mapToResponse(transferencia);
    }

    @Override
    public Optional<TransferirResponse> findByIdempotencyKey(String idempotencyKey) {

        return Optional.empty();
    }

    @Override
    public void saveTransaction(String idempotencyKey, TransferirResponse response) {

        PagamentoPixChave pagamentoPixChave = new PagamentoPixChave();
        pagamentoPixChave.setIdempotencyKey(idempotencyKey);
        pagamentoPixChave.setCodigoTransacao(String.valueOf(response.getCodigoTransacao()));
        pagamentoPixChave.setMensagem(response.getMensagem());
        pagamentoPixChave.setSucesso(response.isSucesso());

        pixChaveRepository.save(pagamentoPixChave);
    }

    private TransferirResponse mapToResponse(PagamentoPixChave pagamentoPixChave) {
        TransferirResponse transferirResponse = new TransferirResponse();
        transferirResponse.setMensagem(pagamentoPixChave.getMensagem());


        transferirResponse.setCodigoTransacao(UUID.fromString(pagamentoPixChave.getCodigoTransacao()));

        transferirResponse.setSucesso(pagamentoPixChave.isSucesso());
        return transferirResponse;
    }

}

