package ru.gb.repositories;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.gb.model.ProductHW;
import ru.gb.model.SessionFactoryUtils;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDAO{
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }



    @Override
    public ProductHW findById(Long id) {
        try  (Session session = sessionFactoryUtils.getSession()){
            session.getTransaction().begin();
            ProductHW productHW = session.get(ProductHW.class, id);
            session.getTransaction().commit();
            return productHW;
        }
    }

    @Override
    public List<ProductHW> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            List<ProductHW> productHWList = session.createQuery("select p from ProductHW p").getResultList();
            session.getTransaction().commit();
            return productHWList;
        }
    }

    @Override
    public ProductHW findByTitle(String title) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            ProductHW productHW = session.createQuery("select product from ProductHW product where product.title = :title", ProductHW.class)
                    .setParameter("title", title).getSingleResult();
            session.getTransaction().commit();
            return productHW;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            ProductHW productHW = session.get(ProductHW.class, id);
            session.delete(productHW);
            session.getTransaction().commit();
        }
    }


    @Override
    public ProductHW saveOrUpdate(ProductHW productHW) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(productHW);
            session.getTransaction().commit();
        }
        return productHW;
    }
}
