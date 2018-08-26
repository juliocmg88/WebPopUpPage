<%-- 
    Document   : admin
    Created on : 24-06-2018, 21:23:35
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
      if(nivel !=0){
        response.sendRedirect("../log_in.jsp");          
      }
    }
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--CSS-->
        <link href='../css/bootstrap.min.css' rel='stylesheet'>
        <link href='../css/style-login.css' rel='stylesheet'>
        <link href='../fonts/fontawesome/font-awesome.min.css' rel='stylesheet'>
        <title>Pagina de Administrador</title>
    </head>
    <body>
        <div align="right">            
            Bienvenid@ Sr@ <%=sesion.getAttribute("fullname") %>
            <a class="btn btn-primary navbar-btn" href="../index.jsp?cerrar=true">Agregar Usuario</a>
            <a class="btn btn-primary navbar-btn" href="../log_in.jsp?cerrar=true">Cerrar Sesion</a>
        </div>
        <h1>Esta es la pagina de administrador</h1>
    </body>
</html>
