/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author antonio
 */
public class AlgoritmosOrd {

    private static ArrayList<Integer> readFile(String fileName) { //lê o arquivo até o final e salva os dados
        ArrayList<Integer> dados_arq = new ArrayList<Integer>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                dados_arq.add(Integer.parseInt(scanner.next()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return dados_arq;
    }
        
    /*      SELECTION SORT      */
    public static void selectionSort(ArrayList<Integer> vetor) { 
        
        int menor, indiceMenor;

        for (int i = 0; i < vetor.size() - 1; i++) { //armazena o primeiro elemento e atribui o indice a ele
            menor = vetor.get(i);
            indiceMenor = i;

            for (int j = i + 1; j < vetor.size(); j++) { //faz a comparação e atribui o novo menor valor
                if (vetor.get(j) < menor) {
                    menor = vetor.get(j);
                    indiceMenor = j;
                }
            }

            //faz as trocas
            vetor.set(indiceMenor, vetor.get(i));
            vetor.set(i, menor);

        }
    }

    /*      INSERTION SORT      */
    public static void insertionSort(ArrayList<Integer> vetor) {
        for (int i = 1; i < vetor.size(); i++) {
            int hold = vetor.get(i);
            int j = i;

            while (j > 0 && vetor.get(j - 1) > hold) {
                vetor.set(j, vetor.get(j - 1));
                j--;
            }

            vetor.set(j, hold);
        }
    }

    public static void main(String[] args) {
        
        ArrayList<Integer> dados_arquivo = readFile("arq.txt");
        //selectionSort(dados_arquivo);
        insertionSort(dados_arquivo);

        for (int n : dados_arquivo) {
            System.out.println(n);
        }
    }

}
