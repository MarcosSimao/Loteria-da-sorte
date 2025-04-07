package com.api.loteria.service.impl;

import com.api.loteria.model.LoteriaModel;
import com.api.loteria.model.TipoLoteria;
import com.api.loteria.service.interfaces.LoteriaService;

public class DuplaSenaService implements LoteriaService {
    @Override
    public LoteriaModel sortear() {
        return null;
    }

    @Override
    public TipoLoteria getTipo() {
        return TipoLoteria.DUPLASENA;
    }
}
