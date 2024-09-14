package edderd.api.nfl;

public class GameInfo {
    private String gameTime;
    private String gameDate;
    private String homeTeam;
    private String awayTeam;
    private String espnLink;

    // Constructor
    public GameInfo(String gameTime, String gameDate, String homeTeam, String awayTeam, String espnLink) {
        this.gameTime = gameTime;
        this.gameDate = gameDate;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.espnLink = espnLink;
    }

    // Getters and Setters
    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getEspnLink() {
        return espnLink;
    }

    public void setEspnLink(String espnLink) {
        this.espnLink = espnLink;
    }

    // toString method for easy debugging
    @Override
    public String toString() {
        return "GameInfo{" +
                "gameTime='" + gameTime + '\'' +
                ", gameDate='" + gameDate + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", espnLink='" + espnLink + '\'' +
                '}';
    }
}