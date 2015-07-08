/**
 * 
 */
package bs;

/**
 * @author UnityBoss
 *
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.util.Random;
import java.util.Vector;
import java.lang.Integer;
import java.text.NumberFormat;	

public class Player
{
	private int hits;
	private int xpos,ypos;  
	//private Integer n;
	private int r,c;//row and column for comp attack	
	private Ship boats[] = new Ship[5];	
	private String user;//user name
	//private JPanel board;//panel to store game board
	private int shipsleft;
	private int shots;// shots taken
	private boolean[][] hitormiss=new boolean[10][10];
	private static final int NUKE = 2;
	private static final int CONF = 4;
	private static final int SF = 6;
	private static final int TOR = 8;
	private static final int FRAG = 10;
	private static final int CROSS = 12;
	private static final int BOMB = 14;
	private static Random rf = new Random();
	private boolean chit=false;//checks if computer hit ship or not		
	private JButton[][] bboard = new JButton [10][10];
						//gbutton=new JButton [10][10];
	private int[][] mhs=new int[10][10];//used by computer to track miss(0)
	//, hit(1), or sunk(2); default is (3)
	private boolean move;
	private JPanel gboard,myboard;
	private Vector<Integer> rows=new Vector<Integer>();
	private Vector<Integer> cols=new Vector<Integer>();	
	private Timer timeleft;//
	private String[][] whatship=new String[10][10];//stores name of ships or " "
	private int go=2;//direction for the computer to look for ships
	private int fr,fc;//first hits made by computer					
	private int lastship;//length of the last ship left
	private NumberFormat nf = NumberFormat.getPercentInstance();
	//private Board games
		
	public Player(String name)
	{			
		user=name;
		shipsleft=5;
		lastship=0;	
				
		if
		((user.equals("Computer"))||(user.equals("CPU1"))||(user.equals("CPU2"))||(Battleship.isAutoSet())||(Battleship.isLocal()))
			for (xpos=0;xpos<5;xpos++)
				boats[xpos]=new Ship(Battleship.getShips(xpos),0,0,0,0);		
		if((user.equals("Computer"))||(user.equals("CPU1"))||(user.equals("CPU2")))
		{
			for (xpos=0;xpos<10;xpos++)
				for (ypos=0;ypos<10;ypos++)
					mhs[xpos][ypos]=3;						
			
			timeleft= new Timer(1000,new CompAttack());
		}
		else
			timeleft= new Timer(10000,new AttackListener());				
		move=false;
		shots=0;
		hits=0;
		for (xpos=0;xpos<10;xpos++)
		{			
			for (ypos=0;ypos<10;ypos++)
			{
				this.bboard[xpos][ypos]=new JButton();
				this.bboard[xpos][ypos].setBackground(null);				
				hitormiss[xpos][ypos]=false;
				this.whatship[xpos][ypos]=" ";				
			}
		}			
	}
	
	public void setUser(String m)
	{
		this.user=m;	
	}
	
	//returns player's game board with ap
	public JPanel getMyBoard()
	{
		return this.myboard;	
	}	
	
	//returns player's game board with ap
	public JPanel getGBoard()
	{
		return this.gboard;	
	}	
	
	public void setMyBoard(JPanel r)
	{
		this.myboard=r;		
	}

	public void setGBoard(JPanel r)
	{
		this.gboard=r;		
	}		
		
	public void setBoats(int i, Ship r)
	{
		this.boats[i]=r;		
	}	
	
	/*public void setGames(Board k)
	{
		this.games=k;
	}	
	
	public Board getGames()
	{
		return this.games;
	}*/
	
	public Ship getBoats(int x)
	{
		return this.boats[x];
	}
		
	public void setShots()
	{
		this.shots+=1;	
	}		
		
	public void setHits()
	{
		this.hits+=1;	
	}		
	
	public int getShots()
	{
		return this.shots;	
	}		
	
	public int getHits()
	{
		return this.hits;	
	}		
		
	public String getAcc()
	{
		if (this.getShots()>0)
			return nf.format(((double)(this.getHits())/(double)(this.getShots())));
		else
			return "";
	}		
		
	public Timer getTimer()
	{
		return timeleft;
	}
	
	public JButton getBboard(int i,int j)
	{
		return this.bboard[i][j];	
	}	
	
	public void setBboard(int i,int j, Color k)
	{
		
		//TODO possible i++ until end of board
		
		
			this.bboard[i][j].setOpaque(true);
		this.bboard[i][j].setBackground(k);	
		
		
		
			
	}		
		
	public void setMove(boolean x)
	{
		this.move=x;
	}
		
	public boolean getMove()
	{
		return this.move;
	}
		
	//returns user name
	public String getUser()
	{
		return user;				
	}
	
	//checks if Statistics frame is open
	public static void isStatsOpen()
	{
		if (Battleship.getStats().isShowing())
		{	
			Battleship.getStats().removeAll();
			Battleship.getStats().setLayout(new GridLayout(6,3));					
			Battleship.setData(new JLabel(""));
			Battleship.getStats().add(Battleship.getData());
			Battleship.setData(new JLabel("Player 1",SwingConstants.CENTER));
			Battleship.getStats().add(Battleship.getData());
			Battleship.setData(new JLabel("Player 2",SwingConstants.CENTER));
			Battleship.getStats().add(Battleship.getData());				
			Battleship.setData(new JLabel("Names"));
			Battleship.getStats().add(Battleship.getData());
			if (Battleship.getYou() == 0)			
				resetStats(Battleship.getYou(),Battleship.getEnemy());			
			else 
				resetStats(Battleship.getEnemy(),Battleship.getYou());			
			Battleship.getStatistics().getContentPane().add(Battleship.getStats());
			Battleship.getStatistics().pack();
			Battleship.getStatistics().repaint();
		}				
	}	
			
	public static void resetStats(int x,int y)
	{
		Battleship.setData(new JLabel(Battleship.getPlayers(x).getUser(),SwingConstants.CENTER));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel(Battleship.getPlayers(y).getUser(),SwingConstants.CENTER));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel("Shots Taken"));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel(Integer.toString(Battleship.getPlayers(x).getShots()),SwingConstants.CENTER));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel(Integer.toString(Battleship.getPlayers(y).getShots()),SwingConstants.CENTER));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel("Hits"));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel(Integer.toString(Battleship.getPlayers(x).getHits()),SwingConstants.CENTER));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel(Integer.toString(Battleship.getPlayers(y).getHits()),SwingConstants.CENTER));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel("Shot Accuracy"));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel(Battleship.getPlayers(x).getAcc(),SwingConstants.CENTER));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel(Battleship.getPlayers(y).getAcc(),SwingConstants.CENTER));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel("Ships Left"));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel(Integer.toString(Battleship.getPlayers(x).getShipsLeft()),SwingConstants.CENTER));
		Battleship.getStats().add(Battleship.getData());
		Battleship.setData(new JLabel(Integer.toString(Battleship.getPlayers(y).getShipsLeft()),SwingConstants.CENTER));
		Battleship.getStats().add(Battleship.getData());	
	}
	
	public String getWhatShip(int x,int y)
	{
		return this.whatship[x][y];			
	}		
	
	public boolean getChit()
	{
		return this.chit;	
	}
	
	public void setChit(boolean x)
	{
		this.chit=x;	
	}
	
	public void setFC(int x)
	{
		this.fc=x;	
	}
	
	public void setFR(int x)
	{
		this.fr=x;	
	}
	
	public void setC(int x)
	{
		this.c=x;	
	}
	
	public void setR(int x)
	{
		this.r=x;	
	}
	
	public int getGo()
	{
		return this.go;	
	}		
	
	//sets direction for comp to look(2=anywhere,1=horizontal,0=vertical)
	public void setGo(int x)
	{
		this.go=x;	
	}	
	
	//returns column of first hit
	public int getFC()
	{
		return this.fc;	
	}		
	
	//column 
	public int getC()
	{
		return this.c;	
	}	
	
	//returns row of first hit
	public int getFR()
	{
		return this.fr;	
	}		
	
	//row 
	public int getR()
	{
		return this.r;	
	}		
	
	public void setLastShip(int x)
	{
		this.lastship=x;	
	}
	
	public int getLastShip()
	{
		return this.lastship;	
	}
	
	public int getShipsLeft()
	{
		return this.shipsleft;	
	}
	
	public void setShipsLeft()
	{
		this.shipsleft-=1;			
	}	
	
	public void setWhatShip(int x,int y,String u)
	{
		this.whatship[x][y]=u;			
	}	
	
	public void setMHS(int x,int y,int z)
	{
		this.mhs[x][y]=z;			
	}
		
	public int getMHS(int x, int y)
	{
		return this.mhs[x][y];				
	}	
	
	//method that determines if hit ship is sunk or not
	public boolean isSunk(int x, int y)
	{
		int f=0;			
		
		//finds which ship was sunk
		while (!this.boats[f].getName().equals(this.getWhatShip(x,y)))
			f++;
		this.boats[f].setHitsLeft();		
		if (this.boats[f].getHitsLeft()==0)
		{
			Battleship.getPlayers(Battleship.getEnemy()).setShipsLeft();
			if
			((Battleship.getPlayers(Battleship.getYou()).getUser().equals("Computer"))||(Battleship.getPlayers(Battleship.getYou()).getUser().equals("CPU1"))||(Battleship.getPlayers(Battleship.getYou()).getUser().equals("CPU2")))
			{	
				for (int k=0;k<10;k++)
					for (int m=0;m<10;m++)
						if
				(this.boats[f].getName().equals(this.getWhatShip(k
							,m)))
						{
							Battleship.getPlayers(Battleship.getYou()).setMHS(k,m,2);
							this.setBboard(k,m,Color.black);
						}
				Battleship.getPlayers(Battleship.getYou()).setGo(2);				
				Battleship.getPlayers(Battleship.getYou()).setChit(false);
				if ((!this.getUser().equals("CPU1"))
					&&(!this.getUser().equals("CPU2"))){
					
					String kl;
					
					
						
						//FIXME
						
					if(this.boats[f].getName().matches("Carrier")){
						
						kl = "You Lost $250";
						
						saveGame(-250);
						
					}else if(this.boats[f].getName().matches("Battleship")){
						
						kl = "You Lost $500";
						saveGame(-500);
						
					}else if(this.boats[f].getName().matches("Submarine")){
						
						kl = "You Lost $700";
						saveGame(-700);
						
					}else if(this.boats[f].getName().matches("Destroyer")){
						
						kl = "You Lost $700";
						saveGame(-700);
						
					}else if(this.boats[f].getName().matches("Patrol Boat")){
						
						kl = "You Lost $1000";
						saveGame(-1000);
						
					}else{
						
						kl = "You Lost";
						System.err.println("SOMETHING WENT WRONG");
						System.exit(0);
					} //TODO MAKE SMOOTHER GAMEPLAY
					
					JOptionPane.showMessageDialog(null,"You just lost your "+
					this.boats[f].getName()+"! \n"+kl,"Ship Destroyed",
					JOptionPane.WARNING_MESSAGE);
				
					
					
					
				
				}
			}
			else
			{
				String kl;
				if(this.boats[f].getName().matches("Carrier")){
					
					kl = "You Earned $350!";
					saveGame(350);
					
				}else if(this.boats[f].getName().matches("Battleship")){
					
					kl = "You Earned $600!";
					saveGame(600);
					
				}else if(this.boats[f].getName().matches("Submarine")){
					
					kl = "You Earned $800!";
					saveGame(800);
					
				}else if(this.boats[f].getName().matches("Destroyer")){
					
					kl = "You Earned $800!";
					saveGame(800);
					
				}else if(this.boats[f].getName().matches("Patrol Boat")){
					
					kl = "You Earned $1100!";
					saveGame(1100);
					
				}else{
					
					kl = "You Lost";
					System.err.println("SOMETHING WENT WRONG");
					System.exit(0);
				}
				
				JOptionPane.showMessageDialog(null,"You sank the "+ //TODO SAME AS ABOVE
				this.boats[f].getName()+"!\n"+kl,"Good Job!",
				JOptionPane.INFORMATION_MESSAGE);
				
				for (int k=0;k<10;k++)
					for (int m=0;m<10;m++)
						if(this.boats[f].getName().equals(this.getWhatShip(k
							,m)))
						{								
							this.setBboard(k,m,Color.black);
						}					
			}
			return true;
		}
		else
			return false;
	}
	
	//method that determines if hit ship is sunk or not
	public boolean isSunk(int x, int y, String z)
	{
		int f=0;			
		
		while (!z.equals(this.boats[f].getName()))
			f++;
		this.boats[f].setHitsLeft();
		System.out.println(z+":  "+this.boats[f].getHitsLeft());
		if (this.boats[f].getHitsLeft()==0)
		{
			this.setShipsLeft();
			JOptionPane.showMessageDialog(null,"You just lost your "+ //TODO SAMETHING
			this.boats[f].getName()+"!","Ship Destroyed",
					JOptionPane.WARNING_MESSAGE);
			for (int k=0;k<10;k++)
				for (int m=0;m<10;m++)
					if(z.equals(this.getWhatShip(k,m)))
						this.setBboard(k,m,Color.black);											
			return true;
		}
		else
			return false;
	}

	//sets hitormiss[x][y] to k 				
	public void setHitOrMiss (int x, int y, boolean k)
	{
		this.hitormiss[x][y]=k;
	}
			
	public boolean getHitOrMiss (int x, int y)
	{
		return this.hitormiss[x][y];
	}
			
	//checks if any of the surrounding points are plausible
	public boolean isSurrounded(int x, int y)
	{
		if (this.isPlausible(x+1,y))				
			return false;		
		else if (this.isPlausible(x-1,y))
			return false;				
		else if (this.isPlausible(x,y+1))
			return false;	
		else if (this.isPlausible(x,y-1))
			return false;	
		else 
			return true;
	}
	
	//checks if shot is possible and hasn't been tried before
	public boolean isPlausible(int x, int y)
	{
		if ((isValid(x,y))&&(this.getMHS(x,y)==3))
			return true;
		else
			return false;
	}
	
	//checks if selected position is a plausible location for the remaining	ships
	public boolean rshipsv(int x,int y)
	{
		int u=0;
		int g=0;
					
	if (((isValid(x+1,y))&&((Battleship.getPlayers(Battleship.getYou()).getMHS(x+1,y)==3)||
							(Battleship.getPlayers(Battleship.getYou()).getMHS(x+1,y)==1)))||
			((isValid(x-1,y))&&((Battleship.getPlayers(Battleship.getYou()).getMHS(x-1,y)==3)||
							(Battleship.getPlayers(Battleship.getYou()).getMHS(x-1,y)==1))))		
			u=0;			
		else
			u=5;			
		found:			
		while (u<5)				
		{
			g=0;						
			if (this.boats[u].getHitsLeft()!=0)
			{						
				daloop:
				for (xpos=(x-(this.boats[u].getLength()));xpos<(x+(this.boats[u].getLength()));xpos++)
				{							
					if ((isValid(xpos,y))&&((Battleship.getPlayers(Battleship.getYou()).getMHS(xpos,y)==3)||
						(Battleship.getPlayers(Battleship.getYou()).getMHS(xpos,y)==1)))
					{
						g+=1;
						if (g==(this.boats[u].getLength()))
								
							break daloop;					
					}	
					else	
						g=0;
				}						
				if (g==(this.boats[u].getLength()))
					break found;
				else
				{
					u++;
					if (u==5)
						g=0;
				}											
			}
			else
				u++;				
		}				
		if (u!=5)
		{						
			return true;			
		}			
		else			
			return false;			
	}
		
	//checks if selected position is a plausible location for the remaining	ships
	public boolean rshipsh(int x,int y)
	{
		int u=0;
		int g=0;
					
		if (((isValid(x,y+1))&&((Battleship.getPlayers(Battleship.getYou()).getMHS(x,y+1)==3)||
							(Battleship.getPlayers(Battleship.getYou()).getMHS(x,y+1)==1)))||
			((isValid(x,y-1))&&((Battleship.getPlayers(Battleship.getYou()).getMHS(x,y-1)==3)||
							(Battleship.getPlayers(Battleship.getYou()).getMHS(x,y-1)==1))))		
			u=0;			
		else
			u=5;			
		alright:
		while (u<5)
		{
			g=0;			
			if (this.boats[u].getHitsLeft()!=0) 
			{	
				daloop:
				for (xpos=(y-this.boats[u].getLength());xpos<(y+this.boats[u].getLength());xpos++)
				{												
					if ((isValid(x,xpos))&&((Battleship.getPlayers(Battleship.getYou()).getMHS(x,xpos)==3)||
						(Battleship.getPlayers(Battleship.getYou()).getMHS(x,xpos)==1)))
					{
						g+=1;
						if (g==this.boats[u].getLength())
							break daloop;
					}	
					else
						g=0;
				}						
				if (g==(this.boats[u].getLength()))
					break alright;
				else
				{
					u++;
					if (u==5)
						g=0;
				}										
			}
			else
				u++;				
		}			
		if (u!=5)					
		{						
			return true;			
		}		
		else			
			return false;			
	}		
	
	//checks if point (x,y) is valid		
	public boolean isValid(int x, int y)
	{			
		if ((x<0)||(y<0)||(x>9)||(y>9))
			return false;	
		else
			return true;		
	}

	
	//used by computer to scan area around last hit			
	public void scanArea(int x, int y)
	{
		if (this.getGo()==2)
		{
			if (this.isPlausible(x,y+1))
				{
					if (!Battleship.getPlayers(Battleship.getEnemy()).rshipsh(x,y+1))
					{	
						this.setMHS(x,y+1,0);
						this.scanArea(x,y);
						
					}								
					else
						this.fireShot(x,y+1,1);					
				}			
			else if (this.isPlausible(x+1,y))
				{
					if (!Battleship.getPlayers(Battleship.getEnemy()).rshipsv(x+1,y))
					{	
						this.setMHS(x+1,y,0);
						this.scanArea(x,y);
					}							
					else
						this.fireShot(x+1,y,0);									
				}
			else if (this.isPlausible(x,y-1))
				{						
					if (!Battleship.getPlayers(Battleship.getEnemy()).rshipsh(x,y-1))
					{	
						this.setMHS(x,y-1,0);
						this.scanArea(x,y);
					}						
					else
						this.fireShot(x,y-1,1);											
				}
			else if (this.isPlausible(x-1,y))
				{						
					if (!Battleship.getPlayers(Battleship.getEnemy()).rshipsv(x-1,y))
					{	
						this.setMHS(x-1,y,0);
						this.scanArea(x,y);
					}						
					else
						this.fireShot(x-1,y,0);					
				}
		}
		else if (this.getGo()==1)//means that ship is horizontal
		{
			if (this.getChit())
			{
				if (this.isPlausible(x,y+1))
					this.fireShot(x,y+1);
				else if (this.isPlausible(x,y-1))						
					this.fireShot(x,y-1);
				else if (this.isPlausible(x,this.getFC()+1))
					this.fireShot(x,this.getFC()+1);
				else if (this.isPlausible(x,this.getFC()-1))
					this.fireShot(x,this.getFC()-1);
				else
				{
					this.setGo(2);
					this.scanArea(this.getFR(),this.getFC());
				}					
			}
			else 
			{
				if (this.isPlausible(x,y+1))
					this.fireShot(x,y+1);
				else if (this.isPlausible(x,y-1))
				{
					this.fireShot(x,y-1);
					if (!this.getChit())
						this.setGo(2);			
				}
				else if (this.isPlausible(x,this.getFC()+1))
				{
					this.fireShot(x,this.getFC()+1);
					if (!this.getChit())
						this.setGo(2);			
				}
				else if (this.isPlausible(x,this.getFC()-1))
				{
					this.fireShot(x,this.getFC()-1);
					if (!this.getChit())
						this.setGo(2);							
				}
				else
				{
					this.setGo(2);
					this.scanArea(this.getFR(),this.getFC());
				}						
			}
		}
		else if (go==0) //means that ship is vertical
		{
			if (this.getChit())
			{
				if (this.isPlausible(x+1,y))
					this.fireShot(x+1,y);					
				else if (this.isPlausible(x-1,y))
					this.fireShot(x-1,y);					
				else if (this.isPlausible(this.getFR()+1,y))						
					this.fireShot(this.getFR()+1,y);					
				else if (this.isPlausible(this.getFR()-1,y))						
					this.fireShot(this.getFR()-1,y);					
				else
				{
					this.setGo(2);
					this.scanArea(this.getFR(),this.getFC());
				}
			}
			else
			{
				if (this.isPlausible(x+1,y))
					this.fireShot(x+1,y);				
				else if (this.isPlausible(x-1,y))
				{
					this.fireShot(x-1,y);	
					if (!this.getChit())
						this.setGo(2);					
				}
				else if (this.isPlausible(this.getFR()+1,y))						
				{
					this.fireShot(this.getFR()+1,y);	
					if (!this.getChit())
						this.setGo(2);								
				}
				else if (this.isPlausible(this.getFR()-1,y))	
				{
					this.fireShot(this.getFR()-1,y);	
					if (!this.getChit())
						this.setGo(2);			
				}
				else
				{
					this.setGo(2);
					this.scanArea(this.getFR(),this.getFC());
				}
			}
		}
	}
	/**
	 * z is the orrientation of the ship also ONLY used be the computer. (0=VERTICAL, 1=HORIZONTAL)
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	private void fireShot(int x, int y, int z)
	{
		this.takeShot(x,y);
		if (this.getChit())
		{
			this.setGo(z);
			this.setR(x);   //used by the computer
			this.setC(y);							
		}	
	}
	/**
	 * this method is ONLY used by the computer for testing ship hits
	 * 
	 * @param x
	 * @param y
	 */
	private void fireShot(int x, int y)
	{
		this.takeShot(x,y);
		if (this.getChit())
		{			
			this.setR(x);
			this.setC(y);							
		}	
	}

	/**
	 * Takes a shot at the specified (x,y) coord.
	 * 	
	 * @param x - xpos of guess
	 * @param y - ypos of Guess.
	 */
	public void takeShot(int x,int y)//takes a shot and tests for hit or miss.
	{				
		this.setShots();
		
		if (Battleship.getPlayers(Battleship.getEnemy()).getHitOrMiss(x,y))
		{
			this.setHits();
			if (!Battleship.getPlayers(Battleship.getEnemy()).isSunk(x,y))
			{
				Battleship.getPlayers(Battleship.getEnemy()).setBboard(x,y,Color.red);
				if ((this.getUser().equals("Computer"))||(this.getUser().equals("CPU1"))||(this.getUser().equals("CPU2")))//if its a computer
				{	/*this is for the computer to track his moves based on wether it was a hit or miss. hits will cause
				him to scan the area around the hit and take a random guess (in easy mode)*/
					this.setMHS(x,y,1);
					this.setChit(true);
				}										
			}											
		}
		else	
		{	
			Battleship.getPlayers(Battleship.getEnemy()).setBboard(x,y,Color.blue);
			if ((this.getUser().equals("Computer"))||(this.getUser().equals("CPU1"))||(this.getUser().equals("CPU2")))
			{	
				this.setMHS(x,y,0);
				this.setChit(false);
			}
		}					
	}		
	/**
	 * When its your turn this method evaluates whether the shot you took is a HIT or a MISS.
	 * as well as check for powerup use.
	 * 
	 * @param v
	 */
	public void humanAttack(ActionEvent v) //TODO PLAYERS TURN
	{
		if (this.getMove())
		{				
			Object source = v.getSource();
			outer:						
			for (xpos=0;xpos<10;xpos++)
			{				
				for (ypos=0;ypos<10;ypos++)
				{					
					if (source==Battleship.getPlayers(Battleship.getEnemy()).getBboard(xpos,ypos))
					{								
						if ((Battleship.getPlayers(Battleship.getEnemy()).getBboard(xpos,ypos).getBackground()==Color.black)||
							(Battleship.getPlayers(Battleship.getEnemy()).getBboard(xpos,ypos).getBackground()==Color.red)||
							(Battleship.getPlayers(Battleship.getEnemy()).getBboard(xpos,ypos).getBackground()==Color.blue))
						{
							JOptionPane.showMessageDialog(null,"You tri"
							+"ed that spot already.","Wasted Shot",
							JOptionPane.ERROR_MESSAGE);								
						}
						else{ //TODO ITEM LOGIC
							
							if(BombListener.isUsing()){
								//- = up/left + = down/right
								int posx = xpos-1;
								int posy = ypos-1;
								this.takeShot(xpos, ypos); 
								if(this.isValid(posx, posy)){
								this.takeShot(posx, posy);
								}
								posy++;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posy++;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posx++;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posx++;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posy--;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posy--;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posx--;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posy--;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posx--;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posx--;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posy++;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posy++;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posy++;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posy++;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posx++;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posx++;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posx++;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posx++;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posy--;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posy--;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posy--;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posy--;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								posx--;
								if(this.isValid(posx, posy)){
									this.takeShot(posx, posy);
									}
								BombListener.setUsed(false);
							}
							
							if(CrossListener.isUsing()){
								
								int xp=xpos,yp=ypos;
								
								this.takeShot(xpos, ypos);
								for(;;){
									yp--;
									if(this.isValid(xp, yp)){
										this.takeShot(xp, yp);
									}else{
										
										break;
										
									}
									
									
									
								}
								xp = xpos;
								yp = ypos;
								for(;;){
									
									yp++;
									if(this.isValid(xp, yp)){
										this.takeShot(xp, yp);
									}else{
										
										break;
										
									}
									
								}
								xp = xpos;
								yp = ypos;
								for(;;){
									
									xp--;
									if(this.isValid(xp, yp)){
										this.takeShot(xp, yp);
									}else{
										
										break;
										
									}
									
								}
								xp = xpos;
								yp = ypos;
								for(;;){
									
									xp++;
									if(this.isValid(xp, yp)){
										this.takeShot(xp, yp);
									}else{
										
										break;
										
									}
									
								}
								
								CrossListener.setUsed(false);
								
								
							}
							
							
							
							if(FragListener.isUsing()){
								
								for(int c=0;c<=8;c++){
									 
									this.takeShot(rf.nextInt(9), rf.nextInt(9));
									
								}
								
								FragListener.setUsed(false);  
								
							}
							
							
							
							if(NukeListener.getUsing()){ //Logic for Nuke
								//TODO move this into itself
								for(int x=0;x<10;x++){
									for(int y=0;y<10;y++){
										
										if(Battleship.getPlayers(Battleship.getEnemy()).getHitOrMiss(x,y)){
											
											this.takeShot(x,y);  
											
										}
										
									}
									
								}
								
								NukeListener.setUsing(false);
								
							}
												
							
							/**
							 * This will randomly choose whether to go vertically or horizontally and also 
							 * whether to go backward or forward.
							 */
							
					
							if(TorpedoListener.getUsing()){ //past this is the logic for if you use a torpedo.
								int ii,jj;
								ii = xpos;
								jj = ypos;
								boolean bkOrFwd = rf.nextBoolean();
								boolean disable = false; //randomly choose backward or forward false = always FORWARD true = RANDOM DIR
								
								if(rf.nextBoolean()){
									System.out.println("ii chosen");
									for(;;){
										
										
										this.takeShot(xpos,ypos);	
									if(bkOrFwd && !disable){
										ii++;
									}else{
										ii--;
									}
										if(this.isValid(ii, ypos)){
											
											if(Battleship.getPlayers(Battleship.getEnemy()).getBboard(ii,ypos).getBackground()==Color.black){ 
												
												TorpedoListener.setUsing(false);
												break;
												
											}else{
												
												this.takeShot(ii, ypos);  
												
											}
											
										
										}else{
											break;
										}
										
									}
									
								}else{
									System.out.println("jj chosen");
									for(;;){
										
										
										this.takeShot(xpos,ypos);
										if(bkOrFwd && !disable){
											jj++;
										}else{
											jj--;
										}
										
										if(this.isValid(xpos, jj)){
											
											if(Battleship.getPlayers(Battleship.getEnemy()).getBboard(xpos,jj).getBackground()==Color.black){ 
												
												TorpedoListener.setUsing(false);
												break;
												
											}else{
												
												this.takeShot(xpos, jj);  
												
											}
											
										
										}else{
											break;
										}
										
									}
									
									
								}
								
								
							}else if(SFListener.isUsing()){ //Logic for Ship Finder
								
								
								
								int pos;
								int pos2;
								
									for(;;){
										
										pos =rf.nextInt(9); //pick random x and y coords and detrmine if its a hit. if it is, mark it with green
										pos2 =rf.nextInt(9);
										
										if(Battleship.getPlayers(Battleship.getEnemy()).getHitOrMiss(pos,pos2) && Battleship.getPlayers(Battleship.getEnemy()).getBboard(pos,pos2).getBackground() != Color.black){
											
											
											
											Battleship.getPlayers(Battleship.getEnemy()).setBboard(pos,pos2,Color.GREEN); 
											break;
											
											
										}
										
									}
									
								
								
								
								
								SFListener.setUsing(false);
								
								
								
							}
							
							
							
							else{ //if not using any powerups just do a normal shot
								
								this.takeShot(xpos,ypos);	
								
							}
							
							
							
							
						}						
						break outer;						
					}
					else if (source==this.getBboard(xpos,ypos))
					{
						if(TorpedoListener.getUsing() == false){
						JOptionPane.showMessageDialog(null,"You are not suppose"
						+"d to fire on your own board!","Lost Turn",
						JOptionPane.WARNING_MESSAGE);
						break outer;
						}else{
							
							JOptionPane.showMessageDialog(null,"You are not suppose"
									+"d to fire on your own board! You got your Torpedo Back.","Lost Turn",
									JOptionPane.WARNING_MESSAGE);
							try {
								saveGame("Torpedo",true);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}						
				}
			}
			
			if ((xpos==10)&&(ypos==10))
				JOptionPane.showMessageDialog(null,"You took too long!",
				"Lost Turn",JOptionPane.INFORMATION_MESSAGE);				
			Player.isStatsOpen();
			this.setMove(false);
			this.getTimer().stop();				
			if (Battleship.getPlayers(Battleship.getEnemy()).getShipsLeft()!=0)
			{						
				if (!Battleship.getPlayers(Battleship.getEnemy()).getUser().equals("Computer")) //TODO test for confusion ray.
					Battleship.getPlayers(Battleship.getEnemy()).setMove(true);					
				Battleship.getPlayers(Battleship.getEnemy()).getTimer().start();
				Battleship.flipYou();
			}
			else
			{
				if (Battleship.getPlayers(Battleship.getEnemy()).getUser().equals("Computer"))//change once
					//menu options work
				{
					JOptionPane.showMessageDialog(null,"YOU WON!",
					"It's A Celebration!",JOptionPane.INFORMATION_MESSAGE);
					if (this.getUser().equals("Stupid"))
						JOptionPane.showMessageDialog(null,"Maybe you're no"
						+"t that stupid after all!","",JOptionPane.INFORMATION_MESSAGE);
					saveGame(1200);
					Battleship.allowedItems = true; //TODO ad evrrywhere else
				}
				else
				{
					JOptionPane.showMessageDialog(null,
					this.getUser()+" won!!!","It's A Celebration"
					+"!",JOptionPane.INFORMATION_MESSAGE);
					if (this.getUser().equals("Stupid"))
						JOptionPane.showMessageDialog(null,"Maybe you're no"
						+"t that stupid after all!","",JOptionPane.INFORMATION_MESSAGE);
					saveGame(1200);
				}						
			}									
		}						
	}
	//Listener for the buttons on the board	while playing game		
	public class CompAttack implements ActionListener
	{	
		public void actionPerformed(ActionEvent v)
		{				
			Battleship.getPlayers(Battleship.getYou()).compattack();			
		}
	}
	
	public void compattack()//FIXME confusion ray dont work
	{	
		TorpedoListener.setUsing(false);
		RayListener.setUsed(false);
		NukeListener.setUsing(false);
		SFListener.setUsing(false);
		FragListener.setUsed(false); 
		BombListener.setUsed(false);
		CrossListener.setUsed(false);
//		if(RayListener.isUsed()){
//			
//			this.setMove(true);
//			Battleship.getPlayers(Battleship.getEnemy()).setMove(false);
//			RayListener.setUsed(false);
//			
//		}
		
		if (this.getChit())
			this.scanArea(this.getR(),this.getC());					
		else
		{
			if (this.getGo()!=2)
				this.scanArea(this.getFR(),this.getFC());			
			else
			{
				blah:
				for (xpos=0;xpos<10;xpos++)
				{
					for (ypos=0;ypos<10;ypos++)
						if (this.getMHS(xpos,ypos)==1)
						{
							if (this.getMHS(this.getFR(),this.getFC())==2)
							{
								if ((this.isPlausible(xpos+1,ypos))||(this.isPlausible(xpos,ypos+1))
								||(this.isPlausible(xpos-1,ypos))||(this.isPlausible(xpos,ypos-1)))
								{
									this.scanArea(xpos,ypos);
									this.setFR(xpos);
									this.setFC(ypos);										
									break blah;
								}
							}
							else 
							{
								this.scanArea(this.getFR(),this.getFC());									
								break blah;																		
							}								
						}
				}
				if (xpos==10)
				{							
					do
					{									
						for (xpos=0;xpos<10;xpos++)
						{
							for (ypos=0;ypos<10;ypos++)
								if (this.getMHS(xpos,ypos)==3)
								{										
									rows.add(new Integer(xpos));
									break;
								}
						}									
						do
						{
							r=(int)(Math.random()*10);
						}
						while(r>=rows.size());												
						r=((Integer)rows.elementAt(r)).intValue();						
						for (xpos=0;xpos<10;xpos++)
						{
							if (this.getMHS(r,xpos)==3)
								cols.add(new Integer(xpos));														
						}											
						do
						{
							c=(int)(Math.random()*10);
						}
						while(c>=cols.size());											
						c=((Integer)cols.elementAt(c)).intValue();										
						if (this.isSurrounded(r,c))							
							this.setMHS(r,c,0);							
						else if ((!Battleship.getPlayers(Battleship.getEnemy()).rshipsh(r,c))
							&&(!Battleship.getPlayers(Battleship.getEnemy()).rshipsv(r,c)))
						{							
							this.setMHS(r,c,0);
						}															
						else if ((Battleship.getPlayers(Battleship.getEnemy()).getShipsLeft()==1)
							&&(this.getLastShip()==0)) //LEL
						{								
							for (int i=0;i<5;i++)
								if (Battleship.getPlayers(Battleship.getEnemy()).boats[i].getHitsLeft()!=0)
									this.setLastShip(Battleship.getPlayers(Battleship.getEnemy()).boats[i].getLength());								
						}							
						rows.clear();
						cols.clear();
					}
					while(this.getMHS(r,c)!=3);						
					this.takeShot(r,c);
					if (this.getChit())
					{	
						this.setFR(r);	
						this.setFC(c);
					}					
				}
			}
		}
		isStatsOpen();
		this.getTimer().stop();
		if (Battleship.getPlayers(Battleship.getEnemy()).getShipsLeft()>0)
		{
			if ((!Battleship.getPlayers(Battleship.getEnemy()).getUser().equals("CPU1"))
				&&(!this.getUser().equals("CPU2")))
				Battleship.getPlayers(Battleship.getEnemy()).setMove(true);	
			Battleship.getPlayers(Battleship.getEnemy()).getTimer().start();
			Battleship.flipYou();
		}
		else
		{
			if (this.getUser().equals("Computer"))
			{
				JOptionPane.showMessageDialog(null,"You Lost! You Paid $700 to a Computer?? WTF??","Sorry!",//TODO add cash update
				JOptionPane.INFORMATION_MESSAGE);
				saveGame(-700);
				if (Battleship.getPlayers(Battleship.getEnemy()).getUser().equals("Stupid"))
					JOptionPane.showMessageDialog(null,"Stupid!","Sorry!",
					JOptionPane.INFORMATION_MESSAGE);
				for (xpos=0;xpos<10;xpos++)
				{
					for (ypos=0;ypos<10;ypos++)
					{
						if ((!this.getWhatShip(xpos,ypos).equals(" "))
							&&(((this.getBboard(xpos,ypos
						).getBackground())!=Color.black)&&
									((this.getBboard(xpos,ypos
								).getBackground())!=Color.red)))							
							{
								this.setBboard(xpos,ypos,Battleship.getColor());
							}
					}
				}									
			}
			else{
				JOptionPane.showMessageDialog(null,this.getUser()+
				" WON!!! AND EARNED $1200","It's A Celebration!",JOptionPane.INFORMATION_MESSAGE);	
				
				saveGame(1200);
			}
			
		}					
	}	
	
	/**
	 * Updates AMT of cash remaining
	 * 
	 * @param cash
	 */
	public static void saveGame(int cash){
		int temp = 0;
		try {
			temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(0)));
			temp += cash;
			Battleship.udata.set(0,Battleship.en.encrypt(Integer.toString(temp)));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Battleship.write(Battleship.udata, Battleship.userData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
/**
 * Saves the game USED FOR THE SHOP
 * 	
 * @param cash - amt to add to current balance
 * @param itemID - item id ex.("Nuke")
 * @param quantity - quantity to add to it
 * @throws Exception - something
 */
public static void saveGame(int cash, String itemID,int quantity)throws Exception{
		
	int temp = 0;
	int tempo = 0;
		try {
			tempo = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(0)));
			tempo += cash;
			if(tempo < 0){
				
				tempo = 0;
				
			}
			Battleship.udata.set(0,Battleship.en.encrypt(Integer.toString(tempo)));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
			if(itemID.matches("Nuke")){
				
				temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(NUKE)));
				temp += quantity;
				Battleship.udata.set(NUKE,Battleship.en.encrypt(Integer.toString(temp)));
				
			}else if(itemID.matches("Confusion Ray")){
				
				temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(CONF)));
				temp += quantity;
				Battleship.udata.set(CONF,Battleship.en.encrypt(Integer.toString(temp)));
				
			}else if(itemID.matches("Ship Finder")){
				
				temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(SF)));
				temp += quantity;
				Battleship.udata.set(SF,Battleship.en.encrypt(Integer.toString(temp)));
				
			}else if(itemID.matches("Torpedo")){
				
				temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(TOR)));
				temp += quantity;
				Battleship.udata.set(TOR,Battleship.en.encrypt(Integer.toString(temp)));
				
				
			}else if(itemID.matches("Frag Bomb")){
				
				temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(FRAG)));
				temp += quantity;
				Battleship.udata.set(FRAG,Battleship.en.encrypt(Integer.toString(temp)));
				
			}else if(itemID.matches("Cross Fire")){
			
				temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(CROSS)));
				temp += quantity;
				Battleship.udata.set(CROSS,Battleship.en.encrypt(Integer.toString(temp)));
			
			}else if(itemID.matches("Bomb")){
			
				temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(BOMB)));
				temp += quantity;
				Battleship.udata.set(BOMB,Battleship.en.encrypt(Integer.toString(temp)));
				
			}else{
				
				System.err.println("ERROR SAVING!");
				
			}
			
			
			try {
				Battleship.write(Battleship.udata, Battleship.userData);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try{
				Battleship.inv.removeAll();
				Battleship.mEN = new JMenuItem("Nukes: "+Battleship.en.decrypt(Battleship.udata.get(NUKE)));		
				Battleship.inv.add(Battleship.mEN);
				Battleship.mEN.addActionListener(new NukeListener());  
				if(Battleship.en.decrypt(Battleship.udata.get(NUKE)).matches("0")){
					Battleship.mEN.setEnabled(false);  
				}else{
					Battleship.mEN.setEnabled(true); 
				}
				Battleship.mEN = new JMenuItem("Confusion Rays: "+Battleship.en.decrypt(Battleship.udata.get(CONF)));		
				Battleship.inv.add(Battleship.mEN);
				Battleship.mEN.addActionListener(new RayListener());
				if(Battleship.en.decrypt(Battleship.udata.get(CONF)).matches("0")){
					Battleship.mEN.setEnabled(false);  
				}else{
					Battleship.mEN.setEnabled(true); 
				}
				Battleship.mEN = new JMenuItem("Ship Finders: "+Battleship.en.decrypt(Battleship.udata.get(SF)));		
				Battleship.inv.add(Battleship.mEN);
				Battleship.mEN.addActionListener(new SFListener());
				if(Battleship.en.decrypt(Battleship.udata.get(SF)).matches("0")){
					Battleship.mEN.setEnabled(false);  
				}else{
					Battleship.mEN.setEnabled(true); 
				}
				Battleship.mEN = new JMenuItem("Torpedoes: "+Battleship.en.decrypt(Battleship.udata.get(TOR)));		
				Battleship.inv.add(Battleship.mEN);
				Battleship.mEN.addActionListener(new TorpedoListener());
				if(Battleship.en.decrypt(Battleship.udata.get(TOR)).matches("0")){
					Battleship.mEN.setEnabled(false);  
				}else{
					Battleship.mEN.setEnabled(true); 
				}
				Battleship.mEN = new JMenuItem("Frag Bombs: "+Battleship.en.decrypt(Battleship.udata.get(FRAG)));		
				Battleship.inv.add(Battleship.mEN);
				Battleship.mEN.addActionListener(new FragListener());
				if(Battleship.en.decrypt(Battleship.udata.get(FRAG)).matches("0")){
					Battleship.mEN.setEnabled(false);  
				}else{
					Battleship.mEN.setEnabled(true); 
				}
				Battleship.mEN = new JMenuItem("Cross Fire: "+Battleship.en.decrypt(Battleship.udata.get(CROSS)));		
				Battleship.inv.add(Battleship.mEN);
				Battleship.mEN.addActionListener(new CrossListener());
				if(Battleship.en.decrypt(Battleship.udata.get(CROSS)).matches("0")){
					Battleship.mEN.setEnabled(false);  
				}else{
					Battleship.mEN.setEnabled(true); 
				}
				Battleship.mEN = new JMenuItem("Bombs: "+Battleship.en.decrypt(Battleship.udata.get(BOMB)));		
				Battleship.inv.add(Battleship.mEN);
				Battleship.mEN.addActionListener(new BombListener());
				if(Battleship.en.decrypt(Battleship.udata.get(BOMB)).matches("0")){
					Battleship.mEN.setEnabled(false);  
				}else{
					Battleship.mEN.setEnabled(true); 
				}
				}catch(Exception e){
					
					e.printStackTrace();
					
				}
		
		
		
	}

