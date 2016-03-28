package com.modelos;

import com.eunumeradores.BusinessArea;
import com.tinyclasses.Cnpj;

public class Customer {
	private Cnpj cnpj;
	private String name;
	private BusinessArea businessArea;
	
	public Customer(Cnpj cnpj, String name, BusinessArea businessArea) {
		this.cnpj = cnpj;
		this.name = name;
		this.businessArea = businessArea;
	}

	public Cnpj getCnpj() {
		return cnpj;
	}
	public String getName() {
		return name;
	}
	public BusinessArea getBusinessArea() {
		return businessArea;
	}
}
