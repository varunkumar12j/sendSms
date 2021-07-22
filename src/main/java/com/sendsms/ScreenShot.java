package com.sendsms;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenShot {

	public static void main(String[] args) {
		try {
			Thread.sleep(120);

			Robot robot = new Robot();

			String path = "C:// Quick_shot.jpg";

			Rectangle rectangleCapture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage bufferImage = robot.createScreenCapture(rectangleCapture);
			ImageIO.write(bufferImage, "jpg", new File(path));
			System.out.println("**************Complete**************");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
