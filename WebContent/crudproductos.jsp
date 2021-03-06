<%@page import="beans.CategoriaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOFactory"%>
<%@page import="beans.ProductoDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools" %>
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
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
    />
    <link rel="stylesheet" href="css/crudproductos.css" />
    <title>Mantenimiento de Productos</title>
  </head>
  <body>
  
    <%    
      ProductoDTO producto = (ProductoDTO) request.getAttribute("existeProducto");
      boolean existeProducto = producto != null;
    %>  
  
    <section id="registro" class="animate__animated animate__fadeIn">
      <div class="container mt-4">
        <div class="row justify-content-center">
          <div class="col-xs-12 col-md-8 col-lg-6">
            <h2 class="text-center mb-4 text-primary">
              Mantenimiento de Productos
            </h2>
            <form
              class="form mb-3 needs-validation row"
              action="prod"
              method="post"
              novalidate
            >
              <div class="mb-3">
                <label for="txtCodigoProd" class="form-label"
                  >C?digo del producto:</label
                >
                <input
                  type="text"
                  name="txtCodigoProd"
                  class="form-control"
                  id="txtCodigoProd"
                  placeholder="Ingrese C?digo"
                  value="<%=existeProducto ? producto.getId() : "" %>"
                  required
                />
                <div class="invalid-feedback">Ingrese un c?digo v?lido</div>
              </div>
              <div class="mb-3">
                <label for="txtDescripcionProd" class="form-label"
                  >Descripci?n :</label
                >
                <input
                  type="text"
                  class="form-control"
                  name="txtDescripcionProd"
                  id="txtDescripcionProd"
                  placeholder="Ingrese nombre o descripci?n del producto"
                  value="<%=existeProducto ? producto.getDescripcion() : "" %>"
                  required
                />
                <div class="invalid-feedback">
                  El nombre o descripci?n es obligatorio
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
                  value="<%=existeProducto ? producto.getStock() : "" %>"
                  required
                />
                <div class="invalid-feedback">
                  El campo stock requiere de un n?mero natural
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
                  value="<%=existeProducto ? producto.getPrecio() : "" %>"
                  required
                />
                <div class="invalid-feedback">Se requiere un precio v?lido</div>
              </div>
              <div class="mb-3 col-md-6 col-xs-12">
                <label for="cboCategoriaProd" class="form-label"
                  >Categor?a :</label
                >                
                <select
                  id="cboCategoriaProd"
                  name="cboCategoriaProd"
                  class="form-select"
                  aria-label="Categor?a de Productos"
                  required
                >
                
                <%
                  DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                  ArrayList<CategoriaDTO> categorias = factory.getProductoDAO().listadoCategoria();
                %>
                  <option <%=existeProducto ? "": "selected" %> disabled hidden="hidden" value="">
                    Seleccione...
                  </option>
                  
                  <%                
                  for( CategoriaDTO categoria: categorias ) {  
                    try {
                  %>
                  <option value="<%=categoria.getId()%>"
                          <%=existeProducto && producto.getIdCategoria() == categoria.getId() ? "selected": "" %>>
                    <%=categoria.getDescripcion() %>
                  </option>

                  <% } catch(Exception e) { } } %>
                               
                </select>
                  
                <select>
                  <tools:comboCat/>
                </select>
                <div class="invalid-feedback">Seleccione una categor?a</div>
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
                  <option <%=existeProducto ? "": "selected" %> disabled hidden="hidden" value="">
                    Seleccione...
                  </option>
                  <%
                    try{ %>

                  <option value="1" 
                          <%=existeProducto && producto.getIdCategoria() == 1 ? "selected": "" %>>
                        Activo
                  </option>
                  <option value="0" 
                          <%=existeProducto && producto.getIdCategoria() == 0 ? "selected": "" %>>
                        No Disponible
                  </option>
                  
                  <% } catch(Exception e) {} %>
                </select>
                <div class="invalid-feedback">Seleccione un estado</div>
              </div>

              <div
                class="d-xxs-grid-config-buttons gap-2 d-flex justify-content-sm-start justify-content-evenly"
              >
                <button
                  type="submit"
                  class="btn btn-primary me-md-2"
                  name="opcion"
                  value="registrar"
                >
                  Registrar
                </button>
                <button
                  class="btn btn-primary me-md-2"
                  type="submit"
                  name="opcion"
                  value="actualizar"
                >
                  Actualizar
                </button>
                <button
                  class="btn btn-danger me-md-2"
                  type="button"
                  name="opcion"
                  value="eliminar"
                >
                  Eliminar
                </button>
                <button
                  class="btn btn-warning me-md-2"
                  type="button"
                  name="opcion"
                  value="listado"
                >
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
