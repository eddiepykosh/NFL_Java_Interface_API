package edderd.api.nfl.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerData {
    private String playerID;
    private String age;
    private String team;
    private String longName;
    private String school;
    private String pos;

    // Default constructor
    public PlayerData() {}

    // Constructor with all fields
    public PlayerData(String playerID, String age, String team, String longName, String school, String pos) {
        this.playerID = playerID;
        this.age = age;
        this.team = team;
        this.longName = longName;
        this.school = school;
        this.pos = pos;
    }

    // Getters and setters
    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }
    
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    
    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    // toString method for easy debugging
    @Override
    public String toString() {
        return "Player{" +
                "playerID='" + playerID + '\'' +
                ", age='" + age + '\'' +
                ", team='" + team + '\'' +
                ", longName='" + longName + '\'' +
                '}';
    }
}