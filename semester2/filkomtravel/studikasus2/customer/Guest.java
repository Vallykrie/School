package customer;

import java.util.LinkedList;

/**
 * The User class represents a user in the system.
 * It contains information about the user's username, password, email, and full
 * name.
 * Users can log in, edit their profile, delete their profile, and view their
 * profile.
 */
public class Guest {
    private String username, password, email, namaLengkap;
    private String status = "non-member";
    private boolean isMember = false;

    /**
     * Constructs a User object with the specified username, password, email, and
     * full name.
     * 
     * @param username    the username of the user
     * @param password    the password of the user
     * @param email       the email of the user
     * @param namaLengkap the full name of the user
     */
    public Guest(String username, String password, String email, String namaLengkap) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.namaLengkap = namaLengkap;
    }

    /**
     * Checks if the given username and password match any user in the provided user
     * list.
     * 
     * @param username the username to be checked
     * @param password the password to be checked
     * @param userList the list of users to search in
     * @return true if the username and password match a user, false otherwise
     */
    public static boolean login(String username, String password, LinkedList<Guest> userList) {
        for (Guest user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the index of the user with the given username in the provided user list.
     * 
     * @param username the username of the user to search for
     * @param userList the list of users to search in
     * @return the index of the user if found, -1 otherwise
     */
    public static int get(String username, LinkedList<Guest> userList) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Edits the profile of the user with the specified username, password, email,
     * and full name.
     * 
     * @param username    the new username of the user
     * @param password    the new password of the user
     * @param email       the new email of the user
     * @param namaLengkap the new full name of the user
     */
    public void editProfile(String username, String password, String email, String namaLengkap) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.namaLengkap = namaLengkap;
        System.out.println("Edit profile berhasil");
    }

    /**
     * Deletes the profile of the user.
     */
    public void deleteProfile() {
        this.username = null;
        this.password = null;
        this.email = null;
        this.namaLengkap = null;
        System.out.println("Delete profile berhasil");
    }

    /**
     * Displays the profile information of the user.
     */
    public void viewProfile() {
        System.out.println("Nama Lengkap\t: " + namaLengkap);
        System.out.println("Username\t: " + username);
        System.out.println("Email\t\t: " + email);
        System.out.println("Status\t\t: " + status);
    }

    // Getters and setters

    /**
     * Sets the username of the user.
     * 
     * @param username the new username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the password of the user.
     * 
     * @param password the new password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the email of the user.
     * 
     * @param email the new email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the full name of the user.
     * 
     * @param namaLengkap the new full name to set
     */
    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    /**
     * Gets the username of the user.
     * 
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password of the user.
     * 
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the email of the user.
     * 
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the full name of the user.
     * 
     * @return the full name of the user
     */
    public String getNamaLengkap() {
        return namaLengkap;
    }

    /**
     * Gets the status of the user.
     * 
     * @return the status of the user
     */
    public String getStatus() {
        return status;
    }

    /**
     * Checks if the user is a member.
     * 
     * @return true if the user is a member, false otherwise
     */
    public boolean isMember() {
        return isMember;
    }
}
