package com.quocanh.personal_portfolio_backend_java_spring.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "experiences")
public class Experience {
    @Id
    private String id;
    private String position;
    private String company;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> description;
}
