package pojo.tool;
/**
 * 更改数据库后
 * @author yejincheng
 *
 */
public class StudentTool {
	private int id;
	private static String attribute; // id,name,age,.....
	
	public static String[] getAttrbute() {
		return attribute.split(",");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAttribute() {
		return StudentTool.attribute;
	}
	public void setAttribute(String attribute) {
		StudentTool.attribute = attribute;
	}
	@Override
	public String toString() {
		return "StuAttribute [id=" + id + ", attribute=" + attribute + "]";
	}
	
}
