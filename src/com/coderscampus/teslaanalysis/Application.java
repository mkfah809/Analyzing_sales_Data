package com.coderscampus.teslaanalysis;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Application {

	public static void main(String[] args) throws IOException, ParseException {

		
		   String str = "A,B,B,C,D";
		   
	        List<String> list =  Stream.of(str.split("-"))
		        					   .map(x -> x)
		        					   .distinct()
		                               .collect(Collectors.toList());
	        
	        String listSplit  = list.stream(x->x);
	      System.out.println(list);
	        
		List<Tesla> populateList = retrieveList();

		List<Tesla> dates = populateDates(populateList);
		System.out.println(dates);
		
		
		List<Tesla> sales = populateSales(populateList);
		System.out.println(sales);

		System.out.println();

		
	}

	private static List<Tesla> retrieveList() throws IOException, ParseException {
		FileService fileService = new FileService();
		List<Tesla> populateList = new ArrayList<>();
		populateList = fileService.readFile(fileService.MODEL3_FILE);
		return populateList;
	}

	private static List<Tesla> populateSales(List<Tesla> populateList) {
		 populateList.stream().forEach(teslaSales -> System.out.println(teslaSales.getSales()));
		 return populateList;
	}

	private static List<Tesla> populateDates(List<Tesla> populateList) {
		populateList.stream().distinct()
							 .forEach(teslaDates -> System.out.println(teslaDates.getDate()));
		return populateList;
	}
	
//	String salesSepereated = populateList.stream().map(s -> s.getSales()).collect(Collectors.joining("\n"));
//	System.out.println(salesSepereated);
//	return salesSepereated;
}
