import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

/*
 * Este programa manipula conjuntos de nomes
 */

public class Maina {

	public static void main(String args[]) {
		
		// Definicao de conjuntos
		Set<String> alunos;
		Set<String> professores; 
		
		// Criacao de conjuntos
		// HashSet eh uma classe que implementa Set 
		alunos = new HashSet<String>();
		professores = new HashSet<String>();

		// Insercao de elementos nos conjuntos
		alunos.add("Maria da Silva");
		alunos.add("Mario de Souza");
		alunos.add("Joao de Moura");
		alunos.add("Joana de Moura");
		alunos.add("Maria da Silva");	// Insercao repetida
		alunos.add("Pedro da Silva");
		System.out.println("Numero de alunos: " + alunos.size());
		System.out.println("Alunos:");
		for(String s : alunos) {
			System.out.println(s);
		}

		professores.add("Pedro da Silva");
		professores.add("Mario de Souza");
		professores.add("Joana de Moura");
		professores.add("Carlos de Melo");
		professores.remove("Joana de Moura");	// Remove um professor
		System.out.println("Numero de professores: " + professores.size());
		System.out.println("Professores:");
		for(String s : professores) {
			System.out.println(s);
		}
		
		// Interseccao entre alunos e professores
		Set<String> interseccao = new TreeSet<String>();
		interseccao.addAll(alunos);
		interseccao.retainAll(professores);
		System.out.println("Professores que sao alunos: ");
		for(String s : interseccao) {
			System.out.println(s);
		}

		// Diferenca entre alunos e professores
		Set<String> diferenca = new TreeSet<String>();
		diferenca.addAll(professores);
		diferenca.removeAll(alunos);
		System.out.println("Apenas professores:");
		for(String s : diferenca) {
			System.out.println(s);
		}		
	}
}