package com.api.loteria.ultil;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class GeradorNumerosMega {
    private static final Random random = new Random();

    public static Set<Integer> sortearNumerosAleatorios(int quantidade, int max) {
        return IntStream.generate(() -> random.nextInt(max) + 1) 
                .distinct() // Remove duplicados
                .limit(quantidade) // Mantém apenas 6 números
                .boxed() // Converte para Integer
                .collect(Collectors.toSet()); // Retorna como Set
    }
    public static Set<Integer> gerarNumerosAleatorios(int quantidade, int max) {
        Set<Integer> numeros = new TreeSet<>();
        while (numeros.size() < quantidade) {
            numeros.add(random.nextInt(max) + 1);
        }
        return Set.copyOf(numeros);
    }
}
