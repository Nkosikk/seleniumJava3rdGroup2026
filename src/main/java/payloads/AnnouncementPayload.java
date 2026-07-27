package payloads;

public class AnnouncementPayload {

    private String title;
    private String content;

    // Default constructor
    public AnnouncementPayload() {
    }

    // Parameterized constructor
    public AnnouncementPayload(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for content
    public String getContent() {
        return content;
    }

    // Setter for content
    public void setContent(String content) {
        this.content = content;
    }
}