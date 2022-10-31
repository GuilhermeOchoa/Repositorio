import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * Este programa le caracteres de um nome e os inverte utilizando uma lista, uma fila e uma pilha
 */

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite um nome: ");
		String nome = sc.nextLine();
		// Transfere os caracteres da string para a lista de caracteres
		System.out.println("Transferencia da string para a lista:");
		List<Character> lista = new ArrayList<Character>(3);
		// ArrayList e' uma classe que implementa a interface List
		for(int i=0; i < nome.length(); i++) {
			Character c = nome.charAt(i);;
			System.out.println(c);
			lista.add(c);
		}
		// Transfere da lista para a pilha
		System.out.println("Transferencia da lista para a pilha:");
		Stack<Character> pilha = new Stack<Character>();
		while(!lista.isEmpty()) {
			Character c = lista.remove(0);
			System.out.println(c);
			pilha.push(c);			
		}
		// Transfere da pilha para a fila
		System.out.println("Transferencia da pilha para a fila:");
		Queue<Character> fila = new LinkedList<Character>();
		// LinkedList e' uma classe que implementa a interface Queue
		while(!pilha.isEmpty()) {
			 Character c = pilha.pop();
			 System.out.println(c);
			 fila.add(c);			 
		 }
		 // Retira os caracteres da fila e imprime
		System.out.println("Conteudo da fila:");
		while(!fila.isEmpty()) {
			 Character c = fila.remove();
			 System.out.println(c);			 
		}
	}	
}
