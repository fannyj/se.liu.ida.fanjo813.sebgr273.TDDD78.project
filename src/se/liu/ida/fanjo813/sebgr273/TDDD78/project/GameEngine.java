package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import javax.swing.*;
import java.util.*;
import java.awt.Point;

/**
 * Deals with all the non-graphical stuff of the game*
 */
public class GameEngine extends Bank {
    private List<Player> players;
    private Player curPlayer;
    private int curPlayerIndex, steps;
    private GameBoard board;
    private boolean winCondition;
    private Collection<BoardListener> boardListeners;
	private List<Brick> brickList;

    public GameEngine(int amount) {
        super(amount);
        board = new GameBoard();
        players = new ArrayList<>();
	    boardListeners = new ArrayList<>();
        winCondition = false;
	    brickList = board.getBrickList();
	    steps = 1;
	    curPlayer = null;
    }

    public void play(){
        setPlayers();
        startGame();
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

    private void nextRound(){
        curPlayer = players.get(curPlayerIndex);
	    steps = diceThrow();
	    System.out.println("Start");
    }

    private void startGame(){
        curPlayerIndex = 0;
        curPlayer = players.get(curPlayerIndex);
    }

    private int diceThrow(){
	    /*6.0 is the multiplier for the random nr*/
        return (int) (6.0 * Math.random()) + 1;
    }

    public GameBoard getBoard(){
		return board;
    }

    public Iterable<Player> getPlayers(){
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
			    moveRotation();
			    System.out.println(steps);
		    } else if (steps == 0){
			    endTurn();
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

	private boolean isPossibleMove(int nextPos, Position playerPos){
		Position startPos = null;
		for (Position position : board.getPositions()) {
			if(position.getId() == playerPos.getId()){
				startPos = position;
			}
		}
		for (Path path : board.getPaths()){
			if ((path.getPosition1().equals(startPos) &&
					path.getPosition2().equals(board.getPosition(nextPos)))
					||
					(path.getPosition1().equals(board.getPosition(nextPos)) &&
							path.getPosition2().equals(startPos))){
				/*if(isSpecialPath(path)){
					return handleSpecialPath(path, playerPos);
				} else {
					return true;
				}*/
				return true;
			}
		}
		return false;
	}

	public boolean isSpecialPath(Path curPath){
		List<Path> pathList = board.getPaths();
		for (Path path : pathList) {
			if (path.equals(curPath) &&
				(path.getPathType().equals(PathType.AIRPLANE)
				||
				path.getPathType().equals(PathType.BOAT))){
				return true;
			}
		}
		return false;
	}

	public boolean handleSpecialPath(Path path, Position playerPos){
		int cost = 0;
		int altCost = 0;

		switch(path.getPathType()){
			case AIRPLANE:
				if(path.getPosition1().equals(playerPos)){
					cost = path.getCostFrom1To2();
				} else if(path.getPosition2().equals(playerPos)){
					cost = path.getCostFrom2To1();
				}
				break;
			case BOAT:
				if(path.getPosition1().equals(playerPos)){
					cost = path.getCostFrom1To2();
					altCost = path.getAlternativeCost();
				} else if (path.getPosition2().equals(playerPos)){
					cost = path.getCostFrom2To1();
					altCost = path.getAlternativeCost();
				}
				break;
			case WALK:
			default:
				break;
		}
		Object[] options = {
				"Pay for it",
				"Roll for it"
		};
		int opt = JOptionPane.showConfirmDialog(null,
				"It`s a special path, do you want to walk it?",
				"Special path", JOptionPane.YES_NO_OPTION);
		if(opt == 0) {
			int ans = JOptionPane.showOptionDialog(null,
					"How do you want to pay for it?",
					"Paying",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[1]);

			if (ans == 0) {
				curPlayer.removeMoney(cost);
				return true;
			} else if (ans == 1) {
				int roll = diceThrow();
				if (roll == altCost){
					return true;
				}
			}
		} else {
			return false;
		}
		return false;
	}

    private void endTurn() {
	    System.out.println("Slut");
	    if(curPlayer.canWin() && curPlayer.getCurPos().posIsStart()){
		    this.winCondition = true;
	    } else if(curPlayerIndex == players.size()-1){
		    curPlayerIndex = 0;
		    nextRound();
	    } else {
		    curPlayerIndex++;
		    nextRound();
	    }
    }

	public void moveRotation(){
	        /**Checks if the moving player is on a brick*
	         * and asks if for a action if player is*
	         */
		Point curPos = curPlayer.getCurPoint();
		System.out.println(curPos);
		if(onBrick(curPos)){
			int ans = JOptionPane.showConfirmDialog(null, "Do you want to flip the marker you're\n" +
					"currently on?", "Flip brick?", JOptionPane.YES_NO_OPTION);
			if (ans == JOptionPane.YES_OPTION){
				flipMethod(curPos);
			}
		}
	}

	private void flipBrick(Point pos){
		/**Handles the event when the*
		 *player wants to flip a brick*
		 */
		Brick brick = getBrick(pos);
		assert brick != null;
		switch (brick.getBrickType()){
			case MONEY:
				curPlayer.addMoney(brick.getMoney().getAmount());
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

	private void flipMethod(Point pos){
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
			flipBrick(pos);
		}else{
			int roll = curPlayer.diceThrow();
			if(roll > 3){
				System.out.println("win");
				flipBrick(pos);
			}else{
				JOptionPane.showMessageDialog(null, "Didn't roll high enough.");
			}
		}
	}

	private boolean onBrick(Point pos){
		for (Brick brick : brickList) {
			if (brick.getBoardPosition().equals(pos)){
				return true;
			}
		}
		return false;
	}

	private Brick getBrick(Point pos) {
		for (Brick brick : brickList) {
			if(brick.getBoardPosition().equals(pos)){
				return brick;
			}
		}
		return null;
	}
}