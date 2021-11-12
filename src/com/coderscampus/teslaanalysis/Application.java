package com.coderscampus.teslaanalysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		FileService fileService = new FileService();
		Set<Tesla> populateList = new HashSet<>();
		
		populateList = fileService.readFile(fileService.MODEL3_FILE);

		populateList.stream()
					.forEach(teslaSales -> System.out.println(teslaSales));
		
		Set<String> sales = populateList.stream()
											 .map(sale -> sale.getSales())
											 .collect(Collectors.toSet());

		String salesSepereated = populateList.stream()
		            .map(s -> s.getSales())	            
		            .collect(Collectors.joining(","));

		
		IntSummaryStatistics sumStats = populateList.stream()
		//											.flatMap(x -> x.s)
		//IntSummaryStatistics sumStats = extracted();
	
	
		
		System.out.println("Model S Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println("Max is:  	" +sumStats.getMax());
		System.out.println("Min is: 	" +sumStats.getMin());	
//		System.out.println(salesSepereated);
//		System.out.println(sales);
		System.out.println();		
			
	}

	@SuppressWarnings("unused")
	private static IntSummaryStatistics extracted() {
		List<List<Integer>> listofNumberList = new ArrayList<>();
		listofNumberList.add(Arrays.asList(1,2,3)); 
		listofNumberList.add(Arrays.asList(3,5,6)); 
		listofNumberList.add(Arrays.asList(1,2,7)); 
		listofNumberList.add(Arrays.asList(1,66,3)); 
		listofNumberList.add(Arrays.asList(1,2,62));
		// Creates list of Int [[1,2,3],[3,5,6],[1,2,7],[1,66,3],[1,2,62]]
		
	IntSummaryStatistics sumStats = listofNumberList.stream()
							   .flatMap(x -> x.stream()) // = 5*3 = 15 
/*More performance*/		   .mapToInt(Integer::intValue)
						       .summaryStatistics();
	
	System.out.println("Max is:  	" +sumStats.getMax());
	System.out.println("Min is: 	"+sumStats.getMin());
	

		return sumStats;
	}

}
