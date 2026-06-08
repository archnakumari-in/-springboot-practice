package com.myrni.requestVo;

import java.sql.Date;
import java.util.UUID;

public class DetailsOfEducationInstitutionResponsVO {
	
	
	private String InstutionType;
	private String InstutionName;
	private String recAttachId;
	private String regAttachId;

	private Boolean isActive;

	private UUID createdBy;

	private Date createdOn;

	private UUID updatedBy;

	private Date updatedOn;

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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public UUID getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public UUID getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(UUID updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	

}
