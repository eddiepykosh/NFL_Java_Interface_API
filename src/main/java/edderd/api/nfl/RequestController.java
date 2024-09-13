package edderd.api.nfl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
	
    @GetMapping("/hello")
    public ResponseManager hello() {
        return new ResponseManager("7 HOURS OF COMMERICAL-FREE FOOTBALL");
    }
    
    @Autowired
    private PlayerDataRetriever playerService;

    @GetMapping("/getPlayerInfo")
    public ResponseEntity<PlayerData> getPlayerInfo(@RequestParam String firstName, @RequestParam String lastName) {
        return playerService.findPlayerByName(firstName, lastName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }  
    
}
