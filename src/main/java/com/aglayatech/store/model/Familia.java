package com.aglayatech.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productofamilia")
public class Familia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproductofamilia;
	private String familia;

	public Integer getIdproductofamilia() {
		return idproductofamilia;
	}

	public void setIdproductofamilia(Integer idproductofamilia) {
		this.idproductofamilia = idproductofamilia;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

}
