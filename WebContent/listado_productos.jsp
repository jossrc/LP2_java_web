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
    <title>Listado de Productos</title>
  </head>
  <body>
    <div class="title-container col bg-primary p-2 mt-4">
      <h1 class="title text-center text-white">Listado de Productos</h1>
    </div>

    <div class="container mt-4">
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
            <tr>
              <th scope="row">${prod.codigo}</th>
              <td>${prod.descripcion}</td>
              <td>${prod.precio}</td>
              <td>${prod.stock}</td>
              <td>${prod.nomMarca}</td>
              <td>
                <div class="btn-container">
                  <a
                    href="ServletProducto?tipo=buscar&cod=${prod.codigo}"
                    class="btn btn-success ml-3"
                  >
                    <i class="fas fa-edit">Buscar</i>
                  </a>
                  <a
                    href="ServletProducto?tipo=eliminar&cod=${prod.codigo}"
                    class="btn btn-danger"
                  >
                    <i class="fas fa-trash-alt">Eliminar</i>
                  </a>
                </div>
              </td>
            </tr>
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