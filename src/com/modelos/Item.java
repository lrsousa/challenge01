package com.modelos;

public class Item {
	private int id;
	private int quantity;
	private double price;

	public Item(int id, int quantity, double price) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}
}
