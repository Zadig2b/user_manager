package com.example.usermanager.dao;

import com.example.usermanager.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class UserDAOTest {

    private UserDAO dao;

    @Before
    public void setUp() {
        // 🔧 Crée le dossier ./db si absent
        File dbFolder = new File("./db");
        if (!dbFolder.exists()) dbFolder.mkdir();

        // 📌 Force le chemin utilisé par UserDAO à "./db/users.db"
        System.setProperty("catalina.base", new File(".").getAbsolutePath());

        dao = new UserDAO();
    }

    @After
    public void tearDown() {
        // 🧹 Supprime le fichier de test après exécution
        File dbFile = new File("./db/users.db");
        if (dbFile.exists()) dbFile.delete();
    }

    @Test
    public void testAddAndListAllUsers() {
        User user = new User(0, "Jean Test", "jean@example.com", "0123456789", LocalDate.of(1990, 5, 15));
        dao.add(user);

        List<User> users = dao.listAll();
        assertFalse("Liste ne doit pas être vide", users.isEmpty());

        User last = users.get(users.size() - 1);
        assertEquals("Jean Test", last.getName());
        assertEquals("jean@example.com", last.getEmail());
    }

    @Test
    public void testDeleteUser() {
        User user = new User(0, "À Supprimer", "a@x.com", "0000000000", LocalDate.of(1980, 1, 1));
        dao.add(user);

        List<User> usersBefore = dao.listAll();
        assertFalse("Liste vide après ajout", usersBefore.isEmpty());

        int id = usersBefore.get(usersBefore.size() - 1).getId();
        dao.delete(id);

        List<User> usersAfter = dao.listAll();
        assertTrue("Utilisateur supprimé", usersAfter.stream().noneMatch(u -> u.getId() == id));
    }
}
