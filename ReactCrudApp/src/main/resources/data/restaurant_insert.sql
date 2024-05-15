INSERT INTO public.coord(
	id, address, latitude, latitude_delta, longitude, longitude_delta, title, url_location)
	VALUES ('51f2b24a-9857-403a-b04a-d4a83d6fa08f', 'Av La Catolica N.90', 8566322, 896632, 8566322, 8566322,
			'Av La Catolica N.90', 'https: address.com');

INSERT INTO public.restaurant(
	id, code, image_url, logo_url, owner, rating, rating_count, "time", title, coords_id)
	VALUES ('423bc7bd-32c9-4471-af60-ee99cbaa9c44',
			'Helados Bon', 'https://pbs.twimg.com/media/C2-H4MeVQAEkW0o.jpg',
			'https://pbs.twimg.com/media/C2-H4MeVQAEkW0o.jpg', 'Doc. Juan Daniel Valdez',
			'5', 5, '30 Min', 'Helados Bon', '51f2b24a-9857-403a-b04a-d4a83d6fa08f');