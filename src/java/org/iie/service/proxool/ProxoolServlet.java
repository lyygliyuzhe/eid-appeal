/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iie.service.proxool;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logicalcobwebs.proxool.ProxoolFacade;

/**
 *
 * @author yulei
 */
public class ProxoolServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {    
    }    
  
    @Override
    public void destroy() {    
        ProxoolFacade.shutdown();    
    }    
  
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws    
        ServletException, IOException {    
        doGet(request,response);    
    }    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws    
        ServletException, IOException {    
           
    } 
}
