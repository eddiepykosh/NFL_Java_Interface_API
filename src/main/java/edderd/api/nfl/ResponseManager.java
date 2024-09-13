package edderd.api.nfl;

public class ResponseManager {

    private String message;

    public ResponseManager(String message) {
        this.message = message;
    }

    public String getMessage() {
    	System.out.println("Getting Message...");
        return message;
    }

    public void setMessage(String message) {
    	System.out.println("Setting Message...");
        this.message = message;
	}
}
