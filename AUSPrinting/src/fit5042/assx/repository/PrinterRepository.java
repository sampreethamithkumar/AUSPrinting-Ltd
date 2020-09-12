package fit5042.assx.repository;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface PrinterRepository {
	public List<Integer> getPrinterId();
}
