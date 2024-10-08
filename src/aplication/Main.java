package aplication;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;
import services.ArquivoService;
import services.FuncionarioService;

public class Main {
	/*
	 * Fazer um programa para ler os dados (nome, email e salário) de funcionários a
	 * partir de um arquivo em formato .csv Em seguida mostrar, em ordem alfabética,
	 * o email dos funcionários cujo salário seja superior a um dado valor fornecido
	 * pelo usuário.
	 *
	 * Mostrar também a soma dos salários dos funcionários cujo nome começa com a
	 * letra 'M'.
	 
	 */

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		// caminho do arquivo com os dados dos funcionários
		String caminhoArquivo = "c:\\Estudos\\Java\\arquivosTxt\\funcionarios.csv";

		// Instância da classe que trata os dados dos funcionários
		FuncionarioService funcionarioService = new FuncionarioService();

		// Intancia da classe que faz a leitura do arquivo
		ArquivoService arquivo = new ArquivoService();
		
		List <Funcionario> listaFuncionarios = arquivo.leituraArquivo(caminhoArquivo);

		// mostrando emails de funcionários cujo salário é maior do que o fornecido pelo
		// usuário
		System.out.println("Insira um valor de salário:");
		double salInserido = sc.nextDouble();
		funcionarioService.emails(listaFuncionarios, salInserido);

		System.out.println();

		// soma dos salários dos funcionários cujo nome começa com a letra Inserida pelo
		// usuário.
		System.out.println("Insira a incial dos nomes do qual deseja saber a soma dos salários: ");
		char inicial = sc.next().toLowerCase().charAt(0);
		funcionarioService.somaSalarios(listaFuncionarios, inicial); // chamada do método que soma os
																					// salários passando a lista como
																					// argumento

		sc.close();

	}

}
