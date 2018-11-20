/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;


import com.bean.JavaBeanCfgPersons;
import com.bean.JavaBeanLogSurveyInteractionsWebPage;

import com.entidades.CfgPersons;
import com.entidades.Reporte;
import com.entidades.ReporteAvanzado;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.Chart;
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
    
        String[] datos=null;
             Date fecha1=null;
              Date fecha2=null;
                String arreglo="'";  
                List lista=null;
                List lista1=null;
                String  data="";
                 String f11="";
                  String f22="";
                  String[] da;
                  String llego;
                  ReporteAvanzado r2 ;
                  String boton;
                  int dt=0;
                  ArrayList resultado = new ArrayList<>();
              
                 

          private String cadena(List<CfgPersons> lista ){
                
                String cadena="";
                CfgPersons obj;
               for (int i=0; i<lista.size(); i++){
                   obj=lista.get(i);
                   cadena=cadena+"<option value=\""+obj.getUsername()+"\" >"+obj.getFullname()+"</option>\n";
               }
               return cadena;
            }
          

         
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            JavaBeanCfgPersons jbcp = new JavaBeanCfgPersons();
            JavaBeanLogSurveyInteractionsWebPage lbcp = new JavaBeanLogSurveyInteractionsWebPage();
               List<Reporte> reporte = new ArrayList<>();
               List<ReporteAvanzado> reporteAvanzado = new ArrayList<>();
               
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
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          
        
            try{
               
            
             datos= request.getParameterValues("mul");
            String tipoinfor= request.getParameter("tipoinforme");
            
f11=  request.getParameter("fecha1");
f22=  request.getParameter("fecha2");   
llego=  request.getParameter("arr"); 
boton = request.getParameter("boton");
  dt=Integer.parseInt(tipoinfor);
   int dt2=Integer.parseInt(tipoinfor);
      
                     for(int i=0; i<datos.length; i++){
                String coma="','";
               
                if(i== datos.length -1){
                    coma = "'";
                }
                 arreglo=arreglo+datos[i]+coma;
                 
            }
                   
                     if(dt==1){
                                          

                               lista1 = lbcp.reporte2(f11,f22, arreglo);
                           
                     }
                      if(dt==2){
             
                lista = lbcp.reporte(f11,f22, arreglo);
               
             
                     }
    

   


  
        
    
     
        
            }
            catch(Exception e
                    ){
                e.printStackTrace();
            }
           


            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\"  media=\"screen,projection\"/>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>");
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
            out.println("<link href='css/style_supervisor.css' rel='stylesheet'>");
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
    
                        out.println("<script type=\"text/javascript\" src=\"javascript/materialize.min.js\"></script>");


                        
            out.println("<head>");
            
 
