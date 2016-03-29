package com.modelos;

import com.tinyclasses.Cpf;
import com.tinyclasses.Salary;

public class Salesman {
	private Cpf cpf;
	private String name;
	private Salary salary;
	
	public Salesman(Cpf cpf, String name, Salary salary) {
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
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
