package com.vsoft.pss.organization.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.base.entity.Page;
import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.organization.dao.OrganizationDao;
import com.vsoft.pss.organization.entity.Organization;
import com.vsoft.pss.receipt.entity.form.ReceiptForm;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationDao organizationDao;

	public void addOrganization(Organization organization) {
		Map<String, Object> data = DataUtil.parseObjectToMap(organization, Organization.class);
		organizationDao.addOrganization(data);
	}

	public List<Organization> queryAllOrg(ReceiptForm form, Page page) {
		// TODO Auto-generated method stub
		return null;
	}
}
