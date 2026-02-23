package com.udemy.springbatch.datamigration.reader.config;

import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.udemy.springbatch.datamigration.domain.Person;

@Configuration
public class ArchivePersonReaderConfig {
	@Bean
	public FlatFileItemReader<Person> archivePerson() {
		return new FlatFileItemReaderBuilder<Person>().name("archivePerson")
				.resource(new FileSystemResource("files/pessoas.csv")).delimited()
				.names("nome", "email", "dataNascimento", "idade", "id").addComment("--").targetType(Person.class)
				.build();
	}

}
