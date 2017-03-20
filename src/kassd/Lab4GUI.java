/*
 * SE 1011-001
 * Winter 2010-2011
 * Lab 4
 * Dan Kass
 * 1/11/11
 */

package kassd;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Lab4GUI {

	public static void main(String[] args) {

		boolean keepRunning = true;
		// Scanning Variables
		String userInput;
		Scanner scan;
		// Math Variables
		double angle = 0;
		double currentNumber = 0;
		double radians = 0;
		double sine = 0;
		double cosine = 0;
		double squared = 0;
		String outAngle;
		String outSine;
		String outCosine;
		String outSquared;
		// English Variables
		String currentWord = "";
		int numberOfIts = 0;
		int numberOfItIs = 0;
		String sentence = "";
		char currentCharacter;
		String reverse = "";
		// Physics Variables
		double height = 0;
		double fallDuration = 0;
		double minHeight = 50.0;
		double maxHeight = 400.0;
		double gravaty = 32;
		String outHeight;
		String outFallDuration;

		while (keepRunning) {
			String typeOfHomework;
			typeOfHomework = JOptionPane
					.showInputDialog("Homework helper -- Enter the subject number: \n 1. Math \n 2. English \n 3. Physics");
			if (typeOfHomework != null) {
				switch (typeOfHomework.charAt(0)) {

				// For the math part of the homework helper
				case '1':
					userInput = JOptionPane
							.showInputDialog("Please enter and angle in degrees.");
					scan = new Scanner(userInput);
					if (scan.hasNextDouble()) {
						currentNumber = scan.nextDouble();
						angle = currentNumber;
						radians = Math.toRadians(angle);
						sine = Math.sin(radians);
						cosine = Math.cos(radians);
						squared = (sine * sine) + (cosine * cosine);
						outAngle = String.format("%.1f", angle);
						outSine = String.format("%.4f", sine);
						outCosine = String.format("%.4f", cosine);
						outSquared = String.format("%.4f", squared);
						JOptionPane.showMessageDialog(null, "Angle = "
								+ outAngle + "\n Sine = " + outSine
								+ "\n Cosine = " + outCosine
								+ "\n Sine squared + cosine squared = "
								+ outSquared);
					}
					break;

				// for the English Par of the homework helper
				// Add the Reversed
				case '2':
					userInput = JOptionPane
							.showInputDialog("Please enter your sentence.");
					scan = new Scanner(userInput);
					while (scan.hasNext()) {
						currentWord = scan.next();
						sentence = sentence + " " + currentWord;
						if (currentWord.equalsIgnoreCase("its")) {
							numberOfIts++;
						} else if (currentWord.equalsIgnoreCase("it's")) {
							numberOfItIs++;
						}
					}
					for (int x = 0; x < sentence.length(); ++x) {
						currentCharacter = sentence.charAt(x);
						if (Character.isLetter(currentCharacter)) {
							reverse = currentCharacter + reverse;
						}
					}
					JOptionPane.showMessageDialog(null, "Sentence: " + sentence
							+ "\n Count of \"its\" = " + numberOfIts
							+ "\n Count of \"it's\" = " + numberOfItIs
							+ "\n Reversed: " + reverse);
					numberOfIts = 0;
					numberOfItIs = 0;
					sentence = "";
					reverse = "";
					break;

				// for the physics part of the homework helper
				case '3':
					height = minHeight + Math.random()
							* (maxHeight - minHeight);
					// t = square root of 2d/g g is equal to 32feet/second
					// second
					fallDuration = Math.sqrt((height * 2) / (gravaty));
					outHeight = String.format("%.2f", height);
					outFallDuration = String.format("%.2f", fallDuration);
					JOptionPane.showMessageDialog(null, "Height = " + outHeight
							+ " feet.\nFall duration = " + outFallDuration
							+ " seconds.");
					break;

				default:
					JOptionPane.showMessageDialog(null, "Thank you");
					keepRunning = false;
				}

			} else {
				JOptionPane.showMessageDialog(null, "Thank you");
				keepRunning = false;
			}
		}
	}
}
