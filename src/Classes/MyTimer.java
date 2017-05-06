package Classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTimer extends javax.swing.JLabel 
 		implements Runnable {
		public Thread clocker=null;
		private String today;
		private int hour;
		private int minute;
		private int seconds;
		public MyTimer(){
			Date date =new Date();
			long times = date.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(times);
			System.out.println(dateString);
			String time_1[]=dateString.split(" ");
			String time_2[]=time_1[1].split(":");
			this.today=time_1[0];
			this.hour=Integer.parseInt(time_2[0]);
			this.minute=Integer.parseInt(time_2[1]);
			this.seconds=Integer.parseInt(time_2[2]);
			
			this.setText(today+" "+hour+":"+minute+":"+seconds);
		}
		public MyTimer(int x,int y,int z){
			this.hour=x;
			this.minute=y;
			this.seconds=z;
			this.clocker=null;
			this.setText("System Clock: "+x+":"+y);
		}
		
		public void UpdateTime(){
			this.seconds++;
			if(this.seconds>=60)
			{
				this.seconds=0;
				this.minute++;
			}
			if(this.minute>=60){
				this.minute=0;
				this.hour++;
			}
		}


		public int getHour() {
			return hour;
		}

		public void setHour(int hour) {
			this.hour = hour;
		}

		public int getMinute() {
			return minute;
		}

		public void setMinute(int minute) {
			this.minute = minute;
		}

		
		
		public void start() {
		    if(clocker==null)
		    {
		      clocker=new Thread(this);
		      clocker.start();
		    }
			
		}
		  public void stop()
		  {
		    clocker=null;
		  }
		  
		public void run(){
			Thread currentThread=Thread.currentThread();
			while(clocker==currentThread){
				
				UpdateTime();
		       this.setText(this.today+" "
		    		   +this.hour+":"+this.minute+":"+this.seconds);
	            try
	           {   
	               clocker.sleep(1000);
	           }
	      catch (InterruptedException ie)
	      {
	        System.out.println("Thread error:"+ie);
	      }
			}
			
		}
	
}
