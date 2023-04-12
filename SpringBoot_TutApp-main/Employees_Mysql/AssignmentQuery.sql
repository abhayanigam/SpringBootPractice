CREATE SCHEMA `userdb` ;

CREATE TABLE `userdb`.`employees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `salary` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

SELECT * FROM userdb.employees;

CREATE TABLE `userdb`.`food` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Meal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `userdb`.`food` (`Meal`) VALUES ('Daal');
INSERT INTO `userdb`.`food` (`Meal`) VALUES ('Chawal');
INSERT INTO `userdb`.`food` (`Meal`) VALUES ('Rice');

SELECT * FROM userdb.food;


SELECT `userdb`.`employees`.`id`,`userdb`.`employees`.`name`,`userdb`.`food`.`id`,`userdb`.`food`.`Meal`
FROM `userdb`.`employees`
LEFT OUTER JOIN `userdb`.`food` ON `userdb`.`employees`.`id` = `userdb`.`food`.`id`
UNION
SELECT `userdb`.`employees`.`id`,`userdb`.`employees`.`name`,`userdb`.`food`.`id`,`userdb`.`food`.`Meal`
FROM `userdb`.`employees`
RIGHT OUTER JOIN `userdb`.`food` ON `userdb`.`employees`.`id` = `userdb`.`food`.`id`;