float speed;
float bX = 10, bY = 10;
int timer;

void setup() {
  size(650, 650);
  frameRate(144);
  frame.setTitle("Black Hole Simulation ALPHA - Hold mouse to increase time");
}

void draw() {
  
  background(0);
  stroke(255);
  
  for(float n = 0; n < 10; n += 0.1) {
    fill(255,255,255,random(100));
    point(random(650), random(650));
  }
  
  fill(0);
  ellipse(width/2, height/2, bX, bY);
  noFill();
  stroke(255, 255, 255, 100);
  ellipse(width/2, height/2, bX+10, bY+10);
  stroke(255);
  
  speed += 0.0001;
  translate(width/2, height/2);
  for(int x = 35; x < 500; x += 30) {
    for(int y = 35; y < 500; y += 30) {
      fill(255);
      rotate(PI+speed+100);
      point(x, y);
      }
    }
  
  if(mousePressed) {
    speed += 0.001;
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

//add mouseClick to add black hole in future version

}
