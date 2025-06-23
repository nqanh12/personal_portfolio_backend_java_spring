package com.quocanh.personal_portfolio_backend_java_spring.model;

import com.quocanh.personal_portfolio_backend_java_spring.model.enums.SkillLevel;
import com.quocanh.personal_portfolio_backend_java_spring.model.enums.SkillType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "skills")
public class Skill {
    @Id
    private String id;
    private String name;
    private SkillType type;
    private SkillLevel level;
}
