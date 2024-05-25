package ru.G0_G4.report.services;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.G0_G4.report.dto.Report;
import ru.G0_G4.report.dto.ReportEntry;
import ru.G0_G4.report.wildberries.WildberriesClient;
import ru.G0_G4.report.wildberries.model.Feedbacks;

@Service
public class WildberriesService {

  private WildberriesClient client;

  @Autowired
  public WildberriesService(WildberriesClient client) {
    this.client = client;
  }

  public Report getReport() {
    long now = System.currentTimeMillis() / 1000L;
    long oneDayAgo = now - 24 * 60 * 60;
    List<ReportEntry> entries = new ArrayList<>();
    Feedbacks feedbacks;
    try {
      do {
        feedbacks = client.getFeedbacks(false, 100, entries.size(), oneDayAgo, now);
        entries.addAll(feedbacks.getData().getFeedbacks().stream()
            .map(feedback -> new ReportEntry(
                feedback.getProductDetails().getSupplierArticle(),
                feedback.getProductDetails().getProductName(),
                Integer.parseInt(feedback.getProductValuation()),
                feedback.getText(),
                OffsetDateTime.parse(feedback.getCreatedDate()),
                feedback.getUserName())).toList());
      } while (!feedbacks.getData().getFeedbacks().isEmpty());
      return new Report("wildberries", OffsetDateTime.now(), entries);
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException("Failed to get report from Wildberries");
    }
  }
}
