<%@page import="Service.*"%>
<jsp:useBean id="u" class="Model.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
UserServiceInterface userService = new UserService();
userService.delete(u);
response.sendRedirect("viewusers.jsp");
%>