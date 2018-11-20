/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.JavaBeanCtWurth2;
import com.entidades.CtWurth2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import static jdk.nashorn.internal.objects.NativeError.getFileName;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Alamiro
 */
public class CargarListaServlet extends HttpServlet {

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
            
            
                
            
            
            
            
            
            
            
            
            
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>WebPopUpPage</title>");
            out.println("<link rel=\"shortcut icon\" href=\"css/images/favicon.ico\" type=\"image/x-icon\">");
            out.println("<link rel=\"icon\" href=\"css/images/favicon.ico\" type=\"image/x-icon\">");
           
            //out.println("<link href=\"fonts/fontawesome/font-awesome.min.css\" rel=\"stylesheet\">");
          
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
                                    out.println("<script type=\"text/javascript\" src=\"javascript/materialize.min.js\"></script>");
 out.println("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\"  media=\"screen,projection\"/>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>");
            
                        out.println("<body>");

            
            
            
            
            
            
            out.print("<form action=\"CargarListaServlet\" method=\"post\" enctype=\"multipart form-data\">\n" +
"    <input type=\"text\" name=\"description\" />\n" +
"    <input type=\"file\" name=\"file\" value=\"file\" />\n" +
"    <input type=\"submit\" />\n" +
"</form>");
            
            
            
             String archivoexcel=request.getParameter("file");
                      System.out.println(archivoexcel);

String sDirectorio = "C:/Users/Alamiro/Desktop";

String sPath = File.separator + sDirectorio + File.separator + archivoexcel;

System.out.println("La ruta es: " + sPath);


List datos = new ArrayList();
     FileInputStream archivoentrada = new FileInputStream("C:/Users/Alamiro/Desktop/ExcelWurt.xlsx");
     
     XSSFWorkbook work = new XSSFWorkbook(archivoentrada);
     XSSFSheet shet = work.getSheetAt(0);
     
     Iterator  row = shet.rowIterator();
            
     
     while(row.hasNext()){
         XSSFRow prueba = (XSSFRow) row.next();
         
         Iterator iterator = prueba.cellIterator();
         List temporal = new ArrayList();

         
         
         while(iterator.hasNext()){
             XSSFCell celdas = (XSSFCell) iterator.next();
             
             temporal.add(celdas);
             
         }
         
         
         
         
         datos.add(temporal);
         
         
         
         
         
         
         
         
         
         
     }
            
                 JavaBeanCtWurth2 bean = new  JavaBeanCtWurth2();
            
