--liquibase formatted sql
--changeset <losnazar>:<create-teams-table>

CREATE TABLE `teams` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account` decimal(38,2) DEFAULT NULL,
  `commission` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--rollback DROP TABLE teams;
