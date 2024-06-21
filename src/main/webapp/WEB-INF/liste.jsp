<%@page import="beans.Utilisateur, java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <title>Crud-JEE : Lister Utilisateur</title>
    <link rel="stylesheet" href="ressources/styles/styles.css">
</head>
<body>
    <%@include file='/WEB-INF/menu.jsp' %>

    <div class="connexion-container">
        <h1 id="titre-principal">Liste des utilisateurs</h1>
        <div class="table-container">
        	<div class="my-5">
            <c:choose>
                <c:when test="${empty requestScope.users}">
                    <p>La liste des utilisateurs est pour le moment vide !</p>
                </c:when>
                <c:otherwise>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Prénom</th>
                                <th>Nom</th>
                                <th>Login</th>
                                <th>Password</th>
                                <th colspan="2">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.prenom}</td>
                                    <td>${user.nom}</td>
                                    <td>${user.username}</td>
                                    <td>${user.password}</td>
                                    <td><a href="<c:url value='/update?id=${user.id}'/>">Modifier</a></td>
                                    <td><a href="<c:url value='/delete?id=${user.id}'/>" onclick="return confirmSuppression()">Supprimer</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
        </div>
    </div>
</body>
    <%@include file='/WEB-INF/footer.jsp' %>
</html>
