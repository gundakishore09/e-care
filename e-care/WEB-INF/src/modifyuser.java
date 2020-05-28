import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class modifyuser extends HttpServlet
{

    public modifyuser()
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
        String s = "";
        String s2 = "";
        String s4 = "";
        String s6 = "";
        String s8 = "";
        String s10 = "";
        String s12 = "";
        String s14 = "";
        String s16 = "";
        String s18 = "";
        String s20 = "";
        boolean flag = false;
        boolean flag1 = false;
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        javax.servlet.http.HttpSession httpsession = httpservletrequest.getSession(true);
        s14 = httpservletrequest.getParameter("u");
        System.out.println("user id is " + s14);
        try
        {
            rs2 = st2.executeQuery("select * from registration where user_id='" + s14 + "'");
            System.out.println("in the try\n");
            if(rs2.next())
            {
                System.out.println("inside if");
                String s1 = rs2.getString("fname");
                System.out.println("fname" + s1);
                String s3 = rs2.getString("lname");
                String s5 = rs2.getString("address");
                String  j = rs2.getString("phno");
                String s7 = rs2.getString("state");
                String s9 = rs2.getString("city");
                String s11 = rs2.getString("country");
                String i = rs2.getString("zipcode");
                String s13 = rs2.getString("email_id");
                String s15 = rs2.getString("user_id");
                String s17 = rs2.getString("password");
                String s19 = rs2.getString("hintquestion");
                String s21 = rs2.getString("hintsolution");
                printwriter.println("<HTML>");
                printwriter.println("<HEAD>");
                printwriter.println("<TITLE></TITLE>");
                printwriter.println("</HEAD>");
                printwriter.println("<BODY>");
                printwriter.println("<form action=./updateuser method=post>");
                printwriter.println("<P align='center' style='COLOR: forestgreen'><STRONG><U>MODIFY User_INFO</U></STRONG></P>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                printwriter.println("<TABLE border=0 align='center' cellPadding=1 cellSpacing=1 width='75%' >");
                printwriter.println("<TR>");
                printwriter.println("<TD>FirstName</TD>");
                printwriter.println("<TD><INPUT id=text1 name=text1 value='" + s1 + "'></TD></TR>");
                printwriter.println("<TD>LastName</TD>");
                printwriter.println("<TD><INPUT id=text2 name=text2 value='" + s3 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>Address</TD>");
                printwriter.println("<TD><INPUT id=text3 name=text3 value='" + s5 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>Phone Number</TD>");
                printwriter.println("<TD><INPUT id=text4 name=text4 value='" + j + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>State</TD>");
                printwriter.println("<TD><INPUT id=text5 name=text5 value='" + s7 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>City</TD>");
                printwriter.println("<TD><INPUT id=text6 name=text6 value='" + s9 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>Country</TD>");
                printwriter.println("<TD><INPUT id=text7 name=text7 value='" + s11 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>Zipcode</TD>");
                printwriter.println("<TD><INPUT id=text8 name=text8 value='" + i + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>Email_id</TD>");
                printwriter.println("<TD><INPUT id=text9 name=text9 value='" + s13 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>User_id</TD>");
                printwriter.println("<TD><INPUT id=text10 name=text10 value='" + s15 + "'readonly></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>Password</TD>");
                printwriter.println("<TD><INPUT id=text11 name=text11 value='" + s17 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>HintQuestion</TD>");
                printwriter.println("<TD><INPUT id=text12 name=text12 value='" + s19 + "'></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>HintAnswer</TD>");
                printwriter.println("<TD><INPUT id=text13 name=text13 value='" + s21 + "'></TD></TR>");
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