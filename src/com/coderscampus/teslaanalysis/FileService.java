package com.coderscampus.teslaanalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileService {
	public final String MODEL3_FILE = "model3.csv";
	public final String MODELX_FILE = "modelX.csv";
	public final String MODELS_FILE = "modelS.csv";

	public List<Tesla> readFile(String filePath) throws IOException {
		List<Tesla> teslaInformation = new ArrayList<>();
		Path pathToFile = Paths.get(filePath);
		try (BufferedReader fileReader = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = fileReader.readLine();
			getTeslaList(teslaInformation, fileReader, line);
		}
		return teslaInformation;
	}
	private void getTeslaList(List<Tesla> teslaInformation, BufferedReader fileReader, String line) throws IOException {
		while (line != null) {
			String[] rows = line.split(",");
			Tesla tesla = createTeslaRow(rows);
			teslaInformation.add(tesla);
			line = fileReader.readLine();
		}
	}
	private Tesla createTeslaRow(String[] rows) {
		String date = rows[0];
		int sale = Integer.parseInt(rows[1]);
		return new Tesla(date, sale);
	}
}