package com.coderscampus.teslaanalysis;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecuteList {

	@SuppressWarnings("static-access")
	public void executeReport(List<Tesla> populateModel3List, List<Tesla> populateModelSList,
			List<Tesla> populateModelXList) {
		IntSummaryStatistics salesMax = populateModel3List.parallelStream()
				.collect(Collectors.summarizingInt(Tesla::getSales));

		getReportTitle(0, "Model 3");

	
//		.filter((Tesla t) -> {
//			if (t.getDate().getYear() == 2017) {
//				return t.getDate().getYear() == 2018;			
//			} else if (t.getDate().getYear() == 2018) {
//				return t.getDate().getYear() == 2018;
//			} else if (t.getDate().getYear() == 2019) {
//				return t.getDate().getYear() == 2019;
//			}
//			return false;
//			
//		})
		
		 populateModel3List.parallelStream()
		 				  //.filter(y -> y.getDate().getYear() == 2018)	    
	   					  .map(t -> t.getDate().getYear() + " -> " + salesMax.getMax())
						  .distinct()
						  .collect(Collectors.toList())
						  .forEach(System.out::println);
						  
		System.out.println();

//		getReportTitle(1, "Model S");
//		populateModelSList.stream()
//						  .map(t -> t.getDate().getYear() + " -> " + t.getSales().MAX_VALUE)
//						  .distinct()
//			              .collect(Collectors.toList())														 
//						  .forEach(System.out::println);
//		System.out.println();
//		
//		
//		getReportTitle(2, "model X");
//		populateModel3List.stream()
//						  .map(t -> t.getDate() + " -> " + t.getSales())
//						  .distinct()
//						  .forEach(System.out::println);
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
