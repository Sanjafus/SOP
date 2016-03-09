<%-- 
    Document   : bierOpLand
    Created on : Feb 1, 2013, 7:37:21 PM
    Author     : frankcoenen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bier op Land</title>
    </head>
    <body>
        <h1>Bier op Land</h1>
        <form action="bierOpLand" method="POST">
            <select name="land">
                <option value="nl">nl</option>
                <option value="be">be</option>
                <option value="du">du</option>
            </select>
            <input type="submit" value="Advies">   
        </form>
    </body>

</html>

