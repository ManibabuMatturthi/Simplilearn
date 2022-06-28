package com;

import java.math.BigDecimal;

public class Eproduct {
	
	private int pid;
	private String pname;
	private BigDecimal price;
	public Eproduct() {	}
	public Eproduct(String pname, BigDecimal price) {
		super();
		this.pname = pname;
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
