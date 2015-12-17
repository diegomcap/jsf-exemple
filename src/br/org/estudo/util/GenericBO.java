package br.org.estudo.util;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public abstract class GenericBO<PK, T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = Constantes.UNIT_NAME)
    private EntityManager em;

    protected abstract Class<?> getTypeClass();

    @SuppressWarnings("unchecked")
    public T getById(PK pk) {

        return (T) em.find(getTypeClass(), pk);
    }

    public T save(T entity) {

        return em.merge(entity);
    }

    public void delete(T entity) {

        em.remove(em.merge(entity));
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {

        return em.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByNamedQuery(String namedQuery, Object... parameters) {

        Query query = em.createNamedQuery(namedQuery);

        if (parameters != null) {
            int i = 1;

            for (Object object : parameters) {
                if (object != null) {
                    query.setParameter(i++, object);
                }
            }
        }

        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public T findSingleByNamedQuery(String namedQuery, Object... parameters) {

        try {
            Query query = em.createNamedQuery(namedQuery);

            if (parameters != null) {
                int i = 1;

                for (Object object : parameters) {
                    if (object != null) {
                        query.setParameter(i++, object);
                    }
                }
            }

            query.setMaxResults(1);
            T returnEntity = (T) query.getSingleResult();

            return returnEntity;
        } catch (NoResultException e) {
            return null;
        }
    }

    public EntityManager getEntityManager() {

        return em;
    }
}