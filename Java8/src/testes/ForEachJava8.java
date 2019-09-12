package testes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ForEachJava8 {
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("alura online");
		lista.add("casa do código");
		lista.add("caelum");

		/*
		 * Collections.sort(lista);
		 * 
		 * Collections.reverse(lista);
		 */
		
		//esse método organiza as palavras por tamanho, 
		//ele pega a palavra da lista, compara com a segunda e assim por diante,
		//se ela for menor, retorna 1, e ela troca de lugar com a outra que é maior 
		//e assim por diante
		lista.sort((c, b) -> {
			if (c.length() < b.length())
				return 1;

			if ((c.length() > b.length()))
				return -1;

			return 0;
		});
		
		System.out.println(lista);
		
		lista.forEach(a -> System.out.println(a));
		
		
		//forEach é um método default (método de interface que contém corpo) de Collections
		Consumer<String> consumidor = new ImprimeNaLinha();
		lista.forEach(consumidor);

	}
}

class ImprimeNaLinha implements Consumer<String>{

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
