package com.udalny.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServerJsonUploader
        implements Uploader<String> {

    private RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(ServerJsonUploader.class);

    @Value("${upload.server.port}")
    private int port;
    @Value("${upload.server.host}")
    private String host;
    @Value("${upload.server.endpoint}")
    private String endpoint;
    @Value("${upload.server.method}")
    private String method;

    @Autowired
    public ServerJsonUploader(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    private String getUri() {
        return String.format("%s:%s%s", host, port, endpoint);
    }

    private HttpEntity<String> getHttpEntity(String what) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(what, headers);
    }

    public void put(String what) {
        restTemplate.put(getUri(), getHttpEntity(what));
    }

    public ResponseEntity<String> post(String what) {
        return restTemplate.postForEntity(getUri(), getHttpEntity(what), String.class);
    }

    @Override
    public void upload(String what) {
        switch(method) {
            case "PUT": put(what); break;
            case "POST": logger.info("Post request answer: {}", post(what)); break;
            default: logger.error("Unknown method {}. Not sending", method); break;
        }
    }

    @Override
    public String toString() {
        return "ServerStringUploader{" +
                "restTemplate=" + restTemplate +
                ", port=" + port +
                ", host='" + host + '\'' +
                ", endpoint='" + endpoint + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
