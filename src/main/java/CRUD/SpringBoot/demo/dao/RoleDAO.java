package CRUD.SpringBoot.demo.dao;

import org.springframework.stereotype.Repository;
import CRUD.SpringBoot.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Role> getRolesList() {
        return entityManager.createQuery("select r from Role r").getResultList();
    }

    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }
}
