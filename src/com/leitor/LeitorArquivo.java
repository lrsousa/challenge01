package com.leitor;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.eunumeradores.TipoDado;

public class LeitorArquivo {
	private final String userhome = System.getProperty("user.home");
	private final String caminhoRepo = userhome + File.separator + "data" + File.separator;
	private final Path in = Paths.get(caminhoRepo + "in");
	private final Path out = Paths.get(caminhoRepo + "out");
	
	private Agregador agregador;
	
	public static void main(String[] args){
		try {
			new LeitorArquivo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private LeitorArquivo() throws Exception {
		for (Path path : listaArquivosDat(in)) {
			
			if (path.toFile().length() > 0) {
			
				agregador = new Agregador();
				
	//			System.out.println(path.getFileName());
				Files.readAllLines(path, StandardCharsets.ISO_8859_1).forEach(linha -> {
					TipoDado.mountType(linha, agregador);
				});
				
				DataAnalyzer dataAnalynzer = new DataAnalyzer(agregador);
				// GeraOutput
				agregador.toString();
		
			}
		}
	}
	
	private List<Path> listaArquivosDat(Path diretorio) throws Exception {
		List<Path> resultado = new ArrayList<Path>();
		
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(diretorio, "*.{dat}")) {
			for (Path path : stream) {
				resultado.add(path);
			}
		} 
		
		return resultado.stream().filter(path -> arquivoEstaValido(path)).collect(Collectors.toList());
	}

	private boolean arquivoEstaValido(Path path) {
		return path.toFile().length() > 0 ? true : false;
	}
}
