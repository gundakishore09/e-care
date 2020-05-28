import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class updatemodule extends HttpServlet
{

    public updatemodule()
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
        String s6 = "";
        String s8 = "";
        String s9 = "";
        String s10 = "";
        String s11 = "";
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        HttpSession httpsession = httpservletrequest.getSession(true);
        s8 = (String)httpsession.getValue("m");
        s9 = (String)httpsession.getValue("c");
        s10 = (String)httpsession.getValue("n");
        s11 = (String)httpsession.getValue("s");
        try
        {
            String s1 = httpservletrequest.getParameter("text1");
            String s3 = httpservletrequest.getParameter("text2");
            String s5 = httpservletrequest.getParameter("text3");
            String s7 = httpservletrequest.getParameter("text4");
            System.out.println("mcode iiiiis" + s1);
            System.out.println("ccode iiiiis" + s3);
            System.out.println("mname iss" + s5);
            System.out.println("status iss" + s7);
            int i = st.executeUpdate("update module set modulename='" + s5 + "',status='" + s7 + "' where moduleid='" + s1 + "'");
            System.out.println(i + " is updated");
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