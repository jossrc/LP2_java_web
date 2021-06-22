package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DetalleBoletaDTO;
import beans.ProductoDTO;

@WebServlet(name = "venta", urlPatterns = { "/venta" })
public class VentaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public VentaServlet() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Entró al Servlet de Producto");
        String opcion = request.getParameter("opcion");

        try {
            switch (opcion) {
            case "agregar":
                agregarCompra(request, response);
                break;
            case "quitar":
                eliminarCompra(request, response);
                break;
            case "finalizar":
                finalizarCompra(request, response);
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

    public void init(ServletConfig config) throws ServletException {
    }

    public void destroy() {
    }

    private void agregarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Entro al Servlet Venta - opcion agregar");

        // Viene del jsp compra
        int cant = Integer.parseInt(request.getParameter("cantidad"));

        // Viene del seleccionar - prod servlet - posible error y conflicto con otro
        // nombre igual que se manda
        ProductoDTO p = (ProductoDTO) request.getSession().getAttribute("existeProducto");

        // Leer las variables globales
        @SuppressWarnings("unchecked")
        ArrayList<DetalleBoletaDTO> carro = (ArrayList<DetalleBoletaDTO>) request.getSession().getAttribute("carro");

        int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
        double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");

        // Actualizar

        DetalleBoletaDTO detalle = new DetalleBoletaDTO();

        detalle.setIdprod(p.getId());
        detalle.setNomprod(p.getDescripcion());
        detalle.setCantidad(cant);
        detalle.setPreciovta(p.getPrecio());
        detalle.setImporte(cant * p.getPrecio());

        // Agregamos el nuevo detalle al carro

        carro.add(detalle);
        cantArticulos += detalle.getCantidad();
        subTotalVenta += detalle.getImporte();

        // Volver a enviar las variables globales de sesion
        request.getSession().setAttribute("carro", carro);
        request.getSession().setAttribute("subTotalVenta", subTotalVenta);
        request.getSession().setAttribute("canArticulos", cantArticulos);

        System.out.println("Enviando variables");

        response.sendRedirect("canasta.jsp");

    }

    private void eliminarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // cod

        System.out.println("Ingreso al proceso eliminarCompra");

        @SuppressWarnings("unchecked")
        ArrayList<DetalleBoletaDTO> carro = (ArrayList<DetalleBoletaDTO>) request.getSession().getAttribute("carro");
        double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
        int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");

        String idprod = request.getParameter("cod");

        // For (busca alternativa TAREA :v de jose del futuro)
        for (DetalleBoletaDTO d : carro) {
            if (d.getIdprod().equals(idprod)) {
                subTotalVenta -= d.getImporte();
                cantArticulos -= d.getCantidad();
                carro.remove(d);
                break;
            }
        }

        request.getSession().setAttribute("carro", carro);
        request.getSession().setAttribute("subTotalVenta", subTotalVenta);
        request.getSession().setAttribute("canArticulos", cantArticulos);

        System.out.println("Enviando atributos globales a la session");
        
        response.sendRedirect("canasta.jsp");

    }

    private void finalizarCompra(HttpServletRequest request, HttpServletResponse response) {
        // Tarea
    }

}
