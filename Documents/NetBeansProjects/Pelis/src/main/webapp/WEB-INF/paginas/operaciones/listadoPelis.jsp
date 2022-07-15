<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/>
<section id="pelis">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4>
                            Listado de Peliculas
                        </h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Director</th>
                                <th>Duracion</th>
                                <th>Costo</th>
                                <th>Visitas</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="peli" items="${pelis}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${peli.nombre}</td>
                                    <td>${peli.director}</td>
                                    <td>${peli.duracion}</td>
                                    <td><fmt:formatNumber value="${peli.costo}" type="currency"/></td>
                                    <td>${peli.visitas}</td>
                                    <td>
                                            <a href="${pageContext.request.contextPath}/servletControl?accion=editar&idpeli=${peli.idpeli}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Cantidad de visitas</h3>
                        <h4 class="display-4">${cantidadVisitas}</h4>
                    </div>
                </div>
                <div class="card text-cnter bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Inversion total de produccion</h3>
                        <h4 class="display-4"><fmt:formatNumber value="${costoTotal}" type="currency"/></h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarPeli.jsp"/>

