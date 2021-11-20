package com.coderscampus.teslaanalysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) throws IOException {
		launch();
	}

	private static void launch() throws IOException  {
		FileService fileService = new FileService();
		List<Tesla> populateModel3List = new ArrayList<>();
		List<Tesla> populateModelSList = new ArrayList<>();
		List<Tesla> populateModelXList = new ArrayList<>();

		ExecuteList execute = new ExecuteList();
		populateModel3List = fileService.readFile(fileService.MODEL3_FILE);
		populateModelSList = fileService.readFile(fileService.MODELS_FILE);
		populateModelXList = fileService.readFile(fileService.MODELX_FILE);
		System.out.println("Successfully read the file!");
		execute.executeReport(populateModel3List, populateModelSList, populateModelXList);
		
	}
}
