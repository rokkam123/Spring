package com.mahesh.annotationConfiguration.HibernateTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public User getUserById(int id) {
		User user = hibernateTemplate.get(User.class, id);
		return user;
	}
	@Transactional
	public void saveUser(User user) {
		hibernateTemplate.save(user);
	}
}
