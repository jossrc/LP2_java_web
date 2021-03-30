<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/crudproductos.css" />
    <title>Mantenimiento de Productos</title>
  </head>
  <body>
    <section id="registro" class="animate__animated animate__fadeIn">
      <div class="container mt-4">
        <div class="row justify-content-center">
          <div class="col-xs-12 col-md-8 col-lg-6">
            <h2 class="text-center mb-4 text-primary">
              Mantenimiento de Productos
            </h2>
            <form
              class="form mb-3 needs-validation row"
              method="post"
              novalidate
            >
              <div class="mb-3">
                <label for="txtCodigoProd" class="form-label"
                  >Código del producto:</label
                >
                <input
                  type="text"
                  name="txtCodigoProd"
                  class="form-control"
                  id="txtCodigoProd"
                  placeholder="Ingrese Código"
                  required
                />
                <div class="invalid-feedback">Ingrese un código válido</div>
              </div>
              <div class="mb-3">
                <label for="txtDescripcionProd" class="form-label"
                  >Descripción :</label
                >
                <input
                  type="text"
                  class="form-control"
                  name="txtDescripcionProd"
                  id="txtDescripcionProd"
                  placeholder="Ingrese nombre o descripción del producto"
                  required
                />
                <div class="invalid-feedback">
                  El nombre o descripción es obligatorio
                </div>
              </div>
              <div class="mb-3 col-md-6 col-xs-12">
                <label for="txtStockProd" class="form-label">Stock :</label>
                <input
                  type="number"
                  name="txtStockProd"
                  class="form-control"
                  id="txtStockProd"
                  placeholder="0"
                  min="0"
                  required
                />
                <div class="invalid-feedback">
                  El campo stock requiere de un número natural
                </div>
              </div>
              <div class="mb-3 col-md-6 col-xs-12">
                <label for="txtPrecioProd" class="form-label">Precio :</label>
                <input
                  type="number"
                  class="form-control"
                  name="txtPrecioProd"
                  id="txtPrecioProd"
                  placeholder="0.00"
                  min="0"
                  step="any"
                  required
                />
                <div class="invalid-feedback">Se requiere un precio válido</div>
              </div>
              <div class="mb-3 col-md-6 col-xs-12">
                <label for="cboCategoriaProd" class="form-label"
                  >Categoría :</label
                >
                <select
                  id="cboCategoriaProd"
                  name="cboCategoriaProd"
                  class="form-select"
                  aria-label="Categoría de Productos"
                  required
                >
                  <option selected disabled hidden="hidden" value="">
                    Seleccione...
                  </option>
                  <option value="1">Pastillas</option>
                  <option value="2">Jarabes</option>
                  <option value="3">Medicamento General</option>
                </select>
                <div class="invalid-feedback">Seleccione una categoría</div>
              </div>
              <div class="mb-3 col-md-6 col-xs-12">
                <label for="cboEstadoProd" class="form-label">Estado :</label>
                <select
                  id="cboEstadoProd"
                  name="cboEstadoProd"
                  class="form-select"
                  aria-label="Estado de Productos"
                  required
                >
                  <option selected disabled hidden="hidden" value="">
                    Seleccione...
                  </option>
                  <option value="1">Activo</option>
                  <option value="0">No Disponible</option>
                </select>
                <div class="invalid-feedback">Seleccione un estado</div>
              </div>

              <div
                class="d-xxs-grid-config-buttons gap-2 d-flex justify-content-sm-start justify-content-evenly"
              >
                <button
                  type="submit"
                  class="btn btn-primary me-md-2"
                  type="button"
                >
                  Registrar
                </button>
                <button class="btn btn-primary me-md-2" type="button">
                  Actualizar
                </button>
                <button class="btn btn-danger me-md-2" type="button">
                  Eliminar
                </button>
                <button class="btn btn-warning me-md-2" type="button">
                  Listado
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
      crossorigin="anonymous"
    ></script>
    <script src="js/form-validator.js"></script>
  </body>
</html>
