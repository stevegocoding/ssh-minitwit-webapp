package com.stevegocoding.minitwit.persist.repository;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by magkbdev on 7/21/16.
 */

public interface GenericRepository<I extends Serializable, E extends Serializable> {

    Iterable<E> getAll();

    E get(I id);

    void add(E entity);

    void update(E entity);

    void delete(E entity);

    void deleteById(I id);

}
