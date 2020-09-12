package fit5042.assx.repository;

import java.util.List;

import javax.ejb.Remote;

import fit5042.assx.entities.Staff;

@Remote
public interface StaffRepository {
	public List<Integer> getStaffId();
}
