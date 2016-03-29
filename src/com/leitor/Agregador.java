package com.leitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.modelos.Customer;
import com.modelos.Item;
import com.modelos.Sale;
import com.modelos.Salesman;

public class Agregador {
	private Set<Salesman> salesmans;
	private Set<Customer> customers;
	private List<Sale> sales;
	
	public Agregador() {
		this.salesmans = new HashSet<Salesman>();
		this.customers = new HashSet<Customer>();
		this.sales = new ArrayList<Sale>();
	}
	
	Set<Salesman> getSalesmans() {
		return salesmans;
	}
	Set<Customer> getCustomers() {
		return customers;
	}
	List<Sale> getSales() {
		return sales;
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
	
	@Override
	public String toString() {
		for (Salesman salesman: getSalesmans()) {
			System.out.println("Salesman name: " + salesman.getName() + " - " + "Valor total de vendas: " + salesman.getTotalValueSales());
		}
		System.out.println("Salesmans size: " + getSalesmans().size());
		System.out.println("===============");
		for (Customer customer : getCustomers()) {
			System.out.println("Customer name: " + customer.getName());
		}
		System.out.println("Customers size: " + getCustomers().size());
		System.out.println("===============");
		for (Sale sale : getSales()) {
			System.out.println("Total venda: " + sale.getTotalValue());
		}
		System.out.println("Sales size: " + getSales().size());
		return "";
	}
	
}
