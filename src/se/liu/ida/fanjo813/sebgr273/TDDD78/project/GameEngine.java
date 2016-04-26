package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import javax.swing.*;
import java.util.*;
import java.awt.Point;

public class GameEngine extends Bank {
    private List<Player> players;
    private Player curPlayer;
    private int curPlayerIndex, steps;
    private GameBoard board;
    private boolean winCondition;
    private Collection<BoardListener> boardListeners = new ArrayList();
	private List<Brick> brickList;

    public GameEngine(int amount) {
        super(amount);
        board = new GameBoard();
        players = new ArrayList<Player>();
        winCondition = false;
	    brickList = new ArrayList<Brick>();
    }

    public void play(){

        setPlayers();
        startGame();

        while(!winCondition){
            standardRotation();
        }
        System.out.println("Someone won");
    }

    public void setPlayers(){
        //Player player = new Player("Gert", board.getPosition(1));
        String amount = JOptionPane.showInputDialog(null, "How many players?");
        if(amount == null){
            System.out.println("Pressed exit");
            System.exit(0);
        }
        int amnt = Integer.parseInt(amount);
        for(int i = 0; i < amnt; i++){
            String name = JOptionPane.showInputDialog(null, "Write the name of player " + (i+1) + ":");
            String id = JOptionPane.showInputDialog(null, "What city do you want to start in?");
            int pos = Integer.parseInt(id);
            players.add(new Player(name, board.getPosition(pos)));

        }
    }

    private void standardRotation(){
        curPlayer = players.get(curPlayerIndex);
        Move move = new Move(brickList);
	    steps = diceThrow();
	    moveRotation(move);
        System.out.println("Start");
        endTurn();
    }

    private void startGame(){
        curPlayerIndex = 0;
        curPlayer = players.get(curPlayerIndex);
    }

    private int diceThrow(){
        return (int) (6.0 * Math.random()) + 1;
    }

    public GameBoard getBoard(){
	return board;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public Player getCurPlayer(){
        return curPlayer;
    }

	public void tick(Point mouseClick){
	    for (Position position : board.getPositions()) {
		    if(position.isRoughPosition(mouseClick) &&
				    isPossibleMove(position.getId(), curPlayer.getCurPos())
				    && steps > 0){
			    curPlayer.setCurPos(position);
			    step();
			    System.out.println(steps);
		    }
	    }
	    notifyListeners();
    }

	public void step(){
		steps -= 1;
	}

	public void addListener(BoardListener b1){
	boardListeners.add(b1);
    }

    private void notifyListeners(){
	    for(BoardListener boardListener : boardListeners){
		    boardListener.boardChanged();
	    }
    }

	private boolean isPossibleMove(int id1, Position player){
		Position startPos = null;
		for (Position position : board.getPositions()) {
			if(position.getId() == player.getId()){
				startPos = position;
			}
		}
		for (Path path : board.getPaths()){
			if ((path.getPosition1().equals(startPos) &&
					path.getPosition2().equals(board.getPosition(id1)))
					||
					(path.getPosition1().equals(board.getPosition(id1)) &&
							path.getPosition2().equals(startPos))){
				return true;
			}
		}
		return false;
	}

    private void endTurn() {
	    System.out.println("Slut");
	    if(curPlayer.getPlayerName().equals("Alex")){
		    this.winCondition = true;
	    } else if(curPlayerIndex == players.size()-1){
		    curPlayerIndex = 0;
	    } else {
		    curPlayerIndex++;
	    }
    }

	public boolean moveRotation(Move move){
	        /**Checks if the moving player is on a brick*
	         * and asks if for a action if player is*
	         */
		Point curPos = curPlayer.getCurPoint();
		while(steps > 0){
			if(move.onBrick(curPos)){
				/*ask player if want to flip brick*/
				int ans = JOptionPane.showConfirmDialog(null, "Do you want to flip the marker you're\n" +
						"currently on?", "Flip brick?", JOptionPane.YES_NO_OPTION);
				if(ans == JOptionPane.YES_OPTION){
					flipMethod(move, curPos);
				}
			}
		}
		if(move.onBrick(curPos)){
			int ans = JOptionPane.showConfirmDialog(null, "Do you want to flip the marker you're\n" +
					"currently on?", "Flip brick?", JOptionPane.YES_NO_OPTION);
			if (ans == JOptionPane.YES_OPTION){
				flipMethod(move, curPos);
			}
		}
		return false;
	}

	private void flipBrick(Move move, Point pos){
		/**Handles the event when the*
		 *player wants to flip a brick*
		 */
		Brick brick = move.getBrick(pos);
		switch (brick.getBrickType()){
			case MONEY:
				break;
			case SSD:
				curPlayer.canWin();
				break;
			case STACK:
				curPlayer.canWin();
				break;
			case BANDIT:
				curPlayer.bandit();
				break;
			case BLANC:
				break;
			case EMPTY:
				break;
			default:
				break;
		}
	}

	private void flipMethod(Move move, Point pos){
		Object[] options = {
				"Pay for it",
				"Roll for it"
		};
		int ans = JOptionPane.showOptionDialog(null,
				"How do you want to flip the marker?",
				"Way of flipping",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[1]);
		if(ans == JOptionPane.YES_OPTION){
			curPlayer.removeMoney(1000);
			System.out.println("you payed");
			flipBrick(move, pos);
		}else{
			int roll = curPlayer.diceThrow();
			if(roll > 3){
				System.out.println("win");
				flipBrick(move, pos);
			}else{
				JOptionPane.showMessageDialog(null, "Didn't roll high enough.");
			}
		}
	}
}