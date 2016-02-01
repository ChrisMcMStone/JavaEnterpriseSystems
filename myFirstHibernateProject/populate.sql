----
-- prepare albums
----
insert into artist values(nextval('artist_id_seq'), 'Pink Floyd', date '01-01-1965', date '01-01-1995');
insert into album values(nextval('album_id_seq'),  'The Dark Side of the Moon', (select id from artist where name='Pink Floyd'), date '1973-03-01', 8.55);
insert into track values
(nextval('track_id_seq'), 'Speak to Me', extract(epoch from time '00:01:30'), 1.50),
(nextval('track_id_seq'), 'Breathe', extract(epoch from time  '00:02:43'), 1.50),
(nextval('track_id_seq'), 'On the Run', extract(epoch from time  '00:03:36'), 1.50),
(nextval('track_id_seq'), 'Time', extract(epoch from time  '00:07:01'), 1.50),
(nextval('track_id_seq'), 'The Great Gig in the Sky', extract(epoch from time  '00:04:36'), 1.50),
(nextval('track_id_seq'), 'Money', extract(epoch from time '00:06:22'), 1.50),
(nextval('track_id_seq'), 'Us and Them', extract(epoch from time  '00:07:40'), 1.50),
(nextval('track_id_seq'), 'Any Colour You Like', extract(epoch from time  '00:03:25'), 1.50),
(nextval('track_id_seq'), 'Brain Damage', extract(epoch from time  '00:03:48'), 1.50),
(nextval('track_id_seq'), 'Eclipse', extract(epoch from time  '00:02:03'), 1.50);
insert into album_track(album_id, track_id)
select (select id from album where name = 'The Dark Side of the Moon'), id from track where id between 1 and 10;

insert into album values(nextval('album_id_seq'),'Wish You Were Here',  (select id from artist where name='Pink Floyd'), date '1975-09-12', 8.72);
insert into track values
(nextval('track_id_seq'), 'Shine On You Crazy Diamond, Parts I-V', extract(epoch from time '00:13:38'), 1.50),
(nextval('track_id_seq'), 'Welcome to the Machine', extract(epoch from time '00:07:30'), 1.50),
(nextval('track_id_seq'), 'Have a Cigar', extract(epoch from time  '00:05:24'), 1.50),
(nextval('track_id_seq'), 'Wish You Were Here', extract(epoch from time '00:05:17'), 1.50),
(nextval('track_id_seq'), 'Shine On You Crazy Diamond, Parts VI-IX', extract(epoch from time '00:12:29'), 1.50);
insert into album_track(album_id, track_id)
select (select id from album where name = 'Wish You Were Here'), id from track where id between 11 and 15;

insert into artist values(nextval('artist_id_seq'), 'Karnivool', date '01-01-1997', null);
insert into album values(nextval('album_id_seq'), 'Themata', (select id from artist where name='Karnivool'), date '2005-02-07', 7.26);
insert into track values
(nextval('track_id_seq'), 'C.O.T.E.', extract(epoch from time '00:05:50'), 1.50),
(nextval('track_id_seq'), 'Themata', extract(epoch from time '00:05:40'), 1.50),
(nextval('track_id_seq'), 'Shutterspeed', extract(epoch from time '00:03:46'), 1.50),
(nextval('track_id_seq'), 'Fear of the Sky', extract(epoch from time '00:05:16'), 1.50),
(nextval('track_id_seq'), 'Roquefort', extract(epoch from time '00:04:38'), 1.50),
(nextval('track_id_seq'), 'L1FEL1KE', extract(epoch from time '00:04:40'), 1.50),
(nextval('track_id_seq'), 'Scarabs', extract(epoch from time '00:02:10'), 1.50),
(nextval('track_id_seq'), 'Sewn and Silent', extract(epoch from time '00:04:12'), 1.50),
(nextval('track_id_seq'), 'Mauseum', extract(epoch from time '00:03:54'), 1.50),
(nextval('track_id_seq'), 'Synops', extract(epoch from time '00:04:53'), 1.50),
(nextval('track_id_seq'), 'Omitted for Clarity', extract(epoch from time '00:00:20'), 1.50),
(nextval('track_id_seq'), 'Change (Part 1)', extract(epoch from time '00:03:28'), 1.50);
insert into album_track(album_id, track_id)
select (select id from album where name = 'Themata'), id from track where id between 16 and 27;

insert into album values(nextval('album_id_seq'), 'Asymmetry', (select id from artist where name='Karnivool'), date '2013-08-06', 9.97);
insert into track values
(nextval('track_id_seq'), 'Aum', extract(epoch from time '00:02:22'), 1.50),
(nextval('track_id_seq'), 'Nachash', extract(epoch from time '00:04:50'), 1.50),
(nextval('track_id_seq'), 'A.M. War', extract(epoch from time '00:05:18'), 1.50),
(nextval('track_id_seq'), 'We Are', extract(epoch from time '00:05:55'), 1.50),
(nextval('track_id_seq'), 'The Refusal', extract(epoch from time '00:04:54'), 1.50),
(nextval('track_id_seq'), 'Aeons', extract(epoch from time '00:07:18'), 1.50),
(nextval('track_id_seq'), 'Asymmetry', extract(epoch from time '00:02:36'), 1.50),
(nextval('track_id_seq'), 'Eidolon', extract(epoch from time '00:03:45'), 1.50),
(nextval('track_id_seq'), 'Sky Machine', extract(epoch from time '00:07:49'), 1.50),
(nextval('track_id_seq'), 'Amusia', extract(epoch from time '00:00:54'), 1.50),
(nextval('track_id_seq'), 'The Last Few', extract(epoch from time '00:05:15'), 1.50),
(nextval('track_id_seq'), 'Float', extract(epoch from time '00:04:17'), 1.50),
(nextval('track_id_seq'), 'Alpha Omega', extract(epoch from time '00:07:57'), 1.50),
(nextval('track_id_seq'), 'Om', extract(epoch from time '00:03:51'), 1.50);
insert into album_track(album_id, track_id)
select (select id from album where name = 'Asymmetry'), id from track where id between 28 and 42;

insert into artist values(nextval('artist_id_seq'), 'TesseracT', date '01-01-2007', null);
insert into album values(nextval('album_id_seq'), 'One', (select id from artist where name='TesseracT'), date '2011-03-22', 7.99);
insert into album values(nextval('album_id_seq'),'Odyssey',  (select id from artist where name='TesseracT'), date '2015-05-19', 7.99);
insert into album values(nextval('album_id_seq'), 'Polaris', (select id from artist where name='TesseracT'), date '2015-09-18', 8.91);
insert into album values(nextval('album_id_seq'), 'Altered State', (select id from artist where name='TesseracT'), date '2013-05-27', 7.99);

update track set length = length * 1000;


insert into users values(nextval('users_id_seq'), 'Chris', 'cxm373', 'password123', True, date '01-02-2010');
insert into users values(nextval('users_id_seq'), 'Tom', 'txs142', '12345678', False, date '28-06-2004');

insert into basket(users_id, track_id)
select (select id from users where username = 'cxm373'), id from track where id between 16 and 27;

insert into basket(users_id, track_id)
select (select id from users where username = 'txs142'), id from track where id between 20 and 27;
