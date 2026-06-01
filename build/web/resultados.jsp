<%-- 
    Document   : resultado
    Created on : 28 de mai. de 2026, 22:29:53
    Author     : saimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso!!</title>
        <link rel="stylesheet" href ="style.css">
    </head>
    <body>
        <%
            String msg = (String) request.getAttribute("message");
            %>
            <h1><%out.println(msg);%>realizado com sucesso</h1>
            <div class="btvoltar">
                <a href="index.html">
                    <button class="btn voltar" name ="op" value ="VOLTAR">
                        Voltar
                    </button>
                </a>
            </div>
    </body>
</html>
