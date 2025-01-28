DELETE FROM images;
ALTER TABLE images AUTO_INCREMENT = 0;

INSERT INTO `jenniferdiez_factoriaf5`.`images`(`id`, `title`, `url`)
VALUES (1, 'Test', 'picture1.jpg'),
(2, 'Test', 'picture2.jpg'),
(3, 'Test', 'picture3.jpg');