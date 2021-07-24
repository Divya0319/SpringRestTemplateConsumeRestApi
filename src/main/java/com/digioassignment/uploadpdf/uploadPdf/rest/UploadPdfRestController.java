package com.digioassignment.uploadpdf.uploadPdf.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.digioassignment.uploadpdf.uploadPdf.entity.request.UploadPdfRequest;
import com.digioassignment.uploadpdf.uploadPdf.entity.response.CustomResponse;
import com.digioassignment.uploadpdf.uploadPdf.entity.response.UploadPdfResponse;

@RestController
@RequestMapping("/api")
public class UploadPdfRestController {

@Value("${digio.baseurl}")
private String digioApiBaseUrl;

@Value("${digio.endpoint.uploadpdf}")
private String uploadPdfEndpoint;
	
@Value("${digio.endpoint.getDocumentDetails}")
private String getDocumentDetailsEndpoint;
	
@Value("${digio.endpoint.downloadDocument}")
private String downloadDocumentEndpoint;

@Value("${digio.header.authorization}")
private String authorization;

@Value("{digio.header.authorizationValue}")
private String authValue;

@Value("${digio.header.contentType}")
private String contentType;

@Value("${digio.header.contentTypeValue}")
private String contentTypeValue;

@Autowired
private RestTemplate restTemplate;

private Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());

	
@PostMapping("/uploadPdf")
public UploadPdfResponse uploadPdf(@RequestBody UploadPdfRequest uploadPdfRequest, HttpServletRequest httpServletRequest) {
	HttpHeaders headers = new HttpHeaders();

	headers.set(authorization, httpServletRequest.getHeader(authorization));
	headers.set(contentType, httpServletRequest.getHeader(contentType));
	
	HttpEntity<UploadPdfRequest> entity = new HttpEntity<>(uploadPdfRequest, headers);
	
	ResponseEntity<UploadPdfResponse> response = restTemplate.exchange(uploadPdfEndpoint, 
			HttpMethod.POST, entity, UploadPdfResponse.class);
	
	int statusCode = response.getStatusCodeValue();
	slf4jLogger.info("---------status received--------" + statusCode);
	
	return response.getBody();
	
}

@GetMapping("/getDocumentDetails/{documentId}")
public List<?> getDocumentDetails(@PathVariable String documentId, HttpServletRequest httpServletRequest) {
		
	HttpHeaders headers = new HttpHeaders();

	headers.set(authorization, httpServletRequest.getHeader(authorization));
	
	HttpEntity<String> entity = new HttpEntity<>(headers);
	
	String theGetDocumentDetailsEndpoint = getDocumentDetailsEndpoint + "{dId}";
		
	
	Map<String, String> params = new HashMap<>();
	params.put("dId", documentId);
	
	
	ResponseEntity<UploadPdfResponse> response = restTemplate.exchange(theGetDocumentDetailsEndpoint, 
			HttpMethod.GET, entity, UploadPdfResponse.class, params);
	
	int statusCode = response.getStatusCodeValue();
	
	slf4jLogger.info("---------status received--------" + statusCode);
	
	
	return handleErrorResponse(statusCode, response);
}

@GetMapping("/downloadDocument")
public ResponseEntity<byte[]> downloadDocument(@RequestParam("document_id") String document_Id, HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {
	
	HttpHeaders headers = new HttpHeaders();

	headers.set(authorization, httpServletRequest.getHeader(authorization));
	
	HttpEntity<String> entity = new HttpEntity<>(headers);
	
	UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(digioApiBaseUrl + downloadDocumentEndpoint)
            .queryParam("document_id", document_Id);
			
	
	ResponseEntity<byte[]> response = restTemplate.exchange(uriBuilder.toUriString(), 
			HttpMethod.GET, entity, byte[].class);
	
	int statusCode = response.getStatusCodeValue();
	
	slf4jLogger.info("---------status received--------" + statusCode);
	
	byte[] pdfContent = response.getBody();
	
	
	HttpHeaders pdfHeaders = new HttpHeaders();
	pdfHeaders.setContentType(MediaType.APPLICATION_PDF);
	ResponseEntity<byte[]> pdfResponse = new ResponseEntity<>(pdfContent, pdfHeaders, response.getStatusCode());
	
	
	return pdfResponse;

}

private List<?> handleErrorResponse(int statusCode, ResponseEntity<?> response) {
	
switch(statusCode) {
	
	case 403 : {
		
		List<CustomResponse> customResponses = new ArrayList<>();
		
		CustomResponse customResponse = new CustomResponse(HttpStatus.FORBIDDEN.value(), "Forbidden");
	
		customResponses.add(customResponse);
		
		return customResponses;
		
		}
	
	case 404 : {
		
		List<CustomResponse> customResponses = new ArrayList<>();
		
		CustomResponse customResponse = new CustomResponse(HttpStatus.NOT_FOUND.value(), "404 Not found");
	
		customResponses.add(customResponse);
		
		return customResponses;
		
		}
	
	default : {
		
		List<UploadPdfResponse> uploadPdfResponses = new ArrayList<>();
		
		uploadPdfResponses.add((UploadPdfResponse) response.getBody());
		
		return uploadPdfResponses;
		
		}
	}
 }

}

