package com.api.loteria.controller;

import com.api.loteria.model.LoteriaModel;
import com.api.loteria.model.TipoLoteria;
import com.api.loteria.service.interfaces.LoteriaService;
import com.api.loteria.ultil.LoteriaFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/sorteio")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class LotericaController {
    private final LoteriaFactory loteriaFactory;
    @GetMapping("/{tipo}")
    public ResponseEntity<LoteriaModel> sortear(@PathVariable Integer tipo){
        log.info("Sorteio solicitado para código: {}",tipo);
            TipoLoteria tipoLoteria = TipoLoteria.fromCodigo(tipo);
            Optional<LoteriaService> loteriaService = loteriaFactory.getLoteriaService(tipoLoteria);

        return loteriaService
                .map(service -> ResponseEntity.ok(service.sortear()))
                .orElseThrow(() -> new IllegalArgumentException("Nenhum sorteio encontrado para este código"));
    }

    }


