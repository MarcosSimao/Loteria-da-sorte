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

    public static List<Object> simuladorGloboDaSorte(int quantidade, int max) {
        List<Integer> bolinhas = new ArrayList<>();
        List<Integer> numerosSorteados = new ArrayList<>();
        for (int i = 1; i <= max; i++) bolinhas.add(i);

        for (int i = 0; i < quantidade; i++) {
            Collections.shuffle(bolinhas, random); // gira urna
            numerosSorteados.add(bolinhas.remove(0)); // pega a bolinha
        }
        Collections.sort(numerosSorteados);
        return new ArrayList<>(numerosSorteados);
    }

    public static List<Object> geradorDeMesAleatorio() {
        return Collections.singletonList(Collections.singleton(MESES.get(random.nextInt(MESES.size()))));
    }

    public static List<Object> gerarLotoManiaNumerosAleatorios(int quantidade, int max) {
        return simuladorGloboDaSorte(50, 100).stream()
                .map(n -> n.equals(100) ? "00" : n)
                .collect(Collectors.toList());
    }

    public static List<Object> geradorSuperSete(int quantidade, int max) {
        List<Integer> numerosSuperSete = new ArrayList<>();
        for (int i = 1; i < quantidade; i++) {
            numerosSuperSete.add(globoDaSorteSuperSete(max));
        }

        Collections.sort(numerosSuperSete);
        return new ArrayList<>(numerosSuperSete);
    }

    private static Integer globoDaSorteSuperSete(int max) {
        List<Integer> bolinha = new ArrayList<>();
        for (int i = 0; i < max; i++) bolinha.add(i);
        Collections.shuffle(bolinha, random);
        return bolinha.get(0);
    }
}
