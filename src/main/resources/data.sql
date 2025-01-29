DELETE FROM images;
ALTER TABLE images AUTO_INCREMENT = 0;

INSERT INTO `jenniferdiez_factoriaf5`.`images`(`id`, `title`, `url`)
VALUES (1, 'Gatín', 'picture1.jpg'),
(2, 'Bocado', 'picture2.jpg'),
(3, 'Ron', 'picture3.jpg');