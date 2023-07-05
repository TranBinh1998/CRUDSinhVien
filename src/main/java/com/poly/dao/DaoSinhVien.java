package com.poly.dao;

import com.poly.Utils.JpaUtils;
import com.poly.controller.SinhVienServlet;
import com.poly.entity.SinhVien;

import javax.persistence.*;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaoSinhVien {

    public void create(SinhVien sinhVien) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        // Tạo transaction

        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            // Bắt đầu transaction
            entityTransaction.begin();
            entityManager.persist(sinhVien);
            entityTransaction.commit();

        } catch (Exception e) {
            System.out.println("Lỗi trùng id");
        } finally {
            entityManager.close();
        }

    }

    //  Lấy tất cả danh sách học sinh

    public List<SinhVien> findAllSinhVien() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinhVien");
        // Tạo EntityManager để bắt đầu làm việc với CSDL
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            String jpql = "SELECT o FROM SinhVien o";

            // Tạo đối tượng truy vấn
            TypedQuery<SinhVien> query = em.createQuery(jpql, SinhVien.class);

            List<SinhVien> sinhVienList = query.getResultList();

            em.getTransaction().commit();

            return sinhVienList == null || sinhVienList.isEmpty() ? Collections.emptyList() : sinhVienList;

        } catch (Exception e) {
            throw new RuntimeException("Lấy danh sách thất bại!", e);
        } finally {
            em.close();
            emf.close();
        }

    }

    // Viết hàm finnALL sinh cho phân trang
//
//    public List<SinhVien> findAllSinhVien(Pageable pageable) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinhVien");
//        // Tạo EntityManager để bắt đầu làm việc với CSDL
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            String jpql = "SELECT o FROM SinhVien o";
//
//            // Tạo đối tượng truy vấn
//            TypedQuery<SinhVien> query = em.createQuery(jpql, SinhVien.class);
//
//
//            // Thiết lập vị trí bắt đầu và số lượng bản ghi lấy ra
//            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
//            query.setMaxResults(pageable.getPageSize());
//
//            List<SinhVien> sinhVienList = query.getResultList();
//
//            em.getTransaction().commit();
//
//            return sinhVienList == null || sinhVienList.isEmpty() ? Collections.emptyList() : sinhVienList;
//
//        } catch (Exception e) {
//            throw new RuntimeException("Lấy danh sách thất bại!", e);
//        } finally {
//            em.close();
//            emf.close();
//        }
//
//    }


    // Viết hàm xóa sinh viên trong database

    public void deleteSinhVien(String mssv) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sinhVien");

        // Tạo EntityManager để làm việc với Csdl
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            // Find là 1 phương thức trong lớp entityManager cho phép tìm kiếm đối tượng trong cơ sở dữ liệu theo khóa chính (mssv)

            SinhVien sinhVien = entityManager.find(SinhVien.class, mssv);

            entityManager.remove(sinhVien); // Hàm xóa đối tượng

            entityManager.getTransaction().commit(); // Chấp nhận thao tác

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    // Lấy 1 user trong database

    public SinhVien findOneSinhVien(String mssv) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sinhVien");

        // Tạo EntityManager để làm việc với Csdl
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin(); // Bắt đầu Transaction

            String jpql = "SELECT o FROM SinhVien o WHERE o.maSV = :maSv";

            TypedQuery<SinhVien> query = entityManager.createQuery(jpql, SinhVien.class);

            query.setParameter("maSv", mssv);

            // Truy vấn 1 thực thể

            SinhVien sinhVien = query.getSingleResult();

            return sinhVien;
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Lấy Sinh viên thất bại!", e);
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    // Update đối tượng trong database

    public void update(String mssv, String tenSV, int tuoi, String diaChi, boolean gioiTinh) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sinhVien");

        // Tạo EntityManager để làm việc với Csdl
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            entityManager.getTransaction().begin();
            SinhVien sinhVien = entityManager.find(SinhVien.class, mssv);

            // Thay đổi thông tin trên database bằng cách set thông tin
            sinhVien.setTenSV(tenSV);
            sinhVien.setTuoi(tuoi);
            sinhVien.setDiaChi(diaChi);
            sinhVien.setGioiTinh(gioiTinh);

            entityManager.getTransaction().commit(); // Chấp nhận kết quả thao tác

        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }


//    public static void main(String[] args) {
//        DaoSinhVien daoSinhVien = new DaoSinhVien();
//
//        List<SinhVien>  sinhVienList = new ArrayList<>();
//
//        sinhVienList =  daoSinhVien.findAllSinhVien();
//
//        sinhVienList.forEach(sinhVien -> {
//            sinhVien.display();
//        });
//    }

}
