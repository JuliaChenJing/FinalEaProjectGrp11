package com.grp11.Consumer;

import java.util.List;


import com.grp11.Domain.UserDomain;

public interface IConsumerService {
	
	public void addConsumer(UserDomain user);
	public UserDomain update(UserDomain user);
	public UserDomain getUser(Long UserId);
	public void deleteUser(Long id);
	public List<UserDomain> getAllUser();
	//public UserDomain getUserbyUserName(String Username);
	
	
}
