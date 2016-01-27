package uk.ac.bham.cs.hibernate.music;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import uk.ac.bham.cs.music.MusicServiceExercise;
import uk.ac.bham.cs.music.model.Album;
import uk.ac.bham.cs.music.model.Artist;
import uk.ac.bham.cs.music.model.Track;

public class Main {
	public static void main(String[] args) {
		SessionFactory factory = null;
		String cmd = null;
		
		try {
			// have we been given at least a command?
			if(args.length < 1) {
				Main.usage(); // no? then tell everyone how it should be done.
				return;
			}
			
			// get it for safe keeping
			cmd = args[0];
			
			try {
				// ensure the driver has been loaded.
				Class.forName("org.postgresql.Driver");
			} catch(ClassNotFoundException e) {
				System.err.println("driver not found.");
				System.err.println(e.getMessage());
				return;
			}

			// time to setup hibernate!
			final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure() // this reads hibernate.cfg.xml
				.build();
			
			try {
				// create a session factory
				factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			} catch(HibernateException e) {
				StandardServiceRegistryBuilder.destroy(serviceRegistry);
				System.err.println("couldn't connect to the database.");
				System.err.println(e.getMessage());
				e.printStackTrace();
				return;
			}
			
			// create a new service
			MusicServiceExercise service = new HibernateExercise(factory);
			// request track information?
			if(cmd.equals("ShowTrack") &&
					args.length == 2) {
				try {
					// attempt to get a number
					Integer id = Integer.parseInt(args[1]);
					try {
						// attempt to get a track
						Track track = service.getTrackById(id);

						// a nice printer for dates (have a look)
						PeriodFormatter length = new PeriodFormatterBuilder()
							.printZeroAlways()
							.minimumPrintedDigits(2)
							.appendHours()
							.appendSeparator(":")
							.appendMinutes()
							.appendSeparator(":")
							.appendSeconds()
							.toFormatter();
						
						// only if we have a track with this id
						System.out.println(
							// http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
							String.format("%-20s | %-8s\n===============================\n", "Title", "Length") +
							String.format("%-20s | %s", 
									track.getTitle(),
									length.print(track.getLength().toPeriod())
								)
						);
					} catch(IllegalArgumentException e) {
						System.err.println(e.getMessage());
						e.printStackTrace();
					}
				} catch(NumberFormatException e) {
					System.err.println(String.format("'%s' is not a valid track number.", args[1]));
				}
			} else if(cmd.equals("InsertArtist") &&
					args.length == 3) {
				LocalDate formationDate = null;
				try {
					formationDate = LocalDate.parse(args[2], DateTimeFormat.forPattern("dd-mm-yyyy"));
					service.newArtist(args[1], formationDate);
					System.out.println(args[1] + " has been added to the database.");
				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}
			} else if(cmd.equals("ShowAlbums") &&
					args.length == 2) {
				try {
					// attempt to get artist
					Artist artist = service.getArtist(args[1]);
					
					// get that artists albums
					List<Album> albums = service.getAlbums(artist);
					
					// date formatter
					DateTimeFormatter df = DateTimeFormat.forPattern("dd-MM-yyyy");
					String disbandmentDate = null;
					
					if(artist.getDisbandmentDate() == null) {
						disbandmentDate = "----------";
					} else {
						disbandmentDate = df.print(artist.getDisbandmentDate());
					}
					System.out.println(
							String.format("%-21s | %-10s | %-10s", "Name", "Formation", "Disbanded"));
					System.out.println("===============================================");
					System.out.println(
							String.format("%-21s | %10s | %10s", artist.getName(),
									df.print(artist.getFormationDate()), disbandmentDate));
					System.out.println();
					System.out.println(
							String.format("%-26s | %-10s | %-10s", "Name", "Released", "Price"));
					System.out.println("===============================================");
					for(Album album: albums) {
						System.out.println(
								String.format("%-26s | %10s | %.2f", album.getName(), df.print(album.getReleaseDate()), album.getPrice())
								);
					}
				} catch(IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}
			} else if(cmd.equals("ShowArtists") &&
					args.length == 1) {
				try {
					// get that artists albums
					List<Artist> artists = service.getArtists();
					
					// date formatter
					DateTimeFormatter df = DateTimeFormat.forPattern("dd-MM-yyyy");
					String disbandmentDate = null;
					
					System.out.println(
							String.format("%-20s | %-10s | %-10s", "Name", "Formation", "Disbanded"));
					System.out.println("==============================================");
					for(Artist artist: artists) {
						if(artist.getDisbandmentDate() == null) {
							disbandmentDate = "----------";
						} else {
							disbandmentDate = df.print(artist.getDisbandmentDate());
						}
						System.out.println(
								String.format("%-20s | %10s | %10s", artist.getName(),
										df.print(artist.getFormationDate()), disbandmentDate));
					}
				} catch(IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}
			}
		} finally {
			if(factory != null && !factory.isClosed()) {
				factory.close();
			}
		}
	}
	
	public static void usage() {
		System.out.println("Usage:\n");
		System.out.println("\tjava uk.ac.bham.cs.jdbc.music.Main ShowArtists");
		System.out.println("\tjava uk.ac.bham.cs.jdbc.music.Main ShowAlbums <artistName>");
		System.out.println("\tjava uk.ac.bham.cs.jdbc.music.Main InsertArtist <artistName> <formationDate (dd-mm-yyyy)>");
		System.out.println("\tjava uk.ac.bham.cs.jdbc.music.Main ShowTrack <trackId>");
	}
}
