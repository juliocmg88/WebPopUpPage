<%-- 
    Document   : agent
    Created on : 04-07-2018, 14:46:40
    Author     : Sebastian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<%
    HttpSession sesion = request.getSession();
    if(sesion.getAttribute("nivel")==null){
        response.sendRedirect("../log_in.jsp");
    } else {
      int nivel = (Integer)sesion.getAttribute("nivel");
      if(nivel <0){
        response.sendRedirect("../log_in.jsp");          
      }
    }
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agent Page</title>
    </head>
    <body>
        <form action="/WebPopUpPage/AgentServlet" method="POST">
        <div align="right">            
            Bienvenid@ Sr@ <%=sesion.getAttribute("fullname") %>
            <a href="../log_in.jsp?cerrar=true">Cerrar Sesion</a>
        </div>
        <h1>Esta es la pagina del agente</h1>
        <%=sesion.getAttribute("id_cliente") %>
        <input type="submit" value="Mostrar Cartera" name="viewButton"/>
        </form>
    </body>
</html>
