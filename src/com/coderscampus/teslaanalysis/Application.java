package com.coderscampus.teslaanalysis;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) throws IOException, ParseException {    
		Launch();
	}

	private static void Launch() throws IOException, ParseException {
		FileService fileService = new FileService();
		List<Tesla> populateList = new ArrayList<>();
		ExecuteList execute = new ExecuteList();
		populateList = fileService.readFile(fileService.MODEL3_FILE);
		execute.populateDates(populateList);
		execute.populateSales(populateList);
				
	}



}
