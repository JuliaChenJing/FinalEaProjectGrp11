package com.grp11.address;

import java.util.Collection;

public interface IAddressDao {
		public void saveAddress(Address e);
		public void updateAddress(Address e);
		public Address loadAddress(int e);
		public Collection<Address> getAddress();
}