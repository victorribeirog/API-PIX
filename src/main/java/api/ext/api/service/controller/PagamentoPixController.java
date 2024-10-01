package api.ext.api.service.controller;

import api.ext.api.model.Request.TransferirRequest;
import api.ext.api.model.Response.TransferirResponse;
import api.ext.api.service.services.PagarPixChaveService;

import api.ext.api.model.Request.TransferirRequest;
import api.ext.api.model.Response.TransferirResponse;
import api.ext.api.service.services.PagarPixChaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/Pix")
public class PagamentoPixController {

    @Autowired
    PagarPixChaveService pagarPixChaveService;

    @PostMapping("/Pagar")
    public ResponseEntity<TransferirResponse> pagarPix(
            @RequestHeader("IdempotencyKey") String idempotencyKey,
            @RequestHeader(value = "IgnoraHandshake", defaultValue = "true") boolean ignoraHandshake,
            @RequestBody TransferirRequest transferirRequest) {

        Optional<TransferirResponse> existingResponse = pagarPixChaveService.findByIdempotencyKey(idempotencyKey);
        if (existingResponse.isPresent()) {

            TransferirResponse response = existingResponse.get();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }


        TransferirResponse response = pagarPixChaveService.transferir(transferirRequest);
        pagarPixChaveService.saveTransaction(idempotencyKey, response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
