import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class modifycategories extends HttpServlet
{

    public modifycategories()
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
            st2 = con.createStatement();
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
        String s = "yes";
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        javax.servlet.http.HttpSession httpsession = httpservletrequest.getSession(true);
        System.out.println("jhfsj");
        String s4 = httpservletrequest.getParameter("n");
        System.out.println("Name is " + s4);
        String s5 = httpservletrequest.getParameter("c");
        System.out.println("Co is " + s5);
        String s6 = httpservletrequest.getParameter("s");
        System.out.println("st is " + s6);
        try
        {
            rs2 = st2.executeQuery("select * from categoryies where categoryid='" + s5 + "'");
            System.out.println("in the try\n");
            if(rs2.next())
            {
                String s2 = rs2.getString(1);
                String s3 = rs2.getString(2);
                String s1 = rs2.getString(3);
                printwriter.println("<HTML>");
                printwriter.println("<HEAD>");
                printwriter.println("<TITLE></TITLE>");
                printwriter.println("</HEAD>");
                printwriter.println("<BODY>");
                printwriter.println("<form action=./updatecategory1 method=post>");
                printwriter.println("<P align='center' style='COLOR: forestgreen'><STRONG><U>MODIFY LEVEL_INFO</U></STRONG></P>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                printwriter.println("<TABLE border=0 align='center' cellPadding=1 cellSpacing=1 width='75%' >");
                printwriter.println("<TR>");
                printwriter.println("<TD>CategoryId</TD>");
                printwriter.println("<TD><INPUT id=text1 name=text1 value='" + s2 + "'readonly></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>CategoryName</TD>");
                printwriter.println("<TD><INPUT id=text2 name=text2 value='" + s3 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>Status</TD>");
                printwriter.println("<TD><INPUT id=text3 name=text3 value='" + s1 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD></TD>");
                printwriter.println("<TD>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT id=submit1 name=submit1 type=submit value=Modify>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P></TD></TR></TABLE>");
                printwriter.println("</P>");
                printwriter.println("</form>");
                printwriter.println("</BODY>");
                printwriter.println("</HTML>");
            }
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    Connection con;
    Statement st;
    Statement st2;
    ResultSet rs;
    ResultSet rs2;
}