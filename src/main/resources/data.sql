INSERT INTO fi (id, fi_name, fi_description, market) VALUES
	(1, 'GOLD', 'GOLD market', 'Zurich'),
	(2, 'Silver', 'Silver market','Madrid'),
	(3, 'Platinum', 'Platinum market', 'Frankfurt');

INSERT INTO order_book (id, fi_id, title, description) VALUES
	(1, 1, 'Juggling GOLD', 'GOOD'),
	(2, 1, 'Dancing Silver', 'AWESOME'),
	(3, 2, 'Juggling Silver', 'AWESOME'),
	(4, 2, 'Story-telling GOLD', 'GODLIKE'),
	(5, 3, 'Singing GOLD', 'GOOD');


