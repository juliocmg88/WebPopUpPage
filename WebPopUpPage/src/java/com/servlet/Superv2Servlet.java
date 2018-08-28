/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.JavaBeanCfgPersons;
import com.entidades.CfgPersons;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian
 */
public class Superv2Servlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            JavaBeanCfgPersons jbcp = new JavaBeanCfgPersons();
            List<CfgPersons> lcp = jbcp.findCfgPersonsByLoginId(1);
            CfgPersons monitor=null;
            for(int i=0;i<lcp.size();i++){
                CfgPersons cp = lcp.get(i);
                if (cp.getUsername().equals("monitor")) {
                    monitor=cp;
                }
            }
            if (monitor != null) {
                lcp.remove(monitor);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
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
            out.println("<link href='css/save_obsv.css' rel='stylesheet'>");
            out.println("<script src=\"javascript/jquery-2.1.0.min.js\"></script>");
            out.println("<script src=\"javascript/1.10.4.jquery-ui.min.js\"></script>");
            out.println("<script src=\"javascript/jquery.cookie.js\" type=\"text/javascript\"></script>");
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
            out.println("<script type=\"text/javascript\" src=\"javascript/supervisor_actions.js\"></script>");
            out.println("<head>");
            out.println("<title>Página de Supervisor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='right'>");           
                    out.println("Bienvenid@ Sr@ "+request.getSession().getAttribute("fullname").toString());
                    out.println("<a href=\"/WebPopUpPage/log_in.jsp?cerrar=true\">Cerrar Sesion</a>");
            out.println("</div>"); 
            out.println("<div>");
                out.println("<h3>Página de Supervisor</h3>");
                out.println("<label for=\"report_type_box\">Seleccione Tipo de Reporte a Visualizar:</label><br>");
                out.println("<select id=\"report_type_box\" name=\"report_type\">");
                    out.println("<option value=\"detail\">Detalle de Gestiones</option>");
                    out.println("<option value=\"general\">Resumen Total de Gestiones</option>");
                out.println("</select><br><br>");                 
                out.println("<label>Seleccione Rango de Fechas:</label><br>");
                out.println("<label for=\"date_from\">Desde: </label>");
                out.println("<input type=\"date\" name=\"date_from\" id=\"date_from\"><br>");
                out.println("<label for=\"date_to\">Hasta: </label>");
                out.println("<input type=\"date\" name=\"date_to\" id=\"date_to\"><br><br>");
                out.println("<label>Seleccione Ejecutivos: </label><br>");
                out.println("<label class=\"radio-inline\"><input type=\"radio\" name=\"select_user\" id=\"select_user_all\" value=\"all\" checked/>Todos</label>");
                out.println("<label class=\"radio-inline\"><input type=\"radio\" name=\"select_user\" id=\"select_user_some\" value=\"some\"/>Filtrar por Nombre: <strong style=\"color:green;font-size:small\">(Dejar vacío para ver todos)</strong></label><br>");  
                out.println("<select id=\"agent_box\" name=\"agent_box\" multiple>");
                for(int i=0;i<lcp.size();i++){
                    CfgPersons defaultCp = lcp.get(i);
                    out.println("<option value=\""+defaultCp.getUsername()+"\">"+defaultCp.getFullname()+"</option>");
                }
                out.println("</select><br>");
            out.println("</div>");
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

}
