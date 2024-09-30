package api.ext.api.model.Enum;

public enum TipoChavePix {
    CPF(0), CNPJ(1), Telefone(2), Email(3), EVP(4);

    private final int tipo;

    TipoChavePix (int tipoChavePix){
        tipo = tipoChavePix;
    }

}
