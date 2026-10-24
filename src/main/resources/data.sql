-- Authors
INSERT INTO author (id, name) VALUES (1, 'George Orwell')    ON CONFLICT (id) DO NOTHING;
INSERT INTO author (id, name) VALUES (2, 'J.K. Rowling')     ON CONFLICT (id) DO NOTHING;
INSERT INTO author (id, name) VALUES (3, 'Agatha Christie')  ON CONFLICT (id) DO NOTHING;
INSERT INTO author (id, name) VALUES (4, 'R.K. Narayan')     ON CONFLICT (id) DO NOTHING;
INSERT INTO author (id, name) VALUES (5, 'Chetan Bhagat')    ON CONFLICT (id) DO NOTHING;

-- Books (author_id is the foreign key)
INSERT INTO book (id, title, author_id) VALUES (1,  '1984', 1)                                        ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author_id) VALUES (2,  'Animal Farm', 1)                                 ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author_id) VALUES (3,  'Homage to Catalonia', 1)                         ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author_id) VALUES (4,  'Harry Potter and the Philosopher''s Stone', 2)   ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author_id) VALUES (5,  'Harry Potter and the Chamber of Secrets', 2)    ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author_id) VALUES (6,  'Murder on the Orient Express', 3)               ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author_id) VALUES (7,  'And Then There Were None', 3)                   ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author_id) VALUES (8,  'Death on the Nile', 3)                          ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author_id) VALUES (9,  'Malgudi Days', 4)                               ON CONFLICT (id) DO NOTHING;
INSERT INTO book (id, title, author_id) VALUES (10, 'The Guide', 4)                                  ON CONFLICT (id) DO NOTHING;

-- Move the ID sequences past the manual IDs, so books/authors
-- created through the API don't collide with these rows
ALTER SEQUENCE author_seq RESTART WITH 1000;
ALTER SEQUENCE book_seq   RESTART WITH 1000;