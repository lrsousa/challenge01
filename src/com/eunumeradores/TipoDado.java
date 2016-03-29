package com.eunumeradores;

import com.logic.Agregador;
import com.modelos.Customer;
import com.modelos.Sale;
import com.modelos.Salesman;
import com.tinyclasses.Cnpj;
import com.tinyclasses.Cpf;
import com.tinyclasses.Salary;

public enum TipoDado {
	N001 ("001") {
		@Override
		Salesman mountTypeInput(String cpf, String nome, String salary, Agregador agregador) {
			Salesman salesman = new Salesman(new Cpf(cpf), nome, new Salary(Double.parseDouble(salary)));
			agregador.addSalesman(salesman);
			return salesman;
		}
	},
	N002 ("002") {
		@Override
		Customer mountTypeInput(String cnpj, String name, String businesArea,  Agregador agregador) {
			Customer customer =  new Customer(new Cnpj(cnpj), name, businesArea);
			agregador.addCustomer(customer);
			return customer;
		}
		
	},
	N003 ("003") {
		@Override
		Sale mountTypeInput(String id, String listaItens, String vendedor, Agregador agregador) {
			Salesman salesmanObject = agregador.getSalesmanByName(vendedor);
			Sale sale = new Sale(Integer.parseInt(id), salesmanObject);

			String[] itensDaVenda = listaItens.substring(1, listaItens.length() - 1).split(",");
			for (String string : itensDaVenda) {
				sale.addItem(agregador.mountItem(string));
			}
			agregador.addSale(sale);
			salesmanObject.salesIncrement(sale);
			return sale;
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
	
	abstract Object mountTypeInput(String n, String f, String g, Agregador a);
	
	public static void mountType(String linha, Agregador agregador) {
		String[] dados = linha.split("ç");
		TipoDado tipo = TipoDado.valueOf("N" + dados[0]);
		if (tipo != null) {
			tipo.mountTypeInput(dados[1], dados[2], dados[3], agregador);
		}
	}
	
}
