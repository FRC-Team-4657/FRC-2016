
package org.usfirst.frc.team4657.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
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

	Double SpeedSelected;
	Double SpeedSelected1;
   

    Double speedSelected;
    Double speedSelected1;
    

    CameraServer server;
    RobotDrive myRobot;
    Joystick stick1;
    Joystick stick2;

    boolean screwed;
   	Talon leftTalon = new Talon(0);
	Talon rightTalon = new Talon(1);
	Talon screwTalon = new Talon(2);
	Talon ballTalon = new Talon(3);
   
    
	double Counter = 0.0;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {    

        myRobot = new RobotDrive(leftTalon,rightTalon);
    	stick1 = new Joystick(0);
    	stick2 = new Joystick(1);
    	myRobot.setInvertedMotor(MotorType.kFrontLeft, true);
        myRobot.setInvertedMotor(MotorType.kFrontRight, true);

    	
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
    	while(Counter < 100){
    		myRobot.tankDrive(1.0,1.0);
    		
    	}
    	myRobot.tankDrive(stick1, stick2);

  
    	
    }
    
    public void teleopInit() {

        
   
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	myRobot.tankDrive(stick1, stick2);
}
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}

