package net.dlhz.pss.inventory.entity.form;

import java.io.Serializable;

import net.dlhz.pss.inventory.entity.Brand;


public class BrandFrom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8846503913267965403L;
	private Brand brand;
	private String industryName;

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

}
