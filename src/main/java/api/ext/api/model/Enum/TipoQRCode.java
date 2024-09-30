package api.ext.api.model.Enum;

public enum TipoQRCode {
    Estatico(1), Dinamico(2);

    private final int tipo;

    TipoQRCode (int tipoQRCODE){
        tipo = tipoQRCODE;
    }

}
