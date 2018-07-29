import java.util.List;

public interface  DataService<E , I> {
    E findById(I id);
    boolean removeById(I id);
    boolean remove(E entity);
    boolean add(E entity);
    List<E> getAll();
    boolean removeAll();
}
