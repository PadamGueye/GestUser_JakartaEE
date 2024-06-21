<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion - Crud-JEE</title>
    <link rel="stylesheet" href="ressources/styles/styles.css">
</head>
<body>
    <%@include file='/WEB-INF/menu.jsp' %>

    <div class="connexion-container">
        <h1 class="connexion-title">Connexion</h1>
        <div class="connexion-form shadow p-5 bg-white rounded">
            <form method="post" action="<c:url value='/Auth' />">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" name="username" id="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" name="password" id="password" required>
                </div>
                <button type="submit" class="btn btn-primary">VALIDER</button>
            </form>
            <p class="text-danger">${status }</p>
        </div>
    </div>
</body>
    <%@include file='/WEB-INF/footer.jsp' %>
</html>
