/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "ck", urlPatterns = {"/ck"})
public class ck extends HttpServlet {
   @Override
    public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        String uname = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        String secf = request.getParameter("se");
        String hof = request.getParameter("hof");
        String cName= "login-cookie";
        String cValue = "AWi3m122klvcXbiOq6B0";
        if(uname.equals("admin") && password.equals("admin")){
                     
            if(secf == null ? hof ==null : secf.equals(hof)){
               
               Cookie c = new Cookie(cName, cValue);
               c.setMaxAge(150);
               c.setDomain("localhost");
               c.setPath("/");
               c.setSecure(false);
               c.setHttpOnly(false);
               response.addCookie(c);
               request.getRequestDispatcher("newhtml.html").forward(request, response);
            }
            else if(secf!=null && hof!=null){
                if(secf.equals("sfTrue")&& hof.equals("hofTrue")){
                    //out.print("b c");
                    Cookie c = new Cookie(cName, cValue);
                    c.setMaxAge(150);
                    c.setDomain("localhost");
                    c.setPath("/");
                    c.setSecure(true);
                    c.setHttpOnly(true);
                    response.addCookie(c);
                    request.getRequestDispatcher("newhtml.html").forward(request, response);
                }                
            }
            else if(secf!=null){
                if(secf.equals("sfTrue")&& hof==null ){
                    //out.print("sf t");
                    Cookie c = new Cookie(cName, cValue);
                    c.setMaxAge(120);
                    c.setDomain("localhost");
                    c.setPath("/");
                    c.setSecure(true);
                    c.setHttpOnly(false);
                    response.addCookie(c);
                    request.getRequestDispatcher("newhtml.html").forward(request, response);
                }
            }
            else if(hof!=null){
                if(hof.equals("hofTrue")&& secf==null){
                   
                    Cookie c = new Cookie(cName, cValue);
                    c.setMaxAge(120);
                    c.setDomain("localhost");
                    c.setPath("/");
                    c.setSecure(false);
                    c.setHttpOnly(true);
                    response.addCookie(c);
                    request.getRequestDispatcher("newhtml.html").forward(request, response);                    
                }
            }
        }
        else
           out.print("Invalid Username or Password!");
    }
    
}
