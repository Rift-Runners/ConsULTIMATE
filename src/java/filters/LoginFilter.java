/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import controller.SessionBean;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        SessionBean session = (SessionBean) req.getSession().getAttribute("sessionBean");
        String url = req.getRequestURI();

        if (session == null || !session.isLogged) {
            if (url.contains("indexCli.xhtml") || url.contains("indexCons.xhtml") || url.contains("dashboard.xhtml")) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/faces/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (url.contains("dashboard.xhtml")) {
                if (session.clienteIsLogged || session.consultorIsLogged) {
                    resp.sendRedirect(req.getServletContext().getContextPath() + "/faces/index.xhtml");
                }
            }
            if (url.contains("indexCli.xhtml")) {
                if (session.consultorIsLogged || session.adminIsLogged) {
                    resp.sendRedirect(req.getServletContext().getContextPath() + "/faces/index.xhtml");
                }
            }
            if (url.contains("indexCons.xhtml")) {
                if (session.clienteIsLogged || session.adminIsLogged) {
                    resp.sendRedirect(req.getServletContext().getContextPath() + "/faces/index.xhtml");
                }
            }
            if (url.contains("cadastro.xhtml") || url.contains("login.xhtml") || url.contains("esqueceu-senha.xhtml")) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/faces/index.xhtml");
            } else if (url.contains("logout.xhtml")) {
                req.getSession().removeAttribute("sessionBean");
                resp.sendRedirect(req.getServletContext().getContextPath() + "/faces/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
    }

}
