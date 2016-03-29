package com.modelos;

import com.tinyclasses.Cnpj;

public class Customer {
	private Cnpj cnpj;
	private String name;
	private String businessArea;
	
	public Customer(Cnpj cnpj, String name, String businessArea) {
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
	public String getBusinessArea() {
		return businessArea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Customer other = (Customer) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
}
