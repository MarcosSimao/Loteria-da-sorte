package com.api.loteria.ultil;

import java.util.*;
import java.util.stream.Collectors;

public final class GeradorNumerosMega {
    private static final Random random = new Random();
    private static final List<String> MESES = List.of(
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    );
    private GeradorNumerosMega() {
        throw new UnsupportedOperationException("Classe utilitária");
    }
    public static Set<Object> simuladorGloboDaSorte(int quantidade, int max) {
        List<Integer> bolinhas = new ArrayList<>();
        for (int i = 1; i <= max; i++) bolinhas.add(i);

        Set<Object> numerosSorteados = new LinkedHashSet<>();

        for (int i = 0; i < quantidade; i++) {
            Collections.shuffle(bolinhas, random); // gira urna
            numerosSorteados.add(bolinhas.remove(0)); // pega a bolinha
        }
        return new TreeSet<>(numerosSorteados);
    }

    public static Set<Object> geradorDeMesAleatorio(){
        return Collections.singleton(MESES.get(random.nextInt(MESES.size())));
    }
    public static Set<Object> gerarLotoManiaNumerosAleatorios(int quantidade, int max){
        return simuladorGloboDaSorte(50, 100).stream()
                .map(n -> n.equals(100) ? "00" : n)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
