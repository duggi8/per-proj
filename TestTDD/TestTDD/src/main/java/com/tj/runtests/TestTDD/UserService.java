package com.tj.runtests.TestTDD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private NameService nameService;
	
	public String getUserName(int id) {
		return nameService.getUserName(id);
	}
	
	
}
