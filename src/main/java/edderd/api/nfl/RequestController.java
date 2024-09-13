package edderd.api.nfl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
	
    @GetMapping("/hello")
    public ResponseManager hello() {
        return new ResponseManager("7 HOURS OF COMMERICAL-FREE FOOTBALL");
    }
}
