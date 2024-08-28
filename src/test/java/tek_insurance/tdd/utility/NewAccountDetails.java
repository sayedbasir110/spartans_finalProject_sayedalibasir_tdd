package tek_insurance.tdd.utility;

public class NewAccountDetails {
    private String email;
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String maritalStatus;
    private String employmentStatus;
    private String birthYear;
    private String birthMonth;
    private String birthDay;
    private String userName;
    private String password;
    private String confirmPassword;

    public NewAccountDetails(String email, String title, String firstName, String lastName, String gender, String maritalStatus, String employmentStatus, String birthYear, String birthMonth, String birthDay, String password, String confirmPassword) {
        if (email.equalsIgnoreCase("random")) this.email = RandomEmail.generateRandomEmail();
        else this.email = email;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.employmentStatus = employmentStatus;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public NewAccountDetails(String email, String title, String firstName, String lastName, String gender, String maritalStatus, String employmentStatus, String birthYear, String birthMonth, String birthDay) {
        if (email.equalsIgnoreCase("random")) this.email = RandomEmail.generateRandomEmail();
        else this.email = email;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.employmentStatus = employmentStatus;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
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
    public String getBirthYear() {return birthYear;}
    public void setBirthYear(String birthYear) {this.birthYear = birthYear;}
    public String getBirthMonth() {return birthMonth;}
    public void setBirthMonth(String birthMonth) {this.birthMonth = birthMonth;}
    public String getBirthDay() {return birthDay;}
    public void setBirthDay(String birthDay) {this.birthDay = birthDay;}
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getConfirmPassword() {return confirmPassword;}
    public void setConfirmPassword(String confirmPassword) {this.confirmPassword = confirmPassword;}
}
