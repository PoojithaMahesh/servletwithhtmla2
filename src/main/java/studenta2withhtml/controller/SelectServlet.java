package studenta2withhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studenta2withhtml.dao.StudentDao;
import studenta2withhtml.dto.Student;

public class SelectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		StudentDao studentDao=new StudentDao();
		Student student=studentDao.findStudentById(id);
		if(student!=null) {
//			student id is present
			PrintWriter printWriter=resp.getWriter();
			printWriter.print(student);
		}else {
//			student is not present in this id
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("Sorry id is not present");
		}
	}
}
