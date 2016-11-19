package com.grp11.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ROLE_SUPPLIER")
public class SuppliersDomain extends UserDomain {

}
