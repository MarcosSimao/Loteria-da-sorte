package com.api.loteria.service.impl;

import com.api.loteria.model.LoteriaModel;
import com.api.loteria.model.TipoLoteria;
import com.api.loteria.service.interfaces.LoteriaService;
import com.api.loteria.ultil.GeradorNumerosMega;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Service
public class LotoFacilService implements LoteriaService {
    @Override
    public LoteriaModel sortear() {
        Map<String, List<Object>> resultado = new HashMap<>();
        resultado.put("numeros", GeradorNumerosMega.simuladorGloboDaSorte(15, 25));
        return new LoteriaModel(TipoLoteria.LOTOFACIL, resultado);
    }

    @Override
    public TipoLoteria getTipo() {
        return TipoLoteria.LOTOFACIL;
    }
}
