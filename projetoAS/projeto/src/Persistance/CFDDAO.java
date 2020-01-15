package Persistance;

import Models.*;

import java.util.List;

public class CFDDAO implements DAO {

	public CFD get(int id) {
		throw new UnsupportedOperationException();
	}

	public List<CFD> getAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void save(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Object o) {
		System.out.println("cfd deleted");
	}

}