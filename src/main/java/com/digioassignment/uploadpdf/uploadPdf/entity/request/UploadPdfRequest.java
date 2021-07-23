package com.digioassignment.uploadpdf.uploadPdf.entity.request;

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
    "signers",
    "expire_in_days",
    "display_on_page",
    "file_name",
    "file_data"
})
@Generated("jsonschema2pojo")
public class UploadPdfRequest {

    @JsonProperty("signers")
    private List<Signer> signers = null;
    @JsonProperty("expire_in_days")
    private Integer expireInDays;
    @JsonProperty("display_on_page")
    private String displayOnPage;
    @JsonProperty("file_name")
    private String fileName;
    @JsonProperty("file_data")
    private String fileData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("signers")
    public List<Signer> getSigners() {
        return signers;
    }

    @JsonProperty("signers")
    public void setSigners(List<Signer> signers) {
        this.signers = signers;
    }

    @JsonProperty("expire_in_days")
    public Integer getExpireInDays() {
        return expireInDays;
    }

    @JsonProperty("expire_in_days")
    public void setExpireInDays(Integer expireInDays) {
        this.expireInDays = expireInDays;
    }

    @JsonProperty("display_on_page")
    public String getDisplayOnPage() {
        return displayOnPage;
    }

    @JsonProperty("display_on_page")
    public void setDisplayOnPage(String displayOnPage) {
        this.displayOnPage = displayOnPage;
    }

    @JsonProperty("file_name")
    public String getFileName() {
        return fileName;
    }

    @JsonProperty("file_name")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @JsonProperty("file_data")
    public String getFileData() {
        return fileData;
    }

    @JsonProperty("file_data")
    public void setFileData(String fileData) {
        this.fileData = fileData;
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
		return "\nUploadPdfRequest \n[signers=" + signers + ", \nexpireInDays=" + expireInDays + ", \ndisplayOnPage="
				+ displayOnPage + ", \nfileName=" + fileName + ", \nfileData=JVBERio.......=" +   "\n]";
	}

    
}
