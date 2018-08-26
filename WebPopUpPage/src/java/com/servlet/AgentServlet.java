/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.JavaBeanCtWurth;
import com.entidades.CtWurth;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian
 */
public class AgentServlet extends HttpServlet {

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
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "*");
            response.setHeader("Access-Control-Max-Age", "86400");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            JavaBeanCtWurth jbcw = new JavaBeanCtWurth();
            List<CtWurth> lcw =jbcw.findCtWurthEntitiesByUsername(request.getSession().getAttribute("username").toString());
            CtWurth cw;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");  
            out.println("<title>WebPopUpPage</title>");
            out.println("<link rel=\"shortcut icon\" href=\"css/images/favicon.ico\" type=\"image/x-icon\">");
            out.println("<link rel=\"icon\" href=\"css/images/favicon.ico\" type=\"image/x-icon\">");
            out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/bootstrap-switch.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/bootstrap-dialog.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/bootstrap-select.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/bootstrap-datetimepicker.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/bootstrap-progressbar-3.3.4.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/dataTables.bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/responsive.dataTables.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/buttons.dataTables.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/select.bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/jquery.accordion-menu.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/smart_wizard.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/smart_wizard_theme_dots.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/jquery.contextMenu.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"fonts/fontawesome/font-awesome.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/style.css\" rel=\"stylesheet\">");
            out.println("<link href=\"bxpadmin/resources/css/style-responsive.css\" rel=\"stylesheet\">");
            out.println("<link href='css/style_client.css' rel='stylesheet'>");
            out.println("<script src=\"http://code.jquery.com/jquery-2.1.0.min.js\"></script>");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js\"></script>");
            out.println("<script src=\"/javascript/jquery.cookie.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/jquery-ui.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/moment.min.js\"></script>");
            out.println("<script src=\"javascript/bootstrap.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/bootstrap-switch.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/bootstrap-filestyle.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/bootstrap-dialog.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/bootstrap-select.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/bootstrap-datetimepicker.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/bootstrap-progressbar.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/jquery.dataTables.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/dataTables.bootstrap.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/dataTables.responsive.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/dataTables.buttons.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/dataTables.select.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/jquery.contextMenu.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/jszip.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/buttons.html5.min.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/jquery.accordion-menu.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/jquery.nicescroll.min.js\"></script>");
            out.println("<script src=\"javascript/jquery.validate.min.js\"></script>");
            out.println("<script src=\"javascript/jquery.fileDownload.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"javascript/jquery.smartWizard.min.js\"></script>");
            out.println("<script defer=\"\" src=\"javascript/js/highcharts.js\" type=\"text/javascript\"></script>");
            out.println("<script defer=\"\" src=\"javascript/highcharts-data.js\" type=\"text/javascript\"></script>");
            out.println("<script defer=\"\" src=\"javascript/drilldown.js\" type=\"text/javascript\"></script>");
            out.println("<script defer=\"\" src=\"javascript/sidebar.js\" type=\"text/javascript\"></script>");
            out.println("<script defer=\"\" src=\"javascript/script.js\" type=\"text/javascript\"></script>");
            out.println("<script type=\"text/javascript\" src=\"javascript/eventscript.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"javascript/call_actions.js\"></script>");
            out.println("<title>Servlet AgentServlet</title>");            
            out.println("</head>");
            out.println("<body id=\"pageBody\" oncontextmenu=\"return false\">");
                out.println("<div align='right'>");           
                    out.println("Bienvenid@ Sr@ "+request.getSession().getAttribute("fullname").toString());
                    out.println("<a href=\"/WebPopUpPage/login.jsp?cerrar=true\">Cerrar Sesion</a>");
                out.println("</div>"); 
                out.println("<div style=\"display:none; \"   id=\"contextMenu\">");
out.println("<table  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" ");
out.println("style=\"border: thin solid #808080; cursor: default;\" width=\"100px\" bgcolor=\"White\">");
out.println("<tr>");
out.println("<td >");
//out.println("<div  class=\"ContextItem\" onclick=\"alertaName('contextMenu');\">Llamar</div>");
out.println("<div id=\"llamar\" class=\"ContextItem\">Llamar</div>");
out.println("</td>");
out.println("</tr>");/*
out.println("<tr>");
out.println("<td >");
out.println("<div  class=\"ContextItem\">Edit</div>");
out.println("</td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td >");
out.println("<div  class=\"ContextItem\">Delete</div>");
out.println("</td>");
out.println("</tr>");*/
out.println("</table>");
out.println("</div>");
out.println("<section class=\"wrapper\">");
out.println("<div class=\"row\">");
out.println("<div id=\"page-content\">");

            out.println("<table class=\"table table-striped table-bordered dataTable no-footer\">");
                out.println("<thead>");
                    out.println("<tr>");
                        out.println("<th>Nombre</th>");
                        out.println("<th>Apellido Paterno</th>");
                        out.println("<th>Apellido Materno</th>");
                        out.println("<th>RUT Persona</th>");
                        out.println("<th>Teléfono</th>");
                        out.println("<th>Nombre Empresa</th>");
                        out.println("<th>RUT Empresa</th>");
                    out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody id=\""+request.getSession().getAttribute("anexo").toString()+"\" class=\"dataTableBody\">");
            for(int i=0;i<lcw.size();i++){
                String clase = "odd";
                if(i%2==0){
                    clase="even";
                }
                cw = lcw.get(i);
                    out.println("<tr "
                            + "class=\""+clase+"\" "
                            + "id=\"record_"+i+"\" "
                            + "onmousedown=\"HideMenu('contextMenu');\" "
                            + "onmouseup=\"HideMenu('contextMenu');\" "
                            //+ "oncontextmenu=\"ShowMenu('record_"+i+"','contextMenu',event);\" "
                            + "onclick=\"rowSelected('record_"+i+"');\" "
                            + ">");
                      out.println("<td id=\"nombre\">"+cw.getNombre()+"</td>");
                      out.println("<td id=\"apellido_pat\">"+cw.getApellidoPat()+"</td>");
                      out.println("<td id=\"apellido_mat\">"+cw.getApellidoMat()+"</td>");
                      out.println("<td id=\"id_cliente\">"+cw.getIdCliente()+"</td>");
                      out.println("<td id=\"contact_info\">"+cw.getContactInfo()+"</td>");
                      out.println("<td id=\"empresa\">"+cw.getEmpresa()+"</td>");
                      out.println("<td id=\"rut_empresa\">"+cw.getRutEmpresa()+"</td>");
                    out.println("</tr>");
            }
                  out.println("</tbody>");         
            out.println("</table>");
            out.println("</div>");
            out.println("</div>");
            out.println("</section>");
            out.println("</body>");
            out.println("</html>");
            //request.setAttribute("id_cliente", cw.getIdCliente());
            //RequestDispatcher rd = request.getRequestDispatcher("agent.jsp");            
            //rd.forward(request, response);
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
