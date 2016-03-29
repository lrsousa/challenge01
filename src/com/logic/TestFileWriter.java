package com.logic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFileWriter {
	
	
	public static void main(String[] args) throws IOException {
		final String userhome = System.getProperty("user.home");
		final String caminhoRepo = userhome + File.separator + "data" + File.separator;
		final Path out = Paths.get(caminhoRepo + "out");
		
		String msg = "Kenai";
		System.out.println(out.toString());
        Files.write(Paths.get(out.toString() + File.separator + "duke.txt"), msg.getBytes());
	}
}
