Ball[] balls;

void setup() {
  size(600, 600);
  balls = new Ball[30];
  for (int i = 0; i < balls.length; i++) {
    balls[i] = new Ball();
  }
  background(0);
}

void draw() {
  background(0);
  for (Ball b : balls) {
    color c = b.c;
    fill(c);
    b.deflect();
    b.act();
    ellipse(b.x, b.y, 20, 20);
  }
}

void changeState(Ball b) {
  for (Ball ba : balls) {
    if (ba.state == 1 || ba.state == 2) {
      if (abs(ba.x-b.x) < (ba.radius + b+radius) && (abs(ba.y-ba.y) < ba.radius + b.radius)) {
        b.state = 1;
      }
    }
  }
}
