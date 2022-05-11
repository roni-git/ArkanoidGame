/*323867077*/
/**
 * @author roni gilboa
 * this class implements HitListener
 * it print a message whenever happened a hit
 */
public class PrintingHitListener implements HitListener {
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}

