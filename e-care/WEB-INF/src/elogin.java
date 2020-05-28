
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class elogin extends HttpServlet
{

    public elogin()
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
        String s2 = "";
        String s4 = "";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        HttpSession httpsession = httpservletrequest.getSession(true);
        try
        {
            String s3 = httpservletrequest.getParameter("text1");
            System.out.println("user_id is " + s3);
            String s1 = httpservletrequest.getParameter("password1");
            System.out.println("password is " + s1);
            String s8 = s3.substring(0, 2);
            System.out.println("substring is " + s8);
			httpsession.putValue("user", s3);
            rs = st.executeQuery("select user_id,password from registration where user_id='" + s3 + "' and password='" + s1 + "'");
            System.out.println("after select statement");
            if(rs.next())
            {
                System.out.println("Inside while");
                s5 = rs.getString(1);
                s4 = rs.getString(2);
            }
            if(s5.equals(s3) && s4.equals(s1))
            {
                if(s8.equals("CC"))
                    httpservletresponse.sendRedirect("./corporateclientview.html");
                else
                if(s8.equals("CU"))
                {
                    
                    httpservletresponse.sendRedirect("./selectcompany");
                }
            } else
            {
                System.out.println("Inside else");
                printwriter.println("<html>");
                printwriter.println("<HEAD>");
                printwriter.println("<TITLE></TITLE>");
                printwriter.println("<BODY>");
                printwriter.println("<form name=f1 action='./elogin.html' style='COLOR: forestgreen'>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P align=center>&nbsp;</P> ");
                printwriter.println("<P align=center>&nbsp;</P>");
                printwriter.println("<P align=center><STRONG><FONT size=4>Invalid Username/Password </FONT></STRONG></P>");
                printwriter.println("<P align=center><FONT size=4><STRONG>Please Check again</STRONG></FONT></P>");
                printwriter.println("<P align=center>&nbsp;</P> ");
                printwriter.println("<P align=center><INPUT id=submit1 name=submit1 style='HEIGHT: 24px; WIDTH: 60px' type=submit value=OK></P>");
                printwriter.println("</form>");
                printwriter.println("</BODY>");
                printwriter.println("</html>");
            }
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