package api.ext.api.model.Enum;

public enum ModeloConta {

    Movimento(1), Escrow(2), Vinculada(3);

    private final int modelo;

    ModeloConta (int modeloConta){
        modelo = modeloConta;
    }
}
