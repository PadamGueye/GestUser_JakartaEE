<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    final String APP_ROOT = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crud-JEE : Ajout</title>    
    <link rel="stylesheet" href="ressources/styles/styles.css">
</head>
<body>
    <%@include file='/WEB-INF/menu.jsp' %>
    <div class="connexion-container mt-3">
        <h1>Nouvel utilisateur</h1>
        <div class="connexion-form">
                <div class="shadow p-5 mt-5 bg-white rounded w-50">
                    <form method="post" action="AddUser" class="mt-5">
                        <div class="form-group my-3">
                            <label for="prenom" class="form-label">Prénom : </label>
                            <input type="text" value="${user.prenom }" class="form-control ${erreurs == null ? '' : (erreurs.prenom == null ? 'border-success' : 'border-danger' ) }" name="prenom" id="prenom"/>
                            <span class='d-inline mt-2 mb-5 text-danger'>${erreurs.prenom }</span>
                        </div>
                    
                        <div class="form-group my-3">
                            <label for="nom">Nom : </label>
                            <input type="text" value="${user.nom }" class="form-control ${erreurs == null ? '' : (erreurs.nom == null ? 'border-success' : 'border-danger' ) }" name="nom" id="nom"/>
                            <span class='mt-2 mb-5 text-danger'>${erreurs.nom }</span>
                        </div>
                        
                        <div class="form-group my-3">
                            <label for="username">Username : </label>
                            <input type="text" value="${user.username }" class="form-control ${erreurs == null ? '' : (erreurs.username == null ? 'border-success' : 'border-danger' ) }" name="username" id="username"/>
                            <span class='mt-2 mb-5 text-danger'>${erreurs.username }</span>
                        </div>
                        
                        <div class="form-group my-3">
                            <label for="password">Password :</label>
                            <input type="password" class="form-control ${erreurs == null ? '' : (erreurs.password == null ? 'border-success' : 'border-danger' ) }" name="password" id="password"/>
                            <span class='mt-2 mb-5 text-danger'>${erreurs.password }</span>
                        </div>
                        
                        <div class="form-group my-3">
                            <label for="passwordbis">Password - Confirmation :</label>
                            <input type="password" class="form-control ${erreurs == null ? '' : (erreurs.passwordbis == null ? 'border-success' : 'border-danger' ) }" name="passwordbis" id="passwordbis"/>
                            <span class='mt-2 mb-5 text-danger'>${erreurs.passwordbis }</span>
                        </div>
                        
                        <div class='mx-auto mt-5'>
                            <button type="submit" class="btn btn-primary">VALIDER</button>
                        </div>
                    </form>
                </div>
            </div>
    </div>
</body>
    <%@include file='/WEB-INF/footer.jsp' %>
</html>
