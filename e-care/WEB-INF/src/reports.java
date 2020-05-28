// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 1/13/2000 12:18:56 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   reports.java

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class reports extends HttpServlet
{

    public reports()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver is created");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            System.out.println("Connection is created");
            st = con.createStatement();
            System.out.println("statement is created");
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        printwriter.println("<html>");
        printwriter.println("<center><h1><font color=forestgreen>HD Problem Desk</h1>");
        printwriter.println("<body>");
        printwriter.println("<form> ");
        printwriter.println("<TABLE bgcolor=white border=1 cellPadding=1 cellSpacing=1 width=80% align=center>");
        printwriter.println("<P><P align=center>");
        printwriter.println("<TR>");
        printwriter.println("<TD><a href=./problemcomplete><strong>Completed Problems</strong></a></TD>");
        printwriter.println("<TD><a href=./viewproblem><strong>Problems History</strong></a></td></tr>");
        printwriter.println("<TR>");
        printwriter.println("<TD><a href=./problempending><strong>Pending Problems</strong></a></TD>");
        printwriter.println("<TD><a href=./categoryuserlist><strong>Category-UserList</strong></a></td>");
        printwriter.println("</TR></TABLE></P>");
        printwriter.println("</form></body></html>");
    }

    Connection con;
    Statement st;
    Statement st1;
    ResultSet rs;
}