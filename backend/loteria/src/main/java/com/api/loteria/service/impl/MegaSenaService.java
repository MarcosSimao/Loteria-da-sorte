package com.api.loteria.service.impl;

import com.api.loteria.model.LoteriaModel;
import com.api.loteria.model.TipoLoteria;
import com.api.loteria.service.interfaces.LoteriaService;
import com.api.loteria.ultil.GeradorNumerosMega;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class MegaSenaService implements LoteriaService {

    @Override
    public LoteriaModel sortear() {
        Map<String, Set<Integer>> resultado = new HashMap<>();
        resultado.put("numeros", GeradorNumerosMega.sortearNumerosAleatorios(6, 60));
        return new LoteriaModel(TipoLoteria.MEGA_SENA, resultado);
    }

    @Override
    public TipoLoteria getTipo() {
        return TipoLoteria.MEGA_SENA;
    }
}
