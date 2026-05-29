package controller;

import DAO.ProdutosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produtos;
/**
 *
 * @author saimo
 */

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{
        response.setContentType ("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            
            String op = request.getParameter("op");
            ProdutosDAO pdao = new ProdutosDAO();
            Produtos p = new Produtos();
            
            //=================================CADASTRO==================================
            
            if (op.equals("CADASTRAR")){
                    String nome = request.getParameter("txtnome");
                    p.setNome(nome);
                    String marca = request.getParameter("txtmarca");
                    p.setMarca(marca);
                    String categoria = request.getParameter("txtcategoria");
                    p.setCategoria(categoria);
                    Double preco = Double.parseDouble(request.getParameter("txtpreco"));
                    p.setPreco(preco);
                    int quantidade = Integer.parseInt(request.getParameter("txtquantidade"));
                    p.setQuantidade(quantidade);
                    String cor = request.getParameter("txtcor");
                    p.setCor(cor);
                    Double peso = Double.parseDouble(request.getParameter("txtpeso"));
                    p.setPeso(peso);
                    String descricao = request.getParameter("txtdescricao");
                    p.setDescricao(descricao);
                    String dataCadastro = request.getParameter("txtDataCadastro");
                    p.setDataCadastro(dataCadastro);
                    String msg = "Cadastrar";
                    try {
                        pdao.cadastrar(p);
                        System.out.println("Cadastrado com sucesso!!");
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("resultados.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException ex){
                        System.out.println("Erro ClassNotFound: " + ex.getMessage());
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("erro.jsp").forward(request, response);
                    }
                    
                //==============================DELETAR=================================
                } else if (op.equals("DELETAR")){
                    int id = Integer.parseInt(request.getParameter("txtid"));
                    p.setId(id);
                    //response.setCharacterEncoding("Você confirma essa ação?");
                    //response.getWriter();
                    String msg = "Deletar";
                    try{
                        pdao.deletar(p);
                        List<Produtos> produtos = pdao.consultarTodos();
                        request.setAttribute("listaProdutos",produtos);
                        request.getRequestDispatcher("todosResultados.jsp").forward(request,response);
                    } catch (ClassNotFoundException | SQLException ex) {
                        System.out.println("Erro classNotFound: " + ex.getMessage());
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("erro.jsp").forward(request, response);
                    }
                    
                //============================ATUALIZAR===================================
                
                    } else if (op.equals("ATUALIZAR")){
                    int id = Integer.parseInt(request.getParameter("txtid"));
                    p.setId(id);
                    try {
                        p = pdao.consultarById(p);
                        request.setAttribute("p", p);
                        request.getRequestDispatcher("telaAtualização.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException ex){
                        System.out.println("Erro classNotFound: " + ex.getMessage());
                    }
                    
                //------------------------------------------------------------------------------- 
                
                } else if (op.equals("EFETIVAR ATUALIZAÇÃO"))
                {
                    int id = Integer.parseInt(request.getParameter("txtid"));
                    p.setId(id);
                    String nome = request.getParameter("txtnomeat");
                    p.setNome(nome);
                    String marca = request.getParameter("txtmarcaat");
                    p.setMarca(marca);
                    String categoria = request.getParameter("txtcategoriaat");
                    p.setCategoria(categoria);
                    Double preco = Double.parseDouble(request.getParameter("txtprecoat"));
                    p.setPreco(preco);
                    int quantidade = Integer.parseInt(request.getParameter("txtquantidadeat"));
                    p.setQuantidade(quantidade);
                    String cor = request.getParameter("txtcorat");
                    p.setCor(cor);
                    Double peso = Double.parseDouble(request.getParameter("txtpesoat"));
                    p.setPeso(peso);
                    String descricao = request.getParameter("txtdescricaoat");
                    p.setDescricao(descricao);
                    String dataCadastro = request.getParameter("txtDataCadastroat");
                    p.setDataCadastro(dataCadastro);
                    String msg = "Atualizado";
                    try{
                        pdao.update(p);
                        System.out.println("Tabela atualizada");
                        request.setAttribute("mensagem", msg);
                        request.getRequestDispatcher("resultado.jsp").forward(request,response);
                    } catch (ClassNotFoundException | SQLException ex){
                        System.out.println("Erro classNotFound: " + ex.getMessage());
                    }
                    
                //==============================CONSULTAS=============================================
                
                } else if (op.equals("CONSULTAR TODOS")){
                    try{
                        List<Produtos> lprod = pdao.consultarTodos();
                        request.setAttribute("lprod", lprod);
                        request.getRequestDispatcher("todosResultados.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException ex){
                        System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    }
                    
               //---------------------------------CONSULTA POR ID--------------------------------------
               
                }else if (op.equals("CONSULTAR POR ID")){
                    int id = Integer.parseInt(request.getParameter("txtid"));
                    p.setId(id);
                    try {
                        p = pdao.consultarById(p);
                        if (p.getNome() != null){
                        request.setAttribute("p", p);
                        request.getRequestDispatcher("consultarporid.jsp").forward(request, response);
                        }
                        request.setAttribute("p", "produto não encontrado");
                        request.getRequestDispatcher("erro.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException ex){
                        System.out.println("Erro classNotFound: " + ex.getMessage());
                    }
                //========================================Voltar=======================================
                }else if (op.equals("VOLTAR")){
                    response.sendRedirect("index.html");
                }else {
                    String msg = "Error";
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request,response);
                }
                }
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
        processRequest(request, response);
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
        processRequest(request, response);
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

