import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class viewemployee extends HttpServlet
{

    public viewemployee()
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
        System.out.println("inside service");
        String s = "";
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        int i = 0;
        int j = 0;
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {
            rs = st.executeQuery("select * from hdemp where userid='" + s1 + "'");
            if(rs.next())
            {
                s = rs.getString(1);
                System.out.println("lname" + s);
                s1 = rs.getString(2);
                System.out.println("userid" + s1);
                s7 = rs.getString(3);
                s2 = rs.getString(4);
                s3 = rs.getString(5);
                s4 = rs.getString(6);
                s5 = rs.getString(7);
                j = rs.getInt(8);
                i = rs.getInt(9);
                s6 = rs.getString(10);
                System.out.println("email" + s6);
            }
            printwriter.println("<HTML>");
            printwriter.println("<HEAD>");
            printwriter.println("<TITLE></TITLE>");
            printwriter.println("</HEAD>");
            printwriter.println("<BODY>");
            printwriter.println("<form name=f1 action='./viewemployee'>");
            printwriter.println("<P>");
            printwriter.println("<TABLE border=0 align='center' cellPadding=1 cellSpacing=1 width=75%>");
            printwriter.println(" <TR>");
            printwriter.println("   <TD></TD>");
            printwriter.println("<TD><FONT size=4><STRONG>View Employee Details</STRONG></FONT></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD></TD>");
            printwriter.println(" <TD>  </TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("  <TD>Level name</TD>");
            printwriter.println("<TD><INPUT id=text1 name=text1 value='" + s + "' ></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD>Userid</TD>");
            printwriter.println("<TD><INPUT id=text2 name=text2 value='" + s1 + "'></TD></TR>");
            printwriter.println(" <TR>");
            printwriter.println("<TD>Employeename</TD>");
            printwriter.println("   <TD><INPUT id=text3 name=text3 value='" + s7 + "'></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD>Address</TD>");
            printwriter.println("<TD><INPUT id=text4 name=text4 value='" + s2 + "'></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>City</TD>");
            printwriter.println(" <TD><INPUT id=text5 name=text5 value='" + s3 + "'></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD>State</TD>");
            printwriter.println("  <TD><INPUT id=text6 name=text6 value='" + s4 + "'></TD></TR>");
            printwriter.println("  <TR>");
            printwriter.println("  <TD>Country</TD>");
            printwriter.println("  <TD><INPUT id=text7 name=text7 value='" + s5 + "'></TD></TR>");
            printwriter.println(" <TR>");
            printwriter.println("  <TD>Zipcode</TD>");
            printwriter.println("  <TD><INPUT id=text8 name=text8 value='" + j + "'></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("    <TD>Phno</TD>");
            printwriter.println("    <TD><INPUT id=text9 name=text9 value='" + i + "'></TD></TR>");
            printwriter.println(" <TR>");
            printwriter.println("   <TD>Email</TD>");
            printwriter.println("   <TD><INPUT id=text10 name=text10 value='" + s6 + "'></TD></TR>");
            printwriter.println(" <TR>");
            printwriter.println("  <TD></TD>");
            printwriter.println("  <TD><INPUT id=submit1 name=submit1 type=submit value=Submit></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD></TD>");
            printwriter.println("  <TD></TD></TR></TABLE></P>");
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