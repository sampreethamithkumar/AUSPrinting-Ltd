package fit5042.assx.repository;

import javax.ejb.Remote;

import fit5042.assx.entities.Users;

@Remote
public interface UserRepository {

	void addUser(Users user);
}
