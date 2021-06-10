package lt.viko.eif.generatoriai.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * First controller
 */
@RestController
public class FirstController {

    /**
     * "index" method is the page stem method
     *
     * @return String type text
     */
    @RequestMapping("/")
    public String index(){
        return "Information for Game";
    }
}
