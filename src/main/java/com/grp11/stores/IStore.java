package com.grp11.stores;

import org.springframework.data.repository.CrudRepository;

public interface IStore extends CrudRepository<StoreDomain, Long> {

}
