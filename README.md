# 📘 Projet UserManager2

Mini-application web Java basée sur Servlets, JSP, DAO et SQLite.  
Elle permet d’ajouter, visualiser et supprimer des utilisateurs via une interface web, le tout déployé sur un serveur Tomcat.

---

## 🧱 Structure du projet

```
user_manager2/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/usermanager/
│       │       ├── controller/
│       │       │   └── UserServlet.java
│       │       ├── dao/
│       │       │   └── UserDAO.java
│       │       └── model/
│       │           └── User.java
│       ├── resources/
│       └── webapp/
│           ├── index.jsp
│           ├── listUsers.jsp
│           └── WEB-INF/
│               └── web.xml
└── target/
    └── user_manager2.war
```

---

## 📂 Description des fichiers

### ✅ `pom.xml`
Fichier de configuration Maven :
- Java 17
- Packaging en `.war`
- Dépendances :
  - `jakarta.servlet-api` (servlets)
  - `sqlite-jdbc` (accès base SQLite)
  - `junit` (tests unitaires)

### ✅ `User.java`
Modèle représentant un utilisateur :
- `id`, `name`, `email`, `phone`, `dateNaissance`

### ✅ `UserDAO.java`
Accès à la base de données SQLite :
- Crée la base `users.db` au besoin
- Méthodes : `listAll()`, `add(User)`, `delete(id)`
- Connexion vers :
  ```
  C:/Program Files/Apache/apache-tomcat-10.1.41/db/users.db
  ```

### ✅ `UserServlet.java`
Contrôleur (Servlet) principal :
- `/users` (GET) → affiche `listUsers.jsp`
- `/users` (POST) → ajoute un utilisateur
- `/users?action=delete&id=X` → supprime un utilisateur

### ✅ `index.jsp`
Formulaire HTML d'ajout d'utilisateur.

### ✅ `listUsers.jsp`
Affiche la liste des utilisateurs enregistrés, avec un bouton 🗑 pour supprimer.

### ✅ `web.xml`
Optionnel dans Tomcat 10 (annotations supportées). Peut rester vide :

```xml
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         version="5.0">
</web-app>
```

---

## 🚀 Compilation et déploiement

### 1. Compiler le projet
```bash
mvn clean package
```

Un fichier `user_manager2.war` est généré dans `target/`.

### 2. Copier le `.war` dans Tomcat
```bash
copy target\user_manager2.war "C:\Program Files\Apache\apache-tomcat-10.1.41\webapps\"
```

### 3. Placer la base SQLite
Créer un dossier :
```bash
mkdir "C:\Program Files\Apache\apache-tomcat-10.1.41\db"
```

Placer dedans un fichier vide `users.db` ou laisser l'application le créer.

### 4. Démarrer Tomcat
```bash
cd "C:\Program Files\Apache\apache-tomcat-10.1.41\bin"
.\startup.bat
```

---

## 🌐 Utilisation

1. Accéder à :
   ```
   http://localhost:8080/user_manager2/index.jsp
   ```

2. Remplir le formulaire et valider.

3. Voir la liste via :
   ```
   http://localhost:8080/user_manager2/users
   ```

4. Supprimer un utilisateur via le bouton 🗑

---

## 🛠️ Améliorations possibles

- Modification d’un utilisateur
- Validation serveur des champs
- Stockage des logs dans un fichier
- Refonte de l’interface avec Bootstrap

---

## 👨‍💻 Auteur

Romain Dugeay

Projet réalisé dans le cadre d’un TP Java Web avec Maven + Tomcat.