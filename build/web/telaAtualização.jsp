<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : telaAtualização
    Created on : 28 de mai. de 2026, 22:30:21
    Author     : saimo
--%>
<%@page import = "model.Produtos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <link rel="stylesheet" href ="style.css">
    </head>
    <body>
        <h1>Produto encontrado</h1>
        <%
            Produtos p = (Produtos) request.getAttribute("p");
        %>
        <% if (p.getDescricao() != null){%>
        <form name ="f1" action="controle_produto" method ="GET">
            <div class ="input-group">
                <label>ID: <%out.print(p.getId());%></label>
                <input type = "hidden" name ="txtid">
            </div>
       
            <div class ="input-group">
                <label>Nome</label>
                <input type ="text" name="txtnomeat" value="<%out.print(p.getNome());%>"><!--  -->
            </div><!--  -->
            
            <div class="input-group"><!--  -->
                <label>Marca</label>
                <input type ="text" name ="txtmarcaat"value="<%out.print(p.getMarca());%>">
            </div>
            
            <div class="input-group">
                <label>Categoria</label>
                <input type="text" name="txtcategoriaat"value="<%out.print(p.getCategoria());%>">
            </div>
            <div class="input-group">
                <label>Preço</label>
                <input type="number" name="txtprecoat"value="<%out.print(p.getPreco());%>">
            </div>
            <div class="input-group">
                <label>Quantidade</label>
                <input type="number" name="txtquantidadeat"value="<%out.print(p.getQuantidade());%>">
            </div>
            <div class="input-group">
                <label>Cor</label>
                <input type="text" name="txtcorat"value="<%out.print(p.getCor());%>">
            </div>
                
            <div class="input-group">
                <label>Peso</label>
                <input type="number" name ="txtpesoat" value="<%out.print(p.getPeso());%>">
            </div>
            
            <div class="input-group">
                <label>Descrição</label>
                <input type ="text" name="txtdescricaoat"value="<%out.print(p.getDescricao());%>"> 
            </div>
            <div class="input-group">
                <label>Data de Cadastro</label>
                <input type="date" name="txtDataCadastroat"value="<%out.print(p.getDataCadastro());%>">
            </div>
        </form>
        <div class="botoes">
            <button class="btn cadastrar" type = "submit" name ="op" value ="EFETIVAR ATUALIZAÇÃO">
                Salvar
            </button>
            <button class="btn salvar" name ="op" value ="VOLTAR">
                Voltar
            </button>
        </div>            
        <%} else {%>
        <h2>Produto não encontrado</h2>
        <button class="btn salvar" align = "center" name ="op" value ="VOLTAR">
                Voltar
            </button>
        <%}%>
    </body>
</html>
