/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.BierExpert;

/**
 *
 * @author frankcoenen
 */
@WebServlet(name = "BierServlet", urlPatterns = {"/BierServlet", "/bierOpKleur", "/bierOpLand"})
public class BierServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String kleur = request.getParameter("kleur");

            BierExpert be = new BierExpert();
            List<String> bierAdvies = be.getBierOpKleur(kleur);

            out.println("<head>");
            out.println("<title>Servlet BierAdvies</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bier Advies</h1>");

            for (String ba : bierAdvies) {
                out.println("<br> probeer: " + ba);
            }

            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //processRequest(request, response);

        String userPath = request.getServletPath();
        if (userPath.equals("/bierOpKleur")) {
            RequestDispatcher view = request.getRequestDispatcher("view/bierOpKleur.jsp");
            view.forward(request, response);
        } else {
            if (userPath.equals("/bierOpLand")) {
                RequestDispatcher view = request.getRequestDispatcher("view/bierOpLand.jsp");
                view.forward(request, response);
            } else {
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
            }
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // processRequest(request, response);
        String userPath = request.getServletPath();
        System.out.println("Userpath :" + userPath);
                
        if (userPath.equals("/bierOpKleur")) {


            String kleur = request.getParameter("kleur");

            BierExpert be = new BierExpert();
            List<String> bierMerken = be.getBierOpKleur(kleur);

            request.setAttribute("bierMerken", bierMerken);
            RequestDispatcher view = request.getRequestDispatcher("view/bierAdvies.jsp");
            view.forward(request, response);

        } else {
            if (userPath.equals("/bierOpLand")) {

                String land = request.getParameter("land");

                BierExpert be = new BierExpert();
                List<String> bierMerken = be.getBierOpLand(land);

                request.setAttribute("bierMerken", bierMerken);
                RequestDispatcher view = request.getRequestDispatcher("view/bierAdvies.jsp");
                view.forward(request, response);

            } else {
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
            }
        }
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
