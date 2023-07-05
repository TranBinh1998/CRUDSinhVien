package com.poly.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
        public  static EntityManager getEntityManager() {
            // Nạp persistence.xml và tạo EntityManagerFactory
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sinhVien");
            return entityManagerFactory.createEntityManager();

        }

}
