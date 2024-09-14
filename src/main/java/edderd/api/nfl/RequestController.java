package edderd.api.nfl;

import java.util.List;

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
    
    @Autowired
    private NFLNewsService nflNewsService;

    @GetMapping("/NFLNews")
    public List<NewsItem> getNFLNews() {
        return nflNewsService.getTopNFLNews();
    }
    
    @Autowired
    private NFLWeeklyGameService nflGameService;

    @GetMapping("/NFLGames")
    public ResponseEntity<List<GameInfo>> getNFLGames(@RequestParam int week) {
        try {
            List<GameInfo> games = nflGameService.getGamesForWeek(week);
            return ResponseEntity.ok(games);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    } 
        @Autowired
        private NFLLiveGameService nflScoreService;

        // Your existing endpoints...

        @GetMapping("/NFLScores")
        public ResponseEntity<List<GameScore>> getNFLScores(@RequestParam int week) {
            try {
                List<GameScore> scores = nflScoreService.getScoresForWeek(week);
                return ResponseEntity.ok(scores);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().build();
            }
    }
}
