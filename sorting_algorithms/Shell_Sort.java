package sorting_algorithms;

import java.lang.Math;
import java.util.Arrays;
public class Shell_Sort {

    public static void shell_sort(int[] list) {

        /*
         * Aplicando a formula proposta por DONALD ERVIN para o obter a distância h =
         * ((3^k)-1)/2 onde 'k' é Nº de loops.
         * 
         * Podemos encontrar o 'k' da seguinte maneira:
         * 
         * Sabendo que h é tamanho da lista divido por 2.
         * 
         * Podemos dizer que h = N / 2
         * 
         * N (3^k)-1
         * __ = ____ => N = (3^k)-1 => 3^k = N + 1 => LOG 3^k = LOG N+1 TEMOS QUE k =
         * LOG N+1 ou k = LOG N+1 / LOG 3
         * 3 3 3
         * 2 2
         * 
         * 
         * Aplicando em código:
         */
        Integer length = list.length;
        int k = (int) Math.floor((Math.log(length + 1) / Math.log(3)) + 0.5);
        int h = (int) (Math.pow(3, k) - 1) / 2;
        int numComparisons = 0;
        int numSwaps = 0;

        while (h > 0) {

            for (int i = h; i < length; i++) {
                int temp = list[i];
                int j;
                for (j = i; j >= h; j -= h) {
                    numComparisons++; // Conta cada comparação
                    if (list[j - h] > temp) {
                        list[j] = list[j - h];
                        numSwaps++; // Conta a troca
                    } else {
                        // Se a comparação mostra que a troca não é necessária, interrompe o loop interno
                        break;
                    }
                }
                // Atribuição pode não ser uma 'troca' se o elemento não se move
                if (j != i) {
                    list[j] = temp;
                    numSwaps++; // Conta a 'troca' final desta inserção, se houve movimento
                }
            }

            k -= 1;
            h = (int) (Math.pow(3, k) - 1) / 2;
        }

        System.out.println("\nMétrica =>");
        System.out.println("Número de comparações: " + numComparisons);
        System.out.println("Número de trocas: " + numSwaps+"\n");
    }

    public static void main(String[] args) {
        int[] list = {10,1,2,3,4,1,2,5};
        System.out.print("Array inicial : ");
        System.out.println(Arrays.toString(list));
        shell_sort(list);
        System.out.print("Array ordenado : ");
        System.out.println(Arrays.toString(list));
    }
}
