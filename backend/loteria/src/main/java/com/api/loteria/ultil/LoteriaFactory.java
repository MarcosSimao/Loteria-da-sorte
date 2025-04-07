package com.api.loteria.ultil;

import com.api.loteria.model.TipoLoteria;
import com.api.loteria.service.interfaces.LoteriaService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LoteriaFactory {
    private final List<LoteriaService> loterias;

    public LoteriaFactory(List<LoteriaService> loterias) {
        this.loterias = loterias;
    }
    public Optional<LoteriaService> getLoteriaService(TipoLoteria tipo) {
        return loterias.stream()
                .filter(service -> service.getTipo() == tipo)
                .findFirst();
    }
}
