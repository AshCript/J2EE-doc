package org.as.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Food")
public class FoodProduct extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date expiredAt;

	public FoodProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodProduct(String name, float price, Date createdAt, Date expiredAt) {
		super(name, price, createdAt);
		this.expiredAt = expiredAt;
	}

	public Date getExpiredAt() {
		return expiredAt;
	}

	public void setExpiredAt(Date expiredAt) {
		this.expiredAt = expiredAt;
	}

	@Override
	public String toString() {
		return super.toString() + " - FoodProduct [expiredAt=" + expiredAt + "]";
	}
	
	
	
	
}
