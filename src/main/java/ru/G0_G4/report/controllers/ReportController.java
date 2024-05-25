package ru.G0_G4.report.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.G0_G4.report.services.WildberriesService;

@RestController
public class ReportController {

  WildberriesService wildberriesService;

  @Autowired
  public ReportController(WildberriesService wildberriesService) {
    this.wildberriesService = wildberriesService;
  }

  @GetMapping("/report/{shop}")
  public ResponseEntity<?> getReport(@PathVariable("shop") String shop) {
    if ("wildberries".equalsIgnoreCase(shop)) {
      return ResponseEntity.ok(wildberriesService.getReport());
    }
    return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body("{error: \"unknown shop\"}");
  }

}