         for(int i = 0; i<datos.size(); i++){
             List archivostemporales = (List) datos.get(i);

              CtWurth2 obj = new CtWurth2(); 
             
             for(int f = 0; f<archivostemporales.size(); f++){

                              XSSFCell cel = (XSSFCell) archivostemporales.get(f);
                                               String valoresfinales = cel.toString();
                                                String variable=valoresfinales;
                                                 String variableTelefono=valoresfinales;
                                                 String telefono =valoresfinales;
                                                 String variableRamo=valoresfinales;
                                                 String variableoperarios=valoresfinales;
 String variabledivision=valoresfinales;
  String variablepotencial=valoresfinales;
String variablecondpago=valoresfinales;
             String variablegrupo=valoresfinales;    
              String variableorsy=valoresfinales;  
              String variableperiodo1=valoresfinales;  
               String variableperiod2=valoresfinales; 
               String variableproyeccion=valoresfinales; 
String proyeccion = valoresfinales;
                                      Date fecha=null;
               String variablevar=valoresfinales; 

             String variablevendedores=valoresfinales;    
 String variableNumeroSuper=valoresfinales; 
 String variableNumerovendedor=valoresfinales; 
String Fechaactualizacion = valoresfinales;
if (f==0){
    
    if(valoresfinales==""){
        variable="";
    }
    else{
  // variable =valoresfinales.substring(0,1);
 variable = valoresfinales.substring(0, valoresfinales.length()-2); 
    }
}

if (f==4){
  // variable =valoresfinales.substring(0,1);
    if(valoresfinales==""){
        telefono ="0";
    }
    else if(valoresfinales.equals("NT")){
        telefono ="0";
    }
    else{
    
 variableTelefono = valoresfinales.substring(0, valoresfinales.length()-2); 
telefono =variableTelefono.replace(".","");
    }
 
}

if (f==5){
  // variable =valoresfinales.substring(0,1);
    if(valoresfinales==""){
     variableRamo="0";
    }else{
 variableRamo = valoresfinales.substring(0, valoresfinales.length()-2); 
    }
}

if (f==6){
  // variable =valoresfinales.substring(0,1);
    if(valoresfinales==""){
    variabledivision="0";
    } else{
    
 variabledivision= valoresfinales.substring(0, valoresfinales.length()-2); 
    }
}

if (f==7){
  // variable =valoresfinales.substring(0,1);
    
  if(valoresfinales==""){
  variableoperarios="0";
  }  
  else{
    variableoperarios= valoresfinales.substring(0, valoresfinales.length()-2); 
   
  }
    

}

if (f==8){
  // variable =valoresfinales.substring(0,1);
    if(valoresfinales==""){
    variablepotencial="0";
    }
    else{
 variablepotencial= valoresfinales.substring(0, valoresfinales.length()-2); 
    }
}




if (f==9){
  // variable =valoresfinales.substring(0,1);
   if(valoresfinales.equals("NT")){
   variablecondpago="0";
   }else{
 variablecondpago= valoresfinales.substring(0, valoresfinales.length()-2); 
   }
}
if (f==10){
  // variable =valoresfinales.substring(0,1);
    if(valoresfinales==""){
    variablegrupo="0";
    }else{
 variablegrupo= valoresfinales.substring(0, valoresfinales.length()-2); 
    }
}




if (f==11){
  // variable =valoresfinales.substring(0,1);
   if(valoresfinales.equals("NT")){
    Fechaactualizacion="00000000000";
    }else{
 Fechaactualizacion= valoresfinales.substring(0, valoresfinales.length()-2); 
    }
}





if (f==12){
  // variable =valoresfinales.substring(0,1);
     if(valoresfinales==""){
     variableorsy="0";
     }
     else{
 variableorsy= valoresfinales.substring(0, valoresfinales.length()-2); 
     }
}
if (f==13){
  // variable =valoresfinales.substring(0,1);
    if(valoresfinales==""){
    variableperiodo1="0";
    }else{
 variableperiodo1= valoresfinales.substring(0, valoresfinales.length()-2); 
    }
}
if (f==14){
  // variable =valoresfinales.substring(0,1);
 variableperiod2= valoresfinales.substring(0, valoresfinales.length()-2); 

}

    if (f==16){
         if(valoresfinales==""){
         fecha=null;
         } else{                

SimpleDateFormat formatofecha= new SimpleDateFormat("dd-MMM-yyyy"); 

                                  try {
                                      fecha = formatofecha.parse(valoresfinales);
                                  } catch (ParseException ex) {
                                      Logger.getLogger(CargarListaServlet.class.getName()).log(Level.SEVERE, null, ex);
                                  }
}  
    }   
if (f==17){
  // variable =valoresfinales.substring(0,1);
   
            
            
    
 /*variableproyeccion= valoresfinales.substring(0, valoresfinales.length()-2);*/ 
 if(valoresfinales==""){
     proyeccion ="";

 }else{
     variableproyeccion= valoresfinales.substring(0, valoresfinales.length()-2);
proyeccion =variableproyeccion.replace(".","");
 }



}    
    
  if (f==18){
  // variable =valoresfinales.substring(0,1);
      
       if(valoresfinales==""){
           variablevar="";
       }
       else{
 variablevar= valoresfinales.substring(0, valoresfinales.length()-2);
 
       }
}    
    
    if (f==20){
  // variable =valoresfinales.substring(0,1);
        if(valoresfinales.equalsIgnoreCase("NT")){
        variablevendedores="0";
        }
        else{
 variablevendedores= valoresfinales.substring(0, valoresfinales.length()-2); 
        }
}    
   
    
      if (f==21){
  // variable =valoresfinales.substring(0,1);
         if(valoresfinales.equalsIgnoreCase("NT")){
         variableNumeroSuper="0";
         } else{
 variableNumeroSuper= valoresfinales.substring(0, valoresfinales.length()-2); 
         }
}     
    
          if (f==23){
  // variable =valoresfinales.substring(0,1);
              
          if(valoresfinales.equalsIgnoreCase("NT")){
          variableNumerovendedor="";
          }    
          else{         
 variableNumerovendedor= valoresfinales.substring(0, valoresfinales.length()-2); 
}
}     
   
          
  if(i>0){
        switch(f){
                    
                        case 0:
                         obj.setNcliente(Integer.parseInt(variable));
                         break;
                         
                 case 1:
                       obj.setNombre(valoresfinales);
                   break;
                     
                   case 2:
                       obj.setComuna(valoresfinales);
                    break;
                             
                  case 3:
                       obj.setDireccion(valoresfinales);
                break;  
                             
                        case 4:
                       obj.setTelefono(Integer.parseInt(telefono));
                break;
                            
                     case 5:
                       obj.setRamo(variableRamo);
                break;              
                            
                            case 6:
                       obj.setDivision(variabledivision);
                break;           
                        
                    case 7:
                       obj.setOperarios(variableoperarios);
                break;                     
                                
                         case 8:
                       obj.setPotencial(variablepotencial);
                break;                     
                                       
                        case 9:
                       obj.setCondpago(variablecondpago);
                break;                  
                                
                      case 10:
                       obj.setGrupo(variablegrupo);
                break;                 
                         
                      case 11:
                       obj.setFechaActualizacion(Fechaactualizacion);
                break;        
                         case 12:
                       obj.setOrsy(variableorsy);
                break;    
                             
                       case 13:
                       obj.setPeriodo1(variableperiodo1);
                break;               
                             
                         case 14:
                       obj.setPeriodo2(variableperiod2);
                break;             
                             
                               case 15:
                       obj.setSml(valoresfinales);
                break;            
                      
                  case 16:
                            obj.setUltFac(fecha);   
                            break;                                      
                                   
                          case 17:
                            obj.setProyeccion(proyeccion);   
                            break;             
                                   
                              case 18:
                            obj.setVar(variablevar);   
                            break;          
                                   
                                  case 19:
                            obj.setLeyenda(valoresfinales);
                            break;     
                                      
                                      
                                      
                               case 20:
                            obj.setQryVendedoresGrupo(variablevendedores);
                            break;      
                                        
                                        
                                        
                               case 21:
                            obj.setNroSup(Integer.parseInt(variableNumeroSuper));
                            break;                
                                        
                                      case 22:
                            obj.setNomSup(valoresfinales);
                            break;  
                                          
                                          
                                           
                                      case 23:
                            obj.setNroVen(Integer.parseInt(variableNumerovendedor));
                            break;               
                                          
                                       case 24:
                            obj.setNomVen(valoresfinales);
                            break;                
                                          
                                          
                                        case 25:
                            obj.setObservacion(valoresfinales);
                            break;                
                                            
                 }

                 }                                           
                                                                    
                                                                    
                                                                    
                                                                    
                /* switch(f){
                     case 0:
                         obj.setNcliente(0513);
                         break;
                         
                      case 1:
                       obj.setNombre(cel.toString());
  break;
                     
                     
                 }
                 
              JavaBeanCtWurth2 bean = new  JavaBeanCtWurth2();
              bean.create(obj);
                 */
                 
                 
 
             }
             
             System.out.println();
             
        
              bean.create(obj);
             
             
             
         }
         
            
            
            
            

            
                                                  //  System.out.println(datos+" ");


           
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
