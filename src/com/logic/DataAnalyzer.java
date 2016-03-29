package com.logic;

import com.modelos.Sale;
import com.modelos.Salesman;

public class DataAnalyzer {
	private int amountCustomers;
	private int amountSalesman;
	private int idMostExpensiveSale;
	private Salesman worstSalesman;
	
	public DataAnalyzer(Agregador agregador) {
		amountCustomersCount(agregador);
		amountSalesmanCount(agregador);
		setIdMostExpensiveSale(getMostExpensiveSale(agregador));
		setWorstSalesman(getWorstSalesmanEver(agregador));
	}
	
	private void amountCustomersCount(Agregador agregador) {
		amountCustomers = agregador.getCustomers().size();
	}
	private void amountSalesmanCount(Agregador agregador) {
		amountSalesman = agregador.getSalesmans().size();
	}
	private Sale getMostExpensiveSale(Agregador agregador) {
		Sale bigestSale = null;
		double bigestValue = 0;
		for (Sale sale : agregador.getSales()) {
			if(sale.getTotalValue() > bigestValue) {
				bigestSale = sale;
				bigestValue = sale.getTotalValue();
			}
		}
		return bigestSale;
	}
	private Salesman getWorstSalesmanEver(Agregador agregador) {
		Salesman worstSalesman = null;
		double worstValue = Double.MAX_VALUE;
		for(Salesman salesman : agregador.getSalesmans()) {
			if(salesman.getTotalValueSales() < worstValue) {
				worstSalesman = salesman;
				worstValue = salesman.getTotalValueSales();
			}
		}
		return worstSalesman;
	}
	private void setWorstSalesman(Salesman worstSalesman) {
		this.worstSalesman = worstSalesman;
	}
	private void setIdMostExpensiveSale(Sale sale) {
		this.idMostExpensiveSale = sale.getId();
	}
	
	
	public int getAmountCustomers() {
		return amountCustomers;
	}
	public int getAmountSalesman() {
		return amountSalesman;
	}
	public int getIdMostExpensiveSale() {
		return idMostExpensiveSale;
	}
	public Salesman getWorstSalesman() {
		return worstSalesman;
	}

	@Override
	public String toString() {
		return "DataAnalyzer [amountCustomers=" + amountCustomers +
				", amountSalesman=" + amountSalesman +
				", idMostExpensiveSale=" + idMostExpensiveSale +
				", worstSalesman=" + worstSalesman.getName() +
				"]";
	}
	
	
}
