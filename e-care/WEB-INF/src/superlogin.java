import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class superlogin extends HttpServlet
{

    public superlogin()
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
        String s6 = "";
        String s9 = "";
        String s12 = "";
        String s13 = "";
        String s14 = "";
        String s15 = "";
        String s16 = "";
        String s17 = "";
        String s18 = "";
        String s19 = "";
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        HttpSession httpsession = httpservletrequest.getSession(true);
        try
        {
         
            String s5 = httpservletrequest.getParameter("text1");
             
            String s3 = httpservletrequest.getParameter("password1");
            httpsession.putValue("name",s5);
            httpsession.putValue("l1empname",s5);
            rs = st.executeQuery("select user_id,password from superuserprofile where user_id='" + s5 + "' and password='" + s3 + "'");
            if(rs.next())
            {
                httpsession.putValue("first", s5);
                String s10 = rs.getString(1);
                String s7 = rs.getString(2);
                System.out.println("INSIDE SUPERUSER uname is " + s10 + " pwd is " + s7);
                httpservletresponse.sendRedirect("./superuserview.html");
            }
            System.out.println("before query");
            rs1 = st1.executeQuery("select levelname,user_id,password from hdemp1 where user_id='" + s5 + "'");
            if(rs1.next())
            {
                System.out.println("inside hdemp1");
                String s1 = rs1.getString(1);
                String s11 = rs1.getString(2);
                String s8 = rs1.getString(3);
                System.out.println(" level is " + s1 + " : user name is " + s11 + "and  passwd is " + s8);
                if(s11.equals(s5) && s8.equals(s3))
                {
                    System.out.println(" level type :  " + s1);
                    String s20 = "";
                    httpsession.putValue(s20, s5);
                    Object obj = httpsession.getValue(s20);
                    System.out.println("get value user-id" + obj.toString());
                    System.out.println("user-id" + s5);
                    if(s1.equals("Level1"))
                        httpservletresponse.sendRedirect("./firstleveladminstrator.html");
                    else
                    if(s1.equals("Level2"))
                        httpservletresponse.sendRedirect("./secondleveladminstrator.html");
                    else
                    if(s1.equals("Level3"))
                        httpservletresponse.sendRedirect("./thirdleveladministrator.html");
                }
            } else
            {
                System.out.println("Inside else");
                printwriter.println("<html>");
                printwriter.println("<HEAD>");
                printwriter.println("<TITLE></TITLE>");
                printwriter.println("<BODY>");
                printwriter.println("<form name=f1 action='./superlogin.html' style='COLOR: forestgreen'>");
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