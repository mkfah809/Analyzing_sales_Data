package com.coderscampus.teslaanalysis;

import java.util.Objects;

public class Tesla {

	String date;
	String sales;
	String year;


	public String getYear() {
		return year;
	}

	public String setYear(String year) {
		return this.year = year;
	}

	@Override
	public String toString() {
		return date + "," + sales;
	}

	public Tesla(String date, String sales) {
		this.date = date;
		this.sales = sales;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, sales);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tesla other = (Tesla) obj;
		return Objects.equals(date, other.date) && Objects.equals(sales, other.sales);
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 * @return 
	 */
	public String setDate(String date) {
		return this.date = date;
	}

	/**
	 * @return the sales
	 */
	public String getSales() {
		return sales;
	}

	/**
	 * @param sales the sales to set
	 */
	public String setSales(String sales) {
		return this.sales = sales;

	}



}
