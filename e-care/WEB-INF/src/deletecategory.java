
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class deletecategory extends HttpServlet
{

    public deletecategory()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            System.out.println("inside try");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver is created");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            System.out.println("Connection is created");
            st = con.createStatement();
            System.out.println("statement is created");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        String s = "";
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        String s6 = httpservletrequest.getParameter("c");
        System.out.println("Co is " + s6);
        String s7 = httpservletrequest.getParameter("n");
        System.out.println("Name is " + s7);
        String s8 = httpservletrequest.getParameter("s");
        System.out.println("status is " + s8);
        System.out.println("before try");
        System.out.println("Code is " + s);
        System.out.println("Name is " + s1);
        System.out.println("status is " + s2);
        try
        {
            int i = st.executeUpdate("delete from categoryies where categoryid='" + s6 + "'");
            System.out.println("deleted:" + i);
            httpservletresponse.sendRedirect("./categories");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    Connection con;
    Statement st;
    ResultSet rs;
}