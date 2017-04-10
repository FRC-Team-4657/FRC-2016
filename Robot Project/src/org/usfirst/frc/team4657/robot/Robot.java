
package org.usfirst.frc.team4657.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    final Double defaultSpeed = 0.5;
    final Double slowerSpeed = 0.25;
    final Double fasterSpeed = 0.75;
    final Double fastestSpeed = 1.0;
    Double speedSelected;
    SendableChooser chooserSpeed;
    
    Compressor aCompressor;

    CameraServer server;
    RobotDrive myRobot;
    Joystick stick1;
    Joystick stick2;

    boolean screwed;

    Talon screwTalon = new Talon(2);
    Talon ballTalon = new Talon(3)
    
    Solenoid singleSolenoid = new Solenoid(0);

    
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {    
        myRobot = new RobotDrive(0,1);
    	stick1 = new Joystick(0);
    	stick2 = new Joystick(1);

    	
    	/*
    	chooserSpeed = new SendableChooser();
        chooserSpeed.addDefault("Default Speed : 0.5", defaultSpeed);
        chooserSpeed.addObject("Speed Option : 0.25", slowerSpeed);
        chooserSpeed.addObject("Speed Option : 0.75", fasterSpeed);
        chooserSpeed.addObject("Speed Option : 1.0", fastestSpeed);
        */
        /*
    	server = CameraServer.getInstance();
        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam0");
        */


        
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {

    }
    	
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
  
    	
    }
    
    public void telepoInit() {

        
   
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	myRobot.tankDrive(stick1, stick2);
    	
    		

    	//speedSelected = (Double) chooserSpeed.getSelected();
    	speedSelected = 1.0;
        speedSelected1 = 1.0;
    	//if (speedSelected == null){
    	//	speedSelected = 0.5;
    	//}
        //SmartDashboard.putNumber("Speed Selected: ", speedSelected);
    	SmartDashboard.putBoolean("Left Trigger Enagaged: ", stick1.getTrigger());
    	SmartDashboard.putBoolean("Right Trigger Enagaged: ", stick2.getTrigger());
    	
    	
    	
    	if (stick1.getTrigger() == true){
    		screwTalon.set(speedSelected); 	
    	   Timer.delay(0.005);		// wait for a motor update time
        }

        if (stick1.getTrigger() == false){
            screwTalon.set(0.0);  
           Timer.delay(0.005);      // wait for a motor update time
        }


        if (stick2.getTrigger() == true){
            ballTalon.set(speedSelected1);  
           Timer.delay(0.005);      // wait for a motor update time
        }
        if (stick2.getTrigger() == false){
            ballTalon.set(0.0);  
           Timer.delay(0.005);      // wait for a motor update time
        }



}
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}

