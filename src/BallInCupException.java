/**
 * This method is thrown whenever the ball is in the cup but the game isn't over.
 *
 */
public class BallInCupException extends Exception {

	public BallInCupException(String msg) {
		super(msg);
	}
}
