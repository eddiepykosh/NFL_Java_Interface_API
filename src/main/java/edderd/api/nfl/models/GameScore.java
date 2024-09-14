package edderd.api.nfl.models;

public class GameScore {
    private String awayTeam;
    private String homeTeam;
    private String gameTime;
    private String gameID;
    private String awayPts;
    private String homePts;
    private String gameClock;
    private String gameStatus;

    // Default constructor
    public GameScore() {}

    // Constructor with all fields
    public GameScore(String awayTeam, String homeTeam, String gameTime, String gameID, 
                     String awayPts, String homePts, String gameClock, String gameStatus) {
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.gameTime = gameTime;
        this.gameID = gameID;
        this.awayPts = awayPts;
        this.homePts = homePts;
        this.gameClock = gameClock;
        this.gameStatus = gameStatus;
    }

    // Getters and Setters
    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getAwayPts() {
        return awayPts;
    }

    public void setAwayPts(String awayPts) {
        this.awayPts = awayPts;
    }

    public String getHomePts() {
        return homePts;
    }

    public void setHomePts(String homePts) {
        this.homePts = homePts;
    }

    public String getGameClock() {
        return gameClock;
    }

    public void setGameClock(String gameClock) {
        this.gameClock = gameClock;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    // toString method for easy printing/logging
    @Override
    public String toString() {
        return "GameScore{" +
                "awayTeam='" + awayTeam + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", gameTime='" + gameTime + '\'' +
                ", gameID='" + gameID + '\'' +
                ", awayPts='" + awayPts + '\'' +
                ", homePts='" + homePts + '\'' +
                ", gameClock='" + gameClock + '\'' +
                ", gameStatus='" + gameStatus + '\'' +
                '}';
    }
}