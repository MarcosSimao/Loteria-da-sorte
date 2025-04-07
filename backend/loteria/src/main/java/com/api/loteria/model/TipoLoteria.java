package com.api.loteria.model;

import java.util.Arrays;

public enum TipoLoteria  {
    MILIONARIO(0),
    MEGA_SENA(1),
    QUINA(2),
    LOTO(3),
    DUPLASENA(5);

    private final int codigo;

    TipoLoteria (int codigo) {
        this.codigo = codigo;
    }


    public int getCodigo() {
        return codigo;
    }

    public static TipoLoteria  fromCodigo(int codigo) {
        return Arrays.stream(TipoLoteria .values())
                .filter(tipo -> tipo.getCodigo() == codigo)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Número inválido para sorteio: " + codigo));
    }
}
