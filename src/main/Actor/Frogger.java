//package main.Actor;
//
//import java.util.ArrayList;
//
//import javafx.event.EventHandler;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyEvent;
//
//
//public class Frogger extends Actor {
//	Image imgW1, imgA1, imgS1, imgD1, imgW2, imgA2, imgS2, imgD2;
//	private boolean second = false;
//	private String filePath = "file:src/img/FroggerAction/";
//
//	int points = 0;
//	int end = 0;-
//	int imgSize = 40;
//	int deathFrame = 0;
//	boolean noMove = false;
//	boolean carDeath = false, waterDeath = false;
//	boolean stop = false;
//	boolean changeScore = false;
//	double w = 800;
//	double movementY = 13.3333333 * 2, movementX = 10.666666 * 2;
//	ArrayList<End> inter = new ArrayList<End>();
//
//	public Frogger(String imageLink) {
//		setImage(new Image(imageLink, imgSize, imgSize, true, true));
//		setX(280);
//		setY(730 + movementY);
//		imgW1 = new Image(filePath + "froggerUp.png", imgSize, imgSize, true, true);
//		imgA1 = new Image(filePath + "froggerLeft.png", imgSize, imgSize, true, true);
//		imgS1 = new Image(filePath + "froggerDown.png", imgSize, imgSize, true, true);
//		imgD1 = new Image(filePath + "froggerRight.png", imgSize, imgSize, true, true);
//		imgW2 = new Image(filePath + "froggerUpJump.png", imgSize, imgSize, true, true);
//		imgA2 = new Image(filePath + "froggerLeftJump.png", imgSize, imgSize, true, true);
//		imgS2 = new Image(filePath + "froggerDownJump.png", imgSize, imgSize, true, true);
//		imgD2 = new Image(filePath + "froggerRightJump.png", imgSize, imgSize, true, true);
//		setOnKeyPressed(new EventHandler<KeyEvent>() {
//			public void handle(KeyEvent event){
//				if (noMove) {
//
//				}
//				else {
//					if (second) {
//						switch(event.getCode()){
//							case W:
//								move(0, -movementY);
//								changeScore = false;
//								setImage(imgW1);
//								second = false;
//								break;
//
//							case A:
//								move(-movementX, 0);
//								setImage(imgA1);
//								second = false;
//								break;
//
//							case S:
//								move(0, movementY);
//								setImage(imgS1);
//								second = false;
//								break;
//
//							case D:
//								move(movementX, 0);
//								setImage(imgD1);
//								second = false;
//								break;
//
//							default:
//
//						}
//					}
//					switch(event.getCode()) {
//						case W:
//							move(0, -movementY);
//							changeScore = false;
//							setImage(imgW2);
//							second = true;
//							break;
//
//						case A:
//							move(-movementX, 0);
//							setImage(imgA2);
//							second = true;
//							break;
//
//						case S:
//							move(0, movementY);
//							setImage(imgS2);
//							second = true;
//							break;
//
//						case D:
//							move(movementX, 0);
//							setImage(imgD2);
//							second = true;
//							break;
//
//						default:
//					}
//				}
//			}
//		});
//
//		setOnKeyReleased(new EventHandler<KeyEvent>() {
//			public void handle(KeyEvent event) {
//				if (noMove) {
//
//				}
//				else {
//					switch (event.getCode()) {
//						case W:
//							if (getY() < w) {
//								changeScore = true;
//								w = getY();
//								points += 10;
//							}
//							move(0, -movementY);
//							setImage(imgW1);
//							second = false;
//							break;
//
//						case A:
//							move(-movementX, 0);
//							setImage(imgA1);
//							second = false;
//							break;
//
//						case S:
//							move(0, movementY);
//							setImage(imgS1);
//							second = false;
//							break;
//
//						case D:
//							move(movementX, 0);
//							setImage(imgD1);
//							second = false;
//							break;
//
//						default:
//					}
//				}
//			}
//
//		});
//	}
//
//	@Override
//	public void act(long now) {
//		int bounds = 0;
//		if (getY()<0 || getY()>730 + movementY) {
//			setY(730 + movementY);
//		}
//		if (getX()<0) {
//			move(movementX*2, 0);
//		}
//		if (getX()>600 - movementY) {
//			move(-movementY*2, 0);
//		}
//
//		if (carDeath) {
//			noMove = true;
//			if ((now)% 11 == 0) {
//				deathFrame++;
//			}
//			switch(deathFrame){
//				case 1:
//					setImage(new Image(filePath + "carDeath1.png", imgSize, imgSize, true, true));
//					break;
//
//				case 2:
//					setImage(new Image(filePath + "carDeath2.png", imgSize, imgSize, true, true));
//					break;
//
//				case 3:
//					setImage(new Image(filePath + "carDeath3.png", imgSize, imgSize, true, true));
//					break;
//
//				case 4:
//					setX(280);
//					setY(730 + movementY);
//					carDeath = false;
//					deathFrame = 0;
//					setImage(new Image(filePath + "froggerUp.png", imgSize, imgSize, true, true));
//					noMove = false;
//					if (points>50) {
//						points-=50;
//						changeScore = true;
//					}else{
//						points = 0;
//						changeScore = true;
//					}
//					break;
//
//				default:
//			}
//		}
//
//		if (waterDeath) {
//			noMove = true;
//			if ((now)% 11 == 0) {
//				deathFrame++;
//			}
//			switch(deathFrame){
//				case 1:
//					setImage(new Image(filePath + "waterDeath1.png", imgSize,imgSize , true, true));
//					break;
//
//				case 2:
//					setImage(new Image(filePath + "waterDeath2.png", imgSize,imgSize , true, true));
//					break;
//
//				case 3:
//					setImage(new Image(filePath + "waterDeath3.png", imgSize,imgSize , true, true));
//					break;
//
//				case 4:
//					setImage(new Image(filePath + "waterDeath4.png", imgSize,imgSize , true, true));
//					break;
//
//				case 5:
////					setX(280);
////					setY(730 + movementY);
//					setX(240);
//					setY(82);
//					waterDeath = false;
//					deathFrame = 0;
//					setImage(new Image(filePath + "froggerUp.png", imgSize, imgSize, true, true));
//					noMove = false;
//					if (points>50) {
//						points-=50;
//						changeScore = true;
//					}else{
//						points = 0;
//						changeScore = true;
//					}
//					break;
//
//				default:
//			}
//		}
//
//		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
//			carDeath = true;
//		}
//
//		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
//			if(getIntersectingObjects(Log.class).get(0).getLeft())
//				move(-2,0);
//			else
//				move (.75,0);
//		}
//		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
//			move(-1,0);
//		}
//		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
//			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
//				waterDeath = true;
//			} else {
//				move(-1,0);
//			}
//		}
//		else if (getIntersectingObjects(End.class).size() >= 1) {
//			inter = (ArrayList<End>) getIntersectingObjects(End.class);
//			if (getIntersectingObjects(End.class).get(0).isActivated()) {
//				end--;
//				points-=50;
//			}
//			points+=50;
//			changeScore = true;
//			w=800;
//			getIntersectingObjects(End.class).get(0).setEnd();
//			end++;
//			setX(280);
//			setY(730 + movementY);
//		}
//		else if (getY()<413){
//			waterDeath = true;
//			//setX(300);
//			//setY(679.8+movementY);
//		}
//	}
//	public boolean getStop() {
//		return end==5;
//	}
//
//	public int getPoints() {
//		return points;
//	}
//
//	public boolean changeScore() {
//		if (changeScore) {
//			changeScore = false;
//			return true;
//		}
//		return false;
//
//	}
//
//
//}
