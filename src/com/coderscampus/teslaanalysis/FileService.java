package com.coderscampus.teslaanalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileService {

	public final String MODEL3_FILE = "model3.csv";
	public final String MODELX_FILE = "modelX.csv";
	public final String MODELS_FILE = "modelS.csv";

	@SuppressWarnings({ "null", "unused" })
	public Set<Tesla> readFile(String filePath) throws IOException  {
		BufferedReader fileReader = null;
		Set<Tesla> teslaInformation = new HashSet<>();
		String line = null;
		Tesla tesla = null;
		String[] rows = null;
		Tesla[] teslas = new Tesla[50];
		Integer controller = 0;
		try {
			fileReader = new BufferedReader(new FileReader(filePath));
			assignDataToList(teslaInformation, teslas,fileReader);
		} catch (FileNotFoundException e) {
			System.out.println("We couldn't find " + filePath + " at the moment.");
			e.printStackTrace();
		} finally {
			if (fileReader == null)
				fileReader.close();
		}
		return teslaInformation;
	}

	@SuppressWarnings({ "unused" })
	private void assignDataToList(Set<Tesla> teslaInformation, Tesla[] teslas, BufferedReader fileReader)
			throws IOException {
		String line;
		String date = null;
		String sales = null;
		Integer controller = 0;
		Tesla tesla = null;
		String[] rows = null;
		while ((line = fileReader.readLine()) != null) {
			tesla = new Tesla(date, sales);
			rows = line.split(",");
			tesla.setDate(rows[0]);
			tesla.setSales(rows[1]);
			teslas[controller] = tesla;
			controller++;
			teslaInformation.add(tesla);
			if (controller == null) {
				break;
			}
		}
	}

}
