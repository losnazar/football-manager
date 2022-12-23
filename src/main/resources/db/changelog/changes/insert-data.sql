--liquibase formatted sql
--changeset <losnazar>:<insert-data>

INSERT INTO teams (name, account, commission) VALUES ('Real Madrid', 10000000, 0.08);
SET @teamId = LAST_INSERT_ID();
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Cristiano', 'Ronaldo', 37, 180, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Lionel', 'Messi', 35, 165, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Killian', 'Mbappe', 23, 123, @teamId);

INSERT INTO teams (name, account, commission) VALUES ('Manchester City', 14000000, 0.073);
SET @teamId = LAST_INSERT_ID();
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Karim', 'Benzema', 32, 90, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Erling', 'Holland', 21, 35, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Ruben', 'Dias', 23, 24, @teamId);

INSERT INTO teams (name, account, commission) VALUES ('Paris Saint Germain', 50000000, 0.045);
SET @teamId = LAST_INSERT_ID();
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Harry', 'Kane', 28, 196, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Bruno', 'Fernandez', 26, 150, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Luis', 'Suarez', 36, 90, @teamId);

INSERT INTO teams (name, account, commission) VALUES ('Manchester United', 490000000, 0.012);
SET @teamId = LAST_INSERT_ID();
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Leonardo', 'Bonucci', 38, 80, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Eduard', 'Mendy', 29, 70, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Sadio', 'Mane', 27, 60, @teamId);

INSERT INTO teams (name, account, commission) VALUES ('Chelsea', 90000000, 0.09);
SET @teamId = LAST_INSERT_ID();
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Phillip', 'Foden', 24, 80, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Mason', 'Mount', 23, 48, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Thomas', 'Muller', 34, 44, @teamId);

INSERT INTO teams (name, account, commission) VALUES ('Arsenal', 23000000, 0.098);
SET @teamId = LAST_INSERT_ID();
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Rahim', 'Sterling', 26, 56, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Lautaro', 'Martinez', 25, 22, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Vinicius', 'Junior', 29, 100, @teamId);

INSERT INTO teams (name, account, commission) VALUES ('Tottenham', 12000000, 0.023);
SET @teamId = LAST_INSERT_ID();
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Angel', 'Di Maria', 28, 68, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Manuel', 'Neuer', 34, 88, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Bernardo', 'Silva', 29, 48, @teamId);

INSERT INTO teams (name, account, commission) VALUES ('Bayern', 50000000, 0.05);
SET @teamId = LAST_INSERT_ID();
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Kai', 'Havertz', 22, 224, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Antonio', 'Rudiger', 25, 146, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Zlatan', 'Ibrahimovich', 40, 240, @teamId);

INSERT INTO teams (name, account, commission) VALUES ('Borussia Dortmund', 5000000, 0.1);
SET @teamId = LAST_INSERT_ID();
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Andriy', 'Shevchenko', 42, 260, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Alisson', 'Becker', 28, 68, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Kyle', 'Walker', 32, 200, @teamId);

INSERT INTO teams (name, account, commission) VALUES ('Juventus', 2500000, 0.086);
SET @teamId = LAST_INSERT_ID();
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Ederson', 'Moraes', 29, 180, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Luke', 'Shaw', 30, 98, @teamId);
INSERT INTO players (first_name, last_name, age, months_of_experience, team_id) VALUES ('Patrick', 'Shick', 26, 124, @teamId);

--rollback DELETE FROM teams;
--rollback DELETE FROM players;
