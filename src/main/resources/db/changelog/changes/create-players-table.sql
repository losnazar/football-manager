--liquibase formatted sql
--changeset <losnazar>:<create-players-table>

CREATE TABLE `players` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `months_of_experience` int NOT NULL,
  `team_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `team_id_pk` (`team_id`),
  CONSTRAINT `team_id_fk` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`)
);

--rollback DROP TABLE players;



