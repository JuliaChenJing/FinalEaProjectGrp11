package com.grp11.stores;

import java.util.Collection;

public interface IStoreDao {
		public void saveStore(Store e);
		public void updateStore(Store e);
		public Store loadStore(int e);
		public Collection<Store> getStore();
}