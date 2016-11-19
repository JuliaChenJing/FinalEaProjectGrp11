package com.grp11.address;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.grp11.address.*;
import com.grp11.customers.*;
/**
 * @author suman
 * Description: AddressService. Call crud operations from here. Add other related methods. Remember SOC and DRY
 */
public class AddressService implements IAddressService {
	private IAddressDao AddressDao;
	public IAddressDao getAddressDao() {
		return AddressDao;
	}
	public void setAddressDao(IAddressDao AddressDao) {
		this.AddressDao = AddressDao;
	}
	@Override
	@Transactional
	public void saveAddress(Address e) {
		AddressDao.saveAddress(e);
	}
	@Override
	@Transactional
	public void updateAddress(Address e) {
		AddressDao.updateAddress(e);
	}
	@Override
	@Transactional
	public Address loadAddress(int eNo) {
		return AddressDao.loadAddress(eNo);
	}
	//@Override
	public Collection<Address> getAddress() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly load!
		return AddressDao.getAddress();
	}
}