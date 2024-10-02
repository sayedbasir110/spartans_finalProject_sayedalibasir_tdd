package tek_insurance.tdd.utility;


public class NewAccountDetails {
    private String email;
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String maritalStatus;
    private String employmentStatus;
    private String dateOfBirth;
    private String userName;
    private String password;
    private String confirmPassword;

    public NewAccountDetails(String email, String title, String firstName, String lastName, String gender, String maritalStatus, String employmentStatus, String dateOfBirth) {
        if (email.equalsIgnoreCase("random")) this.email = RandomEmail.generateRandomEmail();
        else this.email = email;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.employmentStatus = employmentStatus;
        this.dateOfBirth = dateOfBirth;
    }

    public NewAccountDetails(String email, String title, String firstName, String lastName, String gender, String maritalStatus, String employmentStatus, String dateOfBirth, String userName, String password, String confirmPassword) {
        if (email.equalsIgnoreCase("random")) this.email = RandomEmail.generateRandomEmail();
        else this.email = email;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.employmentStatus = employmentStatus;
        this.dateOfBirth = dateOfBirth;
        if (userName.equalsIgnoreCase("random")) this.userName = RandomUserName.generateRandomUserName();
        else this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}
    public String getMaritalStatus() {return maritalStatus;}
    public void setMaritalStatus(String maritalStatus) {this.maritalStatus = maritalStatus;}
    public String getEmploymentStatus() {return employmentStatus;}
    public void setEmploymentStatus(String employmentStatus) {this.employmentStatus = employmentStatus;}
    public String getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getConfirmPassword() {return confirmPassword;}
    public void setConfirmPassword(String confirmPassword) {this.confirmPassword = confirmPassword;}
}