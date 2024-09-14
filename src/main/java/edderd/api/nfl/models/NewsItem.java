package edderd.api.nfl.models;

public class NewsItem {
	
    private String link;
    private String title;
	
    public NewsItem() {}
    
    public NewsItem(String link, String title)
    {
    	this.link = link;
    	this.title = title;
    }

    // Getters and setters
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
