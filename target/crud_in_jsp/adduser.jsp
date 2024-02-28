<%@page import="Service.*"%>
<jsp:useBean id="u" class="Model.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
UserServiceInterface userService = new UserService();
int i=userService.save(u);
if(i>0){
response.sendRedirect("adduser-success.jsp");
}else{
response.sendRedirect("adduser-error.jsp");
}
%>