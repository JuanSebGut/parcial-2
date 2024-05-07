<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Asignatura</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-primary">
                <div class="panel-heading">Adicionar Asignatura</div>
                <div class="panel-body">
                    <form:form method="post" modelAttribute="todo" action="/add-todo">
                        <div class="form-group">
                            <label for="subjectName">Nombre de la Asignatura:</label>
                            <form:input path="subjectName" id="subjectName" class="form-control" required="required"/>
                        </div>

                        <div class="form-group">
                            <label for="description">Descripción:</label>
                            <form:input path="description" id="description" class="form-control" required="required"/>
                        </div>

                        <div class="form-group">
                            <label for="classroom">Salón:</label>
                            <form:input path="classroom" id="classroom" class="form-control" required="required"/>
                        </div>

                        <div class="form-group">
                            <label for="startTime">Hora de Inicio:</label>
                            <form:input path="startTime" id="startTime" class="form-control" type="time" required="required"/>
                        </div>

                        <div class="form-group">
                            <label for="endTime">Hora de Fin:</label>
                            <form:input path="endTime" id="endTime" class="form-control" type="time" required="required"/>
                        </div>

                        <button type="submit" class="btn btn-success">Guardar</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
