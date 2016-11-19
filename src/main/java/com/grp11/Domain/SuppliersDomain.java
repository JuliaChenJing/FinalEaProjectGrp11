package com.grp11.Domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ROLE_SUPPLIER")
public class SuppliersDomain extends UserDomain {

}
