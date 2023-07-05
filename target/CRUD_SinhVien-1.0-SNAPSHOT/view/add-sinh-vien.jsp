<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/18/2023
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" \
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<header class="container">
    <h3>Thêm thông tin Sinh viên</h3>

</header>
    <main class="container">
        <section>
            <form action="/sinh-vien/add" method="post">
                <div class="row mt-4">
                    <div class="col-6">
                        <label>Mã sinh viên</label>
                        <input type="text" class="form-control" name="mssv" placeholder="Mã Sinh viên" required>
                    </div>
                    <div class="col-6">
                        <label>Tên sinh viên</label>
                        <input type="text" class="form-control" name="ten" required>
                    </div>

                </div>
                <div class="row mt-4">
                    <div class="col-6">
                        <label>Tuổi</label>
                        <input type="text" class="form-control" name="tuoi" required>
                    </div>
                    <div class="col-6">
                        <label>Gioi tinh</label>
                        <input type="radio" name="gioiTinh" value="true" checked > Nam
                        <input type="radio" name="gioiTinh" value="false"  > Nữ
                    </div>
                </div>
                <div class="row mt-4" >
                    <div class="col-12">
                        <label>Địa Chỉ</label>
                        <input type="text" class="form-control" name="diaChi" required>
                    </div>
                </div>
                <div class="row mt-4">
                    <button class="btn btn-success col-1 m-3" type="submit">
                        Addd
                    </button>
                </div>


            </form>

        </section>


    </main>
</body>
</html>
