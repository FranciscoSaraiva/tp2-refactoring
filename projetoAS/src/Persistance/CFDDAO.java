package Persistance;

import Models.*;

import java.util.List;

public class CFDDAO implements DAO {

	public CFD get(int id) {
		// TODO - implement CFDDAO.get
		throw new UnsupportedOperationException();
	}

	public List<CFD> getAll() {
		// TODO - implement CFDDAO.getAll
		throw new UnsupportedOperationException();
	}

	@Override
	public void save(Object o) {

	}

	@Override
	public void update(Object o) {

	}

	@Override
	public void delete(Object o) {
		System.out.println("cfd deleted");
	}

}