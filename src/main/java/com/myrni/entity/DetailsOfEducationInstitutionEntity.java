package com.myrni.entity;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "details_of_education_institution")
public class DetailsOfEducationInstitutionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String InstutionType;
	private String InstutionName;
	private String recAttachId;
	private String regAttachId;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "created_by")
	private UUID createdBy;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "updated_by")
	private UUID updatedBy;
	@Column(name = "updated_on")
	private Date updatedOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstutionType() {
		return InstutionType;
	}

	public void setInstutionType(String instutionType) {
		InstutionType = instutionType;
	}

	public String getInstutionName() {
		return InstutionName;
	}

	public void setInstutionName(String instutionName) {
		InstutionName = instutionName;
	}

	public String getRecAttachId() {
		return recAttachId;
	}

	public void setRecAttachId(String recAttachId) {
		this.recAttachId = recAttachId;
	}

	public String getRegAttachId() {
		return regAttachId;
	}

	public void setRegAttachId(String regAttachId) {
		this.regAttachId = regAttachId;
	}

}
