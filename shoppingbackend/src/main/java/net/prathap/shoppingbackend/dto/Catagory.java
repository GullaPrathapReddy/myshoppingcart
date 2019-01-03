package net.prathap.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
@Entity
@Table(name="CATAGORY")
public class Catagory {

	private int catagoryid;
	private String catagoryname;
	private String description;
	private String url;
	private boolean active;
	public Catagory() {
			System.out.println("DTO Object Is Instantiating");
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	@Type(type="int")
	public int getCatagoryid() {
		return catagoryid;
	}

	public void setCatagoryid(int catagoryid) {
		this.catagoryid = catagoryid;
	}

	@Column(name="NAME",length=50)
	@Type(type="string")
	public String getCatagoryname() {
		return catagoryname;
	}

	public void setCatagoryname(String catagoryname) {
		this.catagoryname = catagoryname;
	}
	@Column(name="DESCRIPTION",length=250)
	@Type(type="string")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="IMG_URL",length=50)
	@Type(type="string")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name="IS_ACTIVE")
	@Type(type="boolean")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
