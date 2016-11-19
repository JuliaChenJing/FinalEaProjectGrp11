package com.grp11.Consumer;

import java.util.List;

import com.grp11.Domain.ConsumerDomain;

public interface IConsumerService {
	
	public void addConsumer(ConsumerDomain user);
	public ConsumerDomain update(ConsumerDomain user);
	public ConsumerDomain getUser(Long UserId);
	public void deleteUser(Long UserId);
	public List<ConsumerDomain> getAllUser();
	
	
}
