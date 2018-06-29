import java.util.Random;
public class Trap {
  int nWidth = 60; // width of the map
	  int nHeight = 20; // height of the map
	  int nTraps = 80; // number of trap
	  char[][] Map; // 2-dimensional array of chars for our map
	
// This is to place traps
	public void placeTraps() {
		int TrapsPlaced = 0;
		Random random = new Random(); // this generates random numbers for us
		while(TrapsPlaced < nTraps) {
			int x = random.nextInt(nWidth); // a number between 0 and nWidth - 1
			int y = random.nextInt(nHeight);
			// make sure we don't place a trap on top of another
			if(Maps[y][x] != '*') {
				Maps[y][x] = '*';
				TrapsPlaced ++;
			}
		}
	}
	
  public char TrapsNear(int y, int x) {
    int nTraps = 0;
    // check traps in all directions
    nTraps += TrapsAt(y - 1, x - 1);  // NW
    nTraps += TrapsAt(y - 1, x);      // N
    nTraps += TrapsAt(y - 1, x + 1);  // NE
    nTraps += TrapsAt(y, x - 1);      // W
    nTraps += TrapsAt(y, x + 1);      // E
    nTraps += TrapsAt(y + 1, x - 1);  // SW
    nTraps += TrapsAt(y + 1, x);      // S
    nTraps += TrapsAt(y + 1, x + 1);  // SE
    if(nTraps > 0) {
      // we're changing an int to a char
      return (char)(nTraps + 48);
    } else {
      return ' ';
    }
  }
  
	 public int TrapsAt(int y, int x) {
		    // we need to check also that we're not out of array bounds as that would
		    // be an error
		    if(y >= 0 && y < nHeight && x >= 0 && x < nWidth && Map[y][x] == '*') {
		      return 1;
		    } else {
		      return 0;
		    }
		  }

}
