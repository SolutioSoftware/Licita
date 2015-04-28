/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.filtros;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matheus Oliveira
 */
public class FiltroLogin implements Filter {

    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession sessao = ((HttpServletRequest)request).getSession(false);
        if(sessao.getAttribute("usuario") != null && !sessao.isNew()){
            chain.doFilter(request, response);
        }else{
            ((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "/login/login.xhtml");
        }
    }

    @Override
    public void destroy() {
    }

}
