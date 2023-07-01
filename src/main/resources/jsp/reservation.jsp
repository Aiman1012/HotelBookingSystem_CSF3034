<%-- 
    Document   : reservation
    Created on : 18 Jun 2023, 11:09:53 pm
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        

    
        <%
            String cid = request.getParameter("cid");
            String cod = request.getParameter("cod");
            String roomtype = request.getParameter("roomtype");
            String numguest = request.getParameter("numguest");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreservation", "admin", "Maisa01!");
                PreparedStatement ps = conn.prepareStatement("INSERT INTO reservation (cid, cod, roomtype, numguest, name, email, phone) VALUES (?, ?, ?, ?, ?, ?, ?)");                
                ps.setString(1,cid);
                ps.setString(2,cod);
                ps.setString(3,roomtype);
                ps.setString(4,numguest);
                ps.setString(5,name);
                ps.setString(6,email);
                ps.setString(7,phone);
                
                int x=ps.executeUpdate();
                
                if(x>0){
                out.println("THANK YOU FOR YOUR RESERVATION!");
                }else{
                out.println("RESERVATION FAILED ");
                }
                
            
                
            }catch(Exception e){
                out.println(e);
            }
            
            %>
            <br><br>
            <a href="../../../../../../roomreservation/web/displayreservation.jsp">View Reservations</a>
    </body>
</html>
