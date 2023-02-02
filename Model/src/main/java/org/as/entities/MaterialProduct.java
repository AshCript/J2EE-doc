package org.as.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Material")
public class MaterialProduct extends Product{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean isDangerous;
	private boolean isWeak;
	
	public MaterialProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaterialProduct(String name, float price, Date createdAt, boolean isDangerous, boolean isWeak) {
		super(name, price, createdAt);
		this.isDangerous = isDangerous;
		this.isWeak = isWeak;
	}

	public boolean isDangerous() {
		return isDangerous;
	}

	public void setDangerous(boolean isDangerous) {
		this.isDangerous = isDangerous;
	}

	public boolean isWeak() {
		return isWeak;
	}

	public void setWeak(boolean isWeak) {
		this.isWeak = isWeak;
	}

	@Override
	public String toString() {
		return super.toString() + " - MaterialProduct [isDangerous=" + isDangerous + ", isWeak=" + isWeak + "]";
	}
}