String name=request.getSession().getAttribute("fullname").toString();
            char letra =name.charAt(0);


            out.println("<title>Página de Supervisor</title>");            
            out.println("</head>");
            out.println("<body>");
          /*  out.println("<div class=\"fixed-action-btn\">\n" +
"  <a class=\"btn-floating pulse  red\">\n" +
"    <label><h4><font color=white>"+letra +"</font></h4></label>\n" +
"  </a>\n" +
"  <ul>\n" +
"    <li><a class=\"btn-floating red\"><i class=\"material-icons\">insert_chart</i></a></li>\n" +
"    <li><a class=\"btn-floating yellow darken-1\"><i class=\"material-icons\">format_quote</i></a></li>\n" +
"    <li><a class=\"btn-floating green\"><i class=\"material-icons\">publish</i></a></li>\n" +
"    <li><a class=\"btn-floating blue\"><i class=\"material-icons\">attach_file</i></a></li>\n" +
"  </ul>\n" +
"</div>");*/
             out.println("<div class=\"divHeader\">");           
                    out.println("Bienvenid@ Sr@ "+request.getSession().getAttribute("fullname").toString());
                    out.println("<a href=\"/WebPopUpPage/log_in.jsp?cerrar=true\" style=\"background-color:white;color:#5F5F5F\">Cerrar Sesion</a>");
                out.println("</div>");
            out.println("<div>");
                out.println("<img class=\"logo img-responsive\" src=\"css/images/wurth-chile-logo-1504724576.png\" alt=\"Wurth Chile\" width=\"165\" height=\"35\">");
            out.println("</div>");
            
            out.println("   <body>\n" +
"      <div class=\"container\">\n" +
"         <div class=\"row\">\n" +
"    <div class=\"col s12 m12\">\n" +
                   
"      <div class=\"card  white \">\n" +
"        <div class=\"card-content black-text\">\n" +
"          <span class=\"card-title\">Consulta de resultados</span>\n" +

"<br>"+
"<br>"+
          "<form action =\"VistaReportes\" method=\"post\" >"  +        
 "<i class=\"material-icons prefix\">chrome_reader_mode</i><label><h4>seleccione tipo de reporte</h4></label>"+

"  <select name = tipoinforme class=\"browser-default\">\n" +
"    <option value=\"\" disabled selected>Tipo de reporte</option>\n" +
"    <option value=\"1\">Detalle de Gestiones</option>\n" +
"    <option value=\"2\">Resumen Total de Gestiones</option>\n" +
"  </select>"+      
     "<br>"+
"<br>"+

 "<label><h4>Rango de fechas</h4></label>"+

" <div class=\"row\">\n" +
"    <form class=\"col s12\">\n" +
"      <div class=\"row\">\n" +
"        <div class=\"input-field col s6\">\n" +
"          <i class=\"material-icons prefix\">filter_1</i>\n" +
"          <input name=\"fecha1\" type=\"date\" class=\"validate\">\n" +
"        </div>\n" +
"        <div class=\"input-field col s6\">\n" +
"          <i class=\"material-icons prefix\">filter_2</i>\n" +
"          <input name=\"fecha2\" type=\"date\" class=\"validate\">\n" +
"        </div>\n" +
"      </div>"   +     
         "<br>"+           
     "<i class=\"material-icons prefix\">record_voice_over</i><label><h4>seleccione ejecutivo</h4></label>"+

"  <select multiple name=\"mul\" class=\"browser-default\">\n" +
cadena(lcp)+
"  </select>"+      
     "<br>"+
"<br>"+


"        <div class=\"card-action\">\n" +
" <button class=\"btn waves-effect waves-light\" type=\"submit\" value=\"boton\" name=\"action\">Enviar\n" +
                  
"    <i class=\"material-icons right\">send</i>\n" +
"  </button>"+
"</form>"+
                   
"        </div>\n" +
"      </div>\n" +
"    </div>\n" +
"  </div>" +
                    
                    
                    
"      </div>\n" +
                   
                   
                   
                    
                    
                    
                    
                    
      
                    
                    

          
                    
                    
                    
                    
                    
                    
                   
           
                    
"    </body>");
            if(dt==2){
                out.println( " <div class=\"row\">\n" +
                    
"    <div class=\"col s12 m12\">\n" +
"      <div class=\"card  white \">\n" +
"        <div class=\"card-content black-text\">\n" +
"          <span class=\"card-title\">Resumen Total De Gestiones </span>\n" );
out.println("<table class=\"table table-striped table-bordered no-footer\">");
                out.println("<thead>");                
                    out.println("<tr>");   
                        out.println("<th>Nombre agente</th>"); 
                        out.println("<th>Tipificacion</th>");
                        out.println("<th>Pregunta Nombre</th>");
                        out.println("<th>Envio Cotizacion</th>");
                        out.println("<th>cantidad</th>");
                    out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>"); 
               
           for(int i=0; i<lista.size(); i++){
           
               Object[] obj = (Object[]) lista.get(i);
               Reporte r = new Reporte();
           reporte.add(r);
      
           
               for(int f=0; f<obj.length; f++){
                   Object objColumn = obj[f];
                    switch(f){
                        case 0: 
                            reporte.get(i).setUserAgent(objColumn.toString());
                            break;
                        case 1: 
                           reporte.get(i).setTipificacion(objColumn.toString());
                            break;
                        case 2: 
                           reporte.get(i).setPregNombre(objColumn.toString());
                            
                            
                            break;
                        case 3: 
                            reporte.get(i).setEnviocotizacion(objColumn.toString());
                            break;
                        case 4: 
                              reporte.get(i).setCantidad(objColumn.toString());
                            break;
                            default: break;
                      }

                 
               }
           }
           
           for (int k = 0; k<reporte.size(); k++){
              
               Reporte r2 = reporte.get(k);
               
               out.println("<tr>"); 
                        out.println("<td>"+r2.getUserAgent()+"</td>"+
                                "<td>"+r2.getTipificacion()+"</td>"+
                                "<td>"+r2.getPregNombre()+"</td>"+
                                "<td>"+r2.getEnviocotizacion()+"</td>"+
                                "<td>"+r2.getCantidad()+"</td>"
                             
                        );
               out.println("</tr>"); 
           }
        out.println("</tbody>");
            out.println("</table>");
            arreglo="'"; 
            
           
            }
 
        if(dt==1){
            out.println("<div class=\"row\">\n" +
                    
"    <div class=\"col s12 m12\">\n" +
"      <div class=\"card  white \">\n" +
"        <div class=\"card-content black-text\">\n" +
"          <span class=\"card-title\">Detalle de gestiones</span>\n" );
out.println("<table name =reporte class=\"table table-striped table-bordered no-footer\">");
                out.println("<thead>");                
                    out.println("<tr>");
  
                        out.println("<th>Fecha llamada</th>"); 
                        out.println("<th>Usuario</th>");
                        out.println("<th># cliente</th>");
                        out.println("<th>Nombre Cliente</th>");
                        out.println("<th>Telefono</th>");
                        out.println("<th>Tipificación</th>");
                        out.println("<th>PregNombre</th>");
                        out.println("<th>Envio cotizacion</th>");
                        out.println("<th>Observaciones</th>");
                        
                    out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>"); 
               
           for(int i=0; i<lista1.size(); i++){
           
               Object[] obj = (Object[]) lista1.get(i);
               ReporteAvanzado r = new ReporteAvanzado();
           reporteAvanzado.add(r);
   
           
               for(int f=0; f<obj.length; f++){
                   Object objColumn = obj[f];
                    switch(f){
                        case 0: 
                            reporteAvanzado.get(i).setFechallamada(objColumn.toString());
                            break;
                        case 1: 
                           reporteAvanzado.get(i).setUserAgent(objColumn.toString());
                            break;
                        case 2: 
                           reporteAvanzado.get(i).setIdcliente(objColumn.toString());
                            
                            
                            break;
                        case 3: 
                           reporteAvanzado.get(i).setNombrecliente(objColumn.toString());
                            break;
                        case 4: 
                              reporteAvanzado.get(i).setTelefono(objColumn.toString());
                            break;
                            
                            case 5: 
                              reporteAvanzado.get(i).setTipificacion(objColumn.toString());
                            break;
                            
                            case 6: 
                              reporteAvanzado.get(i).setPregNombre(objColumn.toString());
                            break;
                            
                            case 7: 
                              reporteAvanzado.get(i).setEnviocotizacion(objColumn.toString());
                            break;
                            
                            case 8: 
                              reporteAvanzado.get(i).setObservacion(objColumn.toString());
                            break;
                            
                            
                            default: break;
                      }

                 
               }
           }
            
            


           for (int k = 0; k<reporteAvanzado.size(); k++){
                    
                r2 = reporteAvanzado.get(k);
 

               out.println("<tr>"); 
                        out.println("<td>"+r2.getFechallamada()+"</td>"+
                                "<td>"+r2.getUserAgent()+"</td>"+
                                "<td>"+r2.getIdcliente()+"</td>"+
                                "<td>"+r2.getNombrecliente()+"</td>"+
                                "<td>"+r2.getTelefono()+"</td>"+
                                "<td>"+r2.getTipificacion()+"</td>"+
                                "<td>"+r2.getPregNombre()+"</td>"+
                                "<td>"+r2.getEnviocotizacion()+"</td>"+
                                "<td>"+r2.getObservacion()+"</td>"
                             
                         +""    
                        );
                        
            
                        
               out.println("</tr>"); 
                
           
           }
           
        out.println("</tbody>");
            out.println("</table>");
              
           
            
        
          
         arreglo="'"; 
                       
        }
                
         
           
           

       
            
          

            
            
            
            
            
            
              /*  out.println("<label for=\"report_type_box\">Seleccione Tipo de Reporte a Visualizar:</label><br>");
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
            out.println("</body>");*/
            out.println("</html>");
            
            
        }
          /*response.sendRedirect("/WebPopUpPage/Superv2Servlet");*/
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
              try {
                  processRequest(request, response);
              } catch (ParseException ex) {
                  Logger.getLogger(Superv2Servlet.class.getName()).log(Level.SEVERE, null, ex);
              }
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
              try {
                  processRequest(request, response);
              } catch (ParseException ex) {
                  Logger.getLogger(Superv2Servlet.class.getName()).log(Level.SEVERE, null, ex);
              }
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
