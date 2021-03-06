package com.springmvc.qlcb.service;

import java.util.List;

import com.springmvc.qlcb.model.Khenthuong;;

public interface KhenThuongService {
	public int save(Khenthuong khenthuong);
	public Khenthuong getKhenThuongById(int id);
	public void update(Khenthuong khenthuong);
	public void delete(int id);
	public List<Khenthuong> listKhenThuong();
}
