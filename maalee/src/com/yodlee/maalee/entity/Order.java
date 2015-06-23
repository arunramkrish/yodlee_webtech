package com.yodlee.maalee.entity;

import java.util.Date;
import java.util.Set;

public class Order {
	private Long id;
	private Date createdDate;
	private Float totalAmount;
	private User user;

	private Set<OrderItem> lineItems;

	public Order(Long id, Date createdDate, Float totalAmount, User user) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.totalAmount = totalAmount;
		this.user = user;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<OrderItem> lineItems) {
		this.lineItems = lineItems;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", createdDate=" + createdDate
				+ ", totalAmount=" + totalAmount + ", user=" + user
				+ ", lineItems=" + lineItems + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
