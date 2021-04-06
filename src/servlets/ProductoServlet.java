package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "prod", urlPatterns = { "/prod" })
public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Entró al Servlet de Producto");
        String opcion = request.getParameter("opcion");

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

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Listado");
    }

}
