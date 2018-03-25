package com.footballdata.external.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "position",
        "jerseyNumber",
        "dateOfBirth",
        "nationality",
        "contractUntil",
        "marketValue"
})
public class Player {

    @JsonProperty("name")
    private String name;
    @JsonProperty("position")
    private String position;
    @JsonProperty("jerseyNumber")
    private Integer jerseyNumber;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("contractUntil")
    private String contractUntil;
    @JsonProperty("marketValue")
    private Object marketValue;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("position")
    public String getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(String position) {
        this.position = position;
    }

    @JsonProperty("jerseyNumber")
    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    @JsonProperty("jerseyNumber")
    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @JsonProperty("nationality")
    public String getNationality() {
        return nationality;
    }

    @JsonProperty("nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @JsonProperty("contractUntil")
    public String getContractUntil() {
        return contractUntil;
    }

    @JsonProperty("contractUntil")
    public void setContractUntil(String contractUntil) {
        this.contractUntil = contractUntil;
    }

    @JsonProperty("marketValue")
    public Object getMarketValue() {
        return marketValue;
    }

    @JsonProperty("marketValue")
    public void setMarketValue(Object marketValue) {
        this.marketValue = marketValue;
    }
}
