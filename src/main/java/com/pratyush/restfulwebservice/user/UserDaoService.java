package com.pratyush.restfulwebservice.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new User(1,"pratyush",LocalDate.now().minusYears(20)));
		users.add(new User(2,"pratyush kr",LocalDate.now().minusYears(10)));
		users.add(new User(3,"pratyush lnu",LocalDate.now().minusYears(19)));
		
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		User user = new User();
		for(int i =0 ; i<users.size();i++) {
			if(users.get(i).getId()==id)
				user = users.get(i);
		}
		if(user.getId()==null)
		 throw new UserNotFoundException("User Not Found for id = "+ id);
		
		return user;
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
}
