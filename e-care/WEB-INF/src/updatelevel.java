import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class updatelevel extends HttpServlet
{

    public updatelevel()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            System.out.println("inside init");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver is created");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            System.out.println("Connection is created");
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
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {
            String s = httpservletrequest.getParameter("text1");
            String s1 = httpservletrequest.getParameter("text2");
            System.out.println(s + s1);
            int i = st.executeUpdate("update hdlevels set LEVELNAME='" + s1 + "' where LEVELCODE='" + s + "'");
            System.out.println(i + " is updated");
            httpservletresponse.sendRedirect("./updatelevel.html");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    Statement st;
    ResultSet rs;
}