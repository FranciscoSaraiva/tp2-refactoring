package Persistance;

import java.util.List;

public class FavoritoDAO implements DAO {
    @Override
    public Object get(int id) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void save(Object o) {
		//@SMELL dispensable
    }

    @Override
    public void update(Object o) {
		//@SMELL dispensable
    }

    @Override
    public void delete(Object o) {
        System.out.println("fav deleted");
    }
}
