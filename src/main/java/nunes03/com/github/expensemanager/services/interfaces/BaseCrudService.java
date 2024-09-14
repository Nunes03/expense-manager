package nunes03.com.github.expensemanager.services.interfaces;

public interface BaseCrudService<D, P, I> {

    D findById(I id);

    P findAll(Integer pageNumber, Integer pageSize);

    D save(D dto);

    void delete(I id);
}
