package com.yodlee.maalee.entity;

public class Inventory {
	private Product product;
	private Float quantity;
	private String units;

	public Inventory(Product product, Float quantity, String units) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.units = units;
	}

	public Inventory() {
		super();
	}

	@Override
	public String toString() {
		return "Inventory [product=" + product + ", quantity=" + quantity
				+ ", units=" + units + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		Inventory other = (Inventory) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

}
