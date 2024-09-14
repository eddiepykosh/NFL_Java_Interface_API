package edderd.api.nfl.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edderd.api.nfl.models.GameInfo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NFLWeeklyGameService {

    @Value("${rapidapi.key}")
    private String rapidApiKey;

    @Value("${rapidapi.host}")
    private String rapidApiHost;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<GameInfo> getGamesForWeek(int week) {
        if (week < 1 || week > 18) {
            throw new IllegalArgumentException("Week must be between 1 and 18");
        }

        String url = "https://tank01-nfl-live-in-game-real-time-statistics-nfl.p.rapidapi.com/getNFLGamesForWeek?week=" + week;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", rapidApiKey);
        headers.set("x-rapidapi-host", rapidApiHost);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
        Map<String, Object> responseBody = response.getBody();
        System.out.println("Targeting URL: " + url);
        return ((List<Map<String, String>>) responseBody.get("body"))
                .stream()
                .map(game -> new GameInfo(
                        game.get("gameTime"),
                        game.get("gameDate"),
                        game.get("home"),
                        game.get("away"),
                        game.get("espnLink")
                ))
                .collect(Collectors.toList());
    }
}
