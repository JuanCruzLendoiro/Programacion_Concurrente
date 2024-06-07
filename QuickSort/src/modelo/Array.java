package modelo;

import java.util.Random;

public abstract class Array {

	public static int[] generarArrayAleatorio(int tamanio, int minimo, int maximo) {
		int[] vector = new int[tamanio];

		Random random = new Random();
		for (int i = 0; i < tamanio; i++) {
			vector[i] = random.nextInt(maximo - minimo + 1) + minimo;
		}
		return vector;
	}

	public static void mostrarArray(int[] vector) {
		System.out.println("\nArray:\n");
		for (int i : vector) {
			System.out.print(i + " / ");
		}
		System.out.println("\n");
	}

}
