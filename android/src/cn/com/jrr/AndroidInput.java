package cn.com.jrr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AndroidInput
 */
@WebServlet("/AndroidInput")
public class AndroidInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AndroidInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name=request.getParameter("name_s");
		String psw=request.getParameter("psw_s");
		DbUtil db=new DbUtil();
		String sql="INSERT INTO aa (a_name,a_psw) VALUES (?,?)";
		int res=db.update(sql, name,psw);
		if(res>0){
			PrintWriter out=response.getWriter();
			response.setHeader("Content-type", "text/plain;charset=utf-8");
			out.write("success!");
		}
		System.out.println(name+"   "+psw);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
