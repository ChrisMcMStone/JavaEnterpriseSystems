----
-- prepare albums
----
insert into artist values(nextval('hibernate_sequence'), 'Pink Floyd', date '01-01-1965', date '01-01-1995');
insert into album values(nextval('hibernate_sequence'),  'The Dark Side of the Moon', (select id from artist where name='Pink Floyd'), date '1973-03-01', 8.55);
insert into track values
(nextval('hibernate_sequence'), 'Speak to Me', extract(epoch from time '00:01:30')),
(nextval('hibernate_sequence'), 'Breathe', extract(epoch from time  '00:02:43')),
(nextval('hibernate_sequence'), 'On the Run', extract(epoch from time  '00:03:36')),
(nextval('hibernate_sequence'), 'Time', extract(epoch from time  '00:07:01')),
(nextval('hibernate_sequence'), 'The Great Gig in the Sky', extract(epoch from time  '00:04:36')),
(nextval('hibernate_sequence'), 'Money', extract(epoch from time '00:06:22')),
(nextval('hibernate_sequence'), 'Us and Them', extract(epoch from time  '00:07:40')),
(nextval('hibernate_sequence'), 'Any Colour You Like', extract(epoch from time  '00:03:25')),
(nextval('hibernate_sequence'), 'Brain Damage', extract(epoch from time  '00:03:48')),
(nextval('hibernate_sequence'), 'Eclipse', extract(epoch from time  '00:02:03'));
insert into album_track(album_id, track_id)
select (select id from album where name = 'The Dark Side of the Moon'), id from track where id between 1 and 10;

insert into album values(nextval('hibernate_sequence'),'Wish You Were Here',  (select id from artist where name='Pink Floyd'), date '1975-09-12', 8.72);
insert into track values
(nextval('hibernate_sequence'), 'Shine On You Crazy Diamond, Parts I-V', extract(epoch from time '00:13:38')),
(nextval('hibernate_sequence'), 'Welcome to the Machine', extract(epoch from time '00:07:30')),
(nextval('hibernate_sequence'), 'Have a Cigar', extract(epoch from time  '00:05:24')),
(nextval('hibernate_sequence'), 'Wish You Were Here', extract(epoch from time '00:05:17')),
(nextval('hibernate_sequence'), 'Shine On You Crazy Diamond, Parts VI-IX', extract(epoch from time '00:12:29'));
insert into album_track(album_id, track_id)
select (select id from album where name = 'Wish You Were Here'), id from track where id between 11 and 15;

insert into artist values(nextval('hibernate_sequence'), 'Karnivool', date '01-01-1997', null);
insert into album values(nextval('hibernate_sequence'), 'Themata', (select id from artist where name='Karnivool'), date '2005-02-07', 7.26);
insert into track values
(nextval('hibernate_sequence'), 'C.O.T.E.', extract(epoch from time '00:05:50')),
(nextval('hibernate_sequence'), 'Themata', extract(epoch from time '00:05:40')),
(nextval('hibernate_sequence'), 'Shutterspeed', extract(epoch from time '00:03:46')),
(nextval('hibernate_sequence'), 'Fear of the Sky', extract(epoch from time '00:05:16')),
(nextval('hibernate_sequence'), 'Roquefort', extract(epoch from time '00:04:38')),
(nextval('hibernate_sequence'), 'L1FEL1KE', extract(epoch from time '00:04:40')),
(nextval('hibernate_sequence'), 'Scarabs', extract(epoch from time '00:02:10')),
(nextval('hibernate_sequence'), 'Sewn and Silent', extract(epoch from time '00:04:12')),
(nextval('hibernate_sequence'), 'Mauseum', extract(epoch from time '00:03:54')),
(nextval('hibernate_sequence'), 'Synops', extract(epoch from time '00:04:53')),
(nextval('hibernate_sequence'), 'Omitted for Clarity', extract(epoch from time '00:00:20')),
(nextval('hibernate_sequence'), 'Change (Part 1)', extract(epoch from time '00:03:28'));
insert into album_track(album_id, track_id)
select (select id from album where name = 'Themata'), id from track where id between 16 and 27;

insert into album values(nextval('hibernate_sequence'), 'Asymmetry', (select id from artist where name='Karnivool'), date '2013-08-06', 9.97);
insert into track values
(nextval('hibernate_sequence'), 'Aum', extract(epoch from time '00:02:22')),
(nextval('hibernate_sequence'), 'Nachash', extract(epoch from time '00:04:50')),
(nextval('hibernate_sequence'), 'A.M. War', extract(epoch from time '00:05:18')),
(nextval('hibernate_sequence'), 'We Are', extract(epoch from time '00:05:55')),
(nextval('hibernate_sequence'), 'The Refusal', extract(epoch from time '00:04:54')),
(nextval('hibernate_sequence'), 'Aeons', extract(epoch from time '00:07:18')),
(nextval('hibernate_sequence'), 'Asymmetry', extract(epoch from time '00:02:36')),
(nextval('hibernate_sequence'), 'Eidolon', extract(epoch from time '00:03:45')),
(nextval('hibernate_sequence'), 'Sky Machine', extract(epoch from time '00:07:49')),
(nextval('hibernate_sequence'), 'Amusia', extract(epoch from time '00:00:54')),
(nextval('hibernate_sequence'), 'The Last Few', extract(epoch from time '00:05:15')),
(nextval('hibernate_sequence'), 'Float', extract(epoch from time '00:04:17')),
(nextval('hibernate_sequence'), 'Alpha Omega', extract(epoch from time '00:07:57')),
(nextval('hibernate_sequence'), 'Om', extract(epoch from time '00:03:51'));
insert into album_track(album_id, track_id)
select (select id from album where name = 'Asymmetry'), id from track where id between 28 and 42;

insert into artist values(nextval('hibernate_sequence'), 'TesseracT', date '01-01-2007', null);
insert into album values(nextval('hibernate_sequence'), 'One', (select id from artist where name='TesseracT'), date '2011-03-22', 7.99);
insert into album values(nextval('hibernate_sequence'),'Odyssey',  (select id from artist where name='TesseracT'), date '2015-05-19', 7.99);
insert into album values(nextval('hibernate_sequence'), 'Polaris', (select id from artist where name='TesseracT'), date '2015-09-18', 8.91);
insert into album values(nextval('hibernate_sequence'), 'Altered State', (select id from artist where name='TesseracT'), date '2013-05-27', 7.99);

update track set length = length * 1000;
