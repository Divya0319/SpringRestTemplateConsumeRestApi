package com.digioassignment.uploadpdf.uploadPdf.entity.response;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "identifier",
    "requested_on",
    "expire_on",
    "requester_type"
})
@Generated("jsonschema2pojo")
public class SignRequestDetails {

    @JsonProperty("name")
    private String name;
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("requested_on")
    private String requestedOn;
    @JsonProperty("expire_on")
    private String expireOn;
    @JsonProperty("requester_type")
    private String requesterType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    @JsonProperty("identifier")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @JsonProperty("requested_on")
    public String getRequestedOn() {
        return requestedOn;
    }

    @JsonProperty("requested_on")
    public void setRequestedOn(String requestedOn) {
        this.requestedOn = requestedOn;
    }

    @JsonProperty("expire_on")
    public String getExpireOn() {
        return expireOn;
    }

    @JsonProperty("expire_on")
    public void setExpireOn(String expireOn) {
        this.expireOn = expireOn;
    }

    @JsonProperty("requester_type")
    public String getRequesterType() {
        return requesterType;
    }

    @JsonProperty("requester_type")
    public void setRequesterType(String requesterType) {
        this.requesterType = requesterType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "\nSignRequestDetails \n[name=" + name + ", \nidentifier=" + identifier + ", \nrequestedOn=" + requestedOn
				+ ", \nexpireOn=" + expireOn + ", \nrequesterType=" + requesterType + "\n]";
	}
    
    

}
