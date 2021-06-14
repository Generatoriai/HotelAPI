package lt.viko.eif.generatoriai.demo.controllers;

import lt.viko.eif.generatoriai.demo.model.Hotel;
import lt.viko.eif.generatoriai.demo.model.attraction;
import lt.viko.eif.generatoriai.demo.model.reiting;
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
 * Project's main controller.
 * @version 1.0
 * @since 1.0
 * @author Arminas M. Denis M. Goda M. Lukas A. Deividas K.
 */
@RestController
@RequestMapping(value = "/hotel", produces = MediaType.APPLICATION_JSON_VALUE)

public class HotelResourceController {

    private String titleCountry;

    /**
     * "getAllHotel" request to get the entire list of hotels.
     * Getting hotels by the name of a city that they are in.
     *
     * @return hotels list
     */
    @GetMapping("/{title}")
    public ResponseEntity<CollectionModel<EntityModel<Hotel>>> getAllHotel(@PathVariable String title) {
        titleCountry = title;
        try {
            List<EntityModel<Hotel>> games = HotelApiRepository.getHotelID(title).stream().map(
                    game -> EntityModel.of(game,
                            linkTo(methodOn(HotelResourceController.class).getHotel(game.getId())).withSelfRel(),
                            linkTo(methodOn(HotelResourceController.class).getAllHotel("Vilnius")).withRel("get-all"))
            ).collect(Collectors.toList());

            return ResponseEntity.ok(CollectionModel.of(games, linkTo(methodOn(HotelResourceController.class).getAllHotel("Vilnius")).withSelfRel()));

        } catch (Exception exc) {
            return null;
        }
    }

    /**
     * "getHotel" request to get information about specific hotel.
     * Getting hotels by their ID.
     *
     * @param id - int hotel ID
     * @return one hotel's information
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<EntityModel<Hotel>> getHotel(@PathVariable int id) {
    try {
        EntityModel<Hotel> model = EntityModel.of(HotelApiRepository.getInfo(id));
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        model.add(Link.of(uriString, "self"));
        model.add(linkTo(methodOn(HotelResourceController.class).getAllHotel("Vilnius")).withRel("get-all"));
        return ResponseEntity.ok(model);
    }catch (Exception exc){
        return null;
        }
    }

    /**
     * "getAttractions" request to get places to visit in a city.
     *
     * @param countryTitle - String country name
     * @return List of places to visit.
     */
    @GetMapping("/attractions/{countryTitle}")
    public ResponseEntity<CollectionModel<EntityModel<attraction>>> getAttractions(@PathVariable String countryTitle) {
        try {
            List<EntityModel<attraction>> games = HotelApiRepository.getSuggesionRep(countryTitle).stream().map(
                    game -> EntityModel.of(game,
                            linkTo(methodOn(HotelResourceController.class).getAllHotel(countryTitle)).withRel("get-all"))
            ).collect(Collectors.toList());

            return ResponseEntity.ok(CollectionModel.of(games, linkTo(methodOn(HotelResourceController.class).getAllHotel(countryTitle)).withSelfRel()));
        } catch (Exception exc) {
            return null;
        }
    }

    /**
     * "getReiting" request to get guests' feedback about hotel.
     *
     * @param id - int hotel ID
     * @return list of feedbacks.
     */
    @GetMapping("/rating/{id}")
    public ResponseEntity<CollectionModel<EntityModel<reiting>>> getReiting(@PathVariable int id) {
        try {
            List<EntityModel<reiting>> games = HotelApiRepository.getListReiting(id).stream().map(
                    game -> EntityModel.of(game,
                            linkTo(methodOn(HotelResourceController.class).getHotel(id)).withRel("get-all"))
            ).collect(Collectors.toList());

            return ResponseEntity.ok(CollectionModel.of(games, linkTo(methodOn(HotelResourceController.class).getHotel(id)).withSelfRel()));
        } catch (Exception exc) {
            return null;
        }
    }


    //@DeleteMapping("/{title}")
//    public ResponseEntity<CollectionModel<EntityModel<Game>>> deleteGame(@PathVariable String title){
//        boolean isDel = rp.deleteGame(title);
//        if(!isDel)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return getGameAll();
  //  }

   

}
