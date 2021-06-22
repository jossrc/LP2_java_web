package servlets;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import beans.DetalleBoletaDTO;

@WebListener
public class ProyectoListener implements HttpSessionListener {

    public ProyectoListener() {

    }

    // Se ejecuta cuando se está creando una sesion
    public void sessionCreated(HttpSessionEvent arg0) {
        System.out.println("==============================");
        System.out.println("Empezando a escuchar la sesión");
        System.out.println("==============================");
        System.out.println("ID Sesión          : " + arg0.getSession().getId());
        System.out.println("Fech/Hor acceso    : " + new SimpleDateFormat().format(arg0.getSession().getCreationTime()));
        System.out.println("==============================");
        
        // Variables globales
        ArrayList<DetalleBoletaDTO> carro = new ArrayList<DetalleBoletaDTO>();
        double subTotalVenta = 0.0;
        int cantArticulos = 0;
        
        // Enviar las variables
        arg0.getSession().setAttribute("carro", carro);
        arg0.getSession().setAttribute("subTotalVenta", subTotalVenta);
        arg0.getSession().setAttribute("cantArticulos", cantArticulos);

    }

    // Al cerrar o destruir la sesion
    public void sessionDestroyed(HttpSessionEvent arg0) {
        System.out.println("==============================");
        System.out.println("Dejando de escuchar la sesión");
        System.out.println("==============================");
        System.out.println("ID Sesión               : " + arg0.getSession().getId());
        System.out.println("Fech/Hor último acceso  : " + new SimpleDateFormat().format(arg0.getSession().getLastAccessedTime()));
        System.out.println("==============================");
    }

}
