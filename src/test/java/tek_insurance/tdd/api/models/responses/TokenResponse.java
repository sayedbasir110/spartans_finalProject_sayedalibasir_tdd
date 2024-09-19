package tek_insurance.tdd.api.models.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tek_insurance.tdd.api.models.enums.AccountType;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TokenResponse {
    private String fullName;
    private String username;
    private String token;
    private Date tokenExpiration;
    private Date issueAt;
    private AccountType accountType;
}
