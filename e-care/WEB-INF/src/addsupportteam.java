import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class addsupportteam extends HttpServlet
{

    public addsupportteam()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            System.out.println("nnnnnnnnnnnnnnn");
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
        String s4 = "yes";
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {
            String s = httpservletrequest.getParameter("text1");
            String s1 = httpservletrequest.getParameter("text2");
            String s2 = httpservletrequest.getParameter("text3");
            String s3 = httpservletrequest.getParameter("text4");
            System.out.println("Before inserting");
            int i = st.executeUpdate("insert into supportteam values('" + s + "','" + s1 + "','" + s2 + "','" + s3 + "')");
            System.out.println(i + " One row is inserted");
            System.out.println("After query");
            httpservletresponse.sendRedirect("./supportteamconfirm.html");
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