package com.springmvc.qlcb.model;
// Generated Apr 25, 2016 2:33:53 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CanboDonvi generated by hbm2java
 */
@Entity
@Table(name = "canbo_donvi", catalog = "qlcb")
public class CanboDonvi implements java.io.Serializable {

	private CanboDonviId id;
	private Canbo canbo;
	private Chucvudonvi chucvudonvi;
	private Donvi donvi;

	public CanboDonvi() {
	}

	public CanboDonvi(CanboDonviId id, Canbo canbo, Chucvudonvi chucvudonvi, Donvi donvi) {
		this.id = id;
		this.canbo = canbo;
		this.chucvudonvi = chucvudonvi;
		this.donvi = donvi;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "maCanBo", column = @Column(name = "MaCanBo", nullable = false)),
			@AttributeOverride(name = "maDonVi", column = @Column(name = "MaDonVi", nullable = false)) })
	public CanboDonviId getId() {
		return this.id;
	}

	public void setId(CanboDonviId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaCanBo", nullable = false, insertable = false, updatable = false)
	public Canbo getCanbo() {
		return this.canbo;
	}

	public void setCanbo(Canbo canbo) {
		this.canbo = canbo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ChucVu", nullable = false)
	public Chucvudonvi getChucvudonvi() {
		return this.chucvudonvi;
	}

	public void setChucvudonvi(Chucvudonvi chucvudonvi) {
		this.chucvudonvi = chucvudonvi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaDonVi", nullable = false, insertable = false, updatable = false)
	public Donvi getDonvi() {
		return this.donvi;
	}

	public void setDonvi(Donvi donvi) {
		this.donvi = donvi;
	}

}
