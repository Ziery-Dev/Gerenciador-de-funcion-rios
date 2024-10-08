package services;

import java.util.List;
import java.util.stream.Collectors;

import entities.Funcionario;

//aqui ficam os métodos de manipulação da lista de funcionários
public class FuncionarioService {
	
	//Lógica que exbibe os emails das pessoas com salario maior ao que foi digitado pelo usuário
	public void emails(List<Funcionario> listaFunc, double salInserido ) {
		System.out.println("Email dos funcionários com salário superior a R$" + String.format("%.2f", salInserido) + ":");
		List <String> emails = listaFunc.stream()
								.filter(p -> p.getSalary() > salInserido)
								.map(p -> p.getEmail())
								.sorted().collect(Collectors.toList());
		emails.forEach(System.out::println);
	}
	
	
	//soma dos salários dos funcionários cujo nome começa com a letra inserida pelo usuário.
	public void somaSalarios(List <Funcionario> listaFunc, char inicial	) {
		double soma = listaFunc.stream()
				.filter(p -> p.getName().toLowerCase().startsWith(String.valueOf(inicial))) //startsWith(String.valueOf(inicial)) é uma forma de comparar o valor quando é um char, ao inves de usar equals
				.map(p -> p.getSalary())
				.reduce(0.0, Double::sum); //faz a soma de todos o valores de forma simplificada
		System.out.printf("soma dos salários letra %s: R$%.2f", inicial, soma );
	}
	
	

}
