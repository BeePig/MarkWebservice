package com.example.repository;

        import com.example.model.Admin;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.transaction.annotation.Transactional;

/**
 * Created by beepi on 15/05/2016.
 */

@Transactional
public interface AdminRepository extends CrudRepository<Admin,Long>{
    //-----------------------------------GET-----------------------------------------------------------------------//
    Admin findByUsernameAndPassword(String admin,String password);
    Admin findByUsername(String admin);
    Admin save(Admin admin);
}
