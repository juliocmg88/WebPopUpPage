/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.JavaBeanCfgPersons;
import com.bean.JavaBeanTestRegistration;
import com.entidades.CfgPersons;
import com.entidades.TestRegistration;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author Sebastian
 */
public class MServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String firstName = formatNames(request.getParameter("firstname"));
        String middleName = formatNames(request.getParameter("middlename"));
        String lastName = formatNames(request.getParameter("lastname"));
        String lastName2 = formatNames(request.getParameter("lastname2"));
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String rut = request.getParameter("rut");
        String anexo = request.getParameter("anexo");
        String initial=firstName.substring(0, 1).toLowerCase();
        CfgPersons cp = new CfgPersons();
        cp.setUsername(initial+lastName.toLowerCase());
        cp.setFullname((firstName+" "+middleName+" "+lastName+" "+lastName2).replace("  ", " "));
        cp.setUserpwd(BCrypt.hashpw(password, BCrypt.gensalt()));
        cp.setCrrUsername(rut);
        cp.setDefaultexten(anexo);
        JavaBeanCfgPersons cptr = new JavaBeanCfgPersons();
        cptr.guardar(cp);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Guardado Exitoso</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private String formatNames(String name){
        name = name.replace('ñ', 'n');
        name = name.replace('Ñ', 'N');
        name = name.replace('Á', 'A');
        name = name.replace('É', 'E');
        name = name.replace('Í', 'I');
        name = name.replace('Ó', 'O');
        name = name.replace('Ú', 'U');
        name = name.replace('á', 'a');
        name = name.replace('é', 'e');
        name = name.replace('í', 'i');
        name = name.replace('ó', 'o');
        name = name.replace('ú', 'u');
        return name;
    }

}
