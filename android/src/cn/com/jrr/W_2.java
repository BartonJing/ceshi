package cn.com.jrr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class W_2
 */
@WebServlet("/W_2")
public class W_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Student student=new Student();
		/*获取数据*/
		student.setCode(request.getParameter("code"));
		student.setName(request.getParameter("name"));
		student.setSex(request.getParameter("sex"));
		student.setSchool(request.getParameter("school"));
		System.out.println(student);
		PrintWriter out=response.getWriter();
		
		response.setHeader("Content-type", "text/plain;charset=utf-8");
		/*向客户端发送数据*/
		out.write(student.toString());
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
