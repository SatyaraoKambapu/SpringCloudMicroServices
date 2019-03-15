package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "app_doc_info")
public class AppDocInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	private long application_id;

	private long document_id;

	private String application_name;

	private String document_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getApplication_id() {
		return application_id;
	}

	public void setApplication_id(long application_id) {
		this.application_id = application_id;
	}

	public long getDocument_id() {
		return document_id;
	}

	public void setDocument_id(long document_id) {
		this.document_id = document_id;
	}

	public String getApplication_name() {
		return application_name;
	}

	public void setApplication_name(String application_name) {
		this.application_name = application_name;
	}

	public String getDocument_name() {
		return document_name;
	}

	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}

	@Override
	public String toString() {
		return "AppDocInfo [application_id=" + application_id + ", document_id=" + document_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (application_id ^ (application_id >>> 32));
		result = prime * result + (int) (document_id ^ (document_id >>> 32));
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppDocInfo other = (AppDocInfo) obj;
		if (application_id != other.application_id)
			return false;
		if (document_id != other.document_id)
			return false;

		if (id != other.id)
			return false;

		return true;
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		String s = om.writeValueAsString(new AppDocInfo());
		System.out.println(s);
	}

}
