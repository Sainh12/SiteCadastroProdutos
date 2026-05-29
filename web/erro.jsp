<%-- 
    Document   : erro
    Created on : 28 de mai. de 2026, 22:32:07
    Author     : saimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
            <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <%
            String msg = (String) request.getAttribute("message");
            %>
            <h1><%out.println(msg);%> Não realizado</h1>
            <button class="btn salvar" align = "center" name ="op" value ="VOLTAR">
                Voltar
            </button>
    </body>
</html>
