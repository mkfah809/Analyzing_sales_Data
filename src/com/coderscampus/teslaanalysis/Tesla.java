package com.coderscampus.teslaanalysis;

import java.util.Objects;

public class Tesla {

	String date;
	String sales;

	@Override
	public String toString() {
		return date + ","  + sales ;
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
	 */
	public void setDate(String date) {
		this.date = date;
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
	public void setSales(String sales) {
		this.sales = sales;
		
	}

}
