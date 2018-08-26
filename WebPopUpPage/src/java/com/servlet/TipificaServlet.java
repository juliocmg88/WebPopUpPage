/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.JavaBeanCtWurth2;
import com.bean.JavaBeanLogSurveyInteractionsWebPage;
import com.entidades.CtWurth2;
import com.entidades.LogsSurveyInteractionsWebPage;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian
 */
public class TipificaServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            JavaBeanLogSurveyInteractionsWebPage jls = new JavaBeanLogSurveyInteractionsWebPage();
            JavaBeanCtWurth2 jcw = new JavaBeanCtWurth2();
            LogsSurveyInteractionsWebPage ls = new LogsSurveyInteractionsWebPage();
            LogsSurveyInteractionsWebPage ls2 = null;
            Long record_id = Long.parseLong(request.getParameter("tipRecordId"));
            CtWurth2 cw = jcw.findCtWurth2(record_id);
            String codTermino = request.getParameter("tipifBox");  
            String fecha=request.getParameter("schedDate");
            String hora=request.getParameter("schedTime");
            if(fecha!=null && !fecha.equals("") && hora!=null && !hora.equals("")){
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date schedTime = format.parse(fecha+" "+hora);
                cw.setSchedTime(schedTime);
            }
            //Actualiza ct_wurth2
            cw.setAttempts(cw.getAttempts()+1);
            cw.setCallResult(terminoStringToInt(codTermino));
            try {
                jcw.edit(cw);
            } catch (Exception ex) {
                Logger.getLogger(TipificaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("/WebPopUpPage/Agent2Servlet");
            //Inserta en logs_survey_interactions_web_page
            Date crrTime = new Date();
            String pregNombre = "";
            String pregCotiza = "";
            String connid = UUID.randomUUID().toString();
            connid = connid.replace("-", "");
            ls.setCrrTime(crrTime);
            ls.setPhone(request.getParameter("tipFono"));
            ls.setConnid(connid);
            ls.setImportId(Integer.parseInt(request.getParameter("tipFono")));
            ls.setRecordId(Math.toIntExact(record_id));
            ls.setChainId(request.getParameter("tipNClient"));
            ls.setCdata01(codTermino);
            ls.setCdata02(request.getParameter("tipNomClient"));
            ls.setCdata03(request.getParameter("tipAgentDn"));  
            ls.setCdata04(request.getParameter("observacionInfo"));    
            if(codTermino.equals("ANSWER")){            
                pregNombre = request.getParameter("contactBox"); 
                ls.setQuestionName("PregNombre");
                ls.setResponseCode(pregNombre);
                ls.setResponseText(pregNombre.toUpperCase().replace("_", ""));
                ls.setQuestionNum(1);
                if(pregNombre.equals("contacto_directo")){
                    ls2=(LogsSurveyInteractionsWebPage)ls.clone();
                    pregCotiza = request.getParameter("cotizaBox");
                    ls2.setQuestionName("PregCotiza");
                    ls2.setResponseCode(pregCotiza);
                    ls2.setResponseText(pregCotiza.toUpperCase().replace("_", ""));
                    ls2.setQuestionNum(2);
                }
            }
            jls.create(ls);
            if(ls2!=null){
                jls.create(ls2);                
            } 
        }
    }
    
    private int terminoStringToInt(String codTermino){
        int codigo=0;
        switch(codTermino){
            case "ANSWER":
                codigo=5;
                break;
            case "UNKNOW":
                codigo=0;
                break;
            case "MACHINE":
                codigo=9;
                break;
            case "NOANSWER":
                codigo=3;
                break;
            case "BUSY":
                codigo=4;
                break;
            case "NOTSURE":
                codigo=11;
                break;
            default:
                codigo=0;
                break;
        }
        return codigo;
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
            Logger.getLogger(TipificaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TipificaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
