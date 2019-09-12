package testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MetodoReference {
	public static void main(String[] args) {
		List<String> lista3 = new ArrayList<>();
		lista3.add("afasfadsfasadsfasdf");
		lista3.add("asfasdfasfasf");
		lista3.add("sdfdsaf");
		lista3.add("asdfd");
		
		
		//isso se Lê: cmpare todas as strings da lista pelo tamanho
		lista3.sort(Comparator.comparing(s -> s.length()));
		//aqui a sintaxe munda um pouco, mas é a mesma coisa, invocar os métodos length de todas as strings
		lista3.sort(Comparator.comparing(String::length));  //método reference
		System.out.println(lista3);
		
		lista3.sort(String.CASE_INSENSITIVE_ORDER);  //método reference
		System.out.println(lista3);
		
		System.out.println("*************");
		lista3.forEach(System.out::println); //for Each com método Reference
		
	}
}
