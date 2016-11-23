package com.grp11.Consumer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp11.Domain.UserDomain;

@Service
@Transactional
public class ConsumerServiceImpl implements IConsumerService{
	
	@Autowired
	private IConsumerDAO consumerDAO;


	@Override
	public void addConsumer(UserDomain user) {
		consumerDAO.save(user);	
		
	}

	@Override
	public UserDomain update(UserDomain user) {
		consumerDAO.save(user);	
		return user;
	}

	@Override
	public UserDomain getUser(Long UserId) {
		UserDomain consumer = consumerDAO.findOne(UserId);
		return consumer;
	}

	@Override
	public void deleteUser(Long UserId) {
		
		consumerDAO.delete(UserId);
		
	}

	@Override
	public List<UserDomain> getAllUser() {
		List<UserDomain> listofConsumer = (List<UserDomain>) consumerDAO.findAll();
		return listofConsumer;
	}

	@Override
	public UserDomain getUserbyUserName(String Username) {
		return consumerDAO.findByUsername(Username);
	}

	@Override
	public Long getUserIdByUserName(String Username) {
		UserDomain u = getUserbyUserName(Username);
		return u.getId();
	}

	/*@Override
	public UserDomain getUserbyUserName(String username) {
		// TODO Auto-generated method stub
		return consumerDAO.findByUsername(username);
		
	}
	*/
	

}
