/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.api.respository;

import com.adsi.api.modelo.Film;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author RICARDO
 */
public interface FilmRepository extends JpaRepository<Film, Short>{
    
    @Query(value = "SELECT f.* FROM film_actor as fa, film as f where fa.film_id = f.film_id and fa.actor_id = :id_actor", nativeQuery = true)
    List<Film> listarPeliculasPorActor(@Param("id_actor") Short id_actor);
    
}
