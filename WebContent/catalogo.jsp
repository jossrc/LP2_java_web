<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
    <link
      href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap5.min.css"
      rel="stylesheet"
    />
    <script src="https://kit.fontawesome.com/2e12710f36.js" crossorigin="anonymous"></script>
    <title>Catálogo</title>
  </head>
  <body>
    <div class="title-container col bg-danger p-2">
      <h1 class="title text-center text-white">Catalogo de Productos</h1>
    </div>

    <div class="container mt-4">
      <a class="btn btn-primary mb-3" href="prod?opcion=cargar"><i class="fas fa-arrow-circle-down"></i> Cargar</a>
      <div class="table-responsive text-nowrap">
        <table id="table" class="table table-hover">
          <thead>
            <tr class="table-dark">
              <th scope="col">Código</th>
              <th scope="col">Descripción</th>
              <th scope="col">Precio</th>
              <th scope="col"><span>Stock</span></th>
              <th scope="col">Marca</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
          
          <%-- Proveniente del servlet (atributo) --%>
          <c:forEach items="${ lstProductos }" var="prod">
       
            <tr>
              <td scope="row">${prod.id }</td>
              <td>${prod.descripcion }</td>
              <td>
                <fmt:setLocale value="es_PE"/>
                <fmt:formatNumber type="currency" value="${prod.precio }" /> 
              </td>
              <td>${prod.stock }</td>
              <td>${prod.idCategoria }</td>
              <td>
                <div class="btn-container">
                  <a
                    href="prod?cod=${prod.id}&opcion=select"
                    class="nav-link"
                  >
                    Click para agregar
                  </a>
                </div>
              </td>
            </tr>
            </c:forEach>
            
          </tbody>
        </table>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
      crossorigin="anonymous"
    ></script>
    
    <script
      src="https://code.jquery.com/jquery-3.5.1.js"
    ></script>
    
    <script
      src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"
    ></script>
    
    <script
      src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap5.min.js"
    ></script>
    
    <script>
      $(document).ready(function() {
          $('#table').DataTable();
      });
    </script>
  </body>
</html>