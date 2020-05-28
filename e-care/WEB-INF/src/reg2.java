import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class reg2 extends HttpServlet
{

    public reg2()
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
        String s9 = "";
        String s16 = "";
 System.out.println("******************************************************************reg2*************");
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
            int i = Integer.parseInt(s17);
            System.out.println("phno is" + i);
            String s3 = httpservletrequest.getParameter("city");
            System.out.println("city is " + s3);
            String s4 = httpservletrequest.getParameter("state");
            System.out.println("state is " + s4);
            String s5 = httpservletrequest.getParameter("country");
            System.out.println("country is " + s5);
            String s6 = httpservletrequest.getParameter("gender");
            System.out.println("gender is " + s6);
            String s18 = httpservletrequest.getParameter("zipcode");
            int j = Integer.parseInt(s18);
            System.out.println("zipcode is" + j);
            String s7 = httpservletrequest.getParameter("email_id");
            System.out.println("emailid is " + s7);
            String s8 = httpservletrequest.getParameter("ctype");
            System.out.println("corptype is" + s8);
            
                System.out.println("inside if");
                String s10 = httpservletrequest.getParameter("user_id");
                System.out.println("uuuuuuserid is " + s10);
                s16 = "CU" + s10;
                System.out.println("cat is " + s16);
         
         
            String s12 = httpservletrequest.getParameter("password");
            System.out.println("password is " + s12);
            String s15 = httpservletrequest.getParameter("confpwd");
            System.out.println("password is " + s15);
            String s13 = httpservletrequest.getParameter("hintquestion");
            System.out.println("hintqt is " + s13);
            String s14 = httpservletrequest.getParameter("hintsolution");
            System.out.println("hintsol is " + s14);
            System.out.println("Before inserting");
            int k = st.executeUpdate("insert into registration values('" + s + "','" + s1 + "','" + s2 + "'," + i + ",'" + s4 + "','" + s3 + "','" + s5 + "','" + s6 + "'," + j + ",'" + s7 + "','" + s8 + "','" + s16 + "','" + s12 + "','" + s15 + "','" + s13 + "','" + s14 + "')");
           String username=(String)httpsession.getValue("user");
         
String cname=null;
            ResultSet rs=st.executeQuery("select COMPANY_NAME from hdcompanyinfo where user_id='"+username+"'");
 if(rs.next())
  cname=rs.getString(1);

 int r= st.executeUpdate("insert into userinfo values('"+cname+"','"+s16+"')");
	 System.out.println(j + " One row is inserted"+username);
            System.out.println("After query");
          
                if (r>0)
{
printwriter.println("user is successfully added");
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