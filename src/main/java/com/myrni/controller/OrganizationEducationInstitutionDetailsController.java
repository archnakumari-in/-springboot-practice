package com.myrni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrni.requestVo.OrganizationEducationInstitutionDetailsRequestVO;
import com.myrni.responsVO.OrganizationEducationInstitutionDetailsResponsVO;
import com.myrni.service.OrganizationEducationInstitutionDetailsService;

@RestController
@RequestMapping("/org-education-institution-details")
public class OrganizationEducationInstitutionDetailsController {
	@Autowired
	public OrganizationEducationInstitutionDetailsService orgService ;
	
	@PostMapping("/org-e-i-d")
	public OrganizationEducationInstitutionDetailsResponsVO saveOrganizationEducationInstitutionDetails(@RequestBody OrganizationEducationInstitutionDetailsRequestVO orgReqVO) {
		OrganizationEducationInstitutionDetailsResponsVO orgRespons= orgService.saveOrganizationEducationInstitutionDetails(orgReqVO);
		return orgRespons;
		
	}
	
	@GetMapping("/fatch-all-org-details")
	public List<OrganizationEducationInstitutionDetailsResponsVO> fatchAllOrgDetails() {
		List<OrganizationEducationInstitutionDetailsResponsVO> listOfVo= orgService.fatchAllOrgDetails();
		return listOfVo;
		
	}



}
