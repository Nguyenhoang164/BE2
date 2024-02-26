package com.example.pictureofday.Repository;

import com.example.pictureofday.Model.Picture;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PictureRepository implements IPictureRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Picture findById(int id) {
        TypedQuery<Picture> pictureTypedQuery = entityManager.createQuery("select c from Picture as c where c.id = :id",Picture.class);
        return pictureTypedQuery.getSingleResult();
    }

    @Override
    public void save(Picture picture) {
        entityManager.merge(picture);
    }
}
