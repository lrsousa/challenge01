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

public class LeitorArquivo {
	static final String userhome = System.getProperty("user.home");
	static final Path in = Paths.get(userhome + "/data/in");
	static final Path out = Paths.get(userhome + "/data/ou");
	
	public static void main(String[] args) throws IOException {
		
		for (Path path : listaArquivosDat(in)) {
			List<String> linhas = Files.readAllLines(path, StandardCharsets.ISO_8859_1);
			System.out.println("Quantidade de lihas: " + linhas.size());
			linhas.forEach(linha -> System.out.println(linha));
		}
		
		
//		File dir = new File(in);
//		File[] files = dir.listFiles(filter);
//		
//		for (File file : files) {
//			
//		}
		
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
	
	static FileFilter filter = new FileFilter() {
		@Override
		public boolean accept(File pathname) {
			int tamFileName = pathname.getName().length();
			return pathname.getName().substring(tamFileName - 4, tamFileName).equals(".dat") ? true : false;
		}
	};
}
