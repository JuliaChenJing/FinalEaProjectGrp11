package com.grp11.Consumer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp11.Domain.ConsumerDomain;

@Service
@Transactional
public class ConsumerServiceImpl implements IConsumerService{
	
	@Autowired
	private IConsumerDAO consumerDAO;


	@Override
	public void addConsumer(ConsumerDomain user) {
		consumerDAO.save(user);	
		
	}

	@Override
	public ConsumerDomain update(ConsumerDomain user) {
		consumerDAO.save(user);	
		return user;
	}

	@Override
	public ConsumerDomain getUser(Long UserId) {
		ConsumerDomain consumer = consumerDAO.findOne(UserId);
		return consumer;
	}

	@Override
	public void deleteUser(Long UserId) {
		
		consumerDAO.delete(UserId);
		
	}

	@Override
	public List<ConsumerDomain> getAllUser() {
		List<ConsumerDomain> listofConsumer = (List<ConsumerDomain>) consumerDAO.findAll();
		return listofConsumer;
	}
	
	

}
