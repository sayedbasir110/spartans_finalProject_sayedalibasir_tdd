package tek_insurance.tdd.api.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tek_insurance.tdd.api.models.enums.AccountType;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfileResponse {
    private int id;
    private String fullName;
    private String username;
    private AccountType accountType;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    @JsonIgnore
    private String authorities;

}
