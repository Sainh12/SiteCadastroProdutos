<%-- 
    Document   : telaAtualizacao
    Created on : 28 de mai. de 2026, 22:30:21
    Author     : saimo
--%>
<%@page import ="model.Produtos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <link rel="stylesheet" href ="style.css">
    </head>
    <body>
        <%
            Produtos p = (Produtos) request.getAttribute("p");
        %>
        <% if (p != null && p.getId() != 0) {%>

        <div class="container">

            <h1>Produto encontrado</h1>

            <form class="form-produto" name = "f2" action = "controller" method = "GET">

                <div class ="input-group">
                    <label>ID: <%out.print(p.getId());%></label>
                    <input type = "hidden" name ="txtidat" value = "<%out.print(p.getId());%>">
                </div>

                <div class ="input-group">
                    <label>Nome: </label>
                    <input type ="text" name="txtnomeat" value="<%out.print(p.getNome());%>">
                </div>

                <div class="input-group">
                    <label>Marca: </label>
                    <input type ="text" name ="txtmarcaat" value="<%out.print(p.getMarca());%>">
                </div>

                <div class="input-group">
                    <label>Categoria: </label>
                    <input type="text" name="txtcategoriaat" value="<%out.print(p.getCategoria());%>">
                </div>

                <div class="input-group">
                    <label>Preço: </label>
                    <input type="text" name="txtprecoat" value="<%out.print(p.getPreco());%>">
                </div>

                <div class="input-group">
                    <label>Quantidade: </label>
                    <input type="text" name="txtquantidadeat" value="<%out.print(p.getQuantidade());%>">
                </div>

                <div class="input-group">
                    <label>Cor: </label>
                    <input type="text" name="txtcorat" value="<%out.print(p.getCor());%>">
                </div>

                <div class="input-group">
                    <label>Peso: </label>
                    <input type="text" name ="txtpesoat" value="<%out.print(p.getPeso());%>">
                </div>

                <div class="input-group">
                    <label>Descrição: </label>
                    <input type ="text" name="txtdescricaoat" value="<%out.print(p.getDescricao());%>"> 
                </div>

                <div class="input-group">
                    <label>Data de Cadastro: </label>
                    <input type="text" name="txtDataCadastroat" value="<%out.print(p.getDataCadastro());%>">
                </div>

                <div class="botoes">
                    <button class="btn salvar" type ="submit" name ="op" value="EFETIVAR_ATUALIZACAO">
                        Salvar
                    </button>
                </div>
            </form>        
            <%} else {%>
            <h1>Produto não encontrado</h1>
            <%}%>
        </div>
        <div class="btvoltar">
            <a href="index.html">
                <button class="btn voltar" name ="op" value ="VOLTAR">
                    Voltar
                </button>
            </a>
        </div>
    </body>
</html>
