package fit5042.assx.repository;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fit5042.assx.entities.User;

@Remote
public interface UserService {
	
	public User find(String username);
	
}
