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

import com.udemy.springbatch.datamigration.domain.Person;

@Configuration
public class DataMigrationPersonStepConfig {
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private PlatformTransactionManager transactionManager;

	@Bean
	public Step migrationPersonStep(ItemReader<Person> archivePerson, ItemWriter<Person> bankPersonWriter) {

		return new StepBuilder("migrationPersonStep", jobRepository).<Person, Person>chunk(1, transactionManager)
				.reader(archivePerson).writer(bankPersonWriter).build();
	}

}
