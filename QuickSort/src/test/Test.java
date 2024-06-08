package test;

import java.util.Arrays;

import modelo.Array;
import modelo.ParallelQuickSort;
import modelo.QuickSort;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Variables utiles
		final int tamañoArray = 400000000;
		long tiempoInicial;
		long tiempoFinal;

		// Arrays identicos
		int[] arraySecuencial = Array.generarArrayAleatorio(tamañoArray, 0, 100);
		int[] arrayConcurrente = Arrays.copyOf(arraySecuencial, tamañoArray);

		// QUICKSORT SECUENCIAL
		tiempoInicial = System.currentTimeMillis();									// Se toma el tiempo cuando inicia
		QuickSort.quickSort(arraySecuencial, 0, arraySecuencial.length - 1);						// Se ordena el array
		tiempoFinal = System.currentTimeMillis();									// Se toma el tiempo cuando finaliza
		System.out.println("\nQuickSort Secuencial -> Demoró: " + (tiempoFinal - tiempoInicial) + " milisegundos");	// Print para conocer cuanto tardo
		
		// Si se quiere comprobar que el array este ordenado:
		// Array.mostrarArray(arraySecuencial);

		// QUICKSORT CONCURRENTE
		tiempoInicial = System.currentTimeMillis();									// Se toma el tiempo cuando inicia
		ParallelQuickSort.parallelQuickSort(arrayConcurrente, 0, arrayConcurrente.length - 1);				// Se ordena el array
		tiempoFinal = System.currentTimeMillis();									// Se toma el tiempo cuando finaliza
		System.out.println("\nQuickSort Concurrente -> Demoró: " + (tiempoFinal - tiempoInicial) + " milisegundos");	// Print para conocer cuanto tardo
		
		// Si se quiere comprobar que el array este ordenado:
		// Array.mostrarArray(arrayConcurrente);

	}

}
