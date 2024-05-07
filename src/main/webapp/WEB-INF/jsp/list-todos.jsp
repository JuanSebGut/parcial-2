<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div>
        <a type="button" class="btn btn-primary btn-md" href="/add-todo">Adicionar Asignatura</a>
    </div>
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3>Lista de Asignaturas</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nombre de la Asignatura</th>
                        <th>Descripción</th>
                        <th>Salón</th>
                        <th>Horario (Inicio)</th>
                        <th>Horario (Fin)</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.subjectName}</td>
                            <td>${todo.description}</td>
                            <td>${todo.classroom}</td>
                            <td><fmt:formatDate value="${todo.startTime}" pattern="HH:mm" /></td>
                            <td><fmt:formatDate value="${todo.endTime}" pattern="HH:mm" /></td>
                            <td>
                                <a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Actualizar</a>
                                <a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
