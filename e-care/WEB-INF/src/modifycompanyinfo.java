import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class modifycompanyinfo extends HttpServlet
{

    public modifycompanyinfo()
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
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        HttpSession httpsession = httpservletrequest.getSession(true);
        String s = (String)httpsession.getValue("code1");
        String s1 = (String)httpsession.getValue("name1");
        String s8 = (String)httpsession.getValue("site1");
        String s2 = (String)httpsession.getValue("lid1");
        String s3 = (String)httpsession.getValue("add1");
        String s4 = (String)httpsession.getValue("city1");
        String s5 = (String)httpsession.getValue("state1");
        String s6 = (String)httpsession.getValue("zip1");
        String s7 = (String)httpsession.getValue("phone1");
        String s11 = httpservletrequest.getParameter("l");
        System.out.println("locationid is " + s11);
        String s12 = httpservletrequest.getParameter("cn");
        System.out.println("Co is " + s12);
        httpsession.putValue("co", s12);
        httpsession.putValue("na", s11);
        System.out.println("Companyname is " + s12);
        System.out.println("LocationId is " + s11);
        try
        {
            rs = st.executeQuery("select * from hdcompanyinfo where location_id='" + s11 + "'");
            if(rs.next())
            {
                String s10 = rs.getString(1);
                String s13 = rs.getString(2);
                String s9 = rs.getString(3);
                System.out.println("ln is " + s10);
                System.out.println("id is " + s13);
                System.out.println("lc is " + s9);
                printwriter.println("<HTML>");
                printwriter.println("<HEAD>");
                printwriter.println("<TITLE></TITLE>");
                printwriter.println("</HEAD>");
                printwriter.println("<BODY>");
                printwriter.println("<form action=./updatecompanyinfo method=post>");
                printwriter.println("<P align=center style='COLOR: forestgreen'><STRONG><U>MODIFY COMPANY_INFO</U></STRONG></P>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                printwriter.println("<TABLE border=0 align=center cellPadding=1 cellSpacing=1 width=100% >");
                printwriter.println("<TR>");
                printwriter.println("<TD>Location Id </TD>");
                printwriter.println("<TD><INPUT id=text1 name=text1 readonly value='" + s11 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>Location Name </TD>");
                printwriter.println("<TD><INPUT id=text2 name=text2  value='" + s13 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>Company Name</TD>");
                printwriter.println("<TD><INPUT id=text3 name=text3 readonly value='" + s12 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD></TD>");
                printwriter.println("<TD>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT id=submit1 name=submit1 type=submit value=Modify>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</P></TD></TR></TABLE> ");
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
    ResultSet rs;
}