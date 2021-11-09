package com.coderscampus.teslaanalysis;

import java.time.LocalDate;

public class Tesla {

	Long sales;
	LocalDate date;
	
	public Tesla(LocalDate date, Long sales) {
		this.date = date;
		this.sales = sales;
	}
	@Override
	public String toString() {
		return "Tesla [sales=" + sales + ", date=" + date + "]";
	}

	/**
	 * @return the sales
	 */
	public Long getSales() {
		return sales;
	}

	/**
	 * @param sales the sales to set
	 */
	public void setSales(Long sales) {
		this.sales = sales;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

}
