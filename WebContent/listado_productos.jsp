<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
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
    <script src="https://kit.fontawesome.com/2e12710f36.js" crossorigin="anonymous"></script>
    <title>Listado de Productos</title>
  </head>
  <body>
    <div class="title-container col bg-primary p-2">
      <h1 class="title text-center text-white">Listado de Productos</h1>
    </div>

    <div class="container mt-4">
      <a class="btn btn-primary mb-3" href="prod?opcion=listado"><i class="fas fa-arrow-circle-down"></i> Cargar</a>
      <div class="table-responsive text-nowrap">
        <table class="table table-hover">
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
          
          <%
            @SuppressWarnings("unchecked")
            ArrayList<Producto> lstProductos = (ArrayList<Producto>) request.getAttribute("lstProductos");
            if (lstProductos != null) {
                for (Producto prod : lstProductos) {                   
          %>          
            <tr>
              <th scope="row"><%=prod.getId() %></th>
              <td><%=prod.getDescripcion() %></td>
              <td><%=prod.getPrecio() %></td>
              <td><%=prod.getStock() %></td>
              <td><%=prod.getIdCategoria() %></td>
              <td>
                <div class="btn-container">
                  <a
                    href="prod?cod=<%=prod.getId()%>&opcion=buscar"
                    class="btn btn-success ml-3"
                  >
                    <i class="fas fa-edit"></i>
                  </a>
                  <a
                    href=""
                    class="btn btn-danger"
                  >
                    <i class="fas fa-trash-alt"></i>
                  </a>
                </div>
              </td>
            </tr>
            <% 
               }
             }
            %>
          </tbody>
        </table>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
      crossorigin="anonymous"
    ></script>
  </body>
</html>