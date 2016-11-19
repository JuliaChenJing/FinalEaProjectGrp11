package com.grp11.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ROLE_CONSUMER")
public class ConsumerDomain extends UserDomain{
	
	
}
