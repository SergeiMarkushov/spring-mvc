package ru.gb;


import ru.gb.model.ProductHW;
import ru.gb.model.SessionFactoryUtils;
import ru.gb.repositories.ProductDAO;
import ru.gb.repositories.ProductDaoImpl;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDAO productDAO = new ProductDaoImpl(sessionFactoryUtils);

            System.out.println(productDAO.findByTitle("Bread"));
            System.out.println(productDAO.findAll());
            productDAO.saveOrUpdate(new ProductHW("Carrot",50));
            System.out.println(productDAO.findAll());
            productDAO.deleteById(4L);
            System.out.println(productDAO.findAll());


    } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutDown();
        }
    }

}
