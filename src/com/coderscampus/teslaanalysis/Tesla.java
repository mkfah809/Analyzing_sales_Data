package com.coderscampus.teslaanalysis;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Tesla {

	private YearMonth date;
	private Integer sale;
	@Override
	public String toString() {
		return "Tesla [date=" + date + ", sale=" + sale + "]";
	}

	public Tesla(String date, Integer sale) {
		this.date = YearMonth.parse(date,DateTimeFormatter.ofPattern("yy-MMM"));
		this.sale = sale;
	}

	

	/**
	 * @return the date
	 */
	public YearMonth getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 * @return
	 */
	public void setDate(YearMonth date) {
		this.date = date;
	}

	/**
	 * @return the sales
	 */
	public Integer getSales() {
		return sale;
	}

	/**
	 * @param sales the sales to set
	 */
	public void setSales(Integer sales) {
		this.sale = sales;

	}

}