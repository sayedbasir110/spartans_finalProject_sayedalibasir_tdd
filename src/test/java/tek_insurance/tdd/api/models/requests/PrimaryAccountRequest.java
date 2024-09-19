package tek_insurance.tdd.api.models.requests;

import lombok.*;
import tek_insurance.tdd.api.models.enums.Gender;
import tek_insurance.tdd.api.models.enums.MaritalStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PrimaryAccountRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String title;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private String employmentStatus;
    private String dateOfBirth;
}
