package com.api.loteria.model;

import java.util.Arrays;

public enum TipoLoteria  {
    MILIONARIO(0),
    MEGA_SENA(1),
    QUINA(2),
    LOTOMANIA(3),
    LOTOFACIL(4),
    DUPLASENA(5),
    DIADASORTE(6);

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
