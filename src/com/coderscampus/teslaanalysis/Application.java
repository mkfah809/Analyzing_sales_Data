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
		List<Tesla> populateModel3List = new ArrayList<>();
		List<Tesla> populateModelSList = new ArrayList<>();
		List<Tesla> populateModelXList = new ArrayList<>();

		ExecuteList execute = new ExecuteList();
		populateModel3List = fileService.readFile(fileService.MODEL3_FILE);
		populateModelSList = fileService.readFile(fileService.MODELS_FILE);
		populateModelXList = fileService.readFile(fileService.MODELX_FILE);
		execute.executeReport(populateModel3List, populateModelSList, populateModelXList);
		/*
		 * List<Tesla> populateDates = execute.populateDates(populateModel3List);
		 * List<Tesla> populateSales = execute.populateSales(populateModel3List);
		 */
	}
}
