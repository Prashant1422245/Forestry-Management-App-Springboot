package com.cg.fms.service;



import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cg.fms.entities.Admin;
import com.cg.fms.exception.ConfirmPasswordException;
import com.cg.fms.exception.InvalidEmailAndPassword;
import com.cg.fms.exception.UserDoesNotExist;
import com.cg.fms.exception.UserEmailAlreadyExistException;
import com.cg.fms.exception.UserNameException;
import com.cg.fms.exception.*;

@Service
public interface IAdminService {
	// for registration
	public Admin save(Admin admin)throws AdminEmailAlreadyExistException, AdminNameException, ConfirmPasswordException;
	
	// for login
	public boolean findByEmailAndPassword(String email,String password) throws InvalidEmailAndPassword;

	// for deleting
	public void deleteAdmin(Long valueOf) throws AdminDoesNotExist;

	// for updating
	public Admin updateAdmin(@Valid Admin admin);

//	User getByEmail(String email) throws UserDoesNotExist;
	// by default ABSTRACT methods are public 
	
	// List<User> fetchAll();
	public Admin getByEmail(String email) throws AdminDoesNotExist;
	 

}
