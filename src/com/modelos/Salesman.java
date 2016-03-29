package com.modelos;

import com.tinyclasses.Cpf;
import com.tinyclasses.Salary;

public class Salesman {
	private Cpf cpf;
	private String name;
	private Salary salary;
	private double totalValueSales;
	
	public Salesman(Cpf cpf, String name, Salary salary) {
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
		totalValueSales = 0;
	}

	public Cpf getCpf() {
		return cpf;
	}
	public String getName() {
		return name;
	}
	public Salary getSalary() {
		return salary;
	}
	public double getTotalValueSales() {
		return totalValueSales;
	}
	
	public boolean salesIncrement(Sale sale) {
		if(sale.getTotalValue() > 0) {
			totalValueSales += sale.getTotalValue();
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salesman other = (Salesman) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
}
