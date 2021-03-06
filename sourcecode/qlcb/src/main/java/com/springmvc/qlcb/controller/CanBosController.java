package com.springmvc.qlcb.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springmvc.qlcb.model.Lylich;
import com.springmvc.qlcb.model.Taikhoan;
import com.springmvc.qlcb.service.DanTocService;
import com.springmvc.qlcb.service.LyLichService;
import com.springmvc.qlcb.service.NgoaiNguService;
import com.springmvc.qlcb.service.TonGiaoService;
import com.springmvc.qlcb.service.TrinhDoChinhTriService;
import com.springmvc.qlcb.service.TrinhDoChuyenMonService;

@Controller
public class CanBosController {

 
	@Autowired
	private LyLichService  l ;
	@Autowired
	private DanTocService  dt ;
	@Autowired
	private TonGiaoService  tg ;
	@Autowired
	private TrinhDoChuyenMonService  tdcm ;
	@Autowired
	private TrinhDoChinhTriService  tdct ;
	@Autowired
	private NgoaiNguService  nn ;
	
	
 
	
	@RequestMapping(value = { "/create"}, method = RequestMethod.GET)
	public String Create(HttpSession session, HttpServletRequest request,Model model) {
		
		// header
		Taikhoan tk = (Taikhoan) session.getAttribute("loggedInUser");
		if(tk!=null)
		{
			request.setAttribute("KEY_LOGINED", 1);
			request.setAttribute("NAME_LOGINED", tk.getTenDangNhap());
		}
		else
		{
			request.setAttribute("KEY_LOGINED", 0);
		}
		//-dropdownlist----
		
		model.addAttribute("listdantoc", dt.listDanToc() );
		model.addAttribute("listtocgiao", tg.listTonGiao());
		model.addAttribute("listchuyenmon", tdcm.listTrinhDoChuyenMon() );
		model.addAttribute("listchinhtri", tdct.listTrinhDoChinhTri());
		model.addAttribute("listngoaingu", nn.listNgoaiNgu());
		
		 
		
		model.addAttribute("Lylich", new Lylich());  
		return "/lylich_canbo/themmoi_canbo";
	}
	
	

	@RequestMapping(value = { "/create"}, method = RequestMethod.POST)
	public String DoCreate(@Valid @ModelAttribute(value = "Lylich")  Lylich  data ,BindingResult bindingResult,  Map<String, Object> model ) 
	{
 
		     l.save(data);
		 
			return "/layout/masterpage"; 
	}
	
	
	@RequestMapping(value = { "/detail/{id}"}, method = RequestMethod.GET)
	public String Detail(@PathVariable int id,HttpSession session, HttpServletRequest request,Model model) {
		
		// header
		Taikhoan tk = (Taikhoan) session.getAttribute("loggedInUser");
		if(tk!=null)
		{
			request.setAttribute("KEY_LOGINED", 1);
			request.setAttribute("NAME_LOGINED", tk.getTenDangNhap());
		}
		else
		{
			request.setAttribute("KEY_LOGINED", 0);
		}
		//-dropdownlist----
		
		model.addAttribute("listdantoc", dt.listDanToc() );
		model.addAttribute("listtocgiao", tg.listTonGiao());
		model.addAttribute("listchuyenmon", tdcm.listTrinhDoChuyenMon() );
		model.addAttribute("listchinhtri", tdct.listTrinhDoChinhTri());
		model.addAttribute("listngoaingu", nn.listNgoaiNgu());
		
		
	 
		// model
		Lylich lylich = new Lylich();
		
		lylich= l.getLyLichById(id);
		 
		model.addAttribute("Lylich", lylich);  
		
		return "/lylich_canbo/chitiet_canbo";
	}
	
	
	@RequestMapping(value = { "/edit/{id}"}, method = RequestMethod.GET)
	public String Edit(@PathVariable int id,HttpSession session, HttpServletRequest request,Model model) {
		
		// header
		Taikhoan tk = (Taikhoan) session.getAttribute("loggedInUser");
		if(tk!=null)
		{
			request.setAttribute("KEY_LOGINED", 1);
			request.setAttribute("NAME_LOGINED", tk.getTenDangNhap());
		}
		else
		{
			request.setAttribute("KEY_LOGINED", 0);
		}
		//-dropdownlist----
		
		model.addAttribute("listdantoc", dt.listDanToc() );
		model.addAttribute("listtocgiao", tg.listTonGiao());
		model.addAttribute("listchuyenmon", tdcm.listTrinhDoChuyenMon() );
		model.addAttribute("listchinhtri", tdct.listTrinhDoChinhTri());
		model.addAttribute("listngoaingu", nn.listNgoaiNgu());
		
		
		 
		// model
		Lylich lylich = new Lylich();
		
		lylich= l.getLyLichById(id);
		 
		model.addAttribute("Lylich", lylich);  
		
		return "/lylich_canbo/sua_canbo";
	}
	
	
	@RequestMapping(value = { "/edit/{id}"}, method = RequestMethod.POST) 
	public String Edit(@Valid @ModelAttribute(value = "Lylich")  Lylich  data ,BindingResult bindingResult,  Map<String, Object> model ) 
	{
 
		     l.update(data);
		 
			return "/layout/masterpage"; 
	}
}
