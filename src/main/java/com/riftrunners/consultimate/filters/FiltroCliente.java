/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riftrunners.consultimate.filters;

import com.riftrunners.consultimate.controller.SessionBean;
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
@WebFilter(filterName = "FiltroCliente", description = "Filtro dedicado ao controle dos clientes e seus respectivos acessos",
        urlPatterns = {"/faces/consultor-detalhes.xhtml", "/faces/consultores.xhtml"})
public class FiltroCliente implements Filter {

    @Inject
    private SessionBean session;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (session == null) {
            resp.sendRedirect(req.getServletContext().getContextPath() + "/faces/index.xhtml");
        } else if (session.isClienteLogged()) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect(req.getServletContext().getContextPath() + "/faces/index.xhtml");
        }
    }

    @Override
    public void destroy() {
    }

}
