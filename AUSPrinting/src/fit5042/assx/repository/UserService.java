package fit5042.assx.repository;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fit5042.assx.entities.Users;

@Remote
public interface UserService {
	
	public Users find(String username);
	
}
