package com.myrni.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myrni.entity.OrganizationEducationInstitutionDetailsEO;
import com.myrni.repository.OrganizationEducationInstitutionDetailsRepository;
import com.myrni.requestVo.OrganizationEducationInstitutionDetailsRequestVO;
import com.myrni.responsVO.OrganizationEducationInstitutionDetailsResponceVO1;
import com.myrni.responsVO.OrganizationEducationInstitutionDetailsResponsVO;
import com.myrni.service.OrganizationEducationInstitutionDetailsService;

@Service
public class OrganizationEducationInstitutionDetailsServiceIMPl
		implements OrganizationEducationInstitutionDetailsService {

	@Autowired
	public OrganizationEducationInstitutionDetailsRepository organizationEducationInstitutionDetailsRepository;

	@Override
	public OrganizationEducationInstitutionDetailsResponsVO saveOrganizationEducationInstitutionDetails(
			OrganizationEducationInstitutionDetailsRequestVO orgReqVO) {
		
		OrganizationEducationInstitutionDetailsEO orgEO = new OrganizationEducationInstitutionDetailsEO();
		
		orgEO.setDateOfRagistration(orgReqVO.getDateOfRagistration());
		orgEO.setFcra(orgReqVO.getFcra());
		orgEO.setFullNameOfOrganization(orgReqVO.getFullNameOfOrganization());
		orgEO.setRegistrationNo(orgReqVO.getRegistrationNo());
		
		organizationEducationInstitutionDetailsRepository.save(orgEO);
		OrganizationEducationInstitutionDetailsResponsVO orgRespons= new OrganizationEducationInstitutionDetailsResponsVO("save Organization Education Institution Details");
		

		return orgRespons;
	}

	@Override
	public List<OrganizationEducationInstitutionDetailsResponsVO> fatchAllOrgDetails() {

		
		List<OrganizationEducationInstitutionDetailsEO> listOfEo= organizationEducationInstitutionDetailsRepository.findAll();
		List<OrganizationEducationInstitutionDetailsResponceVO1> listOfOrgVO1= new ArrayList<>();
		for(OrganizationEducationInstitutionDetailsEO orgEO:listOfEo) {
			OrganizationEducationInstitutionDetailsResponceVO1 orgResponceVo= new OrganizationEducationInstitutionDetailsResponceVO1();
			
			orgResponceVo.setDateOfRagistration(orgEO.getDateOfRagistration());
			orgResponceVo.setFcra(orgEO.getFcra());
			orgResponceVo.setFullNameOfOrganization(orgEO.getFullNameOfOrganization());
			orgResponceVo.setRegistrationNo(orgEO.getRegistrationNo());
			listOfOrgVO1.add(orgResponceVo);
			
			
		}

		return null;
	}

//@Override
//public List<OrganizationEducationInstitutionDetailsResponsVO> fatchAllOrgDetails1() {
//	// TODO Auto-generated method stub
//	return null;
//}

}
