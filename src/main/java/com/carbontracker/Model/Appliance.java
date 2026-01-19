package com.carbontracker.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "appliance",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"appliance_code"})
        },
        indexes = {
                @Index(name = "idx_appliance_type", columnList = "appliance_type"),
                @Index(name = "idx_region", columnList = "region"),
                @Index(name = "idx_is_active", columnList = "is_active")
        }
)
public class Appliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appliance_code", nullable = false, unique = true, length = 50)
    private String applianceCode;

    @Column(name = "appliance_type", nullable = false, length = 100)
    private String applianceType;

    @Column(name = "category", nullable = false, length = 50)
    private String category;

    @Column(name = "power_watts", nullable = false)
    private Integer powerWatts;

    @Column(name = "region", nullable = false, length = 50)
    private String region;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}
