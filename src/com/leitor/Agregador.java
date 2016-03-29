package com.leitor;

import java.util.ArrayList;
import java.util.List;

import com.modelos.Customer;
import com.modelos.Item;
import com.modelos.Sale;
import com.modelos.Salesman;

public class Agregador {
	private List<Salesman> salesmans;
	private List<Customer> customers;
	private List<Sale> sales;
	
	public Agregador() {
		this.salesmans = new ArrayList<Salesman>();
		this.customers = new ArrayList<Customer>();
		this.sales = new ArrayList<Sale>();
	}
	
	private List<Salesman> getSalesmans() {
		return salesmans;
	}
	private List<Customer> getCustomers() {
		return customers;
	}
	private List<Sale> getSales() {
		return sales;
	}

	@Override
	public String toString() {
		System.out.println("Salesmans size: " + getSalesmans().size());
		System.out.println("Customers size: " + getCustomers().size());
		System.out.println("Sales size: " + getSales().size());
		return "";
	}
	
	public void addSalesman(Salesman salesman) {
		getSalesmans().add(salesman);
	}
	public void addCustomer(Customer customer) {
		getCustomers().add(customer);
	}
	public void addSale(Sale sale) {
		getSales().add(sale);
	}
	
	public Item mountItem(String item) {
		String[] fieldItens = item.split("-");
		return new Item(Integer.parseInt(fieldItens[0]), Integer.parseInt(fieldItens[1]), Double.parseDouble(fieldItens[2]));
	}
	
	public Salesman getSalesmanByName(String name) {
		for (Salesman salesman : salesmans) {
			if(salesman.getName().equals(name)) {
				return salesman;
			}
		}
		return null;
	}
	
	
	
}
