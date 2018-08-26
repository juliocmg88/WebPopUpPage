/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.JavaBeanCfgPersons;
import com.bean.JavaBeanCtWurth;
import com.bean.JavaBeanTestRegistration;
import com.entidades.CfgPersons;
import com.entidades.CtWurth;
import com.entidades.TestRegistration;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCrypt;
/**
 *
 * @author Sebastian
 */
public class LoginServlet extends HttpServlet {

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
        JavaBeanCfgPersons jbcp = new JavaBeanCfgPersons();
        JavaBeanCtWurth jbcw = new JavaBeanCtWurth();
        CtWurth cw = null;
        //List <TestRegistration> listaTR = jbtr.buscarTodos();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */            
            RequestDispatcher rd = null;
            int nivel=-1;
            String username="";
            String fullname="";
            String anexo="";
            boolean validaNullEntry=true;
            if(request.getParameter("usernameBox").isEmpty() || request.getParameter("passwordBox").isEmpty()){
                validaNullEntry=false;
            }
            if(request.getParameter("usernameBox")==null || request.getParameter("passwordBox")==null){
                validaNullEntry=false;
            } 
            CfgPersons cp = jbcp.getCfgPersonsByUsername(request.getParameter("usernameBox"));
            boolean validaPwd = BCrypt.checkpw(request.getParameter("passwordBox"), cp.getUserpwd());
            if(validaPwd){
                nivel = cp.getLoginid();
                username = cp.getUsername(); 
                fullname = cp.getFullname();
                anexo = cp.getDefaultexten();
                List<CtWurth> lcw =  jbcw.findCtWurthEntitiesByUsername(username);
                if(!lcw.isEmpty()){                    
                    cw = lcw.get(0);
                }
            }
            if(validaNullEntry && nivel>=0 && validaPwd){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            out.println("<b>"+validaNullEntry+"</b>");
            out.println("<tr>");
                out.println("<th>Nombre</th>");
            out.println("</tr>");
            //for(TestRegistration tr : listaTR){
                out.println("<tr>");
                out.println("<td>"+cp.getFullname()+"</td>");
                out.println("</tr>");
                
            //}          
            out.println("</table>");
            out.println("<h1>Servlet MServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");   
            request.setAttribute("nivel", nivel);
            request.setAttribute("username", username);
            request.setAttribute("fullname", fullname);
            request.setAttribute("anexo", anexo);
            //request.setAttribute("id_cliente", cw.getIdCliente());
            }
            rd= request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }  
        catch(Exception e){
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE,null,e);
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

}
