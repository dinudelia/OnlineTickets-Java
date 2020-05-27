package model;

public class Admin extends User {

    private String jobTitle;

    public Admin(Integer idUser,String username, String password, String firstName, String lastName, String jobTitle) {
        super(idUser,username, password, firstName, lastName);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
  }
