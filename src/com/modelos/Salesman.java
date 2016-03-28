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
}
