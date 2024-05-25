package ru.G0_G4.report.wildberries;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import ru.G0_G4.report.wildberries.model.Feedbacks;

public class WildberriesClient {

  private final HttpClient client = HttpClient.newHttpClient();
  private final ObjectMapper mapper = new ObjectMapper().configure(
      DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  private final String token;
  private final String base;

  public WildberriesClient(String token, boolean test) {
    this.token = token;
    base = "https://feedbacks-api%s.wildberries.ru".formatted(test ? "-sandbox" : "");
  }

  public Feedbacks getFeedbacks(boolean isAnswered, int take, int skip, long dateFrom,
      long dateTo) throws IOException, InterruptedException {
    String url = base + "/api/v1/feedbacks?isAnswered=%s&take=%s&skip=%s&dateFrom=%s&dateTo=%s"
        .formatted(isAnswered, take, skip, dateFrom, dateTo);
    HttpRequest request = HttpRequest.newBuilder().header("Authorization", "Bearer " + token)
        .uri(URI.create(url)).build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    return mapper.readValue(response.body(), Feedbacks.class);
  }

}
