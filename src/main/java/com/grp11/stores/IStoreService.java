package com.grp11.stores;
import java.util.Collection;

import com.grp11.address.*;

public interface IStoreService {
	public void saveStore(Store e);
	public void updateStore(Store e);
	public Store loadStore(int e);
	public Collection<Store> getStore();
}