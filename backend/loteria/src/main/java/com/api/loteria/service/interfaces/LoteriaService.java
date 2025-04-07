package com.api.loteria.service.interfaces;

import com.api.loteria.model.LoteriaModel;
import com.api.loteria.model.TipoLoteria;

public interface LoteriaService {
    LoteriaModel sortear();
    TipoLoteria getTipo();
}
