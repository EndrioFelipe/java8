package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("asda", 25));
		cursos.add(new Curso("arduino", 30));
		cursos.add(new Curso("asdf", 28));
		
		//ordenando por número de alunos
		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		cursos.forEach(c -> System.out.println(c.getAlunos()));
		System.out.println("-----------------");
		
		cursos.stream().filter(c -> c.getAlunos() >= 28 ).forEach(c -> System.out.println(c.getAlunos()));
		System.out.println("-----------------");
		
		OptionalDouble media = cursos.stream()
			.filter(c -> c.getAlunos() >= 28 )
			.mapToInt(c -> c.getAlunos())
			.average();
		
		System.out.println("média: "+media.getAsDouble());
		
		System.out.println("-----------------");
				
		Long conta = cursos.stream()
			.filter(c -> c.getAlunos() >= 28 )
			.mapToInt(c -> c.getAlunos()).count();
		System.out.println("contagem: "+conta);
		
		System.out.println("-----------------");
		
		cursos.stream()
				.map(c -> c.getNome())
				.forEach(System.out::println);
		//System.out.println("nomes: "+nomes.toString());
		
		System.out.println("-----------------");
		
		int soma = cursos.stream()
				.filter(c -> c.getAlunos() >= 28 )
				.mapToInt(c -> c.getAlunos()).sum();
			System.out.println("soma: "+soma);
		
		System.out.println("-----------------");
		
		cursos.forEach(c -> System.out.print(c.getAlunos()+", "));
		
		System.out.println("\n-----------------");
		
		//Optional<Curso> optionalCurso = 
		cursos.stream()
		.filter(c -> c.getAlunos() >= 28 )
		.findAny()
		.ifPresent(c -> System.out.println(c.getNome()));
		System.out.println("------------");
		
		List<Curso> cursosFiltradosEmLista = cursos.stream()
			.filter(c -> c.getAlunos() >= 28 )
			.collect(Collectors.toList());
		
		cursosFiltradosEmLista.forEach(c -> System.out.println("cfeml: "+c.getNome()));
		
		System.out.println("------------");
		
		Map<Object, Object> mapa = cursos 
				.stream() 
				.filter(c -> c.getAlunos() >= 28) 
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
		System.out.println("mapa: "+mapa);
		
		System.out.println("---------------OU--------------");
		
		cursos.stream() 
			.filter(c -> c.getAlunos() >= 28) 
			.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
			.forEach((nomes, qtdAlunos) -> System.out.println(nomes +", "+qtdAlunos));
		System.out.println("---------------OU--------------");
		
		cursos.parallelStream() //faz o uso de threads e deixa mais rápido
		.filter(c -> c.getAlunos() >= 28) 
		.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
		.forEach((nomes, qtdAlunos) -> System.out.println(nomes +", "+qtdAlunos));
		
//		Curso curso = optionalCurso.orElse(null);
//		System.out.println("curso: "+curso.getAlunos()); 
//		
//		optionalCurso.ifPresent(c -> System.out.println("se presente: "+c.getNome()));
	}
}