package com.coderscampus.teslaanalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FileService {

	public final String MODEL3_FILE = "model3.csv";
	public final String MODELX_FILE = "modelX.csv";
	public final String MODELS_FILE = "modelS.csv";

	@SuppressWarnings("null")
	public Map<LocalDate, Integer> readFile(String filePath) throws IOException {
		BufferedReader fileReader = null;
		Map<LocalDate, Integer> teslaInformation = new HashMap<>();
		String line = null;
		String[] rows = null;
		LocalDate date = null;
		Long sales = null;
		// Map<Integer, Integer> model3List = new HashMap<>();
		try {
			fileReader = new BufferedReader(new FileReader(filePath));
			while ((line = fileReader.readLine()) != null) {
				Tesla tesla = new Tesla(date,sales);
				rows = line.split(",");
				
				
				tesla.setDate(rows[0]);
				tesla.setSales(rows[1]);
				teslaInformation.put(date, null);
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("We coudln't find " + filePath + " at the moment.");
			e.printStackTrace();
		} finally {
			if (fileReader == null)
				fileReader.close();
		}
		return teslaInformation;
	}

	public void readModel3File(String mODEL3_FILE2) {
		// TODO Auto-generated method stub

	}

}
