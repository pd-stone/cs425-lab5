/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author pdstone
 */
@WebServlet(urlPatterns = {"/testServlet"})
public class testServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet testServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet testServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        response.setContentType("application.json/charset=UTF-8");
        
        JSONObject json = new JSONObject();
        
        Map<String, String[]> parameters = request.getParameterMap();
        
        try(PrintWriter out = response.getWriter()) {
            
            for(Map.Entry<String, String[]> e : parameters.entrySet()) {
                
                json.put(e.getKey(), e.getValue()[0]);
            }
            out.println(JSONValue.toJSONString(json));
        }
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
        
        response.setContentType("text/html;charset=UTF-8");
        
        StringBuilder string1 = new StringBuilder();
        
        StringBuilder string2 = new StringBuilder();
        
        string1.append("<!DOCTYPE html><html><head><title>testServlet POST Output</title></head><body>");
        
        Map<String, String[]> parameters = request.getParameterMap();
        
        try(PrintWriter out = response.getWriter()) {
            
            for(Map.Entry<String, String[]> e : parameters.entrySet()) {
                
                string1.append("<p>Key: ").append(e.getKey());
                
                string1.append(", Value: ").append(Arrays.toString(e.getValue())).append("</p>");
                
                string2.append("<p>Key: ").append(e.getKey());
                
                }
            
            string1.append("</bosy></html>");
            
            out.println(string1.toString());
            
            System.err.println(string2.toString());
        }
        
        catch(Exception e) {
            e.printStackTrace();
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
