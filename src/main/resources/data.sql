INSERT INTO author (name) VALUES ('George Orwell')   ON CONFLICT (name) DO NOTHING;
INSERT INTO author (name) VALUES ('J.K. Rowling')    ON CONFLICT (name) DO NOTHING;
INSERT INTO author (name) VALUES ('Agatha Christie') ON CONFLICT (name) DO NOTHING;
INSERT INTO author (name) VALUES ('R.K. Narayan')    ON CONFLICT (name) DO NOTHING;
INSERT INTO author (name) VALUES ('Chetan Bhagat')   ON CONFLICT (name) DO NOTHING;

INSERT INTO book (title, author_id) SELECT '1984',                                    id FROM author WHERE name = 'George Orwell';
INSERT INTO book (title, author_id) SELECT 'Animal Farm',                             id FROM author WHERE name = 'George Orwell';
INSERT INTO book (title, author_id) SELECT 'Homage to Catalonia',                     id FROM author WHERE name = 'George Orwell';
INSERT INTO book (title, author_id) SELECT 'Harry Potter and the Philosopher''s Stone', id FROM author WHERE name = 'J.K. Rowling';
INSERT INTO book (title, author_id) SELECT 'Harry Potter and the Chamber of Secrets',  id FROM author WHERE name = 'J.K. Rowling';
INSERT INTO book (title, author_id) SELECT 'Murder on the Orient Express',            id FROM author WHERE name = 'Agatha Christie';
INSERT INTO book (title, author_id) SELECT 'And Then There Were None',                id FROM author WHERE name = 'Agatha Christie';
INSERT INTO book (title, author_id) SELECT 'Death on the Nile',                       id FROM author WHERE name = 'Agatha Christie';
INSERT INTO book (title, author_id) SELECT 'Malgudi Days',                            id FROM author WHERE name = 'R.K. Narayan';
INSERT INTO book (title, author_id) SELECT 'The Guide',                               id FROM author WHERE name = 'R.K. Narayan';