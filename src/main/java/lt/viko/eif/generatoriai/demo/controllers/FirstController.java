package lt.viko.eif.generatoriai.demo.controllers;

import lt.viko.eif.generatoriai.demo.repository.HotelApiRepository;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * First controller
 * @version 1.0
 * @since 1.0
 * @author Arminas M. Denis M. Goda M. Lukas A. Deividas K.
 */
@RestController
public class FirstController {

    /**
     * Testing request.
     *
     * @return String type text
     */
    @RequestMapping("/")
    public String index(){
        return "Information for Hotel and More";
    }
}
