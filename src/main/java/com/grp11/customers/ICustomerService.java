package com.grp11.customers;
import java.util.Collection;

import com.grp11.address.*;

public interface ICustomerService {
	public void saveCustomer(Customer e);
	public void updateCustomer(Customer e);
	public Customer loadCustomer(int e);
	public Collection<Customer> getCustomers();
}