package com.coderscampus.teslaanalysis;

import java.text.ParseException;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

public class ExecuteList {

	public List<Tesla> populateSales(List<Tesla> populateList) {
		List<Integer> sales = populateList.stream().map(sale -> sale.getSales()).collect(Collectors.toList());

		return populateList;
	}

	public List<Tesla> populateDates(List<Tesla> populateList) throws ParseException {
		List<YearMonth> dates = populateList.stream().map(year -> year.getDate()).distinct()
				.collect(Collectors.toList());
		return populateList;
	}

	public void executeReport(List<Tesla> populateModel3List, List<Tesla> populateModelSList,
			List<Tesla> populateModelXList) {
		String modelName = null;
		getReportTitle(0,modelName);
		System.out.println(populateModel3List);
		getReportTitle(1,modelName);
		System.out.println(populateModelSList);
		getReportTitle(2,modelName);
		System.out.println(populateModelXList);
	}

	private void getReportTitle(int titleMessage, String modelName) {

		String[] titleMessageControl = new String[3];
		titleMessageControl[0] = " yearly Sales Report\n-------------------------";
		titleMessageControl[1] = " yearly Sales Report\n-------------------------";
		titleMessageControl[2] = " yearly Sales Report\n-------------------------";

		if (titleMessage == 0) {
			modelName = "Model 3";
			System.out.println(modelName + titleMessageControl[0]);
		} else if (titleMessage == 1) {
			modelName = "Model S";
			System.out.println(modelName + titleMessageControl[1]);
		} else if (titleMessage == 2) {
			modelName = "model X";
			System.out.println(modelName + titleMessageControl[2]);
		}
	}
}
