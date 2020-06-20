/**
 * This program checks if the given Directory changes in size every second and is only manually 
 * stoppable
 * author: julian soldanski, bo-ji wong
 */
package specialThreads;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class specialThreads{
	public static void main(String[] args) {
		File f = new File(args[0]);
		Timer timer = new Timer();
		if(!f.exists()) {
			System.err.println("Directory doesn't exist...");
		}
		if(!f.isDirectory()) {
			System.err.println("File is no Directory");
		}
		
		TimerTask t1 = new TimerTask() {
			private long dirSize = 0;

			public void run() {
				f.length();
				if(f.length() != dirSize) {
					System.out.println("Size: " + f.length());
				}
				this.dirSize = f.length();
				
			}
		};
		timer.schedule(t1, 5000,1000);
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				System.out.println("Shutdown Hook wurde aufgerufen");
			}
			
		});
	}


}
