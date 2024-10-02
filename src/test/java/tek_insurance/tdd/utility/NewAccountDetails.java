package tek_insurance.tdd.utility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}