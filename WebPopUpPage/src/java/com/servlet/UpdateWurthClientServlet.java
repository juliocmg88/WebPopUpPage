/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.JavaBeanCtWurth2;
import com.entidades.CtWurth2;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian
 */
public class UpdateWurthClientServlet extends HttpServlet {

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
                throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            RequestDispatcher rd = null;
            /* TODO output your page here. You may use following sample code. */
            String rowid = request.getParameter("myField");
            rowid=rowid.replace("record_", "");
            rowid=rowid.replace("hoy_", "");
            rowid=rowid.replace("sch_", "");
            JavaBeanCtWurth2 jbcw = new JavaBeanCtWurth2();  
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date ultFactUpd = format.parse(request.getParameter("ultfact_"+rowid));
            Long recordId = Long.parseLong(request.getParameter("record_id_"+rowid));            
            CtWurth2 cwUpd = new CtWurth2();       
            CtWurth2 cwOrg = jbcw.findCtWurth2(recordId);
            cwUpd.setRecordType(cwOrg.getRecordType());    
            cwUpd.setCallTime(cwOrg.getCallTime());
            cwUpd.setSchedTime(cwOrg.getSchedTime());         
            cwUpd.setImportId(cwOrg.getImportId());
            cwUpd.setRecordStatus(cwOrg.getRecordStatus());
            cwUpd.setAttempts(cwOrg.getAttempts());
            cwUpd.setCallResult(cwOrg.getCallResult());
            cwUpd.setCrrTime(cwOrg.getCrrTime());
            cwUpd.setAgentDn(request.getSession().getAttribute("username").toString());
            cwUpd.setNcliente(Integer.parseInt(request.getParameter("ncliente_"+rowid)));
            cwUpd.setNombre(request.getParameter("nombre_"+rowid));
            cwUpd.setComuna(request.getParameter("comuna_"+rowid));
            cwUpd.setDireccion(request.getParameter("direccion_"+rowid));
            cwUpd.setTelefono(Integer.parseInt(request.getParameter("telefono_"+rowid)));
            cwUpd.setContactInfo(request.getParameter("telefono_"+rowid));
            cwUpd.setRamo(request.getParameter("ramo_"+rowid));
            cwUpd.setDivision(request.getParameter("division_"+rowid));
            cwUpd.setOperarios(request.getParameter("operarios_"+rowid));
            cwUpd.setPotencial(request.getParameter("potencial_"+rowid));
            cwUpd.setCondpago(request.getParameter("condpago_"+rowid));
            cwUpd.setGrupo(request.getParameter("grupo_"+rowid));
            cwUpd.setFechaActualizacion(request.getParameter("fechaact_"+rowid));
            cwUpd.setOrsy(request.getParameter("orsy_"+rowid));
            cwUpd.setPeriodo1(request.getParameter("periodo1_"+rowid));
            cwUpd.setPeriodo2(request.getParameter("periodo2_"+rowid));
            cwUpd.setSml(request.getParameter("sml_"+rowid));
            cwUpd.setUltFac(ultFactUpd);
            cwUpd.setProyeccion(request.getParameter("proyeccion_"+rowid));
            cwUpd.setVar(request.getParameter("var_"+rowid));
            cwUpd.setLeyenda(request.getParameter("leyenda_"+rowid));
            cwUpd.setQryVendedoresGrupo(request.getParameter("qry_"+rowid));
            cwUpd.setNroSup(Integer.parseInt(request.getParameter("nro_sup_"+rowid)));
            cwUpd.setNomSup(request.getParameter("nom_sup_"+rowid));
            cwUpd.setNroVen(Integer.parseInt(request.getParameter("nro_ven_"+rowid)));
            cwUpd.setNomVen(request.getParameter("nom_ven_"+rowid));
            cwUpd.setObservacion(request.getParameter("observacion_"+rowid));
            cwUpd.setRecordId(recordId);
            cwUpd.setRecycleCount(cwOrg.getRecycleCount());
            try {
                jbcw.edit(cwUpd);
            } catch (Exception ex) {
                Logger.getLogger(UpdateWurthClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateWurthClientServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Se actualizo el elemento con ID " + cwUpd.getRecordId() + "</h1>");   
            out.println("</body>");
            out.println("</html>");                 
            request.getSession().setAttribute("edited_row",rowid);
            response.sendRedirect("/WebPopUpPage/Agent2Servlet");
            //rd= request.getRequestDispatcher("/Agent2Servlet");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateWurthClientServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateWurthClientServlet.class.getName()).log(Level.SEVERE, null, ex);
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
