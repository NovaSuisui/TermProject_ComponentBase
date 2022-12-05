/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.webModel;
import serviceclient.Cv19Ddc;

/**
 *
 * @author SK
 */
@WebServlet(name = "Cv19Control", urlPatterns = {"/Cv19ServletControl"})
public class Cv19Servlet extends HttpServlet {

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
        synchronized(getServletContext()){
            if(request.getParameter("UpdateData") != null){
                try{
                    String res = webModel.updateDataFromSoap();
                    request.setAttribute("res", res);
                    request.getRequestDispatcher("/UpdateRes.jsp").forward(request, response);
                }
                catch(Exception e){
                    request.getRequestDispatcher("/index.html").forward(request, response);
                }
            }
            else if(request.getParameter("FindAllData") != null){
                List<Cv19Ddc> l = webModel.allDataFromSoap();
                request.setAttribute("dataList", l);
                request.getRequestDispatcher("/ShowTable.jsp").forward(request, response);
            }
            else if(request.getParameter("FindByYear") != null){
                int year = Integer.parseInt(request.getParameter("year"));
                List<Cv19Ddc> l = webModel.yearDataFromSoap(year);
                request.setAttribute("dataList", l);
                request.getRequestDispatcher("/ShowTable.jsp").forward(request, response);
            }
            else if(request.getParameter("FindByYearAndWeek") != null){
                int year = Integer.parseInt(request.getParameter("yearnum"));
                int week = Integer.parseInt(request.getParameter("weeknum"));
                List<Cv19Ddc> l = webModel.yearweekDataFromSoap(year, week);
                request.setAttribute("dataList", l);
                request.getRequestDispatcher("/ShowTable.jsp").forward(request, response);
            }
            else{
                //request.getRequestDispatcher("/index.html").forward(request, response);
            }
            return;
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
