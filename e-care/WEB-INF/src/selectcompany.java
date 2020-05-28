import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class selectcompany extends HttpServlet
{

    public selectcompany()
    {
        flag = 0;
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
            st1 = con.createStatement();
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
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        javax.servlet.http.HttpSession httpsession = httpservletrequest.getSession(true);
           String s3 = (String)httpsession.getValue("user");
System.out.println("username "+s3);
        try
        {
            System.out.println("inside try");
            printwriter.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
            printwriter.println("<HTML><HEAD><TITLE></TITLE>");
            printwriter.println("<META content='text/html; charset=unicode' http-equiv=Content-Type>");
            printwriter.println("<META content='MSHTML 5.00.2614.3500' name=GENERATOR></HEAD>");
            printwriter.println("<BODY>");
            printwriter.println("<form  action='./corporateuserview.html'  target='_parent' name=f1 ");
            printwriter.println("style='COLOR: forestgreen'>");
            printwriter.println("<P>&nbsp;</P>");
            printwriter.println("<P align=center><FONT size=5><U><STRONG>Select Company</STRONG> </U></FONT></P>");
            printwriter.println("<P align=center>");
            printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 width='75%'>");
            printwriter.println("<TR>");
            printwriter.println("<TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
            printwriter.println("<strong>Select Company</strong></TD>");
            printwriter.println("<TD><SELECT id=select1 name=select1 style='HEIGHT: 22px; WIDTH: 164px'>");
            String s1;
            for(rs = st.executeQuery("select companyname from userinfo where user_id='"+s3+"'"); rs.next(); printwriter.println("<OPTION value=" + s1 + ">" + s1 + "</OPTION>"))
            {
                s1 = rs.getString(1);
                System.out.println("cname " + s1);
            }

            printwriter.println("</SELECT></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
            printwriter.println("&nbsp;&nbsp;&nbsp; <INPUT id=submit1 name=submit1 type=submit value='    OK    '></TD>");
            printwriter.println("<TD></TD></TR></TABLE></P>");
            printwriter.println("<P align=center>&nbsp;</P></form></BODY></HTML>");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    Connection con;
    Statement st;
    Statement st1;
    ResultSet rs;
    ResultSet rs1;
    int flag;
}