/**
 * Saves the game and Adds/Subtracts items
 * 
 * @param itemID - itemID String "Nuke"
 * @param mode - False is subtract and True is add.
 * @throws Exception
 * @return boolean - whether you had enogh money or not.
 */

public static boolean saveGame(String itemID,boolean mode)throws Exception{
	
	int temp = 0;
	
	if(!Battleship.getCheat(0)){
	
	if(mode == true){
		
		if(itemID.matches("Nuke")){
			
			temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(NUKE)));
			
			temp++;
			Battleship.udata.set(NUKE,Battleship.en.encrypt(Integer.toString(temp)));
			
		}else if(itemID.matches("Confusion Ray")){
			
			temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(CONF)));
			
			temp++;
			Battleship.udata.set(CONF,Battleship.en.encrypt(Integer.toString(temp)));
			
		}else if(itemID.matches("Ship Finder")){
			
			temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(SF)));
			
			temp++;
			Battleship.udata.set(SF,Battleship.en.encrypt(Integer.toString(temp)));
			
		}else if(itemID.matches("Torpedo")){
			
			temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(TOR)));
			
			temp++;
			Battleship.udata.set(TOR,Battleship.en.encrypt(Integer.toString(temp)));
			
			
		}else if(itemID.matches("Frag Bomb")){
			
			temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(FRAG)));
			
			temp++;
			Battleship.udata.set(FRAG,Battleship.en.encrypt(Integer.toString(temp)));
			
		}else if(itemID.matches("Cross Fire")){
		
			temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(CROSS)));
			
			temp++;
			Battleship.udata.set(CROSS,Battleship.en.encrypt(Integer.toString(temp)));
			
		}else if(itemID.matches("Bomb")){
			
temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(BOMB)));
			
			temp++;
			Battleship.udata.set(BOMB,Battleship.en.encrypt(Integer.toString(temp)));
			
		}else{
			
			System.err.println("ERROR SAVING!");
			
		}
		
		
		try {
			Battleship.write(Battleship.udata, Battleship.userData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			Battleship.inv.removeAll();
			Battleship.mEN = new JMenuItem("Nukes: "+Battleship.en.decrypt(Battleship.udata.get(NUKE)));		
			Battleship.inv.add(Battleship.mEN);
			Battleship.mEN.addActionListener(new NukeListener());  
			if(Battleship.en.decrypt(Battleship.udata.get(NUKE)).matches("0")){
				Battleship.mEN.setEnabled(false);  
			}else{
				Battleship.mEN.setEnabled(true); 
			}
			
			Battleship.mEN = new JMenuItem("Confusion Rays: "+Battleship.en.decrypt(Battleship.udata.get(CONF)));		
			Battleship.inv.add(Battleship.mEN);
			Battleship.mEN.addActionListener(new RayListener());
			if(Battleship.en.decrypt(Battleship.udata.get(CONF)).matches("0")){
				Battleship.mEN.setEnabled(false);  
			}else{
				Battleship.mEN.setEnabled(true); 
			}
			Battleship.mEN = new JMenuItem("Ship Finders: "+Battleship.en.decrypt(Battleship.udata.get(SF)));		
			Battleship.inv.add(Battleship.mEN);
			Battleship.mEN.addActionListener(new SFListener());
			if(Battleship.en.decrypt(Battleship.udata.get(SF)).matches("0")){
				Battleship.mEN.setEnabled(false);  
			}else{
				Battleship.mEN.setEnabled(true); 
			}
			Battleship.mEN = new JMenuItem("Torpedoes: "+Battleship.en.decrypt(Battleship.udata.get(TOR)));		
			Battleship.inv.add(Battleship.mEN);
			Battleship.mEN.addActionListener(new TorpedoListener());
			if(Battleship.en.decrypt(Battleship.udata.get(TOR)).matches("0")){
				Battleship.mEN.setEnabled(false);  
			}else{
				Battleship.mEN.setEnabled(true); 
			}
			Battleship.mEN = new JMenuItem("Frag Bombs: "+Battleship.en.decrypt(Battleship.udata.get(FRAG)));		
			Battleship.inv.add(Battleship.mEN);
			Battleship.mEN.addActionListener(new FragListener());
			if(Battleship.en.decrypt(Battleship.udata.get(FRAG)).matches("0")){
				Battleship.mEN.setEnabled(false);  
			}else{
				Battleship.mEN.setEnabled(true); 
			}
			Battleship.mEN = new JMenuItem("Cross Fires: "+Battleship.en.decrypt(Battleship.udata.get(CROSS)));		
			Battleship.inv.add(Battleship.mEN);
			Battleship.mEN.addActionListener(new CrossListener());
			if(Battleship.en.decrypt(Battleship.udata.get(CROSS)).matches("0")){
				Battleship.mEN.setEnabled(false);  
			}else{
				Battleship.mEN.setEnabled(true); 
			}
			Battleship.mEN = new JMenuItem("Bombs: "+Battleship.en.decrypt(Battleship.udata.get(BOMB)));		
			Battleship.inv.add(Battleship.mEN);
			Battleship.mEN.addActionListener(new BombListener());
			if(Battleship.en.decrypt(Battleship.udata.get(BOMB)).matches("0")){
				Battleship.mEN.setEnabled(false);  
			}else{
				Battleship.mEN.setEnabled(true); 
			}
			}catch(Exception e){
				
				e.printStackTrace();
				
			}
		return true;
		
	}else{
	
	if(itemID.matches("Nuke")){
		
		temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(NUKE)));
		if(temp == 0){
			JOptionPane.showMessageDialog(null, "You Don\'t have any!", "No Item", JOptionPane.ERROR_MESSAGE);  
			return false;
		}
		temp--;
		Battleship.udata.set(NUKE,Battleship.en.encrypt(Integer.toString(temp)));
		
	}else if(itemID.matches("Confusion Ray")){
		
		temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(CONF)));
		if(temp == 0){
			JOptionPane.showMessageDialog(null, "You Don\'t have any!", "No Item", JOptionPane.ERROR_MESSAGE);  
			return false;
		}
		temp--;
		Battleship.udata.set(CONF,Battleship.en.encrypt(Integer.toString(temp)));
		
	}else if(itemID.matches("Ship Finder")){
		
		temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(SF)));
		if(temp == 0){
			JOptionPane.showMessageDialog(null, "You Don\'t have any!", "No Item", JOptionPane.ERROR_MESSAGE);  
			return false;
		}
		temp--;
		Battleship.udata.set(SF,Battleship.en.encrypt(Integer.toString(temp)));
		
	}else if(itemID.matches("Torpedo")){
		
		temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(TOR)));
		if(temp == 0){
			JOptionPane.showMessageDialog(null, "You Don\'t have any!", "No Item", JOptionPane.ERROR_MESSAGE);  
			return false;
		}
		temp--;
		Battleship.udata.set(TOR,Battleship.en.encrypt(Integer.toString(temp)));
		
		
	}else if(itemID.matches("Frag Bomb")){
		
		temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(FRAG)));
		if(temp == 0){
			JOptionPane.showMessageDialog(null, "You Don\'t have any!", "No Item", JOptionPane.ERROR_MESSAGE); 
			return false;
		}
		temp--;
		Battleship.udata.set(FRAG,Battleship.en.encrypt(Integer.toString(temp)));
		
	}else if(itemID.matches("Cross Fire")){
	
		temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(CROSS)));
		if(temp == 0){
			JOptionPane.showMessageDialog(null, "You Don\'t have any!", "No Item", JOptionPane.ERROR_MESSAGE); 
			return false;
		}
		temp--;
		Battleship.udata.set(CROSS,Battleship.en.encrypt(Integer.toString(temp)));
		
	}else if(itemID.matches("Bomb")){
	
		temp = Integer.parseInt(Battleship.en.decrypt(Battleship.udata.get(BOMB)));
		if(temp == 0){
			JOptionPane.showMessageDialog(null, "You Don\'t have any!", "No Item", JOptionPane.ERROR_MESSAGE); 
			return false;
		}
		temp--;
		Battleship.udata.set(BOMB,Battleship.en.encrypt(Integer.toString(temp)));
		
	}else{
		
		System.err.println("ERROR SAVING!");
		return false;
	}
	
	
	try {
		Battleship.write(Battleship.udata, Battleship.userData);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try{
		Battleship.inv.removeAll();
		Battleship.mEN = new JMenuItem("Nukes: "+Battleship.en.decrypt(Battleship.udata.get(NUKE)));		
		Battleship.inv.add(Battleship.mEN);
		Battleship.mEN.addActionListener(new NukeListener());  
		if(Battleship.en.decrypt(Battleship.udata.get(NUKE)).matches("0")){
			Battleship.mEN.setEnabled(false);  
		}else{
			Battleship.mEN.setEnabled(true); 
		}
		Battleship.mEN = new JMenuItem("Confusion Rays: "+Battleship.en.decrypt(Battleship.udata.get(CONF)));		
		Battleship.inv.add(Battleship.mEN);
		Battleship.mEN.addActionListener(new RayListener());
		if(Battleship.en.decrypt(Battleship.udata.get(CONF)).matches("0")){
			Battleship.mEN.setEnabled(false);  
		}else{
			Battleship.mEN.setEnabled(true); 
		}
		Battleship.mEN = new JMenuItem("Ship Finders: "+Battleship.en.decrypt(Battleship.udata.get(SF)));		
		Battleship.inv.add(Battleship.mEN);
		Battleship.mEN.addActionListener(new SFListener());
		if(Battleship.en.decrypt(Battleship.udata.get(SF)).matches("0")){
			Battleship.mEN.setEnabled(false);  
		}else{
			Battleship.mEN.setEnabled(true); 
		}
		Battleship.mEN = new JMenuItem("Torpedoes: "+Battleship.en.decrypt(Battleship.udata.get(TOR)));		
		Battleship.inv.add(Battleship.mEN);
		Battleship.mEN.addActionListener(new TorpedoListener());
		if(Battleship.en.decrypt(Battleship.udata.get(TOR)).matches("0")){
			Battleship.mEN.setEnabled(false);  
		}else{
			Battleship.mEN.setEnabled(true); 
		}
		Battleship.mEN = new JMenuItem("Frag Bombs: "+Battleship.en.decrypt(Battleship.udata.get(FRAG)));		
		Battleship.inv.add(Battleship.mEN);
		Battleship.mEN.addActionListener(new FragListener());
		if(Battleship.en.decrypt(Battleship.udata.get(FRAG)).matches("0")){
			Battleship.mEN.setEnabled(false);  
		}else{
			Battleship.mEN.setEnabled(true); 
		}
		Battleship.mEN = new JMenuItem("Cross Fires: "+Battleship.en.decrypt(Battleship.udata.get(CROSS)));		
		Battleship.inv.add(Battleship.mEN);
		Battleship.mEN.addActionListener(new CrossListener());
		if(Battleship.en.decrypt(Battleship.udata.get(CROSS)).matches("0")){
			Battleship.mEN.setEnabled(false);  
		}else{
			Battleship.mEN.setEnabled(true); 
		}
		Battleship.mEN = new JMenuItem("Bombs: "+Battleship.en.decrypt(Battleship.udata.get(BOMB)));		
		Battleship.inv.add(Battleship.mEN);
		Battleship.mEN.addActionListener(new BombListener());
		if(Battleship.en.decrypt(Battleship.udata.get(BOMB)).matches("0")){
			Battleship.mEN.setEnabled(false);  
		}else{
			Battleship.mEN.setEnabled(true); 
		}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	return true;
	}
	
	}else{
		return true;
	}
	
}


	
}
