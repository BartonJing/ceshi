package cn.com.jrr.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DbUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("锟斤拷锟捷匡拷锟斤拷锟斤拷锟斤拷锟斤拷锟届常,锟斤拷锟介！");
			e.printStackTrace();
		}
	}
	private Connection conn = null;
	private Statement stat = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private ResultSetMetaData rst = null;

	private Connection setConn() {
		try {
			/*ComboPooledDataSource  cpds=new ComboPooledDataSource("c3p0.properties");*/
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/universityemploymentinformation","root","jing");
			/*conn=cpds.getConnection();*/
		} catch (Exception e) {
			System.out.println("锟斤拷锟斤拷源锟斤拷锟斤拷失锟斤拷,锟斤拷锟介！");
		}
		return conn;
	}

	private PreparedStatement setPs(String sql) {
		setConn();
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("锟斤拷锟斤拷锟斤拷询锟斤拷锟斤拷锟绞э拷锟�,锟斤拷锟介！");
			e.printStackTrace();
		}
		return ps;
	}

	private void toClose() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("锟斤拷询锟斤拷锟斤拷锟斤拷乇锟绞э拷埽锟�");
				e.printStackTrace();
			}
		}
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("锟斤拷锟斤拷锟斤拷乇锟绞э拷埽锟�");
				e.printStackTrace();
			} finally {
				stat = null;
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("锟斤拷锟斤拷锟斤拷乇锟斤拷斐ｏ拷锟�");
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("锟斤拷锟斤拷源锟截憋拷失锟杰ｏ拷");
				e.printStackTrace();
			}
		}
	}

	public int update(String sql, Object[] obj) {
		ps = setPs(sql);
		try {
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);

			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("锟斤拷锟斤拷失锟斤拷,锟斤拷锟介！");
			e.printStackTrace();
		} finally {
			toClose();
		}
		return -1;
	}

	public int update(String sql) {
		return update(sql, new Object[] {});
	}

	public List<Map<String, Object>> query(String sql, Object[] obj) {
		List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
		setPs(sql);
		try {
			for (int i = 1; i <= obj.length; i++) {
				ps.setObject(i, obj[i - 1]);
			}
			rs = ps.executeQuery();
			rst = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= rst.getColumnCount(); i++) {
					String key = rst.getColumnName(i);
					map.put(key, rs.getString(key));
				}
				list.add(map);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("锟斤拷询锟斤拷锟斤拷锟届常锟斤拷");
			e.printStackTrace();
		} finally {
			toClose();
		}
		return list;
	}

	public List<Map<String, Object>> query(String sql) {
		return query(sql, new Object[] {});
	}

	public void batch(String strs[]) {
		try {
			stat = setConn().createStatement();
			conn.setAutoCommit(false);
			for (String st : strs) {
				stat.addBatch(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			stat.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.commit();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		toClose();
	}

}
