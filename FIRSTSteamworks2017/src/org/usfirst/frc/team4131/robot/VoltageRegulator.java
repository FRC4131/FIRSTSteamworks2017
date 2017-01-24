package org.usfirst.frc.team4131.robot;

public class VoltageRegulator {
	double lMP1, lMP2, rMP1, rMP2;
	double lMPP1, lMPP2, rMPP1, rMPP2;
	double totalVoltage = 0;
	double[] all;
	double[] allPercent;
	public void getVoltage(){
		lMP1 = 25;
		lMP2 = 25;
		rMP1 = 25;
		rMP2 = 25;
		double[] all = {lMP1, lMP2, rMP1, rMP2};
		for(int i = 0; i < all.length; i++){
			System.out.println(all[i] + " ");
			totalVoltage = totalVoltage + all[i];
			System.out.println(totalVoltage);
		}
	}
	
	
	public void voltage(){
		lMPP1 = totalVoltage / lMP1;
		lMPP2 = totalVoltage / lMP2;
		rMPP1 = totalVoltage / rMP1;
		rMPP2 = totalVoltage / rMP2;
		double[] allPercent = {lMPP1, lMPP2, rMPP1, rMPP2};
		double previous = 0.0;
		double temp = 0.0;
		int temp2 = 1;
		String[] names = {"none", "leftMotor1", "leftMotor2", "rightMotor1", "rightMotor2"};
		for(int i = 0; i < allPercent.length; i++){
			if(allPercent[i] > previous){
				temp = allPercent[i];
				temp2 = i;
			}
			
			System.out.println(allPercent[i] + " ");
			previous = allPercent[i];
		}
		System.out.println(names[temp2] + " at a total percent of " + temp);
	}
}
