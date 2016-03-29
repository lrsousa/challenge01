package com.leitor;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.eunumeradores.TipoDado;

public class LeitorArquivo {
	static final String userhome = System.getProperty("user.home");
	static final String caminhoRepo = userhome + File.separator + "Desktop" + File.separator + "data" + File.separator;
	static final Path in = Paths.get(caminhoRepo + "in");
	static final Path out = Paths.get(caminhoRepo + "out");
	
	static Agregador agregador = new Agregador();
	
	public static void main(String[] args) throws IOException {
		
		for (Path path : listaArquivosDat(in)) {
			List<String> linhas = Files.readAllLines(path, StandardCharsets.ISO_8859_1);
			linhas.forEach(linha -> {
				String[] dados = linha.split("ç");
				TipoDado.valueOf("N" + dados[0]).mountTypeInput(dados[1], dados[2], dados[3], agregador);
			});
		}
		
		System.out.println(agregador.getSales().size());
		System.out.println(agregador.getCustomers().size());
		System.out.println(agregador.getSalesmans().size());
		
	}
	
	static List<Path> listaArquivosDat(Path diretorio) {
		List<Path> resultado = new ArrayList<Path>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(diretorio, "*.{dat}")) {
			for (Path path : stream) {
				resultado.add(path);
			}
		} catch (DirectoryIteratorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
}
