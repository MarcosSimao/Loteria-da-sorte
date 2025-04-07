package com.api.loteria.service.impl;

import com.api.loteria.model.LoteriaModel;
import com.api.loteria.model.TipoLoteria;
import com.api.loteria.service.interfaces.LoteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuinaService  implements LoteriaService {

    @Override
    public LoteriaModel sortear() {
        return null;
    }

    @Override
    public TipoLoteria getTipo() {
        return TipoLoteria.QUINA;
    }
}
