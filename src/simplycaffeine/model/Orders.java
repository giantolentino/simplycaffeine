package simplycaffeine.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Orders {
	// 0 1 2 3
	// ------------------------------- userID card# name email
	// csv file should be formatted as 1234 4325 John Doe jd@gmail.com

	public void processOrder(int userID, int amount) throws IOException {

		System.out.println("TESTING");
		String userDB = "UserInfo.csv"; // make sure this file exists
		File inFile = new File(userDB);
		if (!inFile.exists()) {
			JOptionPane.showMessageDialog(null, " File Doesnt exist");
		}
		Scanner fileeReader = new Scanner(inFile);
		String newLine;
		int nextUserID;
		int cardNum;
		String[] dataSplit = new String[4];
		Boolean found = false;
		// File outFile= new File("transactions.txt");

		while (fileeReader.hasNextLine()) { // look for users creditcard num by using userID in UserInfo DB
			newLine = fileeReader.nextLine();
			dataSplit = newLine.split(",");
			nextUserID = Integer.parseInt(dataSplit[0]);
			cardNum = Integer.parseInt(dataSplit[1]);

			if (nextUserID == userID) { // ---------found user, now copy to txt file-> credit card num-
										// and amount to charge.
				found = true;
				// print cardNum and amount to file.
				String data = "charge credit card number " + cardNum + " total of: " + amount;
				PrintWriter writer = new PrintWriter("transactions.txt", "UTF-8");
				System.out.println(data);
				writer.print(data);
				writer.close();
				break;
			}

		}
		if (!found) { // if not found exit order process
			System.exit(1);
		}

	}

	public ArrayList<StatsUserInfoOneDrink> sendInfoToStats(ArrayList<StatsUserInfoOneDrink> stats) {

		return stats;// list of what user bought in one order --> qty , userID, coffeename

	}

	public ArrayList<ReplenishInfo> sendInfoToReplenish(ArrayList<ReplenishInfo> rep) { // list of what is bought send
																						// to replenish--->
																						// qty,coffeename

		return rep;
	}

}