package com.teslait.template.stadistic.infrastructure.outbound.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class StatisticsEntity {
    @JsonAlias("product_code")
    private String productCode;
    @JsonAlias("start_date_time")
    private String startDateTime;
    @JsonAlias("end_date_time")
    private String endDateTime;
    @JsonAlias("bill_indicator")
    private String billIndicator;
    @JsonAlias("branch")
    private String branch;

}
