package tek_insurance.tdd.api.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Endpoints {
    TOKEN("/api/token"),
    GET_PRIMARY_ACCOUNT("/api/accounts/get-primary-account"),
    GET_ALL_PLAN_CODE("/api/plans/get-all-plan-code"),
    ADD_PRIMARY_ACCOUNT("/api/accounts/add-primary-account"),
    GET_ACCOUNT("/api/accounts/get-account"),
    USER_PROFILE("/api/user/profile"),
    DELETE_ACCOUNT("/api/accounts/delete-account");
    private final String value;
}
