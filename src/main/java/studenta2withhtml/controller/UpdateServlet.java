package studenta2withhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studenta2withhtml.dao.StudentDao;
import studenta2withhtml.dto.Student;

public class UpdateServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Student student=new Student();
	student.setAddress(req.getParameter("address"));
	student.setEmail(req.getParameter("email"));
	student.setName(req.getParameter("name"));
	student.setPassword(req.getParameter("password"));
	student.setPhone(Integer.parseInt(req.getParameter("phone")));
	
	int id=Integer.parseInt(req.getParameter("id"));
	StudentDao studentDao=new StudentDao();
	Student dbStudent=studentDao.updateStudent(id,student);
	
	if(dbStudent!=null) {
//		student is present 
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Data Updated successfully");
	}else {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Sorry id is not present to update");
	}
}
}
