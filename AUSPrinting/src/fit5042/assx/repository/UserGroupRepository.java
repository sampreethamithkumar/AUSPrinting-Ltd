package fit5042.assx.repository;

import javax.ejb.Remote;

import fit5042.assx.entities.UserGroup;

@Remote
public interface UserGroupRepository {

	void addUser(UserGroup userGroup);
}
