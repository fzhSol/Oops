package infovk.f_phillips17;

public class OO extends SimpleRobot 
{
	
	int seen = 0;
	int swtchT = 0;
	double bear;
	double dist;
	double closure = 15;
	double safety = 2;
	

	public void run()
	{
		while(true)
		{
			if(seen == 0)
			{
				turnGunRight(20);
				turnRadarRight(20);
			}
			else if(seen == 1 && swtchT > 0)
			{
				swtchT = swtchT - 10;
				pursue();
			}
			else
			{
				seen = 0;
				swtchT = 0;
			}
			
		}
	}
	
	public void pursue()
	{
		if(getHeading() <= bear + closure && getHeading() >= bear - closure)
		{
			ahead(dist - safety);
		}
		else if(getHeading() < bear - closure)
		{
			turnRight(20);
		}
		else if(getHeading() > bear + closure)
		{
			turnLeft(20);
		}
	}
	
	public void ScannedRobotEvent(robocode.ScannedRobotEvent ev)
	{
		bear = ev.getBearing();
		dist = ev.getDistance();
		seen = 1;
		swtchT = 500;
		if (getGunHeat() == 0)
		{
			fireBullet(1);
		}
	}
	
	
	/* public OO() 
	{
		
		behavior=new MyFirstBehavior(this);
		
	} */
}
