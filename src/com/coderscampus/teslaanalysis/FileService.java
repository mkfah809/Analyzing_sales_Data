package com.coderscampus.teslaanalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class FileService {
	public final String MODEL3_FILE = "model3.csv";
	public final String MODELX_FILE = "modelX.csv";
	public final String MODELS_FILE = "modelS.csv";

	public List<Tesla> readFile(String filePath) throws IOException, ParseException {
		List<Tesla> teslaInformation = new ArrayList<>();
		Tesla[] teslas = new Tesla[50];
		loadFileAndAssignData(filePath, teslaInformation, teslas);
		return teslaInformation;
	}

	private void loadFileAndAssignData(String filePath, List<Tesla> teslaInformation, Tesla[] teslas)
			throws IOException, ParseException {
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(filePath));
			assignDataToList(teslaInformation, teslas, fileReader);
		} catch (FileNotFoundException e) {
			System.out.println("We couldn't find " + filePath + " at the moment.");
			e.printStackTrace();
		} finally {
			if (fileReader != null)
				fileReader.close();
		}
	}

	@SuppressWarnings({ "unused" })
	private void assignDataToList(List<Tesla> teslaInformation, Tesla[] teslas, BufferedReader fileReader)
			throws IOException, ParseException, ArrayIndexOutOfBoundsException {
		String line = "";
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
			// rows = line.split("-");
			// tesla.setYear(rows[2]);
			 formatTeslaAttributes(line, tesla, rows);
			teslas[controller] = tesla;
			controller++;
			teslaInformation.add(tesla);
			if (controller == null) {
				break;
			}
		}
	}

	public void formatTeslaAttributes(String line, Tesla tesla, String[] rows)
			throws ParseException, NumberFormatException {
		@SuppressWarnings("unused")
		java.util.Date dateFormatted = new SimpleDateFormat("MMM-YYYY").parse(tesla.setDate(rows[0]));
		@SuppressWarnings("unused")
		int salesFormatted = Integer.parseInt(tesla.setSales(rows[1]));

		// java.util.Date yearFormatted = new
		// SimpleDateFormat("YY").parse(tesla.setYear(rows[2]));

		// System.out.println(line + "\t" + dateFormatted + "\t" + salesFormatted +"\t"
		// + yearFormatted);
	}
}
