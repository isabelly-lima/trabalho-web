/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Fornecedor_Pedido;

/**
 *
 * @author Deus Grego
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //variavel que recebera o valor da flag enviada pelo formulário
        String  flag = request.getParameter("flag");
        try (PrintWriter out = response.getWriter()) {
            if(flag == null){
                //direciona para a pagina de erro
                request.getRequestDispatcher("index.html").forward(request, response);
            }else{
                response.setContentType("text/html;charset=UTF-8");
                String nome = request.getParameter("nome");
                String cidade=request.getParameter("cidade");
                String cnpj= request.getParameter("cnpj");
                String email=request.getParameter("email");
                String endereco =request.getParameter("endereco");
                String razaoSocial=request.getParameter("razaoSocial");
                String telefone=request.getParameter("telefone");
                String senha = request.getParameter("senha");
                
                out.print("Nome: " + nome+"<br>");
                out.print("cidade: " + cidade+"<br>");
                out.print("cnpj: " + cnpj+"<br>");
                out.print("email: " + email+"<br>");
                out.print("endereço: " +endereco+"<br>");
                out.print("Razão Social: " + razaoSocial+"<br>");
                out.print("Telefone: " + telefone+"<br>");
                out.print("Senha: " + senha+"<br>");
                
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
