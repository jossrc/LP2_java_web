package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductoDTO;
import dao.DAOFactory;
import interfaces.ProductoDAO;
import mantenimientos.MySQLProductoDAO;

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
            case "buscar":
                buscar(request, response);
                break;
            default:
                System.out.println("ERROR EN LAS OPCIONES");
                break;
            }
        } catch (Exception e) {
            // response.sendRedirect("error.jsp");
            System.out.println("Error inesperado en el Producto Servlet");
        }

    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al proceso de busqueda");

        String codigo = request.getParameter("cod");

        ProductoDTO producto = new MySQLProductoDAO().buscar(codigo);

        request.setAttribute("existeProducto", producto);

        request.getRequestDispatcher("/crudproductos.jsp").forward(request, response);

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

        // Usando el Patron DAO
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);        
        ProductoDAO dao = factory.getProductoDAO();
        ArrayList<ProductoDTO> lista = dao.listado();
        
        // Enviar el listado al JSP
        request.setAttribute("lstProductos", lista);
        request.getRequestDispatcher("listado_productos.jsp").forward(request, response);
    }

}
