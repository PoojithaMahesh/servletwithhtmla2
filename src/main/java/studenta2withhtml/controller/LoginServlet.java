package studenta2withhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studenta2withhtml.dao.StudentDao;
import studenta2withhtml.dto.Student;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");	
		StudentDao studentDao=new StudentDao();
		List<Student> list=studentDao.getAllStudents();
		boolean value=false;
		String studentPasswordFromTheDatabase=null;
		for(Student student:list) {
			if(email.equals(student.getEmail())) {
				value=true;
				studentPasswordFromTheDatabase=student.getPassword();
				break;
			}
		}
		if(value) {
//		student email is present	
			if(password.equals(studentPasswordFromTheDatabase)) {
//				its a perfect password
//				login success
				PrintWriter printWriter=resp.getWriter();
				printWriter.print("LOGIN SUCCESSS");
			}else {
//				Passwords is inicorrect
				PrintWriter printWriter=resp.getWriter();
				printWriter.print("Sorry Invalid password");
			}
		}else {
//			email is not present
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("Sorry Invalid Email");
		}
		
		
	}

}
