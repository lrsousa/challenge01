package com.leitor;

import com.eunumeradores.BusinessArea;
import com.modelos.Customer;
import com.tinyclasses.Cnpj;

public class LeitorArquivo {
	public static void main(String[] args) {
		Customer customer = new Customer(new Cnpj("111111111"), "leonardo", BusinessArea.RURAL);
		
		System.out.println(customer.getName());
		System.out.println(customer.getBusinessArea());
		System.out.println(customer.getCnpj().getCnpj());
		
	}
}
