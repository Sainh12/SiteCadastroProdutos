<%-- 
    Document   : consultarporid
    Created on : 28 de mai. de 2026, 22:30:45
    Author     : saimo
--%>
<%@page import="model.Produtos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto encontrado</title>
        <link rel="stylesheet" href ="style.css">
    </head>
    <body>
        <h1>Produto Encontrado</h1>
        <table class ="tabela">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Marca</th>
                <th>Categoria</th>
                <th>Preço</th>
                <th>Quantidade</th>
                <th>Cor</th>
                <th>Peso</th>
                <th>Descrição</th>
                <th>Data de Cadastro</th>
                <th>Remover</th>
                <th>Editar</th>
            </tr>
            <%
            Produtos p = (Produtos) request.getAttribute("p");
            %>
            <tr>
                <td><%out.print(p.getId());%></td>
                <td><%out.print(p.getNome());%></td>
                <td><%out.print(p.getMarca());%></td>
                <td><%out.print(p.getCategoria());%></td>
                <td><%out.print(p.getPreco());%></td>
                <td><%out.print(p.getQuantidade());%></td>
                <td><%out.print(p.getCor());%></td>
                <td><%out.print(p.getPeso());%></td>
                <td><%out.print(p.getDescricao());%></td>
                <td><%out.print(p.getDataCadastro());%></td>
                <td align="center"><a href="controller?op=DELETAR&txtid=<%out.print(p.getId());%>" <div>Delet</div></a></td>
                <td align="center"><a href="controller?op=ATUALIZAR&txtid=<%out.print(p.getId());%>"<div>Update</div></a></td>
            </tr>
        </table>
        <div class="btvoltar">
            <a href="index.html">
                <button class="btn voltar" name ="op" value ="VOLTAR">
                    Voltar
                </button>
            </a>
        </div>
    </body>
</html>
