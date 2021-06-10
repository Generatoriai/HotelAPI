package lt.viko.eif.generatoriai.demo.controllers;




import lt.viko.eif.generatoriai.demo.model.hotel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Games API Main Controller
 *
 * @author Denis
 * @version 1.0
 * @since 1.0
 */

@RestController
@RequestMapping(value = "/hotel", produces = MediaType.APPLICATION_JSON_VALUE)
public class GameResourceController {

    //GameRepository rp = new GameRepository();

    /**
     * "getGameAll" Request to get the entire list of games
     *
     * @return game resource list
     */

//    @GetMapping("/{title}")
//    public ResponseEntity<CollectionModel<EntityModel<hotel>>> getAllHotel(@PathVariable String title){

//        List<EntityModel<Game>> games = rp.getGames().stream().map(
//                game -> EntityModel.of(game,
//                        linkTo(methodOn(GameResourceController.class).getGame(game.getGameName())).withSelfRel(),
//                        linkTo(methodOn(GameResourceController.class).getGameAll()).withRel("get-all"))
//        ).collect(Collectors.toList());
//
//        return ResponseEntity.ok(CollectionModel.of(games,linkTo(methodOn(GameResourceController.class).getGameAll()).withSelfRel()));
    //}

    /**
     * "getGame" Request for one game by name
     *
     * @param title - String game title
     * @return one game resource
     */

   // @GetMapping("/{title}")
//    public ResponseEntity<EntityModel<Game>> getGame(@PathVariable String title){
//
//        EntityModel<Game> model = EntityModel.of(rp.getGame(title));
//        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
//        model.add(Link.of(uriString,"self"));
//        model.add(linkTo(methodOn(GameResourceController.class).getGameAll()).withRel("get-all"));
//
//        return ResponseEntity.ok(model);
   // }

    /**
     * "deleteGame" Request to delete a game by name
     *
     * @param title - String game title
     * @return game resource list
     */

    //@DeleteMapping("/{title}")
//    public ResponseEntity<CollectionModel<EntityModel<Game>>> deleteGame(@PathVariable String title){
//        boolean isDel = rp.deleteGame(title);
//        if(!isDel)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return getGameAll();
  //  }

   

}
