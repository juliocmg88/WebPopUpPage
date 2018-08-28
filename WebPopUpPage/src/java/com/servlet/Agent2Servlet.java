/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.JavaBeanCtWurth;
import com.bean.JavaBeanCtWurth2;
import com.entidades.CtWurth;
import com.entidades.CtWurth2;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sebastian
 */
public class Agent2Servlet extends HttpServlet {

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
            RequestDispatcher rd = null;
            Integer initSelected;
            try{
                initSelected = Integer.parseInt(request.getSession().getAttribute("edited_row").toString());
            } catch(Exception e){
                initSelected=0;                
            }
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            /* TODO output your page here. You may use following sample code. */
            JavaBeanCtWurth2 jbcw = new JavaBeanCtWurth2();
            
            /*Calendar cal = Calendar.getInstance(); // locale-specific
                    cal.setTime(new Date());
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                    cal.set(Calendar.HOUR_OF_DAY, 0);
                    cal.set(Calendar.MINUTE, 0);
                    cal.set(Calendar.SECOND, 0);
                    cal.set(Calendar.MILLISECOND, 0);
            List<CtWurth2> lcw =jbcw.findCtWurthEntitiesBySchedTime(request.getSession().getAttribute("username").toString(),cal.getTime());*/
            List<CtWurth2> lcw=null;
            CtWurth2 cw;
            CtWurth2 defaultCw;
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
            //out.println("<link href=\"fonts/fontawesome/font-awesome.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/style.css\" rel=\"stylesheet\">");
            out.println("<link href=\"bxpadmin/resources/css/style-responsive.css\" rel=\"stylesheet\">");
            out.println("<link href='css/style_client.css' rel='stylesheet'>");
            //out.println("<link href='css/style-login.css' rel='stylesheet'>");
            out.println("<link href='css/save_obsv.css' rel='stylesheet'>");
            out.println("<link href='fonts/fontwurth/css_wurth_fonts.css' rel='stylesheet'>");
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
            out.println("<title>Servlet AgentServlet</title>");            
            out.println("</head>");
            out.println("<body id=\"pageBody\" oncontextmenu=\"return false\">");
                out.println("<div class=\"divHeader\">");           
                    out.println("Bienvenid@ Sr@ "+request.getSession().getAttribute("fullname").toString());
                    out.println("<a href=\"/WebPopUpPage/log_in.jsp?cerrar=true\" style=\"background-color:white;color:#5F5F5F\">Cerrar Sesion</a>");
                out.println("</div>");
            out.println("<div>");
                out.println("<img class=\"logo img-responsive\" src=\"css/images/wurth-chile-logo-1504724576.png\" alt=\"Wurth Chile\" width=\"165\" height=\"35\">");
            out.println("</div>"); /*
                out.println("<div style=\"display:none; \"   id=\"contextMenu\">");
out.println("<table  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" ");
out.println("style=\"border: thin solid #808080; cursor: default;\" width=\"100px\" bgcolor=\"White\">");
out.println("<tr>");
out.println("<td >");
//out.println("<div  class=\"ContextItem\" onclick=\"alertaName('contextMenu');\">Llamar</div>");
out.println("<div id=\"llamar\" class=\"ContextItem\">Llamar</div>");
out.println("</td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td >");
out.println("<div  class=\"ContextItem\">Edit</div>");
out.println("</td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td >");
out.println("<div  class=\"ContextItem\">Delete</div>");
out.println("</td>");
out.println("</tr>");
out.println("</table>");
out.println("</div>");*/
out.println("<section class=\"wrapper\">");
out.println("<div class=\"row\">");                          
out.println("<div id=\"phoneCompanyRadio\">");  
out.println("<label>Troncal de Salida de Llamadas</label><br>");
out.println("<label class=\"radio-inline\"><input type=\"radio\" name=\"company\" id=\"redvoiss\" value=\"8\" checked/>Redvoiss</label>");
out.println("<label class=\"radio-inline\"><input type=\"radio\" name=\"company\" id=\"entel\" value=\"9\"/>Entel</label>");      
out.println("</div>"); 
out.println("<nav class=\"navbar navbar-default\">");
    out.println("<div class=\"container-fluid\">");
        out.println("<ul class=\"nav navbar-nav\">");
            out.println("<button type=\"button\" id=\"hoyBtn\">Ver Asignación de Hoy</button>");
            out.println("<button type=\"button\" id=\"schBtn\">Ver Agendados</button>");
        out.println("</ul>");
    out.println("</div>");
out.println("</nav>");
for(int ii=0;ii<=1;ii++){
    String divDayMark="";
    String divDayId="";
    String divDayDisplay="";
    if(ii==0){
        lcw =jbcw.findCtWurthEntitiesByTodayTime(request.getSession().getAttribute("username").toString());
        divDayId= "todayList";
        divDayDisplay="display:inline;";
        divDayMark="hoy_";
    }else{
        lcw =jbcw.findCtWurthEntitiesBySchedTime(request.getSession().getAttribute("username").toString());   
        divDayId= "schedList";
        divDayDisplay="display:none;";
        divDayMark="sch_";
    }

out.println("<div id=\""+divDayId+"\" style=\""+divDayDisplay+"\" >");
out.println("<div id=\"page-content-header\" >");
                out.println("<table>");
                out.println("<thead>");
                    out.println("<tr>");
                        out.println("<th class=\"col-md-6\" align=\"center\">Gestionado</th>");
                        out.println("<th class=\"col-md-6\" align=\"center\">Nombre</th>");
                    out.println("</tr>");
                out.println("</thead>");
                out.println("</table>");
out.println("</div>");
out.println("<div id=\"page-content\" class=\"col-lg-4\" style=\"max-height:400px; overflow-y:auto\">");

            out.println("<table class=\"table table-striped table-bordered dataTable no-footer\">");
                out.println("<tbody id=\""+request.getSession().getAttribute("anexo").toString()+"\" class=\"dataTableBody\">");
            for(int i=0;i<lcw.size();i++){
                String clase = "odd";
                String scrollClass="";
                if(i%2==0){
                    clase="even";
                }
                if(i==initSelected){
                    scrollClass=" scrollHere";
                    if(i%2==0){
                        clase="even selected";
                    } else{
                        clase="odd selected";                        
                    }
                }
                String gestionado="";
                int intento=0;
                cw = lcw.get(i);
                intento = cw.getAttempts();
                if(intento>0){
                    gestionado="🔵";
                }else{
                    gestionado="🔴";
                }
                    out.println("<tr "
                            + "class=\""+clase+scrollClass+"\" "
                            + "id=\""+divDayMark+"record_"+i+"\" "
                            + "onmousedown=\"HideMenu('contextMenu');\" "
                            + "onmouseup=\"HideMenu('contextMenu');\" "
                            + "oncontextmenu=\"ShowMenu('record_"+i+"','contextMenu',event);\" "
                            + "onclick=\"rowSelected('"+divDayMark+"record_"+i+"','"+divDayMark+"client_detail_"+i+"');\" "
                            + ">");
                      out.println("<td class=\"col-md-2\" style=\"color:red;\" align=\"center\" id=\"gestion_"+i+"\">"+gestionado+"</td>");
                      out.println("<td id=\"nombre\">"+cw.getNombre()+"</td>");
                    out.println("</tr>");
            }
                  out.println("</tbody>");         
            out.println("</table>");
            out.println("</div>");
            //defaultCw=lcw.get(0);
            out.println("<div id=\"page-detail\" class=\"col-lg-8\">");
            out.println("<table class=\"table table-striped table-bordered dataTable no-footer\">");
                out.println("<thead>");
                    out.println("<th>Detalle</th>");
                out.println("</thead>");
            out.println("</table>");
            out.println("<form action=\"UpdateWurthClientServlet\" method=\"POST\">");
            for(int k=0;k<lcw.size();k++){
                String visible = "display:none;";
                defaultCw=lcw.get(k);
                if(k==initSelected){
                    visible = "display:inline;";
                }
            
            request.setAttribute("row_"+k, k);
            request.getSession().setAttribute("row_"+k, k);
            out.println("<div id=\""+divDayMark+"client_detail_"+k+"\" class=\"class_detail\" style=\""+visible+"\">");
            out.println("<label for=\"ncliente_"+k+"\">Ncliente</label>");
            out.println("<input readonly type=\"text\" name=\"ncliente_"+k+"\" id=\"ncliente_"+k+"\" class=\"numclient\" value=\""+defaultCw.getNcliente()+"\"/>");
            out.println("<label for=\"nombre_"+k+"\">Nombre</label>");
            out.println("<input readonly type=\"text\" name=\"nombre_"+k+"\" id=\"nombre_"+k+"\" class=\"nomclient\" value=\""+defaultCw.getNombre()+"\"/>");
            out.println("<label for=\"comuna_"+k+"\">Comuna</label>");
            out.println("<input readonly type=\"text\" name=\"comuna_"+k+"\" id=\"comuna_"+k+"\" value=\""+defaultCw.getComuna()+"\"/>");
            out.println("<label for=\"direccion_"+k+"\">Direccion</label>");
            out.println("<input readonly type=\"text\" name=\"direccion_"+k+"\" id=\"direccion_"+k+"\" value=\""+defaultCw.getDireccion()+"\"/>");
            out.println("<label for=\"telefono_"+k+"\">Telefono</label>");
            out.println("<input readonly type=\"text\" name=\"telefono_"+k+"\" id=\"telefono_"+k+"\" class=\"fono\" value=\""+defaultCw.getTelefono()+"\"/>");
            out.println("<label for=\"ramo_"+k+"\">Ramo</label>");
            out.println("<input readonly type=\"text\" name=\"ramo_"+k+"\" id=\"ramo_"+k+"\" value=\""+defaultCw.getRamo()+"\"/>");
            out.println("<label for=\"division_"+k+"\">Division</label>");
            out.println("<input readonly type=\"text\" name=\"division_"+k+"\" id=\"division_"+k+"\" value=\""+defaultCw.getDivision()+"\"/>");
            out.println("<label for=\"operarios_"+k+"\">Operarios</label>");
            out.println("<input readonly type=\"text\" name=\"operarios_"+k+"\" id=\"operarios_"+k+"\" value=\""+defaultCw.getOperarios()+"\"/>");
            out.println("<label for=\"potencial_"+k+"\">Potencial</label>");
            out.println("<input readonly type=\"text\" name=\"potencial_"+k+"\" id=\"potencial_"+k+"\" value=\""+defaultCw.getPotencial()+"\"/>");
            out.println("<label for=\"condpago_"+k+"\">Condpago</label>");
            out.println("<input readonly type=\"text\" name=\"condpago_"+k+"\" id=\"condpago_"+k+"\" value=\""+defaultCw.getCondpago()+"\"/>");
            out.println("<label for=\"grupo_"+k+"\">Grupo</label>");
            out.println("<input readonly type=\"text\" name=\"grupo_"+k+"\" id=\"grupo_"+k+"\" value=\""+defaultCw.getGrupo()+"\"/>");
            out.println("<label for=\"fechaact_"+k+"\">FechaActualizacion</label>");
            out.println("<input readonly type=\"text\" name=\"fechaact_"+k+"\" id=\"fechaact_"+k+"\" value=\""+defaultCw.getFechaActualizacion()+"\"/>");
            out.println("<label for=\"orsy_"+k+"\">ORSY</label>");
            out.println("<input readonly type=\"text\" name=\"orsy_"+k+"\" id=\"orsy_"+k+"\" value=\""+defaultCw.getOrsy()+"\"/>");
            out.println("<label for=\"periodo1_"+k+"\">Periodo 1</label>");
            out.println("<input readonly type=\"text\" name=\"periodo1_"+k+"\" id=\"periodo1_"+k+"\" value=\""+defaultCw.getPeriodo1()+"\"/>");
            out.println("<label for=\"periodo2_"+k+"\">Periodo 2</label>");
            out.println("<input readonly type=\"text\" name=\"periodo2_"+k+"\" id=\"periodo2_"+k+"\" value=\""+defaultCw.getPeriodo2()+"\"/>");
            out.println("<label for=\"sml_"+k+"\">SML</label>");
            out.println("<input readonly type=\"text\" name=\"sml_"+k+"\" id=\"sml_"+k+"\" value=\""+defaultCw.getSml()+"\"/>");
            out.println("<label for=\"ultfact_"+k+"\">Ultima Factura</label>");
            out.println("<input readonly type=\"date\" name=\"ultfact_"+k+"\" id=\"ultfact_"+k+"\" value=\""+df.format(defaultCw.getUltFac())+"\"/>");
            out.println("<label for=\"proyeccion_"+k+"\">Proyeccion</label>");
            out.println("<input readonly type=\"text\" name=\"proyeccion_"+k+"\" id=\"proyeccion_"+k+"\" value=\""+defaultCw.getProyeccion()+"\"/>");
            out.println("<label for=\"var_"+k+"\">Var</label>");
            out.println("<input readonly type=\"text\" name=\"var_"+k+"\" id=\"var_"+k+"\" value=\""+defaultCw.getVar()+"\"/>");
            out.println("<label for=\"leyenda_"+k+"\">Leyenda</label>");
            out.println("<input readonly type=\"text\" name=\"leyenda_"+k+"\" id=\"leyenda_"+k+"\" value=\""+defaultCw.getLeyenda()+"\"/>");
            out.println("<label for=\"qry_"+k+"\">Qry Vendedores Grupo</label>");
            out.println("<input readonly type=\"text\" name=\"qry_"+k+"\" id=\"qry_"+k+"\" value=\""+defaultCw.getQryVendedoresGrupo()+"\"/>");
            out.println("<label for=\"nro_sup_"+k+"\">Numero Supervisor</label>");
            out.println("<input readonly type=\"text\" name=\"nro_sup_"+k+"\" id=\"nro_sup_"+k+"\" value=\""+defaultCw.getNroSup()+"\"/>");
            out.println("<label for=\"nom_sup_"+k+"\">Nombre Supervisor</label>");
            out.println("<input readonly type=\"text\" name=\"nom_sup_"+k+"\"  id=\"nom_sup_"+k+"\" value=\""+defaultCw.getNomSup()+"\"/>");
            out.println("<label for=\"nro_ven_"+k+"\">Numero Vendedor</label>");
            out.println("<input readonly type=\"text\" name=\"nro_ven_"+k+"\"  id=\"nro_ven_"+k+"\" value=\""+defaultCw.getNroVen()+"\"/>");
            out.println("<label for=\"nom_ven_"+k+"\">Nombre Vendedor</label>");
            out.println("<input readonly type=\"text\" name=\"nom_ven_"+k+"\"  id=\"nom_ven_"+k+"\" value=\""+defaultCw.getNomVen()+"\"/>");
            //out.println("<label for=\"observacion_"+k+"\">Observaciones</label>");
            //out.println("<textarea readonly name=\"observacion_"+k+"\" id=\"observacion_"+k+"\">"+defaultCw.getObservacion()+"</textarea>");
            out.println("<input type=\"hidden\" name=\"record_id_"+k+"\" id=\"record_id_"+k+"\" class=\"recordid\" value=\""+defaultCw.getRecordId()+"\"/>");
            out.println("<input type=\"hidden\" name=\"agent_dn_"+k+"\" id=\"agent_dn_"+k+"\" class=\"agentdn\" value=\""+defaultCw.getAgentDn()+"\"/>");
            out.println("<input type=\"hidden\" name=\"import_id_"+k+"\" id=\"import_id_"+k+"\" class=\"importid\" value=\""+defaultCw.getImportId()+"\"/>");
            out.println("<input type=\"hidden\" name=\"myField\" id=\"myField\" class=\"myHiddenFieldClass\" value=\"\" />");
            out.println("</div>");
            }
            out.println("<div>");            
            out.println("<button type=\"button\" id=\""+divDayMark+"call_button\" class=\"btn btn-primary custbtn\">Llamar</button>");         
            out.println("<button type=\"button\" id=\""+divDayMark+"hist_button\" class=\"btn btn-primary custbtn\">Histórico Llamadas</button>");            
            out.println("<button type=\"button\" id=\""+divDayMark+"edit_button\" class=\"btn btn-primary custbtn\">Editar Datos</button>");         
            out.println("<button type=\"submit\" id=\""+divDayMark+"save_button\" class=\"btn btn-primary custbtn\" disabled>Guardar Cambios</button>");          
            //out.println("<button type=\"button\" id=\""+divDayMark+"test_button\" class=\"btn btn-primary custbtn\">Test</button>");      
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
}
            out.println("</section>");
            out.println("<div class=\"fullscreen-container\">");            
                out.println("<div id=\"popdiv\">");
                    out.println("<form action=\"TipificaServlet\" method=\"POST\">");
                        out.println("<div id=\"divObsvr\">");
                        out.println("<h3>Tipifique la Gestión</h3>"); 
                        out.println("<input type=\"hidden\" name=\"tipFono\" id=\"tipFono\">");
                        out.println("<input type=\"hidden\" name=\"tipNClient\" id=\"tipNClient\">");
                        out.println("<input type=\"hidden\" name=\"tipNomClient\" id=\"tipNomClient\">");
                        out.println("<input type=\"hidden\" name=\"tipRecordId\" id=\"tipRecordId\">");
                        out.println("<input type=\"hidden\" name=\"tipAgentDn\" id=\"tipAgentDn\">");
                        out.println("<input type=\"hidden\" name=\"tipImportId\" id=\"tipImportId\">");
                        out.println("<input type=\"hidden\" name=\"tipCallTime\" id=\"tipCallTime\">");
                        out.println("<label for=\"tipifBox\">Tipo Llamada</label>");
                        out.println("<select name=\"tipifBox\" id=\"tipifBox\">");
                            out.println("<option value=\"UNKNOW\">Sin Tipificacion</option>");
                            out.println("<option value=\"ANSWER\">Contesta</option>");
                            out.println("<option value=\"MACHINE\">Voice Mail</option>");
                            out.println("<option value=\"NOANSWER\">No Contesta</option>");
                            out.println("<option value=\"BUSY\">Tono Ocupado</option>");
                            out.println("<option value=\"NOTSURE\">Otro</option>");
                        out.println("</select>");
                        out.println("<label for=\"contactBox\">Tipo Contacto</label>");
                        out.println("<select name=\"contactBox\" id=\"contactBox\" disabled>");
                            out.println("<option value=\"\"></option>");
                            out.println("<option value=\"contacto_directo\">Contacto Directo</option>");
                            out.println("<option value=\"no_corresponde\">Equivocado</option>");
                            out.println("<option value=\"no_se_encuentra\">No se encuentra</option>");
                        out.println("</select>");
                        out.println("<label for=\"cotizaBox\">Envío Cotización</label>");
                        out.println("<select name=\"cotizaBox\" id=\"cotizaBox\" disabled>");
                            out.println("<option value=\"\"></option>");
                            out.println("<option value=\"si\">Si</option>");
                            out.println("<option value=\"no\">No</option>");
                            out.println("<option value=\"otro\">Otro</option>");
                        out.println("</select>");
                        out.println("<br>");
                        out.println("<label for=\"observacionInfo\">Observaciones</label><br>");
                        out.println("<textarea name=\"observacionInfo\" id=\"observacionInfo\" placeholder=\"Inserte una frase de 10 caracteres minimo y 60 maximo\" maxlength=\"60\"></textarea>");
                        out.println("<br>");
                        out.println("<label for=\"schedRadio\">¿Desea agendar la gestión?</label><br>");                           
                        out.println("<div id=\"schedRadio\">");   
                        out.println("<label class=\"radio-inline\"><input type=\"radio\" name=\"sched\" id=\"schNo\" value=\"no\" checked/>No</label>");
                        out.println("<label class=\"radio-inline\"><input type=\"radio\" name=\"sched\" id=\"schYes\" value=\"si\"/>Si</label>");   
                        out.println("<span id=\"schedDateTime\" style=\"display:none;\">");   
                        out.println("<input type=\"date\" name=\"schedDate\" id=\"schedDate\">");
                        out.println("<input type=\"time\" name=\"schedTime\" id=\"schedTime\">");
                        out.println("</span>");   
                        out.println("</div>");   
                        out.println("<button type=\"submit\" id=\"obsv_button\" class=\"btn btn-primary custbtn\" disabled>Guardar Gestión</button>");                        
                        out.println("</div>");
                    out.println("</form>");
                out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            //request.setAttribute("id_cliente", cw.getIdCliente());
            //RequestDispatcher rd = request.getRequestDispatcher("agent.jsp");            
            //rd.forward(request, response);
            
            /*rd= request.getRequestDispatcher("/Agent2Servlet");
            rd.forward(request, response);*/
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
