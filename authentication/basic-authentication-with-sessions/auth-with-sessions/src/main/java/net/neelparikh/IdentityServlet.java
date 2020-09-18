package net.neelparikh;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.neelparikh.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IdentityServlet extends HttpServlet {
    EntityManager entity_manager;
    @Override
    public void init() throws ServletException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("net.neelparikh.pu");
        this.entity_manager = factory.createEntityManager();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        EntityTransaction transaction = entity_manager.getTransaction();
        transaction.begin();
        User user  = new User(username, fname, lname, email, password);
        entity_manager.persist(user);
        transaction.commit();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = entity_manager.find(User.class, username);
        String json = new ObjectMapper().writeValueAsString(user);
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().print(json);
    }
}
