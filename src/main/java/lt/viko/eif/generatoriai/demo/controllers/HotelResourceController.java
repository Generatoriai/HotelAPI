package lt.viko.eif.generatoriai.demo.controllers;




import lt.viko.eif.generatoriai.demo.model.hotel;
import lt.viko.eif.generatoriai.demo.repository.HotelApiRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


/**
 * Games API Main Controller
 *
 * @author Denis
 * @version 1.0
 * @since 1.0
 */

@RestController
@RequestMapping(value = "/hotel", produces = MediaType.APPLICATION_JSON_VALUE)
public class HotelResourceController {



    /**
     * "getGameAll" Request to get the entire list of games
     *
     * @return game resource list
     */

    @GetMapping("/{title}")
    public ResponseEntity<CollectionModel<EntityModel<hotel>>> getAllHotel(@PathVariable String title) throws Exception {

        List<EntityModel<hotel>> games = HotelApiRepository.getHotelID().stream().map(
                game -> {
                    try {
                        return EntityModel.of(game,
                                linkTo(methodOn(HotelResourceController.class).getGame(game.getId())).withSelfRel(),
                                linkTo(methodOn(HotelResourceController.class).getAllHotel(title)).withRel("get-all"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        ).collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(games,linkTo(methodOn(HotelResourceController.class).getAllHotel()).withSelfRel()));
    }

    /**
     * "getGame" Request for one game by name
     *
     * @param id - String game title
     * @return one game resource
     */

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<hotel>> getHotel(@PathVariable int id) throws Exception{

        EntityModel<hotel> model = EntityModel.of(HotelApiRepository.getInfo(id));
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        model.add(Link.of(uriString,"self"));
        model.add(linkTo(methodOn(HotelResourceController.class).getAllHotel()).withRel("get-all"));

        return ResponseEntity.ok(model);
    }

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
