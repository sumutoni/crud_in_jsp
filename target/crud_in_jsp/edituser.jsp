<%@page import="Service.*"%>
<jsp:useBean id="u" class="Model.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
UserServiceInterface userService = new UserService();
int i=userService.update(u);
response.sendRedirect("viewusers.jsp");
%>