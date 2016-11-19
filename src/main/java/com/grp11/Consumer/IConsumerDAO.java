package com.grp11.Consumer;

import org.springframework.data.repository.CrudRepository;

import com.grp11.Domain.ConsumerDomain;

public interface IConsumerDAO extends CrudRepository<ConsumerDomain, Integer>{

}
