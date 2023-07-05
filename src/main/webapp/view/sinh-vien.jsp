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
    <title>Bootrap</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
    <header class="Container"> <h3>Quan Ly Sinh Vien</h3>

    </header>
    <main class="container">
        <section>
            <a href="/sinh-vien/view-add" class="btn btn-success" tabindex="-1" role="button" aria-disabled="true">Add</a>
        </section>
        <section>
            <table>
                <thead>
                <tr>
                    <th scope="col">Mã sinh viên</th>
                    <th scope="col">Tên sinh viên</th>
                    <th scope="col">Tuổi</th>
                    <th scope="col">Địa chỉ</th>
                    <th scope="col">Giới Tính </th>
                    <th colspan="2">Action</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sinhViens}" var="sv">
                    <tr>
                        <td>${sv.maSV}</td>
                        <td>${sv.tenSV}</td>
                        <td>${sv.tuoi}</td>
                        <td>${sv.diaChi}</td>
                        <td>
                            <c:if test="${sv.gioiTinh == 'true' }" >Nam</c:if>
                            <c:if test="${sv.gioiTinh == 'fasle'}">Nữ</c:if>
                        </td>
                        <td>
                <%--      Lấy giá trị của mssv  --%>
                            <a href="/sinh-vien/detail?mssv=${sv.maSV}" class="btn btn-primary" tabindex="-1" role="button" aria-disabled="true">Detail</a>
                            <a href="/sinh-vien/delete?mssv=${sv.maSV}" class="btn btn-danger" tabindex="-1" role="button" aria-disabled="true">Delete</a>
                            <a href="/sinh-vien/view-update?mssv=${sv.maSV}" class="btn btn-success" tabindex="-1" role="button" aria-disabled="true">Update</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>

            </table>


        </section>
    </main>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
