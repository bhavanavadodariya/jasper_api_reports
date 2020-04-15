package com.bhavana.jasper.data;

import com.google.gson.annotations.SerializedName;

public class EmployeeData {
	@SerializedName("id")
	private String id;

	@SerializedName("employee_name")
	private String name;
	
	@SerializedName("employee_salary")
	private String salary;

	@SerializedName("employee_age")
	private String age;

	@SerializedName("profile_image")
	private String image;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "EmployeeData{" +
                "id=" + id +
                ", name=" + name +
                ", salary=" + salary +
                ", age=" + age +
                ", image=" + image +
                '}';
	    }
}
