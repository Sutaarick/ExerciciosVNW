package br.vainaweb.t3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Loteria {
	public static void main(String[] args) {
		
		int[] chosenNumbers = new int[7], sortNumbers = new int[7];
		int points = 0, aux = 0, i = 0;
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("Escolha 7 numeros de 0 a 100");
		
		while (i < 7) {
			try {
				aux = sc.nextInt();
				if (aux >= 0 && aux <= 100 && Verification(chosenNumbers, aux)) {
					chosenNumbers[i] = aux;
					i++;
				} else {
					System.out.println("Por favor digite numeros de 0 à 100! Sem repetições!!");
				}
			} catch (Exception e) {
				System.out.println("Por favor utilize apenas numeros inteiros!");
				sc.nextLine();
			}
		}
		sc.close();
		
		i = 0;
		while (i < 7) {
			aux = r.nextInt(100) + 1;
			if (Verification(sortNumbers, aux)) {
				sortNumbers[i] = aux;
				i++;
			}
		}
		
		for (int c : chosenNumbers) {
			if (!Verification(sortNumbers, c))
				points++;
		}
		
		System.out.println("\nNumberos escolhidos: " + Arrays.toString(chosenNumbers));
		System.out.println("Numberos sorteados: " + Arrays.toString(sortNumbers));
		System.out.println("Acertos: " + points);
		
		switch (points) {
		case 5:
			System.out.println("Parabéns você ganhou R$ 10.000");
			break;
		case 6:
			System.out.println("Parabéns você ganhou R$ 50.000");
			break;
		case 7:
			System.out.println("Parabéns você ganhou R$ 200.000");
			break;
		default:
			System.out.println("Que pena, não foi dessa vez :(");
		}
	}
	

	static boolean Verification(int[] array, int number) {
		boolean verify = true;
		
		for (int a : array) {
			if (number == a) {
				verify = false;
			}
		}
	
		return verify;
	}
}