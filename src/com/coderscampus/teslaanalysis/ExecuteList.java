package com.coderscampus.teslaanalysis;

import java.util.List;
import java.util.stream.Collectors;

public class ExecuteList {

	public List<Tesla> populateSales(List<Tesla> populateList) {
		List<String> sales = populateList.stream()
										 .map(sale -> sale.getDate())
									 	 .collect(Collectors.toList());
		System.out.println("Sales are\n--------");
		System.out.println(populateList);
		
				
		return populateList;
	}

	public List<Tesla> populateDates(List<Tesla> populateList) {
		List<String> dates = populateList.stream()
										.map(year -> year.getDate())
										.distinct()
										.collect(Collectors.toList());
		// How to get Only year seperated? 

		String yearSeperated = populateList.stream().map(year -> year.getDate()).distinct().collect(Collectors.joining(","));
		System.out.println("Date are\n--------");
		
		System.out.println(yearSeperated.split("-"));
		//System.out.println(dates);
		
		return populateList;
	}

}
