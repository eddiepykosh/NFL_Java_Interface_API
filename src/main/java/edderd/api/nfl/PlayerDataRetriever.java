package edderd.api.nfl;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerDataRetriever {
	
    private List<Map<String, Object>> players;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = new ClassPathResource("players.json").getInputStream()) {
            Map<String, Object> jsonData = mapper.readValue(inputStream, Map.class);
            players = (List<Map<String, Object>>) jsonData.get("body");
        }
    }

    public Optional<PlayerData> findPlayerByName(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        return players.stream()
                .filter(p -> p.get("longName").toString().equalsIgnoreCase(fullName))
                .findFirst()
                .map(p -> {
                    PlayerData player = new PlayerData();
                    player.setPlayerID((String) p.get("playerID"));
                    player.setAge((String) p.get("age"));
                    player.setTeam((String) p.get("team"));
                    player.setPos((String) p.get("pos"));
                    player.setSchool((String) p.get("school"));
                    return player;
                });
    }
}
