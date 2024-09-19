package tek_insurance.tdd.api.models.enums;

public enum Endpoints {
    TOKEN("/api/token"),
    GET_PRIMARY_ACCOUNT("/api/accounts/get-primary-account"),
    GET_ALL_PLAN_CODE("/api/plans/get-all-plan-code"),
    ADD_PRIMARY_ACCOUNT("/api/accounts/add-primary-account"),
    GET_ACCOUNT("/api/accounts/get-account");

    private final String value;
    Endpoints(String value){this.value = value;}
    public String getValue(){return value;}
}
