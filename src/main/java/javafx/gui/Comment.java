package javafx.gui;

public class Comment {
    private int id;
    private int postId;
    private String email;
    private String name;
    private String body;

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", postId=" + postId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
