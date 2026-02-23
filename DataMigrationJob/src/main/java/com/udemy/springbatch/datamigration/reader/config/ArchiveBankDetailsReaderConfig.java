package com.udemy.springbatch.datamigration.reader.config;

import com.udemy.springbatch.datamigration.domain.BankDetails;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ArchiveBankDetailsReaderConfig {
    @Bean
    public FlatFileItemReader<BankDetails> archiveBankDetails() {
        return new FlatFileItemReaderBuilder<BankDetails>().name("archiveBankDetails")
                .resource(new FileSystemResource("files/dados_bancarios.csv")).delimited()
                .names("pessoa_id", "agencia", "conta", "banco", "id").addComment("--").targetType(BankDetails.class)
                .build();
    }

}
