package com.pot.catalogservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@Configuration //Указывает класс как источник конфигурации Spring
@EnableJdbcAuditing //Включает аудит постоянных сущностей.
public class DataConfig {

//    @CreatedBy
//    Идентифицирует поле, представляющее пользователя, создавшего сущность. Он определен при создании и никогда не менялся.
//    @CreatedDate
//    Идентифицирует поле, представляющее время создания сущности. Он определен при создании и никогда не менялся.
//    @LastModifiedBy
//    Идентифицирует поле, представляющее пользователя, который последним изменил сущность. Он обновляется при каждой операции создания или обновления.
//    @LastModifiedDate
//    Идентифицирует поле, показывающее дату последнего изменения сущности. Он обновляется при каждой операции создания или обновления.

}
