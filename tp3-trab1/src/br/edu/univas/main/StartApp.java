package br.edu.univas.main;

import java.util.Scanner;
import java.util.Random;
import br.edu.univas.view.View;

public class StartApp {

	private static Scanner scanner = new Scanner(System.in);
	private static View view = new View();

	public static void main(String[] args) {

		String caracteresMinusculos = "abcdefghijklmnopqrstuvywxz";
		String caracteresMaiuculos = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
		String numeros = "0123456789";
		String caracteresEspeciais = "@#$%&*_+^><|";
		String pass = "";

		int choice = 0;

		view.printStart();

		view.printInformeTamanhoMinimo();
		int tamanhoMin = readInt();

		view.printInformeTamanhoMaximo();
		int tamanhoMax = readInt();

		view.printInformeLetraMaiuscula();
		choice = readInt();

		if (choice == 1) {
			pass = caracteresMaiuculos;
		}

		view.printInformeLetraMinuscula();
		choice = readInt();

		if (choice == 1) {
			pass = pass + caracteresMinusculos;

		}

		view.printInformeNumero();
		choice = readInt();

		if (choice == 1) {
			pass = pass + numeros;

		}

		view.printInformeCaracteresEspeciais();
		choice = readInt();

		if (choice == 1) {
			pass = pass + caracteresEspeciais;
		}

		createPassword(pass, tamanhoMin, tamanhoMax);

	}

	public static void createPassword(String pass, int tamanhoMin, int tamanhoMax) {
		char[] ch = new char[pass.length()];
		for (int i = 0; i < pass.length(); i++) {
			ch[i] = pass.charAt(i);

		}
		StringBuilder builder = new StringBuilder();
		Random random = new Random();

		int idx = random.nextInt((tamanhoMax - tamanhoMin) + 1) + tamanhoMin;

		for (int i = 0; i < idx; i++) {
			int posicao = (int) (Math.random() * ch.length);
			builder.append(ch[posicao]);

		}
		System.out.println("sua senha é: \n");
		System.out.println(builder.toString());
	}

	public static int readInt() {
		int value = scanner.nextInt();
		scanner.nextLine();

		return value;
	}
}
