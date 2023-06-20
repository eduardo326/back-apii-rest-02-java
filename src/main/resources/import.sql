/* Populate tabla writers */

INSERT INTO writers (id, name, last_name) VALUES(100, 'Andrés', 'Guzmán');
INSERT INTO writers (id, name, last_name) VALUES(101, 'Jose', 'Lopez');
INSERT INTO writers (id, name, last_name) VALUES(102, 'Eduardo', 'Garcia');


/* Creamos algunos books */
INSERT INTO books (id, title, description, publication_date, writer_id) VALUES(101, 'Alicia', 'Alicia en el pais de las maravillas', '2022-03-06', 100);
INSERT INTO books (id, title, description, publication_date, writer_id) VALUES(102, 'Narnia', 'Narnia un libro de fantasia', '2022-03-06', 100);
