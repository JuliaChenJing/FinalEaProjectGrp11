package com.grp11.stores;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

public class StoreDao implements IStoreDao {
	@Autowired
	private IStore Store;
	@Override
	public void createStore(StoreDomain o) {
		System.out.println(Store.save(o).getClass().getName());
		Store.save(o);
	}
	@Override
	public StoreDomain updateStore(StoreDomain o) {
		System.out.println(Store.save(o).getClass().getName());
		return Store.save(o);
	}
	@Override
	public StoreDomain getStore(Long ordNum) {
		return Store.findOne(ordNum);
	}
	@Override
	public List<StoreDomain> getAllStore() {
		return StreamSupport.stream(Store.findAll().spliterator(), false).collect(Collectors.toList());
	}
	@Override
	public void deleteStore(Long ordNum) {
		Store.delete(ordNum);
	}
}