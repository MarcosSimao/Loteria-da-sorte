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
public class DuplaSenaService implements LoteriaService {
    @Override
    public LoteriaModel sortear() {
        Map<String, Set<Integer>> resultado = new HashMap<>();
        resultado.put("primeiroSorteio", GeradorNumerosMega.sortearNumerosAleatorios(6, 50));
        resultado.put("segundoSorteio", GeradorNumerosMega.sortearNumerosAleatorios(6, 50));
        return new LoteriaModel(TipoLoteria.LOTOFACIL, resultado);
    }

    @Override
    public TipoLoteria getTipo() {
        return TipoLoteria.DUPLASENA;
    }
}
