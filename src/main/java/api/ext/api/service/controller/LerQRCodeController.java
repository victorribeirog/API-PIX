package api.ext.api.service.controller;
import api.ext.api.model.Enum.TipoConta;
import api.ext.api.model.Enum.ModeloConta;
import api.ext.api.model.Request.LerQRCodeRequest;
import api.ext.api.model.Response.LerResponse;
import api.ext.api.service.services.LerQRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/QRCode")
public class LerQRCodeController {

    private final LerQRCodeService lerQRCodeService;

    public LerQRCodeController(LerQRCodeService lerQRCodeService) {
        this.lerQRCodeService = lerQRCodeService; // Injeção de dependência do serviço
    }

    @GetMapping("/Ler")
    public ResponseEntity<LerResponse> lerQRCode(
            @RequestParam String agencia,
            @RequestParam String agenciaDigito,
            @RequestParam String conta,
            @RequestParam String contaDigito,
            @RequestParam String contaPgto,
            @RequestParam TipoConta tipoConta,
            @RequestParam ModeloConta modeloConta,
            @RequestParam String emv) {

        LerQRCodeRequest request = new LerQRCodeRequest(
                agencia, agenciaDigito, conta, contaDigito, contaPgto, tipoConta, modeloConta, emv
        );

        LerResponse response = lerQRCodeService.lerQRCode(request);

        if (response.isSucesso()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

}