import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class cforgetpwd extends HttpServlet
{

    public cforgetpwd()
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
        String s1 = "";
        String s3 = "";
        String s5 = "";
        String s7 = "";
        String s8 = "";
        String s9 = "";
        String s11 = "";
        int i = 0;
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {
            System.out.println("hello");
            String s2 = httpservletrequest.getParameter("user_id");
            System.out.println("user_id is " + s2);
            String s4 = httpservletrequest.getParameter("hintquestion");
            System.out.println("hque is " + s4);
            String s6 = httpservletrequest.getParameter("hintsolution");
            System.out.println("hintsolution is " + s6);
            System.out.println("before select statement");
  //          System.out.println("select user_id,password,hintquestion,hintsolution from registration where user_id='" + s2 + "'");
            rs = st.executeQuery("select user_id,password,hintquestion,hintsolution from registration where user_id='" + s2 + "'");
            System.out.println("After query");
            while(rs.next()) 
            {
                System.out.println("Inside while");
                s7 = rs.getString(1);
                System.out.println("u si " + s7);
                s8 = rs.getString(2);
                System.out.println("p si " + s8);
                String s10 = rs.getString(3);
		System.out.println(s10);

                String s12 = rs.getString(4);
                System.out.println("hint sol" + s12);
                if(s10.equalsIgnoreCase(s4) && s12.equalsIgnoreCase(s6))
                {
                    System.out.println("Inside if");
                    i = 1;
                }
            }
            System.out.println(i);
            if(i == 1)
            {
                printwriter.println("<HTML>");
                printwriter.println("<BODY>");
                printwriter.println("<form name=f1 action='./elogin.html'>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P>");
                printwriter.println("<P align=center style='COLOR: forestgreen'><STRONG> ");
                printwriter.println("<U>FORGET PASSWORD</U></STRONG></P>");
                printwriter.println("<P align=center>&nbsp;</P>");
                printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 width='75%' align=center>");
                printwriter.println("<TR>");
                printwriter.println("<TD>");
                printwriter.println("<P align=left>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                printwriter.println("<STRONG> User_Id is :</STRONG></P></TD>");
                printwriter.println("<TD>" + s7 + "</TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD>");
                printwriter.println("<P align=left><STRONG>  ");
                printwriter.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Password is :</STRONG></P></TD>");
                printwriter.println("<TD>" + s8 + "</TD></TR>");
                printwriter.println("<TR>");
                printwriter.println("<TD></TD>");
                printwriter.println("<TD>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P><INPUT id=submit1 name=submit1 type=submit value=Submit>&nbsp;</P></TD></TR></TABLE>&nbsp;&nbsp;</STRONG></P>");
                printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P>");
                printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P>");
                printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                printwriter.println("</STRONG></P>");
                printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P></form>");
                printwriter.println("</BODY></HTML>");
            }
            if(i == 0)
                httpservletresponse.sendRedirect("./invalidform.html");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    Connection con;
    Statement st;
    ResultSet rs;
    int flag;
}