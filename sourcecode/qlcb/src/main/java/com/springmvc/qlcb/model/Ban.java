package com.springmvc.qlcb.model;
// Generated Apr 25, 2016 2:33:53 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ban generated by hbm2java
 */
@Entity
@Table(name = "ban", catalog = "qlcb")
public class Ban implements java.io.Serializable {

	private int maBan;
	private Donvi donvi;
	private String tenBan;
	private Date ngayThanhLap;
	private Integer maTruongBan;
	private Set<CanboBan> canboBans = new HashSet<CanboBan>(0);

	public Ban() {
	}

	public Ban(int maBan, Donvi donvi, String tenBan, Date ngayThanhLap) {
		this.maBan = maBan;
		this.donvi = donvi;
		this.tenBan = tenBan;
		this.ngayThanhLap = ngayThanhLap;
	}

	public Ban(int maBan, Donvi donvi, String tenBan, Date ngayThanhLap, Integer maTruongBan, Set<CanboBan> canboBans) {
		this.maBan = maBan;
		this.donvi = donvi;
		this.tenBan = tenBan;
		this.ngayThanhLap = ngayThanhLap;
		this.maTruongBan = maTruongBan;
		this.canboBans = canboBans;
	}

	@Id

	@Column(name = "MaBan", unique = true, nullable = false)
	public int getMaBan() {
		return this.maBan;
	}

	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaDonVi", nullable = false)
	public Donvi getDonvi() {
		return this.donvi;
	}

	public void setDonvi(Donvi donvi) {
		this.donvi = donvi;
	}

	@Column(name = "TenBan", nullable = false, length = 45)
	public String getTenBan() {
		return this.tenBan;
	}

	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NgayThanhLap", nullable = false, length = 10)
	public Date getNgayThanhLap() {
		return this.ngayThanhLap;
	}

	public void setNgayThanhLap(Date ngayThanhLap) {
		this.ngayThanhLap = ngayThanhLap;
	}

	@Column(name = "MaTruongBan")
	public Integer getMaTruongBan() {
		return this.maTruongBan;
	}

	public void setMaTruongBan(Integer maTruongBan) {
		this.maTruongBan = maTruongBan;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ban")
	public Set<CanboBan> getCanboBans() {
		return this.canboBans;
	}

	public void setCanboBans(Set<CanboBan> canboBans) {
		this.canboBans = canboBans;
	}

}