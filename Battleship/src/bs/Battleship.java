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
import javax.swing.border.*;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;




import java.io.*;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Scanner;


public class Battleship extends JFrame
{		
	/**
	 * v3.4 : Bug fixes
	 * v4.0 : Smoother game play by removing the dialogs if a ship is sunk instead a little disappearing text box
	 * will show the update rather than a interruptive dialog.
	 * v4.x : ~~BUG FIX UPDATE~~	
	 * v5.0 : New volley and classic game mode both of which don't involve power ups but do involve money which CAN be used in standard mode.
	 * v5.x : ~~BUG FIX UPDATE~~
	 * v6.0 : Multi-User update allows for more people to store data on the same account. previous data will be deleted
	 * v6.x : ~~BUG FIX UPDATE~~
	 */
	private static final long serialVersionUID = 1L;
	private static JButton ok = new JButton("OK"),//closes stats menu
						   done =new JButton("Done");//closes options menu
	private static JFrame statistics= new JFrame("Statistics"),//holds stats
						  options=new JFrame("Options");//holds opts
	private static JLabel data,//used for stats menu
						  title;//used for options menu
	private static JPanel stats=new JPanel(),//used for stats menu
						  opts,//used for options menu
						  inputpanel;//for manually inputting ships
	private static Container b,c,d;//board and input panel 
	private static final int NUKE = 2;
	private static final int CONF = 4;
	private static final int SF = 6;
	public static boolean allowedItems = false;
	private static final int TOR = 8;
	private static final int FRAG = 10;
	private static final int CROSS = 12;
	private static final int BOMB = 14;
	private static final int NAME = 15;
	private static boolean INFINITE_ITEMS; 
	private static boolean INFINITE_CASH;
	private static String LOOKANDFEEL,THEME;
	public static int cash;
	public static JButton nuke,conf,sf,tor,frag,cros,bom,cancel;
	public static JLabel display = new JLabel("Mouse Over the Products to See Info on them!");
	public static JPanel pane2 = new JPanel();
	private static JPanel com;
	private static JLabel many;
	public static JComboBox<Integer> amt = new JComboBox<Integer>();
	public static JLabel totl = new JLabel("TEMP");
	public static JFrame frr = new JFrame("Buy Items");
	public static JButton shopB = new JButton("SHOP");
	public static Encryptor en = new Encryptor();
	private JPanel input;//input bar	
	public static JMenuItem mEN,pvp,pvc,cvc;//menu items	
	private static String[] cletters = {" ","A","B","C","D","E","F","G","H","I","J"},
	//array of letters used for combo boxes
			    	 cnumbers = {" ","1","2","3","4","5","6","7","8","9","10"},
	//array of numbers used for combo boxes
					 ships = {"Carrier","Battleship","Submarine","Destroyer",
					 "Patrol Boat"},//strings used for ship combo box
					 direction = {"Horizontal","Vertical"},//directions
					 level={"Normal", "Ridiculously Hard"}, 
					 layout={"Manual","Automatic"},
					 colors={"Cyan", "Green", "Yellow", "Magenta", "Pink", "Orange",
					 "White"},
					 first={"Player 1", "Player 2", "Random"};//used for options
	private JComboBox<String> cshi = new JComboBox<String>(ships),//ships
					  cdir = new JComboBox<String>(direction);//directions
	private static JComboBox<String> aiLevel=new JComboBox<String>(level),
						     shipLayout=new JComboBox<String>(layout),
							 shipColor=new JComboBox<String>(colors),
							 playsFirst=new JComboBox<String>(first);//used
					  			//for options menu
	private JTextField mbar = new JTextField();//message bar	
	private static int enemy=1,
				i,j,//counters							
				length=5,
				you=0,
				prevcolor=0,//index of previous color
				prevFirst=0,
				prevLayout=0,
				prevLevel=0,//tracks changes in corresponding comboboxes
				ready=0,
				sindex=0,//stores index of array
				dindex=0;//direction	
	private static Player players[]=new Player[2];
	private static JButton deploy=new JButton("START");
	private static File dir;
	public static File userData;
	public static JLabel bal = new JLabel("Balance:");
	public static ArrayList<String> udata = new ArrayList<String>();
	public static JMenu inv,help;
	
	private static int w=0,a=0,s=0,t=0,e=0;//counters to track the use of all ships
	//private static String[][] shiphit=new String[10][10];
	private static String user,user2;
	private static Color[] color={Color.cyan,Color.green,Color.yellow,Color.magenta,
									Color.pink,	Color.orange,	Color.white};		 	
	private static Object selectedValue=" ",
						  gametype;
	//private static BattleshipClient me;
	private static boolean gameover=false;
	
	/**
	 * Sets the cheat codes to either on or off.
	 * 
	 * @param items
	 * @param cash
	 */
	private static void cheats(boolean items,boolean cash){
		
		INFINITE_ITEMS = items;
		INFINITE_CASH = cash;
		
	}
	
