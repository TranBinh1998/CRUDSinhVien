package com.poly.controller;

import com.poly.dao.DaoSinhVien;
import com.poly.entity.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi", // get
        "/sinh-vien/detail",    // get
        "/sinh-vien/delete", // get
        "/sinh-vien/view-update", // get
        "/sinh-vien/update",// post
        "/sinh-vien/view-add", // get
        "/sinh-vien/add" // post
})
public class SinhVienServlet extends HttpServlet {
    private List<SinhVien> listSinhVien = new ArrayList<>();
    private DaoSinhVien daoSinhVien = new DaoSinhVien();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {

            // hiển thị sinh viên
            this.hienThiDanhSachSinhVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailSinhVien(request, response);

        } else if (uri.contains("delete")) {
            this.deleteSinhVien(request, response);

        } else if (uri.contains("view-update")) {
            this.viewUpdateSinhVien(request, response);

        } else if (uri.contains("view-add")) {
            this.viewAddSinhVien(request, response);

        } else {
            // Trang hiển thị sinh viên
            this.hienThiDanhSachSinhVien(request, response);
        }

    }

    private void viewAddSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/add-sinh-vien.jsp").forward(request, response);

    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1, Lấy giá trị từ jsp về severlet
        String mssv = request.getParameter("mssv");
        // B2. Tìm mssv được chọn
        int viTri = -1;
        for (int i = 0; i < listSinhVien.size() ; i++) {
            if (listSinhVien.get(i).getMaSV().equalsIgnoreCase(mssv)) {
                viTri=i;
            }
        }
        SinhVien sv = listSinhVien.get(viTri);
        // b4. Chuyển trang
        request.setAttribute("sinhVien", sv);
        request.getRequestDispatcher("/view/update-sinh-vien.jsp").forward(request,response);
    }

    private void deleteSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mssv = request.getParameter("mssv");
        daoSinhVien.deleteSinhVien(mssv);

        // trở về trang hiển thị
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String mssv = request.getParameter("mssv");

        SinhVien sinhVien = daoSinhVien.findOneSinhVien(mssv);

        // B4 chuyển trang
        request.setAttribute("sinhVien", sinhVien);

        request.getRequestDispatcher("/view/detail-sinh-vien.jsp").forward(request, response);
    }

    private void hienThiDanhSachSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        listSinhVien = daoSinhVien.findAllSinhVien();
//        listSinhVien.sort((o1, o2) -> {
//
//            return o1.getTuoi()-o2.getTuoi();
//        });
        listSinhVien.sort((o1, o2) -> {

            return o1.getMaSV().compareTo(o2.getMaSV());
        });


        // Truyền giá trị từ sevrlet sang controller

        request.setAttribute("sinhViens", listSinhVien);

        // Chuyển trang
        request.getRequestDispatcher("/view/sinh-vien.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI(); // lấy uri
        if (uri.contains("add")) {
            this.addSinhVien(request, response);
        } else {
            // update sinh vien
            this.updateSinhVien(request, response);
        }
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Lấy giá trị từ ô input trong form
        String maSV = request.getParameter("mssv");
        String tenSV = request.getParameter("tenSV");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");

        // Update đối tượng vào database


        daoSinhVien.update(maSV, tenSV, Integer.valueOf(tuoi),diaChi, Boolean.valueOf(gioiTinh));

        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maSV = request.getParameter("mssv");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");

        SinhVien sv = new SinhVien(maSV, ten, Integer.valueOf(tuoi), diaChi, Boolean.valueOf(gioiTinh));

        // b3. add vào list

        daoSinhVien.create(sv);

        //  b4. Chuyển sang trang hiển thị

        response.sendRedirect("/sinh-vien/hien-thi");

    }
}
