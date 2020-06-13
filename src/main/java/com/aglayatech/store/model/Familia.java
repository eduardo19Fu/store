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
	private String nombrefamilia;

	public Integer getIdproductofamilia() {
		return idproductofamilia;
	}

	public void setIdproductofamilia(Integer idproductofamilia) {
		this.idproductofamilia = idproductofamilia;
	}

	public String getNombrefamilia() {
		return nombrefamilia;
	}

	public void setNombrefamilia(String nombrefamilia) {
		this.nombrefamilia = nombrefamilia;
	}

	@Override
	public String toString() {
		return "Familia [idproductofamilia=" + idproductofamilia + ", nombrefamilia=" + nombrefamilia + "]";
	}

}
