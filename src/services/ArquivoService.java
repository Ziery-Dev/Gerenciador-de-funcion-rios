package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Funcionario;

public class ArquivoService {
	
	
	public List<Funcionario> leituraArquivo(String caminho) {
		List<Funcionario> listaFunc = new ArrayList<>();

		// leitura do arquivo e insersão na lista de funconários
		try (BufferedReader bf = new BufferedReader(new FileReader(caminho))) {
			String line = bf.readLine();

			while (line != null) {
				String d[] = line.split(",");
				listaFunc.add(new Funcionario(d[0], d[1], Double.parseDouble(d[2])));
				line = bf.readLine();
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return listaFunc;
	}
}
