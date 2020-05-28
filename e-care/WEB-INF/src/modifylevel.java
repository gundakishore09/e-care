import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class modifylevel extends HttpServlet
{

    public modifylevel()
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
        String s2 = "";
        String s3 = "";
        PrintWriter printwriter = httpservletresponse.getWriter();
        String s = httpservletrequest.getParameter("c");
        String s1 = httpservletrequest.getParameter("n");
        httpservletresponse.setContentType("text/html");
        try
        {
            rs = st.executeQuery("select levelcode,levelname from hdlevels where levelcode='" + s + "'");
            if(rs.next())
            {
                s2 = rs.getString(1);
                s3 = rs.getString(2);
                System.out.println("lc is " + s2);
                System.out.println("ln is " + s3);
                printwriter.println("<HTML>");
                printwriter.println("<HEAD>");
                printwriter.println("<TITLE></TITLE>");
                printwriter.println("</HEAD>");
                printwriter.println("<script language='JavaScript'>");
                printwriter.println("function canc()");
                printwriter.println("{");
                printwriter.println("document.f1.action='./levels';");
                printwriter.println("document.f1.submit();");
                printwriter.println("}");
                printwriter.println("function sub()");
                printwriter.println("{");
                printwriter.println("document.f1.action='./updatelevel';");
                printwriter.println("document.f1.submit();");
                printwriter.println("}");
                printwriter.println("</script>");
            }
            printwriter.println("<BODY>");
            printwriter.println("<form name=f1 >");
            printwriter.println("<P align='center' style='COLOR: forestgreen'><STRONG><U>MODIFY LEVEL_INFO</U></STRONG></P>");
            printwriter.println("<P>&nbsp;</P>");
            printwriter.println("<P>&nbsp;</P>");
            printwriter.println("<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("<TABLE border=0 align='center' cellPadding=1 cellSpacing=1 width='75%' >");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Level code</strong></TD>");
            printwriter.println("<TD><INPUT id=text1 name=text1 value='" + s2 + "' readonly></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Level name</strong></TD>");
            printwriter.println("<TD><INPUT id=text2 name=text2 value='" + s3 + "'></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P>&nbsp;</P>");
            printwriter.println("<P><INPUT id=submit1 name=submit1 type=submit value=Modify onClick='sub()'>&nbsp;&nbsp;");
            printwriter.println("<INPUT id=button1 name=button1 type=button value=Cancel Onclick='canc()'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P></TD></TR></TABLE></TABLE>");
            printwriter.println("</form>");
            printwriter.println("</BODY>");
            printwriter.println("</HTML>");
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