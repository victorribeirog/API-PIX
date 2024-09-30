package api.ext.api.model.Enum;

public enum TipoConta {

    Corrente(1), Poupança(2), Pagamento(3), Salario(4);

    private final int tipo;

    TipoConta (int tipoConta){
        tipo = tipoConta;
    }
}
