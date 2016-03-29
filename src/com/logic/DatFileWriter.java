package com.logic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DatFileWriter {
	
	public void createDoneDatFile(Path path, Path fileName, String dataToWrite) throws IOException {
		String tempFileName = path.toString() + File.separator + fileName.getFileName();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(tempFileName.substring(0, tempFileName.length() - 4) + ".done.dat");
		Files.write(Paths.get(stringBuilder.toString()), dataToWrite.getBytes());
	}
}
