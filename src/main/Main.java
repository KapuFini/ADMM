package main;
import java.util.ArrayList;
public class Main {
	public static void main(String args[]) {
		ArrayList<Agent> agents=new ArrayList<Agent>();
		int a=1;
		Agent a1=new Agent(1,a*3,40,4);
		Agent a2=new Agent(2,a,20,4,a1);
		Agent a3=new Agent(3,a,100,4,a2);
		Agent a4=new Agent(4,a,-5,4,a1);
		Agent a5=new Agent(5,a,-15,4,a4,a2,a3);
		Agent a6=new Agent(6,a,36,4,a5,a1);
		int t=50;
		new Thread(()->{
			for(int i=0;i<t;i++) {
				a1.renew();
			}
		}).start();
		new Thread(()->{
			for(int i=0;i<t;i++) {
				a2.renew();
			}
		}).start();
		new Thread(()->{
			for(int i=0;i<t;i++) {
				a3.renew();
			}
		}).start();
		new Thread(()->{
			for(int i=0;i<t;i++) {
				a4.renew();
			}
		}).start();
		new Thread(()->{
			for(int i=0;i<t;i++) {
				a5.renew();
			}
		}).start();
		new Thread(()->{
			for(int i=0;i<t;i++) {
				a6.renew();
			}
		}).start();
	}
}
