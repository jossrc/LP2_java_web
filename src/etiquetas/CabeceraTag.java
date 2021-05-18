package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CabeceraTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    public int doStartTag() throws JspException {

        JspWriter out = pageContext.getOut();

        try {
            out.println("<h1 class='text-center'>CiberFarma Presente</h1>");
        } catch (IOException e) {
            System.out.println("Error en inicio de CabeceraTag : " + e.getMessage());
        }

        return SKIP_BODY;

    }

    public int doEndTag() throws JspException {

        return EVAL_PAGE;

    }

}
