<!--%@page import="jdk.nashorn.internal.ir.RuntimeNode.Request"%-->
<!--%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--CSS-->
        <link href='css/bootstrap.min.css' rel='stylesheet'>
        <link href='css/style-login.css' rel='stylesheet'>
        <link href='css/style-new-user.css' rel='stylesheet'>
        <link href='fonts/fontawesome/font-awesome.min.css' rel='stylesheet'>
        <!-- Javascript -->
        <script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
        <script src="javascript/jquery-1.11.1.min.js"></script>
        <script src="javascript/bootstrap.min.js"></script>
        <script src="javascript/jquery.nicescroll.min.js"></script>
        <script src="javascript/jquery.backstretch.min.js"></script>
        <script src="javascript/new_user_actions.js"></script>
<title>Registro de Usuario</title>
</head>
<body class="col-sm-6 top-left text-justify" align="left">
        <div class="col-sm-6 top-left text-justify" align="left">
            <div class="inner-bg">
                <div class="container">
                    <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3 id="form-title">Registro de Nuevo Ejecutivo</h3>
                            		<p>Rellene todos los campos a continuación:</p>
                        		</div>                        		
                            </div>    
<div class="form-group">
<form action="MServlet" method="post" class="form-top">
    <div class="form-group">
            <label for="firstname">Primer Nombre</label>
            <input type="text" name="firstname" id="firstname" placeholder="Solo Letras"/>
            <label for="middlename">Segundo Nombre</label>
            <input type="text" name="middlename" id="middlename" placeholder="Solo Letras"/>
    </div>
    <div class="form-group">
            <label for="lastname">Apellido Paterno</label>
            <input type="text" name="lastname" id="lastname" placeholder="Solo Letras"/>
            <label for="lastname2">Apellido Materno</label>
            <input type="text" name="lastname2" id="lastname2" placeholder="Solo Letras"/>
    </div>
    <div>
	 <label for="rut">Rut</label>
	 <input type="text" name="rut" id="rut" placeholder="Ej.: 12345678-9"/>
         <label for="anexo">Anexo</label>
	 <input type="text" name="anexo" id="anexo"  placeholder="Solo Numeros"/>
    </div>
    <div>
	<label for="password">Password</label>
	 <input type="password" name="password" id="password"  placeholder="Entre 5 y 8 caracteres"/>
        <span>
	<label for="password2">Confirmar Password</label>
	 <input type="password" name="password2" id="password2" onChange="checkPasswordMatch();"/>
        <label id="divCheckPasswordMatch"></label>
        </span>
    </div>
    <button type="submit" id="saveUser" name="btnInicio" class="btn btn-primary">Guardar persona</button>
    <button id="backLink" class="btn btn-primary">Atras</button>
    
</form>
</div>
</div>
                    </div>
                    </div>
            </div>
<!--form action="MServlet" method="get">
	 <input type="submit" value="Consultar persona" /><br/>
</form-->
</body>
</html>