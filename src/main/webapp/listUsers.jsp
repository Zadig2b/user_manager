<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.example.usermanager.model.User" %>
<html>
<head>
    <title>Liste des utilisateurs</title>
</head>
<body>
    <h2>Liste des utilisateurs</h2>
    <table border="1" cellpadding="5">
    <tr>
    <th>Nom</th><th>Email</th><th>Téléphone</th><th>Date de naissance</th><th>Actions</th>
    </tr>

        <%
            List<User> users = (List<User>) request.getAttribute("users");
            for (User u : users) {
        %>
        <tr>
            <td><%= u.getName() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getPhone() %></td>
            <td><%= u.getDateNaissance() %></td>
            <td>
            <a href="users?action=delete&id=<%= u.getId() %>" 
                onclick="return confirm('Supprimer <%= u.getName() %> ?');">
                🗑 Supprimer
            </a>
            </td>
        </tr>
        <% } %>
    </table>
    <br>
    <a href="index.jsp">Retour au formulaire</a>
</body>
</html>
