package thedailyscribbles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thedailyscribbles.model.Blogger;
import thedailyscribbles.repository.Temp;

@Service
public class TempServ {
	@Autowired
	Temp temp;
	
	public void createUser(Blogger user) {
		System.out.println("entered here");
		temp.save(user);
	}
}
