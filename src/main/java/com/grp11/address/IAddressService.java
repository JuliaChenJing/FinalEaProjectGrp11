package com.grp11.address;
import java.util.Collection;

import com.grp11.address.*;

public interface IAddressService {
	public void saveAddress(Address e);
	public void updateAddress(Address e);
	public Address loadAddress(int e);
	public Collection<Address> getAddress();
}