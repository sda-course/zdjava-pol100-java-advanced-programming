package javafx.gui;

public class Album {
    private int userId;
    private int id;
    private String title;
    //Włączenie zabezpieczeń uniemożliwiających działanie refleksji
//    public Album(){
//        System.getSecurityManager().checkPropertiesAccess();
//    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Album{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
