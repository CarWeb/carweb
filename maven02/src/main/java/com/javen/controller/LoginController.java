package com.javen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.model.Login;
import com.javen.service.ILoginService;

@Controller  
@RequestMapping("login") 
public class LoginController {

	@Autowired
	private ILoginService iLoginService;
	
	@RequestMapping(value="/idus", method=RequestMethod.GET)
    public String idus(HttpServletRequest request,Model model){  
		String idus = request.getParameter("x");
		return ""+idus+"";
	}
	//selectById
	//����ҳ��
	@RequestMapping(value="/selectById", method=RequestMethod.GET)
    public String selectById(HttpServletRequest request,Model model){  
		String idString = request.getParameter("id");
		System.out.println("selectById: "+idString);
		Integer idInteger = Integer.valueOf(idString);
		Login loginid = iLoginService.selectById(idInteger);
		System.out.println("��ѯ���"+loginid.toString());
        return "selectById";
    }//��������
	@ResponseBody
	@RequestMapping(value="/selectByIdValue", method=RequestMethod.GET)
    public Login selectByIdValue(HttpServletRequest request,Model model){  
		String idString = request.getParameter("id");
		Integer idInteger = Integer.valueOf(idString);
		Login id = iLoginService.selectById(idInteger);
        return id;
    }
	//selectAll
	//����ҳ��
	@RequestMapping(value="/selectAll", method=RequestMethod.GET)
    public String selectAll(HttpServletRequest request,Model model){  
		List<Login> userList =iLoginService.selectAll();
    	System.out.println(userList.toString());
        return "selectAll";
    }//��������
	@ResponseBody
	@RequestMapping(value="/selectAllValue", method=RequestMethod.GET)
    public List<Login> selectAllValue(HttpServletRequest request,Model model){  
		List<Login> userList =iLoginService.selectAll();
    	System.out.println(userList.toString());
        return userList;
    }
	//selectByName
	//����ҳ��
	@RequestMapping(value="/selectByName", method=RequestMethod.GET)
    public String selectByName(HttpServletRequest request,Model model){
		String name = request.getParameter("user_name");
		System.out.println("selectByName: "+name);
		Login user_name =iLoginService.selectByName(name);
    	System.out.println(user_name.toString());
        return "selectByName";
    }//��������
	@ResponseBody
	@RequestMapping(value="/selectByNameValue", method=RequestMethod.GET)
    public Login selectByNameValue(HttpServletRequest request,Model model){  
		String name = request.getParameter("user_name");
		Login user_name =iLoginService.selectByName(name);
        return user_name;
    }
	//deleteById
	//����ҳ��
	@RequestMapping(value="/deleteById", method=RequestMethod.GET)
	public String deleteById(HttpServletRequest request,Model model){
		String idString = request.getParameter("id");
		Integer id = Integer.valueOf(idString);
		System.out.println(id);
    	iLoginService.deleteById(id);
        return "deleteById";
	}
	//��������
	@ResponseBody
	@RequestMapping(value="/deleteByIdValue", method=RequestMethod.GET)
	public Login deleteByIdValue(HttpServletRequest request,Model model){
		String idString = request.getParameter("id");
		Integer id = Integer.valueOf(idString);
    	iLoginService.deleteById(id);
    	System.out.println("����id: "+id+" ɾ���ɹ�!");
        return null;
	}
	//deleteByName
	//����ҳ��
	@RequestMapping(value="/deleteByName", method=RequestMethod.GET)
	public String deleteByName(HttpServletRequest request,Model model){
		String user_name = request.getParameter("user_name");
		System.out.println(user_name);
		iLoginService.deleteByName(user_name);
		return "deleteByName";
	}
	//��������
	@ResponseBody
	@RequestMapping(value="/deleteByNameValue", method=RequestMethod.GET)
	public Login deleteByNameValue(HttpServletRequest request,Model model){
		String user_name = request.getParameter("user_name");
		System.out.println(user_name);
		iLoginService.deleteByName(user_name);
		System.out.println("����name: "+user_name+" ɾ���ɹ�!");
		return null;
	}
	//insert
	//����ҳ��
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(HttpServletRequest request,Model model){
		String name  = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Login login = new Login();
		login.setUser_name(name);
		login.setPassword(pwd);
    	iLoginService.insert(login);
        return "insert";
	}
	//��������
	@ResponseBody
	@RequestMapping(value="/insertValue", method=RequestMethod.GET)
	public Login insertValue(HttpServletRequest request,Model model){
		String name  = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Login login = new Login();
		login.setUser_name(name);
		login.setPassword(pwd);
    	iLoginService.insert(login);
    	System.out.println("insert[user_name: "+name+" ,password: "+pwd+"]");
		return null;
	}
	//update
		//����ҳ��
		@RequestMapping(value="/update", method=RequestMethod.GET)
		public String update(HttpServletRequest request,Model model){
			String idString  = request.getParameter("id");
			String name  = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			Integer id = Integer.valueOf(idString);
			Login login = new Login();
			login.setId(id);
			login.setUser_name(name);
			login.setPassword(pwd);
			iLoginService.update(login);
	        return "update";
		}
		//��������
		@ResponseBody
		@RequestMapping(value="/updateValue", method=RequestMethod.GET)
		public Login updateValue(HttpServletRequest request,Model model){
			String idString  = request.getParameter("id");
			String name  = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			Integer id = Integer.valueOf(idString);
			Login login = new Login();
			login.setId(id);
			login.setUser_name(name);
			login.setPassword(pwd);
			iLoginService.update(login);
	    	System.out.println("update[id: "+id+" ,user_name: "+name+" ,password: "+pwd+"]");
			return null;
		}
}
