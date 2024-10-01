package api.ext.api.service.services;

import api.ext.api.model.Request.TransferirRequest;
import api.ext.api.model.Response.TransferirResponse;

import java.util.Optional;

public interface PagarPixChaveService {
    TransferirResponse transferir(TransferirRequest transferirRequest);

    Optional<TransferirResponse> findByIdempotencyKey(String idempotencyKey);

    void saveTransaction(String idempotencyKey, TransferirResponse response);
}
