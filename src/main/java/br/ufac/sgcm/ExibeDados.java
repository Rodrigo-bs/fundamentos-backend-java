package br.ufac.sgcm;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExibeDados extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mensagem = req.getParameter("mensagem");

        PrintWriter saida = resp.getWriter();
        saida.print("<html>");
        saida.print("<body>");
        saida.print("<p>" + mensagem + "</p>");
        saida.print("</body>");
        saida.print("</html>");
    }
}
