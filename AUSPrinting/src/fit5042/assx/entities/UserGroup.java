package fit5042.assx.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Groups")
public class UserGroup implements Serializable{
	
	private long id;
	private String userName;
	private String groupName;
	
	
	public UserGroup() {
		
	}


	public UserGroup(long id, String userName, String groupName) {
		super();
		this.id = id;
		this.userName = userName;
		this.groupName = groupName;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	@Column(name="username")
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="groupname")
	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	@Override
	public String toString() {
		return "UserGroup [id=" + id + ", userName=" + userName + ", groupName=" + groupName + "]";
	}
	
	
}
