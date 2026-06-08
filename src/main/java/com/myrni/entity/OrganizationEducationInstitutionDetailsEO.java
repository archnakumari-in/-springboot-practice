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
@Table(name = "organization_education_institution_details")
public class OrganizationEducationInstitutionDetailsEO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "application_id")
	private int applicationIfid;

	@Column(name = "full_name_of_organization")
	private String fullNameOfOrganization;

	@Column(name = "registration_no")
	private int registrationNo;

	@Column(name = "date_of_ragistrati_on")
	private int dateOfRagistration;

	@Column(name = "fcra")
	private String fcra;

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

	public int getApplicationIfid() {
		return applicationIfid;
	}

	public void setApplicationIfid(int appicationIfid) {
		this.applicationIfid = appicationIfid;
	}

	public String getFullNameOfOrganization() {
		return fullNameOfOrganization;
	}

	public void setFullNameOfOrganization(String fullNameOfOrganization) {
		this.fullNameOfOrganization = fullNameOfOrganization;
	}

	public int getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(int registrationNo) {
		this.registrationNo = registrationNo;
	}

	public int getDateOfRagistration() {
		return dateOfRagistration;
	}

	public void setDateOfRagistration(int dateOfRagistration) {
		this.dateOfRagistration = dateOfRagistration;
	}

	public String getFcra() {
		return fcra;
	}

	public void setFcra(String fcra) {
		this.fcra = fcra;
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
