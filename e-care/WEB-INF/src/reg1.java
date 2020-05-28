import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class reg1 extends HttpServlet
{

    public reg1()
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
         }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        String s9 = "";
        String s16 = "";
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        HttpSession httpsession = httpservletrequest.getSession(true);
        httpservletresponse.setContentType("text/html");
        try
        {
            String s = httpservletrequest.getParameter("fname");
            System.out.println("first name is " + s);
            String s1 = httpservletrequest.getParameter("lname");
            System.out.println("lname is" + s1);
            String s2 = httpservletrequest.getParameter("address");
            System.out.println("address is " + s2);
            String s17 = httpservletrequest.getParameter("phno");
            System.out.println("phno is" + s17);
            String s3 = httpservletrequest.getParameter("city");
            System.out.println("city is " + s3);
            String s4 = httpservletrequest.getParameter("state");
            System.out.println("state is " + s4);
            String s5 = httpservletrequest.getParameter("country");
            System.out.println("country is " + s5);
            String s6 = httpservletrequest.getParameter("gender");
            System.out.println("gender is " + s6);
            String s18 = httpservletrequest.getParameter("zipcode");
            System.out.println("zipcode is" + s18);
            String s7 = httpservletrequest.getParameter("email_id");
            System.out.println("emailid is " + s7);
            String s8 = httpservletrequest.getParameter("ctype");
            System.out.println("corptype is" + s8);
            if(s8.equalsIgnoreCase("corpuser"))
            {
                System.out.println("inside if");
                String s10 = httpservletrequest.getParameter("user_id");
                System.out.println("userid is " + s10);
                s16 = "CU" + s10;
                System.out.println("cat is " + s16);
            } else
            if(s8.equalsIgnoreCase("corpclient"))
            {
                String s11 = httpservletrequest.getParameter("user_id");
                System.out.println("userid is " + s11);
                s16 = "CC" + s11;
                System.out.println("cat is " + s16);
                httpsession.putValue("uid", s16);
            }
            String s12 = httpservletrequest.getParameter("password");
            System.out.println("password is " + s12);
            String s15 = httpservletrequest.getParameter("confpwd");
            System.out.println("password is " + s15);
            String s13 = httpservletrequest.getParameter("hintquestion");
            System.out.println("hintqt is " + s13);
            String s14 = httpservletrequest.getParameter("hintsolution");
            System.out.println("hintsol is " + s14);
            System.out.println("Before inserting");
			st = con.prepareStatement("insert into registration(firstname,lastname,address,phoneno,state,city,country,zipcode,gender,email_id,ctype,user_id,password,conformationpassword,hintquestion,hintsolution) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			System.out.println("statement is executed");
			st.setString(1,s);
			st.setString(2,s1);
			st.setString(3,s2);
			st.setString(4,s17);
			st.setString(5,s4);
			st.setString(6,s3);
			st.setString(7,s5);
			st.setString(8,s18);
			st.setString(9,s6);
			st.setString(10,s7);
			st.setString(11,s8);
			st.setString(12,s16);
			st.setString(13,s12);
			st.setString(14,s15);
			st.setString(15,s13);
			st.setString(16,s14);
			int k = st.executeUpdate();
            System.out.println(" One row is inserted" +k);
            System.out.println("After query");
            if(s8.equalsIgnoreCase("corpclient"))
			{
				System.out.println("Inside If Loop");
                httpservletresponse.sendRedirect("./addcompanyinfo.html");
			}
            else
			{
                httpservletresponse.sendRedirect("./elogin.html");
			}
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    Connection con;
    PreparedStatement st;
    ResultSet rs;
}