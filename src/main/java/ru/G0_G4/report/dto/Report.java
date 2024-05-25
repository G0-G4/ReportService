package ru.G0_G4.report.dto;

import java.time.OffsetDateTime;
import java.util.List;

public record Report(String shop,
                     OffsetDateTime date,
                     List<ReportEntry> entries) {

}
