package com.modelos;

import java.util.List;

public class Sales {
	private int id;
	private List<Item> itens;
	private Salesman salesman;
	
	public Sales(int id, List<Item> itens, Salesman salesman) {
		this.id = id;
		this.itens = itens;
		this.salesman = salesman;
	}

	public int getId() {
		return id;
	}
	public List<Item> getItens() {
		return itens;
	}
	public Salesman getSalesman() {
		return salesman;
	}
}
