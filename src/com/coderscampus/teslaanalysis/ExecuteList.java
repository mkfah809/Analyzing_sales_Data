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

	}
}
