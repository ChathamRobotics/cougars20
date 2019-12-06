package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class HardwareMain
{
    // Public OpMode members.
    private DcMotor  leftFront      = null;
    private DcMotor  rightFront     = null;
    private DcMotor  leftRear       = null;
    private DcMotor  rightRear      = null;
    private DcMotor  intakeMotorLeft   = null;
    private DcMotor  intakeMotorRight      = null;
    private DcMotor  liftmotorLeft    = null;
    private DcMotor  liftmotorRight    = null;
    private Servo  iHold    = null;
    private Servo  fGrabLeft    = null;
    private Servo  fGrabRight    = null;
    private Servo  claw    = null;
    private Servo  fBarLeft    = null;
    private Servo  fBarRight    = null;



    // local OpMode members.
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    // Constructor
    public HardwareMain(){

    }

    // Initialize standard Hardware interfaces
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        leftFront = hwMap.get(DcMotor.class, "leftFront");
        rightFront = hwMap.get(DcMotor.class, "rightFront");
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear = hwMap.get(DcMotor.class, "leftRear");
        rightRear = hwMap.get(DcMotor.class, "rightRear");
        leftRear.setDirection(DcMotor.Direction.FORWARD);
        rightRear.setDirection(DcMotor.Direction.REVERSE);

        //Intake hardware mapping
        intakeMotorLeft = hwMap.get(DcMotor.class, "intakeMotorLeft");
        intakeMotorRight = hwMap.get(DcMotor.class, "intakeMotorRight");
        intakeMotorLeft.setDirection(DcMotor.Direction.FORWARD);
        intakeMotorRight.setDirection(DcMotor.Direction.REVERSE);

        //Lift hardware mapping
        liftmotorLeft = hwMap.get(DcMotor.class, "liftmotorLeft");
        liftmotorRight = hwMap.get(DcMotor.class, "liftmotorRight");
        liftmotorLeft.setDirection(DcMotor.Direction.REVERSE);
        liftmotorRight.setDirection(DcMotor.Direction.FORWARD);

        //Servo hardware mapping
        iHold = hwMap.get(Servo.class, "iHold");
        fGrabLeft = hwMap.get(Servo.class, "fGrabLeft");
        fGrabRight = hwMap.get(Servo.class, "fGrabRight");
        claw = hwMap.get(Servo.class, "claw");
        fBarLeft = hwMap.get(Servo.class, "fBarLeft");
        fBarRight = hwMap.get(Servo.class, "fBarRight");


        // Set all motors to zero power
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftRear.setPower(0);
        rightRear.setPower(0);
        intakeMotorLeft.setPower(0);
        intakeMotorRight.setPower(0);
        liftmotorLeft.setPower(0);
        liftmotorRight.setPower(0);




    }
}

