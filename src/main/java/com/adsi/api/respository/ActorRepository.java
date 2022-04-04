
package com.adsi.api.respository;

import com.adsi.api.modelo.Actor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ActorRepository extends JpaRepository<Actor, Short>{
    
    
    @Query(value = "SELECT * FROM actor where first_name = :nombre",nativeQuery = true)
    List<Actor> listarPorNombre(@Param("nombre") String nombre );
    
}
