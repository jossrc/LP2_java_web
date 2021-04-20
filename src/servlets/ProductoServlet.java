package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionProducto;
import model.Producto;

@WebServlet(name = "prod", urlPatterns = { "/prod" })
public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Entró al Servlet de Producto");
        String opcion = request.getParameter("opcion");

        try {
            switch (opcion) {
              case "registrar":
                  registrar(request, response);
                  break;
              case "actualizar":
                  actualizar(request, response);
                  break;
              case "eliminar":
                  eliminar(request, response);
                  break;
              case "listado":
                  listar(request, response);
                  break;
              default:
                  System.out.println("ERROR EN LAS OPCIONES");
                  break;
            }
        } catch (Exception e) {
            //response.sendRedirect("error.jsp");
            System.out.println("Error inesperado en el Producto Servlet");
        }

    }

    private void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Registrar");
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Actualizar");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Eliminar");
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Listado");

        // Obtener el listado
        ArrayList<Producto> lista = new GestionProducto().listado();
        // Enviar el listado al JSP
        request.setAttribute("lstProductos", lista);
        request.getRequestDispatcher("listado_productos.jsp").forward(request, response);
    }

}