    public static void initSave()throws Exception{ //FO4eIhSrm/OHX18VHHq8Ow==
    	
   
    	

    	
    	display.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
    	
    	 com = new JPanel();
    	 com.setLayout(new GridLayout(1,4)); 
     many = new JLabel("How Many Do You Want?");
        totl = new JLabel("Total Cost: $"); //TODO THREAD
    	
    	 amt = new JComboBox<Integer>();
    	
    	for(int u=1;u<101;u++){
    		
    		amt.addItem(u);
    		
    	}
    	
    	com.add(many);
    	com.add(amt);
    	com.add(totl);
    	
    	
    	nuke = new JButton("Nuke");
    	conf = new JButton("Confusion Ray");
    	sf = new JButton("Ship Finder");
    	tor = new JButton("Torpedo");
    	frag = new JButton("Frag Bomb");			
    	cancel = new JButton("Cancel");
    	cros = new JButton("Cross Fire");
    	bom = new JButton("Bomb");
    	//frr = new JFrame("Shop");
    	
    	frr.setLayout(new BorderLayout()); 
    	frr.add(display);
    	pane2.add(nuke);
    	pane2.add(conf);
    	pane2.add(sf);
    	pane2.add(tor);
    	pane2.add(frag);
    	pane2.add(cros);
    	pane2.add(bom);
    	
    	pane2.add(cancel);
    	pane2.setSize(600,50);
    	frr.setSize(700, 200);
    	frr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
    	frr.add(pane2, BorderLayout.SOUTH);
    	
    	try {
    		Thread.sleep(50);
    	} catch (InterruptedException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
    	pane2.setVisible(true);
    	 frr.setLocationRelativeTo(null);
    	 try {
    			Thread.sleep(50);
    		} catch (InterruptedException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    	
    	
    	if(System.getProperty("os.name").compareToIgnoreCase("mac os x") == 0){
    		
    		
    		userData = new File("/Users/"+System.getProperty("user.name")+"/Library/Application Support/.BattleShip/.user");
    		
    		dir = new File("/Users/"+System.getProperty("user.name")+"/Library/Application Support/.BattleShip");
    		
    		
     	}else if(System.getProperty("os.name").startsWith("Windows")){ 
    		
    		userData = new File("C:/Users/"+System.getProperty("user.name")+"/AppData/Roaming/.BattleShip/.user");
    		
    		dir = new File("C:/Users/"+System.getProperty("user.name")+"/AppData/Roaming/.BattleShip");
    		
    		
    	}else{
    		
    		JOptionPane.showMessageDialog(null, "Your OS is unrecognized! \n the game data will be saved next to this JAR", "OS ERROR!", JOptionPane.ERROR_MESSAGE);
    		userData = new File("Booty/user.dat");
    		
    		dir = new File("Booty");
    		
    		
    	}
    	
        if(dir.exists()){
			
			
			//read file
       udata = read(userData);
       
       
       cash = Integer.parseInt(en.decrypt(udata.get(0)));
       if(cash < 0){
    	   
    	   cash = 0;
    	   Player.saveGame(Math.abs(cash));
       }
       
       if(INFINITE_CASH){
    	   
    	   cash = Integer.MAX_VALUE;
    	   
       }
       JOptionPane.showMessageDialog(null, "Welcome Back "+en.decrypt(udata.get(NAME))+"!!");  
			Thread.sleep(400);
		}else{
			
			cash = 0;
			
			dir.mkdirs();
		
			userData.createNewFile();
			JOptionPane.showMessageDialog(null, "Make sure you read the rules and help!");
			//write new data TODO
			udata.add(en.encrypt("0"));
			udata.add(en.encrypt("Nuke"));
			udata.add(en.encrypt("0"));
			udata.add(en.encrypt("Confusion Ray"));
			udata.add(en.encrypt("0"));
			udata.add(en.encrypt("Ship Finder"));
			udata.add(en.encrypt("0"));
			udata.add(en.encrypt("Torpedo"));
			udata.add(en.encrypt("0"));
			udata.add(en.encrypt("Frag Bomb"));
			udata.add(en.encrypt("0"));
			udata.add(en.encrypt("Cross Fire"));
			udata.add(en.encrypt("0"));
			udata.add(en.encrypt("Bomb"));
			udata.add(en.encrypt("0"));
			udata.add(en.encrypt(JOptionPane.showInputDialog("Enter Your Name")));  
			udata.add(en.encrypt(""+false));
			
			write(udata,userData);
			
		}
    	
    	
    	
    }
    
    
    
public static ArrayList<String> read(File f) throws FileNotFoundException{
		
		ArrayList<String> al = new ArrayList<String>();
		Scanner s = new Scanner(f);
		while(s.hasNext()){
			al.add(s.nextLine());
		}
		s.close();
		return al;
		
		
	}
	public static void write(ArrayList<String> al,File f) throws FileNotFoundException{
		
		
		PrintWriter pw = new PrintWriter(f);
		
		for(int u=0;u<al.size();u++){
			
			pw.println(al.get(u)); 
			
		}
		pw.close();
		
		
		
	}
	
	public Battleship(String nam)//TODO CONTRUCTOR
	{	
		setTitle("Battleship");	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(createMenuBar());
		setResizable(false);			
		
		//gets user to input name
		user=nam;		
		int dummy=0;
		while (((user==null)||(user.equals("")))&&(dummy<3))
		{				
			user=JOptionPane.showInputDialog("You have to input something.");
			if ((user!=null)&&(!user.equals("")))
				dummy=4;
			else
				dummy++;
		}
		if (dummy==3)
		{
			JOptionPane.showMessageDialog(null,"Since you're having trouble inp"
			+"utting your name, I'll just call you stupid.","",JOptionPane.INFORMATION_MESSAGE);
			user="Stupid";
		}
		players[you]=new Player (user);
		players[enemy]=new Player ("Computer");						
		b=getContentPane();		
		b.add(setBoard(you),BorderLayout.CENTER);			
		c=getContentPane();
		d = getContentPane();
		inputpanel=shipinput();
		d.add(inputpanel,BorderLayout.NORTH);			
		pack();		
		
		setVisible(true);
		
	}	
	
	public static boolean getGameOver()
	{
	 	return gameover;	  
	}

	public static void setGameOver(boolean b)
	{
	 	gameover=b;	  
	}
	
	//method to determine who plays first
	public void whoGoesFirst()
	{
		int x=0;
		if (playsFirst.getSelectedIndex()!=2)
		{
			if (playsFirst.getSelectedIndex()!=you)
				flipYou();	
			players[playsFirst.getSelectedIndex()].getTimer().start();
			x=playsFirst.getSelectedIndex();
		}
		else
		{		
			int rand=(int)(Math.random()*2);					
			JOptionPane.showMessageDialog(null,players[rand].getUser()+" will "
			+"go first.","",JOptionPane.PLAIN_MESSAGE);
			if (rand!=you)
				flipYou();	
			players[rand].getTimer().start();
			x=rand;
		}
		if
		((!players[x].getUser().equals("Computer"))||(!players[x].getUser().equals("CPU1"))||(!players[x].getUser().equals("CPU2")))
			players[x].setMove(true);
	}
	
	//returns ship color, as selected by the user
	public static Color getColor()
	{			
		return (color[shipColor.getSelectedIndex()]);	
	}
	
	//asks if two players are playing on the same computer or over the web
	public static boolean isLocal()
	{
		if ((gametype==pvp)&&(selectedValue.equals("Local")))
				return true;
		else
			return false;
	}
	
	
	public static void flipYou()
	{
		if (you==1)
		{	
			you=0;
			enemy=1;
		}
		else
		{
			you=1;
			enemy=0;
		}	
	}
	
	//determines whether or not is shipLayout is set to automatic
	public static boolean isAutoSet()
	{
		if (shipLayout.getSelectedIndex()==0)
			return false;
		else
			return true;
	}
	
	
	//variable that determines whether or not a carrier has been placed
	public static int getW()
	{
		return w;	
	}
	
	//variable that determines whether or not a battleship has been placed
	public static int getA()
	{
		return a;	
	}
	
	//variable that determines whether or not a submarine has been placed
	public static int getS()
	{
		return s;	
	}
	
	//variable that determines whether or not a destroyer has been placed
	public static int getT()
	{
		return t;	
	}
	
	//variable that determines whether or not a patrol boat has been placed
	public static int getE()
	{
		return e;	
	}		
	
	public static int getReady()
	{
		return ready;	
	}
	
	public static JFrame getStatistics()
	{
		return statistics;	
	}
	
	public static void setData(JLabel x)
	{
		data=x;	
	}
	
	public static JLabel getData()
	{
		return data;	
	}
	
	public static JPanel getStats()
	{
		return stats;	
	}	
	
	public static void setDeploy(boolean k)
	{
		deploy.setEnabled(k);	
	}	
	
	public static Player getPlayers(int x)
	{
		return players[x];	
	}
	
	public static String getDirection(int i)
	{
		return direction[i];	
	}
	
	public static String getCletters(int i)
	{
		return cletters[i];	
	}	
	
	public static String getShips(int i)
	{
		return ships[i];	
	}
	
	public static String getCnumbers(int i)
	{
		return cnumbers[i];	
	}	
	
	public static int getSIndex()
	{
		return sindex;	
	}
	
	public static int getDIndex()
	{
		return dindex;	
	}	
	
	public static int getYou()
	{
		return you;	
	}
	
	public static int getEnemy()
	{
		return enemy;	
	}	
	
	public static void setYou(int x)
	{
		you=x;	
	}
	
	public static void setEnemy(int x)
	{
		enemy=x;	
	}
	
	//creates Game menu and submenus
	public JMenuBar createMenuBar()
	{
		
		
		
		JMenu menu;//menu
      
		// create the menu bar
		JMenuBar menuBar = new JMenuBar();

		// build the Game menu
		menu = new JMenu("Game");
		inv = new JMenu("Items");
		help = new JMenu("Help");
		
		menuBar.add(menu);
		menuBar.add(inv);
		menuBar.add(help);
		mEN = new JMenu("New Game");		
		menu.add(mEN);
		
		//submenu of New Game
		GameListener stuff = new GameListener();
		pvp = new JMenuItem("Player vs. Player");		
		pvp.addActionListener(stuff);
		mEN.add(pvp);
	pvc = new JMenuItem("Player vs. AI");
		pvc.addActionListener(stuff);
		mEN.add(pvc);
		cvc = new JMenuItem("AI vs. AI");
		cvc.addActionListener(stuff);
		mEN.add(cvc);
		
		//pvp.setEnabled(false);
		//cvc.setEnabled(false);
		
		mEN = new JMenuItem("Rules");
		mEN.addActionListener(new RulesListener());
		menu.add(mEN);
		mEN = new JMenuItem("Statistics");
		mEN.addActionListener(new StatsListener());		
		menu.add(mEN);
		mEN.setEnabled(false);
		mEN = new JMenuItem("Options");
		mEN.addActionListener(new OptionsListener());		
		menu.add(mEN);
		mEN.setEnabled(false);
		mEN = new JMenuItem("Exit");
		mEN.addActionListener(new ExitListener());
		menu.add(mEN);	
		mEN = new JMenuItem("About");		
		help.add(mEN);
		mEN.addActionListener(new AboutListener());
		mEN = new JMenuItem("Game Help");		
		help.add(mEN);
		mEN.addActionListener(new HelpListener());
		if(INFINITE_ITEMS){
			
			shopB.setEnabled(false);  
			
			try{
				
				mEN = new JMenuItem("Nukes: ∞");		
				inv.add(mEN);
				mEN.addActionListener(new NukeListener());
				mEN = new JMenuItem("Confusion Rays: ∞");		
				inv.add(mEN);
				mEN.addActionListener(new RayListener());
				mEN = new JMenuItem("Ship Finders: ∞");		
				inv.add(mEN);
				
				mEN.addActionListener(new SFListener());
				mEN = new JMenuItem("Torpedoes: ∞");		
				inv.add(mEN);
				mEN.addActionListener(new TorpedoListener());
				mEN = new JMenuItem("Frag Bombs: ∞");		
				inv.add(mEN);
				mEN.addActionListener(new FragListener());
				mEN = new JMenuItem("Cross Fires: ∞");		
				inv.add(mEN);
				mEN.addActionListener(new CrossListener());
				mEN = new JMenuItem("Bombs: ∞");		
				inv.add(mEN);
				mEN.addActionListener(new BombListener());
				}catch(Exception e){
					
					e.printStackTrace();
					
				}
			
			
			
		}else{
			
		try{
		
		mEN = new JMenuItem("Nukes: "+en.decrypt(udata.get(NUKE)));		
		inv.add(mEN);
		mEN.addActionListener(new NukeListener());
		if(en.decrypt(udata.get(NUKE)).matches("0")){
			mEN.setEnabled(false);  
		}
		mEN = new JMenuItem("Confusion Rays: "+en.decrypt(udata.get(CONF)));		
		inv.add(mEN);
		mEN.addActionListener(new RayListener());
		if(en.decrypt(udata.get(CONF)).matches("0")){
			mEN.setEnabled(false);  
		}
		mEN = new JMenuItem("Ship Finders: "+en.decrypt(udata.get(SF)));		
		inv.add(mEN);
		//mEN.setEnabled(false);  
		mEN.addActionListener(new SFListener());
		if(en.decrypt(udata.get(SF)).matches("0")){
			mEN.setEnabled(false);  
		}
		mEN = new JMenuItem("Torpedoes: "+en.decrypt(udata.get(TOR)));		
		inv.add(mEN);
		mEN.addActionListener(new TorpedoListener());
		if(en.decrypt(udata.get(TOR)).matches("0")){
			mEN.setEnabled(false);  
		}
		mEN = new JMenuItem("Frag Bombs: "+en.decrypt(udata.get(FRAG)));		
		inv.add(mEN);
		mEN.addActionListener(new FragListener());
		if(en.decrypt(udata.get(FRAG)).matches("0")){
			mEN.setEnabled(false);  
		}
		mEN = new JMenuItem("Cross Fires: "+en.decrypt(udata.get(CROSS)));		
		inv.add(mEN);
		mEN.addActionListener(new CrossListener());
		if(en.decrypt(udata.get(CROSS)).matches("0")){
			mEN.setEnabled(false);  
		}
		mEN = new JMenuItem("Bombs: "+en.decrypt(udata.get(BOMB)));		
		inv.add(mEN);
		mEN.addActionListener(new BombListener());
		if(en.decrypt(udata.get(BOMB)).matches("0")){
			mEN.setEnabled(false);  
		}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		}
		
		
		
		//m = new JMenuItem("Sell");
	//	m.addActionListener(new SellListener());
		//powerUps.add(m);
		
		
		
		return menuBar;
	}
	
	
	
	//creates panels that used to place ships
	public JPanel shipinput()
	{
		input= new JPanel();
		
		mbar.setText("Select a ship, its front position and direction.");
		mbar.setFont(new Font("Courier New", Font.BOLD, 14));
		mbar.setEditable(false);
		mbar.setVisible(true);
		//input.add(mbar);
		cshi.setSelectedIndex(0);	
		cshi.addActionListener(new ShipsListener());
		TitledBorder title;//used for titles around combo boxes
		title = BorderFactory.createTitledBorder("Ships");
		cshi.setBorder(title);	
		input.add(cshi);		
		cdir.setSelectedIndex(0);	
		cdir.addActionListener(new DirectListener());	
		input.add(cdir);
		title = BorderFactory.createTitledBorder("Direction");
		cdir.setBorder(title);		
		deploy.setEnabled(false);
		shopB.setEnabled(true);
		deploy.addActionListener(new DeployListener());
		input.add(deploy);
		input.add(shopB);
		
		return input;
	}	

	//creates board for manual ship placement
	public JPanel setBoard(int n)
	{
		players[n].setMyBoard(new JPanel(new GridLayout(11,11)));//panel to store board		
		JTextField k;		
		for (i=0;i<11;i++)
		{			
			for (j=0;j<11;j++)
			{
				if ((j!=0)&&(i!=0))
				{					
					players[n].getBboard(i-1,j-1).addActionListener(new BoardListener());
					players[n].getMyBoard().add(players[n].getBboard(i-1,j-1));
				}				
				if (i==0)
				{				
					if (j!=0)
					{	
						//used to display row of numbers
						k= new JTextField(Battleship.getCnumbers(j));
						k.setEditable(false);
						k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT); 
					}									
					else 
					{	
						//used to display column of numbers
						k= new JTextField();
						k.setEditable(false);						
					}
					players[n].getMyBoard().add(k);
				}
				else if (j==0)					
				{	
					k= new JTextField(Battleship.getCletters(i));	
					k.setEditable(false);
					k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT); 
					players[n].getMyBoard().add(k);
				}				
			}
		}
		return players[n].getMyBoard();		
	}
	
	//creates board and automatically places ship
	public JPanel autoBoard(int u,int t) 
	{
		players[u].setGBoard(new JPanel(new GridLayout(11,11)));//panel to store board		
		JTextField k;	
		if (!players[u].getUser().equals("Unknown"))
			for (i=0;i<5;i++)
			{				
				players[u].setBoats(i,players[u].getBoats(i).compinput(i,u));
			}		
		for (i=0;i<11;i++)
		{			
			for (j=0;j<11;j++)
			{
				if ((j!=0)&&(i!=0))
				{								
					if ((players[u].getUser().equals("Computer"))||(isLocal()))						
					{						
						players[u].getBboard(i-1,j-1).addActionListener(new AttackListener());									
					}						
					else if
						((players[t].getUser().equals("Computer"))||(players[t].getUser().equals("CPU1"))||(players[t].getUser().equals("CPU2"))||(players[t].getUser().equals("Unknown")))			
					{
						if (players[u].getHitOrMiss(i-1,j-1))
							players[u].setBboard(i-1,j-1,getColor());						
					}
					else
					{
						//players[u].getBboard(i-1,j-1).addActionListener(new InternetListener());
						
					}
					players[u].getGBoard().add(players[u].getBboard(i-1,j-1));
				}				
				if (i==0)
				{				
					if (j!=0)
					{	
						//used to display row of numbers
						k= new JTextField(Battleship.getCnumbers(j));
						k.setEditable(false);
						k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT); 
					}									
					else 
					{	
						//used to display column of numbers
						k= new JTextField();
						k.setEditable(false);						
					}
					players[u].getGBoard().add(k);
				}
				else if (j==0)					
				{	
					k= new JTextField(Battleship.getCletters(i));	
					k.setEditable(false);
					k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT); 
					players[u].getGBoard().add(k);
				}				
			}			
		}
		return players[u].getGBoard();		
	}
	
	//Listener for combo boxes used to layout ships 
	private class ShipsListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent v)
		{				
			sindex=cshi.getSelectedIndex();
			if (players[you].getBoats(sindex)!=null)
				cdir.setSelectedIndex(players[you].getBoats(sindex).getDirect());
			switch (sindex)
			{
				case 0:		length=5;
				break;
				case 1:		length=4;
				break;
				case 2:		length=3;	
				break;
				case 3:		length=3;
				break;
				case 4:		length=2;
				break;							
			}
			if (players[you].getBoats(sindex) != null)
			{
				Ship boat=new Ship(ships[sindex],players[you].getBoats(sindex).getDirect()
				,length,players[you].getBoats(sindex).getX(),players[you].getBoats(sindex).getY());		
				players[you].getBoats(sindex).clearship();
				players[you].setBoats(sindex,boat);
				players[you].getBoats(sindex).placeship();			
			}							
		}
	}			
			
	//Listener for the Direction combo box		
	private class DirectListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent v)
		{						
			dindex = cdir.getSelectedIndex();					
			if (players[you].getBoats(sindex) != null)
			{
				Ship boat=new Ship(ships[sindex],dindex,players[you].getBoats(sindex).getLength(),
			   	players[you].getBoats(sindex).getX(),players[you].getBoats(sindex).getY());		   
				players[you].getBoats(sindex).clearship();
				players[you].setBoats(sindex,boat);
				players[you].getBoats(sindex).placeship();		   
			}						
		}
	}				
	
	//Listener for the buttons on the board		
	private class BoardListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent v)
		{				
			if (ready==0)
			{
				if (players[you].getBoats(sindex)!=null)
					players[you].getBoats(sindex).clearship();
				Object source = v.getSource();
				outer:						
				for (i=0;i<10;i++)
				{				
					for (j=0;j<10;j++)
					{
						if (source==players[you].getBboard(i,j))
						{						
							switch (sindex)
							{
								case 0:	{											
											if (w==0)
												w++;														
										}
								break;						
								case 1:	{											
											if (a==0)
												a++;														
										}
								break;
								case 2:	{								
											if (s==0)								
												s++;
										}
								break;
								case 3:	{									
											if (t==0)
												t++;													
										}
							break;
							case 4:	{								
										if (e==0)
											e++;															
									}
							break;							
						}	
						players[you].setBoats(sindex,new Ship(ships[sindex],dindex,length,i,j));																									
						break outer;						
					}					
				}
			}			
			players[you].getBoats(sindex).placeship();
			}						
		}
    }
	
	//creates a panel that tells whose board is which
	private JPanel whoseBoard()
	{
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(new JLabel(players[you].getUser()+"'s Board",SwingConstants.LEFT),BorderLayout.WEST);
		panel.add(new JLabel(players[enemy].getUser()+"'s Board",SwingConstants.RIGHT),BorderLayout.EAST);
		return panel;
	}
	
	//Listener for exit choice on Game menu	
	private class ExitListener implements ActionListener //TODO COPY THIS FOR SHOP 
	{
		public void actionPerformed(ActionEvent e)
		{
			int r= JOptionPane.showConfirmDialog(null,"Are you sure you would l"
			+"ike to exit Battleship?", "Exit?", JOptionPane.YES_NO_OPTION);
			if (r==0){
				//hjk();
				System.exit(0);	
				
			}
		}	
	}
	
	
	
