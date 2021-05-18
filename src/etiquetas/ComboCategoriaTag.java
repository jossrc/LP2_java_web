package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.CategoriaDTO;
import dao.DAOFactory;

public class ComboCategoriaTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    public int doStartTag() throws JspException {

        JspWriter out = pageContext.getOut();

        try {
            
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            ArrayList<CategoriaDTO> lista = factory.getProductoDAO().listadoCategoria();
            
            for (CategoriaDTO categoria : lista) {
                out.println("<option value='"+ categoria.getId() +"'>"+ categoria.getDescripcion() +"</option>");
            }
            
            out.println("<h1 class='text-center'>CiberFarma Presente</h1>");
        } catch (IOException e) {
            System.out.println("Error en inicio de ComboCategoriaTag : " + e.getMessage());
        }

        return SKIP_BODY;

    }

    public int doEndTag() throws JspException {

        return EVAL_PAGE;

    }

}
