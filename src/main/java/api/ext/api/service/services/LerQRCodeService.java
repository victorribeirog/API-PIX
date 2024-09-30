package api.ext.api.service.services;

import api.ext.api.model.Request.LerQRCodeRequest;
import api.ext.api.model.Response.LerResponse;

public interface LerQRCodeService {
    LerResponse lerQRCode(LerQRCodeRequest ler);
}
