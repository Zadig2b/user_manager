<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Ajouter un utilisateur</title>
</head>
<body>
    <h2>Ajouter un utilisateur</h2>
    <form method="post" action="users">
        Nom : <input type="text" name="name" required><br><br>
        Email : <input type="email" name="email"><br><br>
        Téléphone : <input type="text" name="phone"><br><br>
        Date de naissance : <input type="date" name="dateNaissance"><br><br>
        <input type="submit" value="Ajouter">
    </form>
    <br>
    <a href="users">Voir la liste des utilisateurs</a>
</body>
</html>
