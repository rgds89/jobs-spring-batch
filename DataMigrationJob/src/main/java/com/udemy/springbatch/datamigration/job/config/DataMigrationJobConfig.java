package com.udemy.springbatch.datamigration.job.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class DataMigrationJobConfig {
	@Autowired
	private JobRepository jobRepository;

	@Bean
	public Job dataMigrationJob(@Qualifier("migrationPersonStep") Step migrationPersonStep, @Qualifier("migrationBankDetailsStep") Step migrationBankDetailsStep) {
		return new JobBuilder("dataMigrationJob", jobRepository).start(migrationPersonStep).next(migrationBankDetailsStep)
				.build();
	}

}
