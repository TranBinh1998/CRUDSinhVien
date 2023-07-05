<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/18/2023
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<header>
    Thông tin Sinh Viên
</header>
<main class="container">
    <section>
        <form action="/sinh-vien/update" method="post">


            <div class="row mt-4">
                <div class="col-6">
                    <label>Mã sinh viên: </label>
                    <input type="text" class="form-control" value="${sinhVien.maSV}" name="mssv">
                </div>
                <div class="col-6">
                    <label>Tên sinh viên: </label>
                    <input type="text" class="form-control" value="${sinhVien.tenSV}" name="tenSV">
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label>Tuổi: </label>
                    <input type="text" class="form-control  " value="${sinhVien.tuoi}" name="tuoi">

                </div>
                <div class="col-6">
                    <label>Gioi Tinh: </label>
                    <input type="radio" name="gioiTinh" value="true" ${sinhVien.gioiTinh == true ?"checked":""}>Nam
                    <input type="radio" name="gioiTinh" value="false" ${sinhVien.gioiTinh == false ?"checked":""}>Nữ

                </div>
            </div>
            <div class="row mt-4">
                <div class="col-12">
                    <label>Địa Chỉ: </label>
                    <input type="text" class="form-control" value="${sinhVien.diaChi}" name="diaChi">


                </div>
            </div>
            <div class="row mt-4">
                <button class="btn btn-primary col-1 m3" type="submit">
                    Update
                </button>

            </div>

        </form>
    </section>

</main>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>