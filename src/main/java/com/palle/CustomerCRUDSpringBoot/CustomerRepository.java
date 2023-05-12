package com.palle.CustomerCRUDSpringBoot;

import org.springframework.data.jpa.repository.JpaRepository;

/*
*  JpaRespository<Bean className, PrimaryKey variable type>
* */
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{

}
