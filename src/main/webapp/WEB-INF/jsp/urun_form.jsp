<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Ürün Ekle</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body background="https://www.webtekno.com/images/editor/default/0002/92/3c38d88834e0edcb4fb54d961566b8403fb1881d.jpeg">
<body>

<div class="container">
    <spring:url value="/urun/addUrun" var="addURL" />
    <h2>Ürün Ekle</h2>
    <form:form modelAttribute="urunForm" method="post" action="${addURL}" cssClass="form" >
        <form:hidden path="id"/>
        <div class="form-group">
            <label>Ürün Adı</label>
            <form:input path="adi" cssClass="form-control" id="adi" />
        </div>
        <div class="form-group">
            <label>Birim Fiyat</label>
            <form:input path="birimfiyat" cssClass="form-control" id="birimfiyat" />
        </div>

        <div class="form-group">
            <label>Ürün Kodu</label>
            <form:input path="kod" cssClass="form-control" id="kod" />
        </div>

        <div class="form-group">
            <label>Stok Miktarı</label>
            <form:input path="stokmiktari" cssClass="form-control" id="stokmiktari" />
        </div>

        <div class="form-group">
            <label>Kategori</label>
            <form:input path="kategori" cssClass="form-control" id="kategori" />
        </div>


        <button type="submit" class="btn btn-success">Ürün Ekle</button>
    </form:form>

</div>
</body>
</html>