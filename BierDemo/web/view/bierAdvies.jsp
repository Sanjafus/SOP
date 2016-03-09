<%-- 
    Document   : BIerAdvies
    Created on : Feb 1, 2013, 2:22:20 PM
    Author     : frankcoenen
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bier Advies</title>
    </head>
    <body>
           <h1>Bier Advies</h1>

        <%
            List<String> bierMerken = (List<String>) request.getAttribute("bierMerken");
            for (String s : bierMerken) {
                out.print("<br/>" + s);
            }
        %>
        
        <c:forEach var="bier" items="${bierMerken}">
            <br> probeer: <c:out value="${bier}"/>
        </c:forEach>
       
    </body>
</html>
