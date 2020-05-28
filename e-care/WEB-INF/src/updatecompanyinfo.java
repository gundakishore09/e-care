import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class updatecompanyinfo extends HttpServlet
{

    public updatecompanyinfo()
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
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        HttpSession httpsession = httpservletrequest.getSession(true);
        String s11 = (String)httpsession.getValue("na");
        String s10 = (String)httpsession.getValue("id");
        String s9 = (String)httpsession.getValue("co");
        String s17 = (String)httpsession.getValue("add");
        String s12 = (String)httpsession.getValue("city");
        String s13 = (String)httpsession.getValue("state");
        String s14 = (String)httpsession.getValue("zip");
        String s15 = (String)httpsession.getValue("phone");
        String s16 = (String)httpsession.getValue("na1");
        try
        {
            String s = httpservletrequest.getParameter("text1");
            String s1 = httpservletrequest.getParameter("text2");
            String s2 = httpservletrequest.getParameter("text3");
            String s3 = httpservletrequest.getParameter("text4");
            String s4 = httpservletrequest.getParameter("text5");
            String s5 = httpservletrequest.getParameter("text6");
            String s6 = httpservletrequest.getParameter("text7");
            String s7 = httpservletrequest.getParameter("text8");
            String s8 = httpservletrequest.getParameter("text9");
            System.out.println(s + s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8);
            int i = st.executeUpdate("update hdcompanyinfo set location_name='"+s1+"', address='" + s3 + "',city='" + s4 + "',state='" + s5 + "',zip=" + s6 + ",phone=" + s7 + " where location_id='" + s + "'");
            System.out.println(i + " is updated");
            if(i == 1)
                httpservletresponse.sendRedirect("./updatecompanyinfo.html");
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