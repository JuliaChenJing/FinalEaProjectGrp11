package com.grp11.customers;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.grp11.address.*;
import com.grp11.customers.*;
/**
 * @author suman
 * Description: CustomerService. Call crud operations from here. Add other related methods. Remember SOC and DRY
 */
public class CustomerService implements ICustomerService {
	private ICustomerDao CustomerDao;
	public ICustomerDao getCustomerDao() {
		return CustomerDao;
	}
	public void setCustomerDao(ICustomerDao CustomerDao) {
		this.CustomerDao = CustomerDao;
	}
	@Override
	@Transactional
	public void saveCustomer(Customer e) {
		CustomerDao.saveCustomer(e);
	}
	@Override
	@Transactional
	public void updateCustomer(Customer e) {
		CustomerDao.updateCustomer(e);
	}
	@Override
	@Transactional
	public Customer loadCustomer(int eNo) {
		return CustomerDao.loadCustomer(eNo);
	}
	@Override
	public Collection<Customer> getCustomers() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly load!
		return CustomerDao.getCustomer();
	}
}