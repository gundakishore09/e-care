import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class updatelevel1category extends HttpServlet
{

    public updatelevel1category()
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
        System.out.println("This is my service");
        String s = "";
        String s2 = "";
        String s4 = "";
        String s5 = "";
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        HttpSession httpsession = httpservletrequest.getSession(true);
        s4 = (String)httpsession.getValue("co");
        s5 = (String)httpsession.getValue("na");
        try
        {
            String s1 = httpservletrequest.getParameter("text1");
            String s3 = httpservletrequest.getParameter("text2");
            System.out.println("code is" + s1);
            System.out.println("cname is" + s3);
            int i = st.executeUpdate("update hdfirstlevelcategory set categoryname='" + s3 + "' where categorycode='" + s1 + "'");
            System.out.println("update hdcategory set categoryname='" + s3 + "' where categorycode='" + s1 + "'");
            System.out.println(i + " is updated");
            httpservletresponse.sendRedirect("./level1category");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    Statement st;
    ResultSet rs;
}