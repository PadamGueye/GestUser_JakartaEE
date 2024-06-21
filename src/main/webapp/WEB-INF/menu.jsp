<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/Liste' />">Lister</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/AddUser'/>">Ajouter</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <c:choose>
                    <c:when test="${sessionScope.isConnected != null}">
                        <li class="nav-item">
                            <a class="btn btn-danger text-light" href="<c:url value='/Logout' />">Se Déconnecter</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="btn btn-primary text-light" href="<c:url value='/Auth' />">Se Connecter</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
    </nav>