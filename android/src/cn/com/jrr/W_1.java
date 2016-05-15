package cn.com.jrr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class W_1
 */
@WebServlet("/W_1")
public class W_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8") );
		String content=bufferedReader.readLine();
		System.out.println(content);
		Gson gson=new Gson();
		Student student=gson.fromJson(content, Student.class);
		
		System.out.println(student);
		
		student.setId((int)1);
		
		response.setHeader("Content-type", "text/json;charset=utf-8");
		response.getWriter().append(gson.toJson(student));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
