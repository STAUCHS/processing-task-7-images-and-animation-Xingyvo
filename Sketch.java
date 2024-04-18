import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  PImage imgGojo;
  PImage imgHamster;

  // x and y coordinate, radius, and angle for images
  float fltGojoX = 0;
  float fltGojoY = 0;

  float fltHamsterX;
  float fltHamsterY;
  float fltHamsterRadius;
  float fltHamsterAngle;

  // x and y coordinate for circle
  float fltCircleX = 0;
  float fltCircleY = 0;

  // Image speed variables
  float fltGojoXSpeed = random(1, 2);
  float fltGojoYSpeed = random(1, 2);

  double fltHamsterSpeed = 0.03;

  // Circle speed variables
  float fltCircleXSpeed = random(4, 6);
  float fltCircleYSpeed = random(4, 6);

  // Define colours
  int black = color(0);
  int red = color(217, 33, 33);

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(210, 255, 173);

    // Load images
    imgGojo = loadImage("Gojo-PNG-Photos.png");
    imgHamster = loadImage("8h26xs.png");

    // Resize images
    imgGojo.resize(imgGojo.width / 6, imgGojo.height / 6);
    imgHamster.resize(imgHamster.width / 4, imgHamster.height / 4);

    // Initialize hamster variables
    fltHamsterX = width / 3;
    fltHamsterY = height / 3;
    fltHamsterRadius = 100;
    fltHamsterAngle = 0;
  }

  public void draw() {
    background(black);

    // Draw Gojo and move
    image(imgGojo, fltGojoX, fltGojoY);

    fltGojoX += fltGojoXSpeed;
    fltGojoY += fltGojoYSpeed;

    // Check for edge collision
    if (fltGojoX > width - imgGojo.width + 40 || fltGojoX < 0 - imgGojo.width / 7) {
      fltGojoXSpeed *= -1;
    }

    if (fltGojoY > height - imgGojo.height || fltGojoY < 0) {
      fltGojoYSpeed *= -1;
    }

    // Draw hamster that moves in a circular motion
    float fltNewHamsterX = fltHamsterX + cos(fltHamsterAngle) * fltHamsterRadius;
    float fltNewHamsterY = fltHamsterY + sin(fltHamsterAngle) * fltHamsterRadius;

    image(imgHamster, fltNewHamsterX, fltNewHamsterY);

    // Check for edge collision
    if (fltNewHamsterX < 0 || fltNewHamsterX > width || fltNewHamsterY < 0 || fltNewHamsterY > height) {
      fltHamsterSpeed *= -1;
    }

    fltHamsterAngle += fltHamsterSpeed;

    // Draw a red circle and move
    fill(red);
    ellipse(fltCircleX, fltCircleY, 50, 50);

    fltCircleX += fltCircleXSpeed;
    fltCircleY += fltCircleYSpeed;

    // Check for edge collision
    if (fltCircleX > width - 25 || fltCircleX < 0) {
      fltCircleXSpeed *= -1;
    }
    
    if (fltCircleY > height - 25 || fltCircleY < 0) {
      fltCircleYSpeed *= -1;
    }
  }
}