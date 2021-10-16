
package JHONNY.JHONNY;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Game")
public class GamesWeb {
     @GetMapping("/hola")
    public String saludar(){
    return "Hola mundo 11111";
    }
    @Autowired
    private servicioGames servicio;
    @GetMapping("/all")
    public List<Games> getGames(){
        return servicio.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Games> getGames(@PathVariable("id") int idGames) {
        return servicio.getGames(idGames);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Games save(@RequestBody Games games) {
        return servicio.save(games);
    }
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Games update(@RequestBody Games games) {
        return servicio.update(games);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id) {
        return servicio.deleteGames(Id);
    }
    
}
