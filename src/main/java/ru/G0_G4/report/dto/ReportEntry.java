package ru.G0_G4.report.dto;

import java.time.OffsetDateTime;

public record ReportEntry(String article,
                          String name,
                          int star,
                          String comment,
                          OffsetDateTime time,
                          String userName) {

}
