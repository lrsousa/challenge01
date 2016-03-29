package com.modelos;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private int id;
	private List<Item> itens;
	private Salesman salesman;
	
	private double totalValue;
	
	public Sale(int id, Salesman salesman) {
		this.id = id;
		this.salesman = salesman;
		itens = new ArrayList<>();
	}

	public int getId() {
		return id;
	}
	
	public double getTotalValue() {
		return totalValue;
	}
	
	public void addItem(Item item) {
		if (item != null) {
			totalValue += (item.getPrice() * item.getQuantity());
			itens.add(item);
		}
	}
	
	public Salesman getSalesman() {
		return salesman;
	}
}
