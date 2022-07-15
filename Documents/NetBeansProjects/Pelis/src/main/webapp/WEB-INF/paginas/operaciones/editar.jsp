<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
<!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Pelicula</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/382381b436.js" crossorigin="anonymous"></script>
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        
        <form action="${pageContext.request.contextPath}/servletControl?accion=modificar&idpeli=${peli.idpeli}" method="POST" class="was-validated">
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavEdicion.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Pelicula</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Titulo</label>
                                        <input type="text" class="form-control" name="nombre" required="" value="${peli.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="director">Director</label>
                                        <input type="text" class="form-control" name="director" value="${peli.director}">
                                    </div>
                                    <div class="form-group">
                                        <label for="duracion">Duracion en Minutos</label>
                                        <input type="number" class="form-control" name="duracion" required="" value="${peli.duracion}">
                                    </div>
                                    <div class="form-group">
                                        <label for="costo">Costo de la Pelicula (en MM)</label>
                                        <input type="currency" class="form-control" name="costo" required="" value="${peli.costo}">
                                    </div>
                                    <div class="form-group">
                                        <label for="visitas">Visitas recibidas</label>
                                        <input type="number" class="form-control" name="visitas" required="" value="${peli.visitas}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        
        <jsp:include page="/WEB-INF/paginas/comunes/pieDePagina.jsp"/>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
