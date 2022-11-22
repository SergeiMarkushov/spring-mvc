package ru.gb.repositories;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.gb.model.ProductsEntity;
import ru.gb.model.SessionFactoryUtils;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDAO {
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }


    @Override
    public ProductsEntity findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            ProductsEntity product = session.get(ProductsEntity.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<ProductsEntity> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            List<ProductsEntity> productList = session.createQuery("select p from ProductsEntity p").getResultList();
            session.getTransaction().commit();
            return productList;
        }
    }

    @Override
    public ProductsEntity findByTitle(String title) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            ProductsEntity product = session.createQuery("select product from ProductsEntity product where product.title = :title", ProductsEntity.class)
                    .setParameter("title", title).getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            ProductsEntity product = session.get(ProductsEntity.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }


    @Override
    public ProductsEntity saveOrUpdate(ProductsEntity product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
        return product;
    }

    public ProductsEntity productInfo(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            ProductsEntity product = session.get(ProductsEntity.class, id);
            session.getTransaction().commit();
            return product;
        }
    }
}
