package servlets;

import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

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
