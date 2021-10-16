
package JHONNY.JHONNY;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class servicioGames {
      @Autowired
     private GamesRepositorio metodosCrud;
     
     public List<Games> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Games> getGames(int idGames) {
        return metodosCrud.getGames(idGames);
    }

    public Games save(Games games){
        if(games.getIdgames()==null){
            return metodosCrud.save(games);
        }else{
            Optional<Games> e=metodosCrud.getGames(games.getIdgames());
            if(e.isEmpty()){
                return metodosCrud.save(games);
            }else{
                return games;
            }
        }
    }
     public Games update(Games games){
        if(games.getIdgames()!=null){
            Optional<Games> e=metodosCrud.getGames(games.getIdgames());
            if(!e.isEmpty()){
                if(games.getName()!=null){
                    e.get().setName(games.getName());
                }
                if(games.getBrand()!=null){
                    e.get().setBrand(games.getBrand());
                }
                if(games.getYear()!=null){
                    e.get().setYear(games.getYear());
                }
                if(games.getDescription()!=null){
                    e.get().setDescription(games.getDescription());
                }
                if(games.getCategoria()!=null){
                    e.get().setCategoria(games.getCategoria());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return games;
            }
        }else{
            return games;
        }
    }


    public boolean deleteGames(int gamesId) {
        Boolean aBoolean = getGames(gamesId).map(games -> {
            metodosCrud.delete(games);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
