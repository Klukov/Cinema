INSERT INTO movie(title, description, length_minutes, status) VALUES
('Star Wars Phantom Menace', 'bla bla bla asdasd Star Wars 1 xd', 121, 'AVAILABLE'),
('Star Wars Attack of the Clones', 'another Star Wars movie ...', 132, 'AVAILABLE'),
('Star Wars Revenge of the Sith', 'last good star wars movie', 141, 'AVAILABLE'),
('Shrek', 'first film about shrek', 91, 'ARCHIVED'),
('Shrek 2', 'another Shrek movie ...', 99, 'ARCHIVED'),
('Shrek 3', 'another Shrek movie ...', 98, 'ARCHIVED'),
('Lord of The Rings The Fellowship of the Ring', 'Tolkien 1 movie', 155, 'AVAILABLE'),
('Lord of The Rings The Two Towers', 'Tolkien 2 movie', 166, 'AVAILABLE'),
('Lord of The Rings The return of the king', 'Tolkien 3 movie', 174, 'AVAILABLE')
ON CONFLICT DO NOTHING;
INSERT INTO cinema(name, address, city, postal_code, phone_number, email, time_zone) VALUES
('Warszawskie kino', 'Galeria Polnocna', 'Warszawa', '00-000', '123456789', 'kinoWarszawa@kino.pl', 'Europe/Warsaw'),
('Suwalskie kino', 'Plaza', 'Suwalki', '16-400', '987654321', 'kinoSuwalki@kino.pl', 'Europe/Warsaw'),
('Dupa a nie kino', 'Wypizdow', 'Grudziadz', '00-010', '111222333', 'kinoWypizdow@kino.pl', 'Europe/Warsaw')
ON CONFLICT DO NOTHING;
INSERT INTO room(room_in_cinema_number, cinema_id) VALUES
('A', 1), ('B', 1), ('C', 1), ('D', 1), ('JP', 2), ('HWDP', 2), ('1', 3)
ON CONFLICT DO NOTHING;
