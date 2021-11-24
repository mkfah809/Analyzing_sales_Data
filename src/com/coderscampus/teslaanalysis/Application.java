package com.coderscampus.teslaanalysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) throws IOException {
		launch();
	}

	private static void launch() throws IOException {
		FileService fileService = new FileService();
		List<Tesla> pospulateModel3List = fileService.readFile(fileService.MODEL3_FILE);
		List<Tesla> populateModelSList = fileService.readFile(fileService.MODELS_FILE);
		List<Tesla> populateModelXList = fileService.readFile(fileService.MODELX_FILE);
		displayReport(pospulateModel3List, populateModelSList, populateModelXList);
	}

	private static void displayReport(List<Tesla> pospulateModel3List, List<Tesla> populateModelSList,
			List<Tesla> populateModelXList) {
		ExecuteList execute = new ExecuteList();
		execute.executeReport(pospulateModel3List, "Model 3 ");
		execute.executeReport(populateModelSList, "Model S ");
		execute.executeReport(populateModelXList, "Model X ");
	}

}
