package pa03;


/**
 * CatchandRun are red circles which move at a constant velocity and change
 * the radius at a constant velocity. But once it reach the boarder and the value
 * of radius change smaller than the value of x's movement, the circle will be
 * catched by the boarder and can move to other position only when it grows to
 * the maximum radius. While it is growing, the circle should change the color
 * randomly and leave with the last color.
*/
public class CatchandRun extends CircleShape{

  private double vr=1.0;
  private int colorx;
  private int colory;
  private int colorz;

	/**
	 * create a radius changing circle and set the color to red
	 */
  public CatchandRun(){
    super();
		this.color = new java.awt.Color(204,0,0,100); // transparent red
  }

	/**
	 * update the circle as usual, but also change the radius. While it is moving
   * inside the board, it can only get smaller, and once reach the boarder, it
   * can only grow to the largest size
	 */
  public void update(double dt){
    // change the properties of the CircleShape after dt seconds have elapsed.

    this.colorx = (int)(255*Math.random());
    this.colory = (int)(255*Math.random());
    this.colorz = (int)(255*Math.random());

		this.radius += dt*vr;

    if  (this.radius <10) {
      this.vr *= -1;
    } else if (this.radius > 50) {
      this.vr *= -1;
    }


    if (this.x < this.radius) {
      this.vx = -this.vx;
      this.x = this.radius;
      this.color = new java.awt.Color(colorx,colory,colorz,100);

    }else if (this.x > CircleShape.boardWidth-this.radius) {
      this.vx = -this.vx;
      this.x = CircleShape.boardWidth-this.radius;
      this.color = new java.awt.Color(colorx,colory,colorz,100);
    }

    if (this.y < this.radius){
      this.vy = -this.vy;
      this.y = this.radius;
      this.color = new java.awt.Color(colorx,colory,colorz,100);

    } else if (this.y > CircleShape.boardHeight-this.radius) {
      this.vy = -this.vy;
      this.y = CircleShape.boardHeight-this.radius;
      this.color = new java.awt.Color(colorx,colory,colorz,100);
    }

		super.update(dt);
  }

}
