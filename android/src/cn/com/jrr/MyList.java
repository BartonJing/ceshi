package cn.com.jrr;

public class MyList {
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MyList [id=" + id + ", name=" + name + "]";
	}
	public MyList(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public MyList() {
		
	}
	
	
}
