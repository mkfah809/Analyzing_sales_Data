package com.coderscampus.teslaanalysis;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException, ParseException {
		
		  
		String line = null;
		Tesla tesla = null;
		String[] rows = null;

		    
		FileService fileService = new FileService();
		Set<Tesla> populateList = new HashSet<>();
		populateList = fileService.readFile(fileService.MODEL3_FILE);
		

		getEachOfTeslaAttribitues(populateList);
		
		Set<String> dates = populateList.stream()
										.map(date -> date.getDate())
										.collect(Collectors.toSet());
		
		String yearSeperated = populateList.stream()
										   .map(date -> date.getDate())
										   .
		Set<String> sales = populateList.stream()
										.map(sale -> sale.getSales())
										.collect(Collectors.toSet());

		String salesSepereated = populateList.stream()
											 .map(s -> s.getSales())	            
											 .collect(Collectors.joining("\n"));

		System.out.println("Model S Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println(salesSepereated);
		System.out.println(sales);
		System.out.println();		
			
	}

	private static Set<Tesla> getEachOfTeslaAttribitues(Set<Tesla> populateList) {
		populateList.stream()
					.forEach(teslaSales -> teslaSales.toString());
		populateList.stream()
					.forEach(teslaDates -> teslaDates.toString());
		return populateList;
	}
}
