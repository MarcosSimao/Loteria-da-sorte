package com.api.loteria.service.impl;

import com.api.loteria.model.LoteriaModel;
import com.api.loteria.model.TipoLoteria;
import com.api.loteria.service.interfaces.LoteriaService;
import com.api.loteria.ultil.GeradorNumerosMega;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class DiaDeSorteService implements LoteriaService {
    @Override
    public LoteriaModel sortear() {
        Map<String, Set<Object>> resultado = new HashMap<>();
        resultado.put("numeros", GeradorNumerosMega.simuladorGloboDaSorte(7, 31));
        resultado.put("mes da sorte", GeradorNumerosMega.geradorDeMesAleatorio());
        return new LoteriaModel(TipoLoteria.DIADASORTE, resultado);
    }

    @Override
    public TipoLoteria getTipo() {
        return TipoLoteria.DIADASORTE;
    }
}
