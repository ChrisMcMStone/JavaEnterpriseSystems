
-- prepare albums
----
insert into artist values(default, 'Pink Floyd', date '01-01-1965', date '01-01-1995');
insert into album values(default, (select id from artist where name='Pink Floyd'), 'The Dark Side of the Moon', date '1973-03-01', 8.55);
insert into track values
(nextval(hibernate_sequence), 'Speak to Me', extract(epoch from time '00:01:30')),
(default, 'Breathe', extract(epoch from time  '00:02:43')),
(default, 'On the Run', extract(epoch from time  '00:03:36')),
(default, 'Time', extract(epoch from time  '00:07:01')),
(default, 'The Great Gig in the Sky', extract(epoch from time  '00:04:36')),
(default, 'Money', extract(epoch from time '00:06:22')),
(default, 'Us and Them', extract(epoch from time  '00:07:40')),
(default, 'Any Colour You Like', extract(epoch from time  '00:03:25')),
(default, 'Brain Damage', extract(epoch from time  '00:03:48')),
(default, 'Eclipse', extract(epoch from time  '00:02:03'));
insert into album_track(album_id, track_id)
select (select id from album where name = 'The Dark Side of the Moon'), id from track where id between 1 and 10;

insert into album values(default, (select id from artist where name='Pink Floyd'), 'Wish You Were Here', date '1975-09-12', 8.72);
insert into track values
(default, 'Shine On You Crazy Diamond, Parts I-V', extract(epoch from time '00:13:38')),
(default, 'Welcome to the Machine', extract(epoch from time '00:07:30')),
(default, 'Have a Cigar', extract(epoch from time  '00:05:24')),
(default, 'Wish You Were Here', extract(epoch from time '00:05:17')),
(default, 'Shine On You Crazy Diamond, Parts VI-IX', extract(epoch from time '00:12:29'));
insert into album_track(album_id, track_id)
select (select id from album where name = 'Wish You Were Here'), id from track where id between 11 and 15;

insert into artist values(default, 'Karnivool', date '01-01-1997', null);
insert into album values(default, (select id from artist where name='Karnivool'), 'Themata', date '2005-02-07', 7.26);
insert into track values
(default, 'C.O.T.E.', extract(epoch from time '00:05:50')),
(default, 'Themata', extract(epoch from time '00:05:40')),
(default, 'Shutterspeed', extract(epoch from time '00:03:46')),
(default, 'Fear of the Sky', extract(epoch from time '00:05:16')),
(default, 'Roquefort', extract(epoch from time '00:04:38')),
(default, 'L1FEL1KE', extract(epoch from time '00:04:40')),
(default, 'Scarabs', extract(epoch from time '00:02:10')),
(default, 'Sewn and Silent', extract(epoch from time '00:04:12')),
(default, 'Mauseum', extract(epoch from time '00:03:54')),
(default, 'Synops', extract(epoch from time '00:04:53')),
(default, 'Omitted for Clarity', extract(epoch from time '00:00:20')),
(default, 'Change (Part 1)', extract(epoch from time '00:03:28'));
insert into album_track(album_id, track_id)
select (select id from album where name = 'Themata'), id from track where id between 16 and 27;

insert into album values(default, (select id from artist where name='Karnivool'), 'Asymmetry', date '2013-08-06', 9.97);
insert into track values
(default, 'Aum', extract(epoch from time '00:02:22')),
(default, 'Nachash', extract(epoch from time '00:04:50')),
(default, 'A.M. War', extract(epoch from time '00:05:18')),
(default, 'We Are', extract(epoch from time '00:05:55')),
(default, 'The Refusal', extract(epoch from time '00:04:54')),
(default, 'Aeons', extract(epoch from time '00:07:18')),
(default, 'Asymmetry', extract(epoch from time '00:02:36')),
(default, 'Eidolon', extract(epoch from time '00:03:45')),
(default, 'Sky Machine', extract(epoch from time '00:07:49')),
(default, 'Amusia', extract(epoch from time '00:00:54')),
(default, 'The Last Few', extract(epoch from time '00:05:15')),
(default, 'Float', extract(epoch from time '00:04:17')),
(default, 'Alpha Omega', extract(epoch from time '00:07:57')),
(default, 'Om', extract(epoch from time '00:03:51'));
insert into album_track(album_id, track_id)
select (select id from album where name = 'Asymmetry'), id from track where id between 28 and 42;

insert into artist values(default, 'TesseracT', date '01-01-2007', null);
insert into album values(default, (select id from artist where name='TesseracT'), 'One', date '2011-03-22', 7.99);
insert into album values(default, (select id from artist where name='TesseracT'), 'Odyssey', date '2015-05-19', 7.99);
insert into album values(default, (select id from artist where name='TesseracT'), 'Polaris', date '2015-09-18', 8.91);
insert into album values(default, (select id from artist where name='TesseracT'), 'Altered State', date '2013-05-27', 7.99);

update track set length = length * 1000;

