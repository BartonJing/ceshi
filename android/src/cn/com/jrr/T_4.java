package cn.com.jrr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


/**
 * Servlet implementation class T_4
 */
@WebServlet("/T_4")
public class T_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*DbUtil db=new DbUtil();
		for(int i=0;i<50;i++){
			db.update("INSERT INTO myList(m_name) VALUES (?)",new Object[]{"name"+i});
		}*/
		
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8") );
		String content=bufferedReader.readLine();
		System.out.println(content);
		
		DbUtil db=new DbUtil();
		
		String sql="select * from myList";
		PageModel<MyList> pageModel=new PageModel<MyList>();
		pageModel.setSql(sql);
		pageModel.setPageSize(10);
		pageModel.setCurrentPage(1);
		int totalPage=db.query(pageModel.getSql()).size();
		if(totalPage%pageModel.getPageSize()==0){
			totalPage=totalPage/pageModel.getPageSize();
		}else{
			totalPage=totalPage/pageModel.getPageSize()+1;
		}
		pageModel.setTotalPage(totalPage);
		
		sql="SELECT * FROM ("+pageModel.getSql()+") as temp LIMIT ?,?";
		List<Map<String,Object>> data=db.query(sql,new Object[]{(pageModel.getCurrentPage()-1)*pageModel.getPageSize(),pageModel.getPageSize()});
		
		MyList myList;
		List<MyList> list=new ArrayList<>();
		for(Map<String,Object> map:data){
			myList=new MyList();
			myList.setName(map.get("m_name")==null?"":map.get("m_name").toString());
			myList.setId(Integer.parseInt(map.getOrDefault("m_id", 1).toString()));
			list.add(myList);
		}
		pageModel.setData(list);
		System.out.println(pageModel.getData());
		
		
		Gson gson=new Gson();
		System.out.println(gson.toJson(pageModel));
		System.out.println(gson.toJson(pageModel.getData()));
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().append(gson.toJson(pageModel));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
