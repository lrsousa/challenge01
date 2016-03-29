package com.eunumeradores;

import java.util.ArrayList;
import java.util.List;

import com.leitor.Agregador;
import com.modelos.Customer;
import com.modelos.Item;
import com.modelos.Sale;
import com.modelos.Salesman;
import com.tinyclasses.Cnpj;
import com.tinyclasses.Cpf;
import com.tinyclasses.Salary;

public enum TipoDado {
	N001 ("001") {
		@Override
		public Salesman mountTypeInput(String cpf, String nome, String salary, Agregador agregador) {
			System.out.println("SALESMAN");
			Salesman vendedor = new Salesman(new Cpf(cpf), nome, new Salary(Double.parseDouble(salary)));
			agregador.getSalesmans().add(vendedor);
			return vendedor;
		}
	},
	N002 ("002") {
		@Override
		public Customer mountTypeInput(String cnpj, String name, String businesArea,  Agregador agregador) {
			System.out.println("CUSTOMER");
			Customer cliente =  new Customer(new Cnpj(cnpj), name, BusinessArea.valueOf(businesArea.toUpperCase()));
			agregador.getCustomers().add(cliente);
			return cliente;
		}
		
	},
	N003 ("003") {
		@Override
		public Sale mountTypeInput(String id, String listaItens, String vendedor, Agregador agregador) {
			System.out.println("SALES");
			List<Item> itens = new ArrayList<Item>();
			String[] itensDaVenda = listaItens.substring(1, listaItens.length() - 1).split(",");
			for (String string : itensDaVenda) {
				itens.add(agregador.mountItem(string));
			}
			Sale venda = new Sale(Integer.parseInt(id), itens, agregador.getSalesmanByName(vendedor));
			agregador.getSales().add(venda);
			return venda;
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
	
	public abstract Object mountTypeInput(String n, String f, String g, Agregador a);
}
