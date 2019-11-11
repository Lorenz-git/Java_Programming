package tdgame.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import tdgame.Handler;
import tdgame.worlds.World;

public class Utils {
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null){
				builder.append(line + "\n");
			}
			br.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static void writeFileFromWorld(String path, Handler handler) {
		try {
			PrintWriter writer = new PrintWriter(path);
			writer.println(handler.getWorld().getWidth() + " " + handler.getWorld().getHeight()); 
			writer.println(handler.getWorld().getEntryX() + " " + handler.getWorld().getEntryY());
			writer.println(handler.getWorld().getExitX() + " " + handler.getWorld().getExitY());
			for(int y = 0; y < handler.getWorld().getHeight(); ++y) {
				String line = "";
				for(int x = 0; x < handler.getWorld().getWidth(); ++x) {
					line= line+ handler.getWorld().getWorldTiles()[x][y]+ " ";
				}
				writer.println(line);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
