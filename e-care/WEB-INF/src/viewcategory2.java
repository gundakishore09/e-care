import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class viewcategory2 extends HttpServlet
{

    public viewcategory2()
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
        String s2 = "yes";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        String s = httpservletrequest.getParameter("c");
        System.out.println(s);
        String s1 = httpservletrequest.getParameter("n");
        System.out.println(s1);
        s2 = httpservletrequest.getParameter("s");
        System.out.println(s2);
        try
        {
            rs = st.executeQuery("select * from categoryies where categoryid='" + s + "'");
            if(rs.next())
            {
                s3 = rs.getString(1);
                System.out.println("categorycode is :" + s3);
                s4 = rs.getString(2);
                System.out.println("categoryname is:" + s4);
                s5 = rs.getString(3);
                System.out.println("categorystatus is:" + s5);
            }
            printwriter.println("<HTML>");
            printwriter.println("<HEAD>");
            printwriter.println("<TITLE></TITLE>");
            printwriter.println("</HEAD>");
            printwriter.println("<BODY>");
            printwriter.println("<form name=f1 action='./categories1'>");
            printwriter.println("<P>");
            printwriter.println("<TABLE border=0 align='center' cellPadding=1 cellSpacing=1 width=75%>");
            printwriter.println(" <TR>");
            printwriter.println(" </TR>");
            printwriter.println(" <TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD><FONT size=4><STRONG><U>View Category Details</U></STRONG></FONT></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD></TD>");
            printwriter.println(" <TD>  </TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD></TD>");
            printwriter.println(" <TD>  </TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD></TD>");
            printwriter.println(" <TD>  </TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>CategoryId</strong></TD>");
            printwriter.println("<TD>" + s3 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD><strong>CategoryName</strong></TD>");
            printwriter.println("<TD>" + s4 + "</TD></TR>");
            printwriter.println(" <TR>");
            printwriter.println("<TD><strong>Status</strong></TD>");
            printwriter.println("<TD>" + s5 + "</TD></TR>");
            printwriter.println(" <TR>");
            printwriter.println(" <TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD><INPUT id=submit1 name=submit1 type=submit value=OK></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR></TABLE></P>");
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