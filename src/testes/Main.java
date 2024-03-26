package testes;

import projeto.teste.codigos.FileReader;
import projeto.teste.codigos.SortingAlgorithms;

import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            //Esse endereço é o meu, troque para o endereço onde vocês guardaram os arquivos contendo os números.
            String fileName = "";
            List<int[]> numbersList = FileReader.readNumbersFromFile(fileName);

            int[][] copiedNumbers = copyList(numbersList);

            for (int j = 0; j < copiedNumbers.length; j++) {
                int[] numbers = copiedNumbers[j];
                System.out.println("Arquivo " + i);
                System.out.println("InsertionSort Times:");
                impressaoDoTempo(numbers, SortingAlgorithms::insertionSort);

                System.out.println("QuickSort Times:");
                impressaoDoTempo(numbers, SortingAlgorithms::quickSort);
            }
            System.out.println();
        }
    }

    private static void impressaoDoTempo(int[] numbers, SortingAlgorithm sortingAlgorithm) {
        for (int k = 0; k < 30; k++) {
            long tempoInicial = System.nanoTime();
            sortingAlgorithm.sort(Arrays.copyOf(numbers, numbers.length));
            long tempoFinal = System.nanoTime();
            long tempoCalculado = tempoFinal - tempoInicial;
            System.out.println(" - " + tempoCalculado + " nanossegundos");
        }
    }


    // Criaando cópias profundas da lista de arrays de inteiros
    private static int[][] copyList(List<int[]> original) {
        int[][] copy = new int[original.size()][];
        for (int i = 0; i < original.size(); i++) {
            int[] arr = original.get(i);
            copy[i] = Arrays.copyOf(arr, arr.length);
        }
        return copy;
    }

    //Interface para usar qualquer tipo de ordenação
    interface SortingAlgorithm {
        void sort(int[] array);
    }
}