public static void openShop() throws Exception{//TODO hjk 
	
	
	
	frr.setVisible(true);
	try {
		Thread.sleep(50);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	display.setVisible(true);
	nuke.setVisible(true);
	conf.setVisible(true);
	sf.setVisible(true);
	tor.setVisible(true);
	frag.setVisible(true);
	cros.setVisible(true);
	bom.setVisible(true);
	cancel.setVisible(true);
	
	//initSave();
	
	

	//String[] ops = {"Nuke ($20,000)","Confusion Ray ($12,000)","Ship Finder ($5000)","Torpedo ($1000)","Frag Bomb ($2000)"};
	
	
	
	for(;;){
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	
	if(nuke.getModel().isRollover() == true){     		  
		  
		  display.setText("<html>INSTANT KILLS THE COMPUTER BY FINDING<br/>THE PRECISE COORDS OF HIS SHIPS AND TAKING SHOTS AT THEM<br/>Price: $100,000</html>");        		  
		  
	  }else if(conf.getModel().isRollover() == true){
		  
		  display.setText("<html>Will Confuse the Opponent<br/>Making him lose their turn<br/>Price: $1000</html>");
		  
	  }else if(sf.getModel().isRollover() == true){
		  
		 display.setText("<html>Will indicate the location of<br/>ONE of the CPU's Ships<br/>Price: $3000</html>");
		  
	  }else if(tor.getModel().isRollover() == true){
		  
		display.setText("<html>You can take out an entire Row or Column<br/>Price: $5000</html>");
		  
	  }else if(frag.getModel().isRollover() == true){
		  
		display.setText("<html>Fires at 8 random places on the board.<br/>Price: $2000</html>");
		  
	  }else if(cros.getModel().isRollover() == true){
		  
		  display.setText("<html>Will fire outward in every direction of<br/>chosen point (inclusive)<br/>Price: $5200</html>");
		  
	  }else if(bom.getModel().isRollover() == true){
		  
		  display.setText("<html>Will blow a 5x5 hole of guesses<br/>chosen point being the center.<br/>Price: $10,000</html>");
		  
	  }else{
		  
		  display.setText("<html>Mouse Over the Products to See Info on them!<br/>Current Balance: $"+cash+"</html>");
		  
	  }
	
	
	if(nuke.getModel().isPressed() == true){
  		 // com.setVisible(true);  
		TotalThread.updateItemCost(100000);  
		nuke.getModel().setPressed(false);
  	int yy =   JOptionPane.showConfirmDialog(null,com,"Buy",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);  
  		   if(yy == JOptionPane.YES_OPTION){
  			   
  			   if(cash < 100000){
  				   
  				   JOptionPane.showMessageDialog(null, "You Don\'t have Enough Money!", "Not Enough Money", JOptionPane.ERROR_MESSAGE);  
  				   
  			   }else{
  				   
  				 cash -= TotalThread.getCost();
  				   
  				      Player.saveGame(-TotalThread.getCost(), "Nuke", amt.getSelectedIndex()+1);  
  				  
  				   //add to inv
  				 
  				  // return;
  				   
  			   }
  			   
  		   }
  		  
  	  }else if(conf.getModel().isPressed() == true){
  		TotalThread.updateItemCost(1000);
  		conf.getModel().setPressed(false);
  		int yy =  JOptionPane.showConfirmDialog(null,com,"Buy",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
  		   if(yy == JOptionPane.YES_OPTION){
  			   
  			   if(cash < 1000){
  				   
  				   JOptionPane.showMessageDialog(null, "You Don\'t have Enough Money!", "Not Enough Money", JOptionPane.ERROR_MESSAGE);  
  				   
  			   }else{
  				   
  				 cash -= TotalThread.getCost();
				   
				      Player.saveGame(-TotalThread.getCost(), "Confusion Ray", amt.getSelectedIndex()+1);
  				 
  				  // return;
  				   
  			   }
  			   
  		   }
  	
  		  
  	  }else if(sf.getModel().isPressed() == true){
  		TotalThread.updateItemCost(3000);
  		sf.getModel().setPressed(false);
  		int yy =   JOptionPane.showConfirmDialog(null,com,"Buy",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
  		   if(yy == JOptionPane.YES_OPTION){
  			   
  			   if(cash < 3000){
  				   
  				   JOptionPane.showMessageDialog(null, "You Don\'t have Enough Money!", "Not Enough Money", JOptionPane.ERROR_MESSAGE);  
  				   
  			   }else{
  				   
  				 cash -= TotalThread.getCost();
				   
				      Player.saveGame(-TotalThread.getCost(), "Ship Finder", amt.getSelectedIndex()+1);
  				 
  				 // return;
  			   }
  			   
  		   }
  		
  		  
  	  }else if(tor.getModel().isPressed() == true){
  		TotalThread.updateItemCost(5000);
  		tor.getModel().setPressed(false);
  		
  		int yy =   JOptionPane.showConfirmDialog(null,com,"Buy",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
  		   if(yy == JOptionPane.YES_OPTION){
  			   
  			   if(cash < 5000){
  				   
  				   JOptionPane.showMessageDialog(null, "You Don\'t have Enough Money!", "Not Enough Money", JOptionPane.ERROR_MESSAGE);  
  				   
  			   }else{
  				   
  				 cash -= TotalThread.getCost();
				   
				      Player.saveGame(-TotalThread.getCost(), "Torpedo", amt.getSelectedIndex()+1);
  				
  				 //return;
  				   
  			   }
  			   
  		   }
  	
  		  
  	  }else if(frag.getModel().isPressed() == true){
  		TotalThread.updateItemCost(2000);
  		frag.getModel().setPressed(false);
  		int yy =   JOptionPane.showConfirmDialog(null,com,"Buy",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
  		   if(yy == JOptionPane.YES_OPTION){
  			   
  			   if(cash < 2000){
  				   
  				   JOptionPane.showMessageDialog(null, "You Don\'t have Enough Money!", "Not Enough Money", JOptionPane.ERROR_MESSAGE);  
  				   
  			   }else{
  				   
  				 cash -= TotalThread.getCost();
				   
				      Player.saveGame(-TotalThread.getCost(), "Frag Bomb", amt.getSelectedIndex()+1);
  				// return;
  				   
  			   }
  			   
  		   }
  		
    
  	  }else if(cros.getModel().isPressed() == true){
  		  
  		TotalThread.updateItemCost(5200);
  		cros.getModel().setPressed(false);
  		int yy =   JOptionPane.showConfirmDialog(null,com,"Buy",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
  		   if(yy == JOptionPane.YES_OPTION){
  			   
  			   if(cash < 5200){
  				   
  				   JOptionPane.showMessageDialog(null, "You Don\'t have Enough Money!", "Not Enough Money", JOptionPane.ERROR_MESSAGE);  
  				   
  			   }else{
  				   
  				 cash -= TotalThread.getCost();
				   
				      Player.saveGame(-TotalThread.getCost(), "Cross Fire", amt.getSelectedIndex()+1);
  				// return;
  				   
  			   }
  			   
  		   }
  		  
  	  }else if(bom.getModel().isPressed() == true){
  		  
  		TotalThread.updateItemCost(10000);
  		cros.getModel().setPressed(false);
  		int yy =   JOptionPane.showConfirmDialog(null,com,"Buy",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
  		   if(yy == JOptionPane.YES_OPTION){
  			   
  			   if(cash < 10000){
  				   
  				   JOptionPane.showMessageDialog(null, "You Don\'t have Enough Money!", "Not Enough Money", JOptionPane.ERROR_MESSAGE);  
  				   
  			   }else{
  				   
  				 cash -= TotalThread.getCost();
				   
				      Player.saveGame(-TotalThread.getCost(), "Bomb", amt.getSelectedIndex()+1);
  				// return;
  				   
  			   }
  			   
  		   }
  		  
  	  }else if(cancel.getModel().isPressed() == true){
  	  
  		  
  		cancel.getModel().setPressed(false);
  		  frr.setVisible(false);
  		  //FIXME
  		
  		 return;
  		  
  		  
  	  }
	
	 }
	


	}
	
	

	//listener for New Game submenu		
	private class GameListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{	
			int q= JOptionPane.showConfirmDialog(null,"Are you sure you would l"
			+"ike to start a new game?", "New Game?", JOptionPane.YES_NO_OPTION);
			if (q==0)
			{					
				//resets variables
				b.removeAll();
				c.removeAll();
				d.removeAll();				
				you=0;
				enemy=1;
				ready=0;
				
				if (players[you].getTimer()!=null)
					if (players[you].getTimer().isRunning())
						players[you].getTimer().stop();
				if (players[enemy].getTimer()!=null)
					if (players[enemy].getTimer().isRunning())
						players[enemy].getTimer().stop();									
				
				gametype = e.getSource();			
			
				if (gametype==pvp)
				{
					if (!selectedValue.equals("no server"))
					{
						String[] possibleValues = { "Local", "Online"};
						selectedValue = JOptionPane.showInputDialog(null, 
						"Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null,
						possibleValues, possibleValues[0]);
					}
					if (!players[you].getUser().equals("CPU1"))
					{
						if (players[you].getUser().equals("Stupid"))
						{
							int w=JOptionPane.showConfirmDialog(null,"Would you"
							+" like to try inputting your name again?","",
							JOptionPane.YES_NO_OPTION);
							if (w==JOptionPane.YES_OPTION)
							{	
								user=JOptionPane.showInputDialog("Enter your name.");
								int dummy=0;
								while (((user==null)||(user.equals("")))&&(dummy<3))
								{				
									user=JOptionPane.showInputDialog("You have to input something.");
									if ((user!=null)&&(!user.equals("")))
										dummy=4;
									else
										dummy++;
								}
								if (dummy==3)
								{
									JOptionPane.showMessageDialog(null,"Still a"
									+"cting stupid.  Oh well, we'll run with it."
									,"",JOptionPane.INFORMATION_MESSAGE);
									user="Stupid";
								}
								else
									JOptionPane.showMessageDialog(null,"That wasn't"
									+" so hard now, was it?","YEAH!",
									JOptionPane.INFORMATION_MESSAGE);									
							}							
						}
						players[you]=new Player (players[you].getUser());
					}
					else									
						players[you]=new Player (user);								
					if (selectedValue.equals("Online"))
					{
						players[enemy]=new Player ("Unknown");
						if (!isAutoSet())
						{
							b.add(setBoard(you),BorderLayout.CENTER);							
							deploy.setEnabled(false);
							d.add(inputpanel,BorderLayout.NORTH);					
						}
						else
						{
							b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
							c.add(autoBoard(enemy,you),BorderLayout.EAST);
							ready=1;																
						}					
					}
					else
					{//TODO PVP LOCAL
						//gets user to input name
						if((players[enemy].getUser().equals("Computer"))||(players[enemy].getUser().equals("CPU2"))||(players[enemy].getUser().equals("Unknown")))
						{							
							user2=JOptionPane.showInputDialog("Enter your name.");					
							while ((user2==null)||(user2.equals("")))
							{				
								user2=JOptionPane.showInputDialog("You have to input something.");							
							}						
						}
						else
							user2=players[enemy].getUser();
						players[enemy]=new Player (user2);	
						b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
						c.add(autoBoard(enemy,you),BorderLayout.EAST);
						d.add(whoseBoard(),BorderLayout.NORTH);						
						whoGoesFirst();
						ready=1;
					}
					//ready=1;
				}
				else if (gametype==pvc)//Player vs Computer
				{						
					if (!players[you].getUser().equals("CPU1"))
					{
						if (players[you].getUser().equals("Stupid"))
						{
							int w=JOptionPane.showConfirmDialog(null,"Would you"
							+" like to try inputting your name again?","",
							JOptionPane.YES_NO_OPTION);
							if (w==JOptionPane.YES_OPTION)
							{	
								user=JOptionPane.showInputDialog("Enter your name.");
								int dummy=0;
								while (((user==null)||(user.equals("")))&&(dummy<3))
								{				
									user=JOptionPane.showInputDialog("You have to input something.");
									if ((user!=null)&&(!user.equals("")))
										dummy=4;
									else
										dummy++;
								}
								if (dummy==3)
								{
									JOptionPane.showMessageDialog(null,"Still a"
									+"cting stupid.  Oh well, we'll run with it."
									,"",JOptionPane.INFORMATION_MESSAGE);
									user="Stupid";
								}
								else
									JOptionPane.showMessageDialog(null,"That wasn't"
									+" so hard now, was it?","YEAH!",
									JOptionPane.INFORMATION_MESSAGE);									
							}							
						}
						players[you]=new Player (players[you].getUser());
					}
					else									
						players[you]=new Player (user);								
					players[enemy]=new Player ("Computer");			
					if (!isAutoSet())
					{
						b.add(setBoard(you),BorderLayout.CENTER);							
						deploy.setEnabled(false);
						d.add(inputpanel,BorderLayout.NORTH);					
					}
					else
					{
						b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
						c.add(autoBoard(enemy,you),BorderLayout.EAST);
						whoGoesFirst();	
					}
				}
				else if (gametype==cvc)//Computer vs Computer
				{										
					mbar.setText("Battleship Demo");					
					mbar.setEditable(false);					
					d.add(mbar,BorderLayout.NORTH);
					players[you]=new Player ("CPU1");
					players[enemy]=new Player ("CPU2");					
					b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
					c.add(autoBoard(enemy,you),BorderLayout.EAST);					
					whoGoesFirst();		
				}				
				pack();		
				repaint();
			}									
		}	
	}	
	
	//Listener for Rules menu
	private class RulesListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{	
			
		}	
	}
	
	
	//Listener for ok button in statistics menu
	private class OkListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{	
			statistics.dispose();
		}	
	}
	
	//Listener for Stats menu
	private class StatsListener implements ActionListener
	{	
		//
		public void setup()
		{			
			stats=new JPanel();
			ok.addActionListener(new OkListener());		
			statistics.setSize(300,300);
			statistics.setResizable(false);		
			statistics.getContentPane().add(ok,BorderLayout.SOUTH);
			//statistics.setLocation(700,200);				
		}	
		
		public void actionPerformed(ActionEvent e)
		{				
			if (data==null)
				setup();
			else
				stats.removeAll();
			stats.setLayout(new GridLayout(6,3));					
			data=new JLabel("");
			stats.add(data);
			data=new JLabel("Player 1",SwingConstants.CENTER);
			stats.add(data);
			data=new JLabel("Player 2",SwingConstants.CENTER);
			stats.add(data);				
			data=new JLabel("Names");
			stats.add(data);
			if (you == 0)
			{								
				data=new JLabel(players[you].getUser(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(players[enemy].getUser(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Shots Taken");
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getShots()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getShots()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Hits");
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getHits()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getHits()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Shot Accuracy");
				stats.add(data);
				data=new JLabel(players[you].getAcc(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(players[enemy].getAcc(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Ships Left");
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getShipsLeft()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getShipsLeft()),SwingConstants.CENTER);
				stats.add(data);
			}		
			else 
			{					
				data=new JLabel(players[enemy].getUser(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(players[you].getUser(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Shots Taken");
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getShots()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getShots()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Hits");
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getHits()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getHits()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Shot Accuracy");
				stats.add(data);
				data=new JLabel(players[enemy].getAcc(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(players[you].getAcc(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Ships Left");
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getShipsLeft()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getShipsLeft()),SwingConstants.CENTER);
				stats.add(data);
			}
			statistics.getContentPane().add(stats);			
			statistics.pack();
			statistics.setVisible(true);			
		}	
	}
	
	//Listener for Deploy Button 
	private class DeployListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent v)
		{	
			int r= JOptionPane.showConfirmDialog(null,"Are you sure you would l"
			+"ike to deploy your ships?", "Deploy Ships?", 
			JOptionPane.YES_NO_OPTION);
			if (r==0)
			{	
				allowedItems = true;
				w=0;
				a=0;
				s=0;
				t=0;
				e=0;									
				d.remove(input);						
				b.add(players[you].getMyBoard(),BorderLayout.WEST);
				ready=1;	
				c.add(autoBoard(enemy,you),BorderLayout.EAST);													
				d.add(new JPanel(),BorderLayout.CENTER);
				if (!selectedValue.equals("Online"))
					whoGoesFirst();						
				pack();
				repaint();										
			}
		}	
	}

	//Listener for Options menu
	public class OptionsListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{		
			if (opts==null)
				setup();
			else
				options.setVisible(true);					
		}		
		
		public void setup()
		{			
			opts=new JPanel(new GridLayout(4,2));
			title=new JLabel("Computer AI");
			opts.add(title);			
			aiLevel.setSelectedIndex(0);			
			opts.add(aiLevel);
			title=new JLabel("Ship Layout");
			opts.add(title);			
			shipLayout.setSelectedIndex(0);			
			opts.add(shipLayout);
			title=new JLabel("Ship Color");
			opts.add(title);				
			shipColor.addActionListener(new SColorListener());
			shipColor.setSelectedIndex(0);	
			opts.add(shipColor);
			title=new JLabel("Who Plays First?");
			opts.add(title);			
			playsFirst.setSelectedIndex(0);			
			opts.add(playsFirst);		
			options.getContentPane().add(opts,BorderLayout.CENTER);
			//options.setSize(600,800);
			options.setResizable(false);
			done.addActionListener(new DoneListener());		
			options.getContentPane().add(done,BorderLayout.SOUTH);
			options.setLocation(200,200);
			options.pack();
			options.setVisible(true);		
		}
		
		//Listener for the Colors combo box		
		private class SColorListener implements ActionListener
		{	
			public void actionPerformed(ActionEvent v)
			{	
				for (i=0;i<10;i++)
					for (j=0;j<10;j++)
					{
						if (players[you].getBboard(i,j).getBackground()==color[prevcolor])
							players[you].setBboard(i,j,color[shipColor.getSelectedIndex()]);				
						if (players[enemy].getBboard(i,j).getBackground()
							==color[prevcolor])
							players[enemy].setBboard(i,j,color[shipColor.getSelectedIndex()]);		
					}
				prevcolor=shipColor.getSelectedIndex();	
			}
		}	
		
		//Listener for ok button in statistics menu
		private class DoneListener implements ActionListener
		{	
			public void actionPerformed(ActionEvent e)
			{	
				if ((shipLayout.getSelectedIndex()!=prevLayout)||
					(aiLevel.getSelectedIndex()!=prevLevel)||
					(playsFirst.getSelectedIndex()!=prevFirst))
				{
					JOptionPane.showMessageDialog(null,"Changes will take"+
					" place at the start of a new game.",""
					,JOptionPane.PLAIN_MESSAGE);
					if (shipLayout.getSelectedIndex()!=prevLayout)
						prevLayout=shipLayout.getSelectedIndex();
					if (playsFirst.getSelectedIndex()!=prevFirst)
						prevFirst=playsFirst.getSelectedIndex();
					if (aiLevel.getSelectedIndex()!=prevLevel)
						prevLevel=aiLevel.getSelectedIndex();
				}
				options.dispose();
			}	
		}	
	}	
	
	public static boolean getCheat(int id){
		
		if(id == 0){
			
			return INFINITE_ITEMS;
			
		}else{
			return INFINITE_CASH;
		}
		
	}
	
	public static void main(String[] args) throws Exception{	  
		
		
		String res = JOptionPane.showInputDialog("Enter a Cheat Code (Optional)(Leave Blank if you wanna play legit)");
		if(res.equals("MoneyIs4Noobz")){	
			JOptionPane.showMessageDialog(null, "Infinite Cash Enabled");   
		cheats(false,true);
		}else if(res.equals("ItemsAre4Noobz")){
			JOptionPane.showMessageDialog(null, "Infinite Items Enabled"); 
			cheats(true,false);
		}else
			cheats(false,false);
		if(INFINITE_CASH && INFINITE_ITEMS){
			
			System.err.println("Invalid Configuration Exception: CANNOT HAVE INFINITE CASH AND INFINITE ITEMS ENABLED!\n\tat: Battleship.java:1644 ");
			JOptionPane.showMessageDialog(null, "The Game Has Crashed! \n Please Check the Console for ERRORS!!", "ERROR!", JOptionPane.ERROR_MESSAGE);   
			System.exit(0);
		}
		initLookAndFeel("Nimbus",null);
		ShopThread.start();
		amt.addItem(0);
		TotalThread.start();
		//System.out.println(en.encrypt("140000.0"));
		//System.out.println(en.encrypt("Nuke"));
	   initSave();
		Battleship gui= new Battleship(udata.get(NAME));   
		
		
		//hjk();
		while (gui.isActive())
		{
			while (selectedValue.equals(" "))
				{	}
			System.out.println("xenophobia");
			System.out.println("Object = "+selectedValue);
					
		}		//System.out.println("okay");		
	}
	
	private static void initLookAndFeel(String LaF,String theme) { //TODO LaF
    	LOOKANDFEEL = LaF;
    	THEME = theme;
	        String lookAndFeel = null;
	        
	        
	        if (LOOKANDFEEL != null) {
	            if (LOOKANDFEEL.equals("Metal")) {
	                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
	              //  an alternative way to set the Metal L&F is to replace the 
	              // previous line with:
	              // lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
	                
	            }
	            
	            else if (LOOKANDFEEL.equals("System")) {
	                lookAndFeel = UIManager.getSystemLookAndFeelClassName();
	            } 
	            
	            else if (LOOKANDFEEL.equals("Motif")) {
	                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	            } 
	            
	            else if (LOOKANDFEEL.equals("Nimbus")) { 
	                lookAndFeel = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	try {
		            	
		            	
		                UIManager.setLookAndFeel(lookAndFeel);
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	                
	            }
	    }
	
	}
	
}	
