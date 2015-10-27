import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Assessment2 extends PApplet {

float speed;
float bX = 10, bY = 10;
int timer;

public void setup() {
  size(650, 650);
  frameRate(144);
  frame.setTitle("Black Hole Simulation ALPHA - Hold mouse to increase time");
}

public void draw() {
  
  background(0);
  stroke(255);
  
  for(float n = 0; n < 10; n += 0.1f) {
    fill(255,255,255,random(100));
    point(random(650), random(650));
  }
  
  fill(0);
  ellipse(width/2, height/2, bX, bY);
  noFill();
  stroke(255, 255, 255, 100);
  ellipse(width/2, height/2, bX+10, bY+10);
  stroke(255);
  
  speed += 0.0001f;
  translate(width/2, height/2);
  for(int x = 35; x < 500; x += 30) {
    for(int y = 35; y < 500; y += 30) {
      fill(255);
      rotate(PI+speed+100);
      point(x, y);
      }
    }
  
  if(mousePressed) {
    speed += 0.001f;
    bX++;
    bY++;
  } else if (millis() - timer >= 2000) {
    bX++;
    bY++;
    timer = millis() + second();
  }
  
  if(bX >= width || bY >= height) {
    bX = 0;
    bY = 0;
  }
  
  if(keyPressed) {
    if(key == 'q') {
      save("bh.png");
    }
  }
  
  //TO ADD FROM JORDAN

  /*
  Black holes only have three properties- mass, charge and angular momentum. As objects fall in their mass, charge and angular momentum is added to the black hole. The radius of event horizon of the black hole is proportional to its mass. So infalling matter
will increase the mass of the black hole and the radius of the horizon */

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assessment2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
