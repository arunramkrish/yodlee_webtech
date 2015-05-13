package struts2demo.action;

public class MyStrutsAction {
	private String name;

	public String execute() throws Exception {
		System.out.println(name);
		return "success";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
