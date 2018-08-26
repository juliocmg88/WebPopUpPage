<%-- 
    Document   : login
    Created on : 24-06-2018, 18:05:11
    Author     : Sebastian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='css/bootstrap.min.css' rel='stylesheet'>
        <link href='css/style-login.css' rel='stylesheet'>
        <!--link href='fonts/fontawesome/font-awesome.min.css' rel='stylesheet'-->
        <link href='fonts/fontwurth/css_wurth_fonts.css' rel='stylesheet'>
        <!-- Javascript -->
        <script src="javascript/jquery-2.1.0.min.js"></script>
        <script src="javascript/1.10.4.jquery-ui.min.js"></script>
        <script src="javascript/jquery-1.11.1.min.js"></script>
        <script src="javascript/bootstrap.min.js"></script>
        <script src="javascript/jquery.nicescroll.min.js"></script>
        <script src="javascript/jquery.backstretch.min.js"></script>
        <script src="javascript/loginscript.js"></script>
        <title>Pagina Login</title>
        <link rel="shortcut icon" href="css/images/favicon.ico" type="image/x-icon">
        <link rel="icon" href="css/images/favicon.ico" type="image/x-icon">
    </head>
    <body>
        <!--div align="center" class="form-bottom">
            <h3>Formulario de Log</h3>
            <hr>
            <form action="LoginServlet" method="POST" class="login-form">
                <input type="text" name="usernameBox" placeholder="Usuario"><br>
                <input type="password" name="passwordBox" placeholder="Contraseña"><br>
                <br>
                <input type="submit" name="btnInicio" class="btn btn-primary" value="Iniciar Sesión">
            </form>
        </div-->
        <div class="top-content">
            <div class="inner-bg">
                <div class="container">
                    <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3 id="initsess">Inicio de Sesión</h3>
                            		<!--p>Ingrese su nombre de usuario y contraseña</p-->
                        		</div>
                        		 
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                        		
                            </div>
                            <div class="form-bottom">
                            <!-- start alert -->
                               
							<!-- end alert -->
							<!-- /bxpadmin/ -->
			                    <form action="Login2Servlet" method="POST" class="login-form">
			                    
			                    	<div class="form-group">
			                    		<label class="sr-only" for="usernameBox">Usuario</label>
			                        	<input type="text" name="usernameBox" placeholder="Usuario..." class="form-username form-control" id="username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="passwordBox">Contraseña</label>
			                        	<input type="password" name="passwordBox" placeholder="Contraseña..." class="form-password form-control" id="password">
			                        </div>
                                                <button type="submit" name="btnInicio" class="btn btn-primary custbtn">Iniciar Sesión</button>
			                    </form>
			                  
		                    </div>
                        </div>
                        <!--div class="col-sm-6 col-sm-offset-3 social-login">
                        	<h3>© Alteor 2018</h3>
                        </div-->
                  </div>
            </div>
        </div>
        <%
          HttpSession sesion = request.getSession();
          int nivel=-1;
          if(request.getAttribute("nivel")!=null){
              nivel = (Integer)request.getAttribute("nivel");
              if(nivel==0){
                  sesion.setAttribute("username", request.getAttribute("username"));
                  sesion.setAttribute("fullname", request.getAttribute("fullname"));
                  sesion.setAttribute("nivel", nivel);
                  response.sendRedirect("Admin/admin.jsp");
              }
              if(nivel==1){
                  sesion.setAttribute("username", request.getAttribute("username"));
                  sesion.setAttribute("fullname", request.getAttribute("fullname"));
                  sesion.setAttribute("anexo", request.getAttribute("anexo"));
                  sesion.setAttribute("nivel", nivel);
                  response.sendRedirect("/WebPopUpPage/Agent2Servlet");
              }
          }
          
          if(request.getParameter("cerrar")!=null){
              session.invalidate();
          }
        %>
    </body>
</html>
