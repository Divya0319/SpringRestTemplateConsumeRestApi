package com.digioassignment.uploadpdf.uploadPdf.entity.response;

import java.util.HashMap;
import java.util.List;
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
    "id",
    "is_agreement",
    "agreement_type",
    "agreement_status",
    "file_name",
    "created_at",
    "self_signed",
    "self_sign_type",
    "no_of_pages",
    "signing_parties",
    "sign_request_details",
    "channel"
})
@Generated("jsonschema2pojo")
public class UploadPdfResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("is_agreement")
    private Boolean isAgreement;
    @JsonProperty("agreement_type")
    private String agreementType;
    @JsonProperty("agreement_status")
    private String agreementStatus;
    @JsonProperty("file_name")
    private String fileName;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("self_signed")
    private Boolean selfSigned;
    @JsonProperty("self_sign_type")
    private String selfSignType;
    @JsonProperty("no_of_pages")
    private Integer noOfPages;
    @JsonProperty("signing_parties")
    private List<SigningParty> signingParties = null;
    @JsonProperty("sign_request_details")
    private SignRequestDetails signRequestDetails;
    @JsonProperty("channel")
    private String channel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("is_agreement")
    public Boolean getIsAgreement() {
        return isAgreement;
    }

    @JsonProperty("is_agreement")
    public void setIsAgreement(Boolean isAgreement) {
        this.isAgreement = isAgreement;
    }

    @JsonProperty("agreement_type")
    public String getAgreementType() {
        return agreementType;
    }

    @JsonProperty("agreement_type")
    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

    @JsonProperty("agreement_status")
    public String getAgreementStatus() {
        return agreementStatus;
    }

    @JsonProperty("agreement_status")
    public void setAgreementStatus(String agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    @JsonProperty("file_name")
    public String getFileName() {
        return fileName;
    }

    @JsonProperty("file_name")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("self_signed")
    public Boolean getSelfSigned() {
        return selfSigned;
    }

    @JsonProperty("self_signed")
    public void setSelfSigned(Boolean selfSigned) {
        this.selfSigned = selfSigned;
    }

    @JsonProperty("self_sign_type")
    public String getSelfSignType() {
        return selfSignType;
    }

    @JsonProperty("self_sign_type")
    public void setSelfSignType(String selfSignType) {
        this.selfSignType = selfSignType;
    }

    @JsonProperty("no_of_pages")
    public Integer getNoOfPages() {
        return noOfPages;
    }

    @JsonProperty("no_of_pages")
    public void setNoOfPages(Integer noOfPages) {
        this.noOfPages = noOfPages;
    }

    @JsonProperty("signing_parties")
    public List<SigningParty> getSigningParties() {
        return signingParties;
    }

    @JsonProperty("signing_parties")
    public void setSigningParties(List<SigningParty> signingParties) {
        this.signingParties = signingParties;
    }

    @JsonProperty("sign_request_details")
    public SignRequestDetails getSignRequestDetails() {
        return signRequestDetails;
    }

    @JsonProperty("sign_request_details")
    public void setSignRequestDetails(SignRequestDetails signRequestDetails) {
        this.signRequestDetails = signRequestDetails;
    }

    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
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
		return "\nUploadPdfResponse \n[id=" + id + ", \nisAgreement=" + isAgreement + ", \nagreementType=" + agreementType
				+ ", \nagreementStatus=" + agreementStatus + ", \nfileName=" + fileName + ", \ncreatedAt=" + createdAt
				+ ", \nselfSigned=" + selfSigned + ", \nselfSignType=" + selfSignType + ", \nnoOfPages=" + noOfPages
				+ ", \nsigningParties=" + signingParties + ", \nsignRequestDetails=" + signRequestDetails + ", \nchannel="
				+ channel + "\n]";
	}
    
    

}
