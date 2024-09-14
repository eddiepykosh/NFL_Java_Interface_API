package edderd.api.nfl.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edderd.api.nfl.models.GameScore;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NFLLiveGameService {

    @Value("${rapidapi.key}")
    private String rapidApiKey;

    @Value("${rapidapi.host}")
    private String rapidApiHost;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<GameScore> getScoresForWeek(int week) {
        if (week < 1 || week > 18) {
            throw new IllegalArgumentException("Week must be between 1 and 18");
        }

        String url = "https://tank01-nfl-live-in-game-real-time-statistics-nfl.p.rapidapi.com/getNFLScoresOnly?topPerformers=true&gameWeek=" + week;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", rapidApiKey);
        headers.set("x-rapidapi-host", rapidApiHost);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
        Map<String, Object> responseBody = response.getBody();
        Map<String, Map<String, Object>> games = (Map<String, Map<String, Object>>) responseBody.get("body");

        return games.values().stream()
                .map(game -> new GameScore(
                        (String) game.get("away"),
                        (String) game.get("home"),
                        (String) game.get("gameTime"),
                        (String) game.get("gameID"),
                        (String) game.get("awayPts"),
                        (String) game.get("homePts"),
                        (String) game.get("gameClock"),
                        (String) game.get("gameStatus")
                ))
                .collect(Collectors.toList());
    }
}