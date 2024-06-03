package com.example.restfulWebService.restfulWebServices.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<Users> users = new ArrayList<>();
	
	static int userCount = 0;
	
	static {
		users.add(new Users(++userCount,"Hari",LocalDate.now().minusYears(30)));
		users.add(new Users(++userCount,"Krishna",LocalDate.now().minusYears(27)));
		users.add(new Users(++userCount,"Reddy",LocalDate.now().minusYears(25)));
	}
	
	public List<Users> findAll() {
		return users;
	}

	public Users saveUser(Users user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public Users findOne(int id) {
		Predicate<? super Users> predicate = user -> user.getId() == id ; 
		return users.stream().filter(predicate).findFirst().get();
	}

	public void deleteById(int id) {
		Predicate<? super Users> predicate = user -> user.getId() == id ;
		users.removeIf(predicate);
	}
	
}
