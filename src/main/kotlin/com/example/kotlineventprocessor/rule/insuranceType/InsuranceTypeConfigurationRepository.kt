package com.example.kotlineventprocessor.rule.insuranceType

import org.springframework.data.jpa.repository.JpaRepository

interface InsuranceTypeConfigurationRepository : JpaRepository<InsuranceTypeConfiguration, String> {
}