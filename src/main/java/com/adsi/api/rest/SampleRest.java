package com.adsi.api.rest;
import com.adsi.api.modelo.Actor;
import com.adsi.api.modelo.Film;
import com.adsi.api.respository.ActorRepository;
import com.adsi.api.respository.FilmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
public class SampleRest { 

    @Autowired
    ActorRepository actorService ;
    
    @Autowired
    FilmRepository filmService;
    
    @GetMapping("/hola/rest")
    String holaMundo(){
        return "Hola Mundo";
    }
    
    
    @GetMapping("/actor/consultar/like/{parametro}")
    List<Actor> consultarConLike(@PathVariable("parametro") String parametro ){
        return actorService.consultarConLike('%'+parametro+'%') ;
    }
    
    
    @GetMapping("/actor/listar/nombre/{nombre}")
    List<Actor> listarPorNombre(@PathVariable("nombre") String nombre ){
        return actorService.listarPorNombre(nombre);
    }
    
    @GetMapping("/actor/listar")
    List<Actor> actorListar(){
        return actorService.findAll();
    }
    
    @PostMapping("/actor/nuevo")
    Actor actorNuevo(@RequestBody Actor actor){
        return actorService.save(actor);
    }
    
    @PutMapping("/actor/update")
    Actor actorUpdate(@RequestBody Actor actor){
        return actorService.save(actor);
    }
    
    
    
    
    
    @GetMapping("/film/listar/actor/{id}")
    List<Film> listarPeliculasPorActor(@PathVariable("id") Short id ){
        return filmService.listarPeliculasPorActor(id);
    }
    
    
    
}
