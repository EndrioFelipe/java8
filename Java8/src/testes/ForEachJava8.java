package testes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ForEachJava8 {
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("afasfadsfasadsfasdf");
		lista.add("asfasdfasfasf");
		lista.add("sdfdsaf");
		lista.add("asdfd");

		/*
		 * Collections.sort(lista);
		 * 
		 * Collections.reverse(lista);
		 */

		// esse método organiza as palavras por tamanho,
		// ele pega a palavra da lista, compara com a segunda e assim por diante,
		// se ela for menor, retorna 1, e ela troca de lugar com a outra que é maior
		// e assim por diante. A ordem fica do maior para o menor.
		lista.sort((c, b) -> {
			if (c.length() < b.length())
				return -1;

			if ((c.length() > b.length()))
				return 1;

			return 0;
		});
		System.out.println("sort1: "+lista);

//----------------------------------------------------------------------------------
		
		
		List<String> lista2 = new ArrayList<>();
		lista2.add("afasfadsfasadsfasdf");
		lista2.add("asfasdfasfasf");
		lista2.add("sdfdsaf");
		lista2.add("asdfd");
		
		
		
		//esse sort aqui faz a mesma coisa do sort de cima
		//retorna -1 se o primeiro for menor, 1 se o segundo for menor, ou 0 se der empate
		lista2.sort((c, b) -> 
			Integer.compare(c.length(), b.length())
		);
		System.out.println("sort2: "+lista2);
		
		
//----------------------------------------------------------------------------------
		
		
		List<String> lista3 = new ArrayList<>();
		lista3.add("afasfadsfasadsfasdf");
		lista3.add("asfasdfasfasf");
		lista3.add("sdfdsaf");
		lista3.add("asdfd");
		
		
		//isso se Lê: cmpare todas as strings da lista pelo tamanho
		lista3.sort(Comparator.comparing(s -> s.length()));
		//aqui a sintaxe munda um pouco, mas é a mesma coisa, invocar os métodos length de todas as strings
		lista3.sort(Comparator.comparing(String::length));  //método reference
		
		//isso tudo é comparado a ao de cima só q sem o lâmbda
		
		
		Function<String, Integer> funcao = new Function<String, Integer>() {

			@Override
			public Integer apply(String a) {
				return a.length();
			}
			
		};
		//esse comparing() recebe um obj de uma interface funcional chamada Function
		Comparator<String> comparador = Comparator.comparing(funcao);
		lista3.sort(comparador);
	
		System.out.println("sort3: "+lista3);
		
//----------------------------------------------------------------------------------
		
		List<String> lista4 = new ArrayList<>();
		lista4.add("afasfadsfasadsfasdf");
		lista4.add("asfasdfasfasf");
		lista4.add("sdfdsaf");
		lista4.add("asdfd");
		
		//esse sort tb faz a mesma coisa dos de cima
		lista4.sort((s1, s2) -> s1.length() - s2.length());

		System.out.println("sort4: "+lista4);
		
//----------------------------------------------------------------------------------

		
		
		System.out.println("*5************");
		
		
		
		
		//pode usar assim 
		lista.forEach(a -> System.out.println(a));
		//ou assim
		lista.forEach(System.out::println);
		System.out.println("**5***********");
		
		
		// forEach é um método default (método de interface que contém corpo) de
		// Collections
		//Esse forEach aqui faz a mesma coisa do de cima
		Consumer<String> consumidor = new ImprimeNaLinha();
		lista.forEach(consumidor);
		
		
		
		System.out.println("*************");
		//forEach com classe anônima
		lista.forEach(new Consumer<String>(){
		    public void accept(String a) {
		        System.out.println(a);
		    }
		});
		
		System.out.println("*************");
		new Thread(new Runnable() {

		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }

		}).start();
		
		//escrevendo a execução acima com lâmbda
		new Thread(()->
				System.out.println("Executando um Runnable")
		   ).start();
	}
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);
	}
}
