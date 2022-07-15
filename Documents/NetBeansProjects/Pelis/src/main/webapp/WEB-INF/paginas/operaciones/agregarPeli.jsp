<div class="modal fade" id="agregarPeliModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title"> Agregar Pelicula </h5>
            </div>
            <form action="${pageContext.request.contextPath}/servletControl?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Titulo</label>
                        <input type="text" class="form-control" name="nombre" required="">
                    </div>
                    <div class="form-group">
                        <label for="director">Director</label>
                        <input type="text" class="form-control" name="director">
                    </div>
                    <div class="form-group">
                        <label for="duracion">Duracion</label>
                        <input type="number" class="form-control" name="duracion" required="">
                    </div>
                    <div class="form-group">
                        <label for="costo">Costo de la pelicula</label>
                        <input type="number" class="form-control" name="costo" required="">
                    </div>
                    <div class="form-group">
                        <label for="visitas">Cantidad de visitas</label>
                        <input type="number" class="form-control" name="visitas" required="">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

