package com.myAbility.collection.login.DAO;

import org.springframework.stereotype.Repository;

@Repository
public interface IloginDAO {
	
	public loginDTO selectLogininfo(String userId);

	public int updateLogininfo(loginDTO userInfo);
}
