package com.grp11.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ROLE_ADMIN")
public class AdminDomain extends UserDomain{
	
}
