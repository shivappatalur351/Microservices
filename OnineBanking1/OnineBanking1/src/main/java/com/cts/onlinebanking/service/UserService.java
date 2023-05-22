package com.cts.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.onlinebanking.model.UserRegistration;
import com.cts.onlinebanking.model.Users;
import com.cts.onlinebanking.model.Withdraw;
import com.cts.onlinebanking.repository.HIS;
import com.cts.onlinebanking.repository.UserRegistrationRepository;
import com.cts.onlinebanking.repository.UserRepository;

@Service
public class UserService {
	
	UserRepository uRepository;
	UserRegistrationRepository rRepository;
	HIS his;
	@Autowired
	public UserService(UserRepository uRepository,UserRegistrationRepository rRepository ,HIS his) {
	this.uRepository = uRepository;
	this.rRepository=rRepository;
	this.his=his;
	}
	
	public void createUser(UserRegistration userDetails)
	{
		Users user = new Users();
		user.setActive(true);
		user.setPassword(userDetails.getPassword());
		user.setRoles("USER");
		user.setUserName(userDetails.getUserName());
		rRepository.save(userDetails);
		uRepository.save(user);
		
	}
	
	public UserRegistration retriveUserDetails(String name)
	{
		UserRegistration user = rRepository.findByUserName(name);
		return user;
	}

	public String getAuthority(String name) {
		Optional<Users> user = uRepository.findByUserName(name);
		return user.get().getRoles();
	}

	public List<Withdraw> getTransferTransaction(String name) {
		System.out.println("service");
	
		return his.findByUserName(name);

		}
}
