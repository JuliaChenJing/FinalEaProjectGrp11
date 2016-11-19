package com.grp11.stores;

import java.util.List;


public interface IStoreService {
	public void createStore(StoreDomain o);
	public StoreDomain updateStore(StoreDomain o);
	public StoreDomain getStore(Long ordNum);
	public List<StoreDomain> getAllStore();
	public void deleteStore(Long ordNum);
}
