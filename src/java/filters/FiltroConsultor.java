/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import controller.SessionBean;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Guilherme Matuella
 * @author Diego Peixoto
 */
@WebFilter(filterName = "FiltroConsultor", description = "Filtro dedicado ao controle dos consultores e seus respectivos acessos",
        urlPatterns = {"/faces/meus-clientes.xhtml"})
public class FiltroConsultor implements Filter {

    @Inject
    private SessionBean session;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (session == null || !session.consultorIsLogged) {
            resp.sendRedirect(req.getServletContext().getContextPath() + "/faces/index.xhtml");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}
