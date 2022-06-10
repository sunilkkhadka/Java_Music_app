package music;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	private static ArrayList<Album> albums = new ArrayList<Album>();
	
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size() == 0) {
			System.out.println("This playlist has no songs");
		}
		else {
			System.out.println("Now playing - " + listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch(action) {
				case 0:
					System.out.println("PlayList complete");
					quit = true;
					break;
				
				case 1: 
					if(!forward) {
						if(listIterator.hasNext()) {
							listIterator.next();
						}
						forward = true;
					}
					if(listIterator.hasNext()) {
						System.out.println("Now playing - " + listIterator.next().toString());
					}
					else {
						System.out.println("No song available, reached to the end of the list");
						forward = false;
					}
					break;
					
				case 2:
					if(forward) {
						if(listIterator.hasPrevious()) {
							listIterator.previous();
						}
						forward = false;
					}
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing - " + listIterator.previous().toString());
					}
					else {
						System.out.println("We are at the first song");
						forward = false;
					}
					break;
					
				case 3:
					if(forward) {
						if(listIterator.hasPrevious()) {
							System.out.println("Now playing - " + listIterator.previous().toString());
							forward = false;
						}
						else {
							System.out.println("We are at the start of the list");
						}
					}
					else {
						if(listIterator.hasNext()) {
							System.out.println("Now playing - " + listIterator.next().toString());
							forward = true;
						}
						else {
							System.out.println("we have reached the end of the list");
						}
					}
					break;
					
				case 4:
					printList(playList);
					break;
					
				case 5: 
					printMenu();
					break;
					
				case 6:
					if(playList.size() > 0) {
						listIterator.remove();
						if(listIterator.hasNext()) {
							System.out.println("Now playing - " + listIterator.next().toString());
							forward = true;
						}
						else {
							if(listIterator.hasPrevious()) {								
								System.out.println("Now playing - " + listIterator.previous().toString());
							}
						}
					}
					break;
			}
		}
	}
	
	
	private static void printMenu() {
		System.out.println("Options:\n");
		System.out.println("Press [0] to quit\n");
		System.out.println("Press [1] to play next song\n");
		System.out.println("Press [2] to play previous song\n");
		System.out.println("Press [3] to replay the current song\n");
		System.out.println("Press [4] to list all the song in album\n");
		System.out.println("Press [5] to print all the available options\n");
		System.out.println("Press [6] to delete the current song from the album\n");
	}
	
	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator = playList.iterator();
		System.out.println("=======================");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("=======================");
	}

	public static void main(String[] args) {
		
		
		Album album = new Album("Kamikazi", "eminem");
		
		album.addSong("fact", 4.5);
		album.addSong("No body", 3.33);
		album.addSong("Fast and fast", 2.55);
		
		albums.add(album);

		album = new Album("HELL", "AC/DC");
		
		album.addSong("TNT", 2.55);
		album.addSong("ThunderStruck", 4.3);
		
		albums.add(album);
	
		LinkedList<Song> playlist_1 = new LinkedList<Song>();
		
		albums.get(0).addToPlayList("fact", playlist_1);
		albums.get(0).addToPlayList("No body", playlist_1);
		albums.get(1).addToPlayList("TNT", playlist_1);
		albums.get(1).addToPlayList("ThunderStruck", playlist_1);
		
		play(playlist_1);
		
	}
	
}
