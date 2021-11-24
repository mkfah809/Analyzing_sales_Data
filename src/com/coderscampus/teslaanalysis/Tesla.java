package com.coderscampus.teslaanalysis;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Tesla {

	private YearMonth date;
	private Integer sale;
	
	@Override
	public String toString() {
		return "date=" + date + ", sale=" + sale ;
	}

	public Tesla(String date, String sale) {
		this.date = YearMonth.parse(date,DateTimeFormatter.ofPattern("yy-MMM"));
		this.sale = Integer.parseInt(sale);	
		}

	public YearMonth getDate() {
		return date;
	}

	public void setDate(YearMonth date) {
		this.date = date;
	}

	public Integer getSales() {
		return sale;
	}

	public void setSales(Integer sales) {
		this.sale = sales;
	}

}