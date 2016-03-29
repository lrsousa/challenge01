package com.leitor;

import java.io.File;
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
	static final String caminhoRepo = userhome + File.separator + "data" + File.separator;
	static final Path in = Paths.get(caminhoRepo + "in");
	static final Path out = Paths.get(caminhoRepo + "out");
	
	static Agregador agregador = new Agregador();
	
	public static void main(String[] args) throws IOException {
		for (Path path : listaArquivosDat(in)) {
//			System.out.println(path.getFileName());
			Files.readAllLines(path, StandardCharsets.ISO_8859_1).forEach(linha -> {
				TipoDado.mountType(linha, agregador);
			});
			// Analise
			// GeraOutput
		}
		agregador.toString();
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
