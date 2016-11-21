package com.grp11.Consumer;

import org.springframework.data.repository.CrudRepository;

import com.grp11.Domain.UserDomain;


public interface IConsumerDAO extends CrudRepository<UserDomain, Long>{


}
