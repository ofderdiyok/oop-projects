package abstractclasses;

public abstract class UserAbstract {
    private int userID;
    private String fullName;


    public UserAbstract(int userID, String fullName) {
        this.userID = userID;
        this.fullName = fullName;
    }

    public UserAbstract(int userID) {
        this.userID=userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
