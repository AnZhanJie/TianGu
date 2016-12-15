package util;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import freemarker.template.utility.Execute;

public class Test extends ActionSupport{
	private String path;
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	public String getAAA(){
		path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/images");
		ProductDao dao = new ProductDaoImpl();
		path = dao.query(path);
		return "success";
	}
}
