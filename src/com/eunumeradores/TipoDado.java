package com.eunumeradores;

import com.modelos.Customer;
import com.modelos.Salesman;
import com.tinyclasses.Cnpj;
import com.tinyclasses.Cpf;
import com.tinyclasses.Salary;

public enum TipoDado {
	N001 ("001") {
		@Override
		public Salesman retornaTipo(String cpf, String nome, String salary) {
			System.out.println("SALESMAN");
			return new Salesman(new Cpf(cpf), nome, new Salary(Double.parseDouble(salary)));
		}
	},
	N002 ("002") {
		@Override
		public Customer retornaTipo(String cnpj, String name, String businesArea) {
			System.out.println("CUSTOMER");
			return new Customer(new Cnpj(cnpj), name, BusinessArea.valueOf(businesArea.toUpperCase()));
		}
		
	},
	N003 ("003") {
		@Override
		public Object retornaTipo(String n, String f, String g) {
			System.out.println("SALES");
			return null;
		}
	};
	
	private String tipo;
	private TipoDado(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	
	public static TipoDado find(String nomeTipo) {
		for (TipoDado tipo : TipoDado.values()) {
			if(tipo.getTipo().contains(nomeTipo)) {
				return tipo;
			}
		}
		return null;
	}
	
	public abstract Object retornaTipo(String n, String f, String g);
}
