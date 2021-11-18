package com.coderscampus.teslaanalysis;

import java.util.List;
import java.util.stream.Collectors;
public class ExecuteList {


	public void executeReport(List<Tesla> populateModel3List, List<Tesla> populateModelSList,
			List<Tesla> populateModelXList) {
		
		getReportTitle(0, "Model 3");
		populateModel3List.stream()
						  .map(t -> t.getDate() + " -> " + t.getSales())
						  .distinct()
						  .collect(Collectors.toList())
						  .forEach(System.out::println);
		System.out.println();
		
						  						
		getReportTitle(1, "Model S");
		populateModelSList.stream()
						  .map(t -> t.getDate() + " -> " + t.getSales())
						  .distinct()
						  .forEach(System.out::println);
		System.out.println();
		
		
		getReportTitle(2, "model X");
		populateModel3List.stream()
						  .map(t -> t.getDate() + " -> " + t.getSales())
						  .distinct()
						  .forEach(System.out::println);
	}
	
	private void getReportTitle(int titleMessage, String modelName) {
		@SuppressWarnings("unused")
		String[] titleMessageControl = new String[3];
		String titleMsg = " yearly Sales Report\n-------------------------";
		if (titleMessage == 0) {
			System.out.println(modelName + titleMsg);
		} else if (titleMessage == 1) {
			System.out.println(modelName + titleMsg);
		} else if (titleMessage == 2) {
			System.out.println(modelName + titleMsg);
		}
	}
}