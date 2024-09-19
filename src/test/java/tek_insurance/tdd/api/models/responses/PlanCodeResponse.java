package tek_insurance.tdd.api.models.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanCodeResponse {
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private int id;
    private String planType;
    private double planBasePrice;
    private String icon;
    private Date expirationDate;
    private boolean planExpired;
    private boolean isNew;
}