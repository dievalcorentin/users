package com.graphmytech.administrationusers.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user", schema = "saas_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "last_usage_date")
    private LocalDateTime lastUsageDate;

    @Column(name = "limit_date")
    private LocalDateTime  limitDate;

    @Column(name = "usage_count")
    private Integer usageCount;

    @Column(name = "in_usage")
    private Boolean inUsage;

    @Column(name = "limit_usage")
    private Integer limitUsage;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "created_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "count_total_project")
    private Integer countTotalProject;

    @Column(name = "max_count_project")
    private Integer maxCountProject;

    @Column(name = "max_count_request")
    private Integer maxCountRequest;

}
