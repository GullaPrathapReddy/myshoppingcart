package net.prathap.shoppingbackend.dto;

public class Catagory {

	private int catagoryid;
	private String catagoryname;
	private String description;
	private String url;
	private boolean active;

	public int getCatagoryid() {
		return catagoryid;
	}

	public void setCatagoryid(int catagoryid) {
		this.catagoryid = catagoryid;
	}

	public String getCatagoryname() {
		return catagoryname;
	}

	public void setCatagoryname(String catagoryname) {
		this.catagoryname = catagoryname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
