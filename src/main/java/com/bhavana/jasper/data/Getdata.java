package com.bhavana.jasper.data;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Getdata {
	@SerializedName("status")
	private String status;

	@SerializedName("data")
	private ArrayList<EmployeeData> edata;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<EmployeeData> getEdata() {
		return edata;
	}

	public void setEdata(ArrayList<EmployeeData> edata) {
		this.edata = edata;
	}

	 @Override
	    public String toString() {
		 String empList = "";

		 for (EmployeeData s : edata) {
		     empList += s + "\n";
		 }
		 
	        return "Getdata{" +
	                "status=" + status + "\n" +
	                "users=" + empList +
	                '}';
	    }
}
