package tek_insurance.tdd.api.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PrimaryAccountResponse {
    private int id;
    private String email;
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String maritalStatus;
    private String employmentStatus;
    @JsonIgnore
    private String dateOfBirth;
}
