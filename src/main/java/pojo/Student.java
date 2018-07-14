package pojo;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author yejincheng
 *
 */
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String address;
	private Integer age;
	private String sex;
	private String image;//头像路径
	private MultipartFile picture;  
	//private String favorite;
	
//	public String getFavorite() {
//		return favorite;
//	}
//
//
//
//
//	public void setFavorite(String favorite) {
//		this.favorite = favorite;
//	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	
	
	
	








	




	



//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + ", sex=" + sex
//				+ ", image=" + image + ", picture=" + picture + ", favorite=" + favorite + "]";
//	}




	public MultipartFile getPicture() {
		return picture;
	}




	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}




	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}




	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}




	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}




	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}




	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}




	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}




	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}




	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}




	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}




	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}







	

}
