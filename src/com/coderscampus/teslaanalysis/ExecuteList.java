package com.coderscampus.teslaanalysis;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExecuteList {


	public void executeReport(List<Tesla> populateModelList, String modelName) {
		
		System.out.println(modelName + "Yearly Sales Report\n-------------------------");
		Map<Integer, List<Tesla>> grouppedByDate = populateModelList
					            .stream()
							    .distinct()	
							    .collect(Collectors.groupingBy(t -> t.getDate().getYear()));
			
		String datesSeperated = grouppedByDate
								.entrySet()
								.parallelStream()
								.map(d -> d.getKey() + " -> " + d.getValue().stream()
								.collect(Collectors.summingInt(Tesla::getSales)))
								.collect(Collectors.joining("\n"));
		
		System.out.println(datesSeperated);
		System.out.println();
		
		Optional<Tesla> bestMonth = populateModelList
				.stream()
				.max((Tesla this1, Tesla that2) -> 
				this1.getSales().compareTo(that2.getSales()));
		
		Optional<Tesla> worstMonth = populateModelList
				.stream()
				.min((Tesla this1, Tesla that2) -> 
				this1.getSales().compareTo(that2.getSales()));
		
		String date="17-Jul";
		int sale= 0;
		Tesla tesla = new Tesla(date,sale);
		
				
		System.out.println("The best month for " + modelName + " was: " + bestMonth.orElse(tesla).getDate());
		
		System.out.println("The worst month for " + modelName + " was: " + worstMonth.orElse(tesla).getDate());

		System.out.println();
	}
}
