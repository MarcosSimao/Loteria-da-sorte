package com.api.loteria.service.impl;

import com.api.loteria.model.LoteriaModel;
import com.api.loteria.model.TipoLoteria;
import com.api.loteria.service.interfaces.LoteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MegaSenaService implements LoteriaService {

    @Override
    public LoteriaModel sortear() {
        return null;
    }

    @Override
    public TipoLoteria getTipo() {
        return TipoLoteria.MEGA_SENA;
    }
}
