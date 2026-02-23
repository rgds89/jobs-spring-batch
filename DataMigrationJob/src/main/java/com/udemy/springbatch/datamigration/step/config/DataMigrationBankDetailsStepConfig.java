package com.udemy.springbatch.datamigration.step.config;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.udemy.springbatch.datamigration.domain.BankDetails;

@Configuration
public class DataMigrationBankDetailsStepConfig {
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private PlatformTransactionManager transactionManager;

	@Bean
	public Step migrationBankDetailsStep(ItemReader<BankDetails> archiveBankDetails,
			ItemWriter<BankDetails> bankDetailsWriter) {

		return new StepBuilder("migrationBankDetailsStep", jobRepository)
				.<BankDetails, BankDetails>chunk(1, transactionManager).reader(archiveBankDetails)
				.writer(bankDetailsWriter).build();
	}

}
