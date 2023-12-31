package me.brunosantana.service;

import java.util.List;

import me.brunosantana.model.Photo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public
class PhotoServiceClient {
  private final String baseUrl;
  private final RestTemplate restTemplate;

  PhotoServiceClient(@Value("${photos.api.base-url}") String baseUrl, RestTemplateBuilder builder) {
    this.baseUrl = baseUrl;
    this.restTemplate = builder.build();
  }

  public List<Photo> getPhotos(Long albumId) {
    String url = baseUrl + "/albums/{albumId}/photos";
    ResponseEntity<List<Photo>> response =
        restTemplate.exchange(
            url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {}, albumId);
    return response.getBody();
  }
}
