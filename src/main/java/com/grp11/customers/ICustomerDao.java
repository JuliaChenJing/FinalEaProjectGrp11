package com.grp11.customers;
import java.util.Collection;

public interface ICustomerDao {
		public void saveCustomer(Customer e);
		public void updateCustomer(Customer e);
		public Customer loadCustomer(int e);
		public Collection<Customer> getCustomer();
}