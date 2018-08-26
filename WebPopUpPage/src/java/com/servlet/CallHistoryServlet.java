/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.JavaBeanLogSurveyInteractionsWebPage;
import com.entidades.HistoricoGestion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian
 */
public class CallHistoryServlet extends HttpServlet {

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
            String histCliente = request.getParameter("histCliente");
            JavaBeanLogSurveyInteractionsWebPage jbl = new JavaBeanLogSurveyInteractionsWebPage();
            List objList=jbl.getHistoricoGestion(histCliente);
            List<HistoricoGestion> hgl = new ArrayList<>();
            for(int i=0;i<objList.size();i++){
                Object[] obj = (Object[]) objList.get(i);
                HistoricoGestion hg = new HistoricoGestion();
                hgl.add(hg);
                for (int j=0;j<obj.length;j++){
                    Object objColumn = obj[j];
                    switch(j){
                        case 0: 
                            hgl.get(i).setFechaLlamada((Date)objColumn);
                            break;
                        case 1: 
                            hgl.get(i).setUserAgent(objColumn.toString());
                            break;
                        case 2: 
                            hgl.get(i).setnClient(objColumn.toString());
                            break;
                        case 3: 
                            hgl.get(i).setNameClient(objColumn.toString());
                            break;
                        case 4: 
                            hgl.get(i).setTelefono(objColumn.toString());
                            break;
                        case 5: 
                            hgl.get(i).setTipificacion(objColumn.toString());
                            break;
                        case 6: 
                            hgl.get(i).setPregNombre(objColumn.toString());
                            break;
                        case 7: 
                            hgl.get(i).setPregCotiza(objColumn.toString());
                            break;
                        case 8: 
                            hgl.get(i).setObservaciones(objColumn.toString());
                            break;
                        default: break;
                    }
                }
            }
            Object[] object = (Object[]) objList.get(3) ;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");            
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
            out.println("<title>Historico de Gestión</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
                out.println("<thead>");                
                out.println("<tr>");   
                    out.println("<th>Fecha de Gestion</th>"); 
                    out.println("<th>Id Usuario que Gestionó</th>");
                    out.println("<th>NClient</th>");
                    out.println("<th>Nombre de Cliente</th>");
                    out.println("<th>Telefono</th>");
                    out.println("<th>Tipifiacion</th>");
                    out.println("<th>Pregunta Nombre</th>");
                    out.println("<th>Envio Cotizacion</th>");
                    out.println("<th>Observaciones</th>");
                out.println("</tr>");
                //out.println("<h1>NCliente " + object[2]+ "</h1>"); 
                out.println("<thead>");  
                out.println("<tbody>");     
                for(int k=0;k<hgl.size();k++){
                    HistoricoGestion defaultHg = hgl.get(k);
                    out.println("<tr>"); 
                        out.println("<td>"+defaultHg.getFechaLlamada()+"</td>");
                        out.println("<td>"+defaultHg.getUserAgent()+"</td>");
                        out.println("<td>"+defaultHg.getnClient()+"</td>");
                        out.println("<td>"+defaultHg.getNameClient()+"</td>");
                        out.println("<td>"+defaultHg.getTelefono()+"</td>");
                        out.println("<td>"+defaultHg.getTipificacion()+"</td>");
                        out.println("<td>"+defaultHg.getPregNombre()+"</td>");
                        out.println("<td>"+defaultHg.getPregCotiza()+"</td>");
                        out.println("<td>"+defaultHg.getObservaciones()+"</td>");
                    out.println("</tr>");     
                }
                out.println("</tbody>");
            out.println("</table>");
            out.println("<div>");
            out.println("<button type=\"button\" id=\"close_button\" class=\"btn btn-primary custbtn\">Cerrar</button>"); 
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
