package main;
import java.util.ArrayList;
import java.util.HashMap;
public class Agent {
	public int number;
	ArrayList<Agent> neighbors;
	HashMap<Agent,Double> lambda;
	HashMap<Agent,Double> low;
	int t;
	int state;
	double a;
	double b;
	double c;
	volatile double x;
	//double lambda;
	//double low;
	public Agent(int i,int _a,int _b,int _c,Agent...agents ) {
		number=i;
		neighbors=new ArrayList<Agent>();
		for(Agent agent:agents) {
			neighbors.add(agent);
			agent.neighbors.add(this);
		}
		x=Math.random()*100-50;
		t=0;
		state=0;
		a=Math.abs(_a);
		b=_b;
		c=_c;
		low=new HashMap<Agent,Double>();
		lambda=new HashMap<Agent,Double>();
		for(Agent a:neighbors) {
			low.put(a, 0.1);
			lambda.put(a, low.get(a)*(x-a.x));
			a.put();
		}
		System.out.println("t:"+t+" ,n="+number+" x="+(x));

	}
	void put() {
		for(Agent a:neighbors) {
			if(low.containsKey(a)) {
				low.replace(a, 0.1);
			}else {
				low.put(a, 0.1);

			}
			if(!lambda.containsKey(a))lambda.put(a, low.get(a)*(x-a.x));
		}
	}
	double f(double x) {
		return a*x*x+b*x+c;
	}
	double f_1(double x){
		return 2*a*x+b;
	}
	void renew(){
		double right=2*x;
		for(Agent a:neighbors) {
			while(t!=a.t) {

			}
			double lam=lambda.get(a);
			lambda.replace(a, lam+low.get(a)*(x-a.x));
			//lambda.put(a, low.get(a)*(x-a.x));
			right+=low.get(a)*(a.x-x)-lambda.get(a);
			low.replace(a, low.get(a)+0.01);
		}
		state=1;
		for(Agent a:neighbors) {
			while(a.state!=1) {
				if(a.t>=t+1)break;
			}
		}
		state=0;
		right-=b;
		x=right/(2*a+2);
		t++;
		System.out.println("t:"+t+" ,n="+number+" x="+(x));
		//System.out.printf("   x=%.9f\n", x);


	}

}
