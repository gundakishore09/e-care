import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class updateuser extends HttpServlet
{

    public updateuser()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            System.out.println("inside init");
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
        System.out.println("This is my service");
        String s7 = "";
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        javax.servlet.http.HttpSession httpsession = httpservletrequest.getSession(true);
        try
        {
            String s = httpservletrequest.getParameter("text1");
            System.out.println("first name is " + s);
            String s1 = httpservletrequest.getParameter("text2");
            System.out.println("lname is" + s1);
            String s2 = httpservletrequest.getParameter("text3");
            System.out.println("address is " + s2);
            String s12 = httpservletrequest.getParameter("text4");
            int i = Integer.parseInt(s12);
            System.out.println("phno is" + i);
            String s3 = httpservletrequest.getParameter("text5");
            System.out.println("city is " + s3);
            String s4 = httpservletrequest.getParameter("text6");
            System.out.println("state is " + s4);
            String s5 = httpservletrequest.getParameter("text7");
            System.out.println("country is " + s5);
            String s13 = httpservletrequest.getParameter("text8");
            int j = Integer.parseInt(s13);
            System.out.println("zipcode is" + j);
            String s6 = httpservletrequest.getParameter("text9");
            System.out.println("emailid is " + s6);
            String s8 = httpservletrequest.getParameter("text10");
            System.out.println("userid is" + s8);
            String s9 = httpservletrequest.getParameter("text11");
            System.out.println("password is " + s9);
            String s10 = httpservletrequest.getParameter("text12");
            System.out.println("hintqt is " + s10);
            String s11 = httpservletrequest.getParameter("text13");
            System.out.println("hintsol is " + s11);
            int k = st.executeUpdate("update registration set fname='" + s + "',lname='" + s1 + "',address='" + s2 + "',phno=" + i + ",state='" + s4 + "',city='" + s3 + "',country='" + s5 + "',zipcode=" + j + ",email_id='" + s6 + "',user_id='" + s8 + "',password='" + s9 + "',hintquestion='" + s10 + "',hintsolution='" + s11 + "'where user_id='" + s8 + "'");
            System.out.println(k + " is updated");
            httpservletresponse.sendRedirect("./createuser");
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