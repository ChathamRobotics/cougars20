package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import java.lang.*;

@Autonomous(name = "Auto2", group = "LinearOpMode")

public class Auto2 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront, rightFront, leftRear, rightRear, intakeMotorLeft, intakeMotorRight, liftmotorLeft, liftmotorRight;
    private Servo iHold, fGrabLeft, fGrabRight, claw, fBarLeft, fBarRight;
    //right trigger up
    //left trigger down



    @Override
    public void runOpMode() {


        telemetry.addData("init","init");
        telemetry.update();

        //wheel motors hardware mapping
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        leftRear.setDirection(DcMotor.Direction.FORWARD);
        rightRear.setDirection(DcMotor.Direction.REVERSE);

        //Intake hardware mapping
        intakeMotorLeft = hardwareMap.get(DcMotor.class, "intakeMotorLeft");
        intakeMotorRight = hardwareMap.get(DcMotor.class, "intakeMotorRight");
        intakeMotorLeft.setDirection(DcMotor.Direction.FORWARD);
        intakeMotorRight.setDirection(DcMotor.Direction.REVERSE);

        //Lift hardware mapping
        liftmotorLeft = hardwareMap.get(DcMotor.class, "liftmotorLeft");
        liftmotorRight = hardwareMap.get(DcMotor.class, "liftmotorRight");
        liftmotorLeft.setDirection(DcMotor.Direction.REVERSE);
        liftmotorRight.setDirection(DcMotor.Direction.FORWARD);

        //Servo hardware mapping
        iHold = hardwareMap.get(Servo.class, "iHold");
        fGrabLeft = hardwareMap.get(Servo.class, "fGrabLeft");
        fGrabRight = hardwareMap.get(Servo.class, "fGrabRight");
        claw = hardwareMap.get(Servo.class, "claw");
        fBarLeft = hardwareMap.get(Servo.class, "fBarLeft");
        fBarRight = hardwareMap.get(Servo.class, "fBarRight");



        waitForStart();




            //This has the robot move up and then grab the plate
            while (opModeIsActive() && (getRuntime() < 2.2 ))
            {
                leftFront.setPower(-.25);
                rightFront.setPower(-.25);
                leftRear.setPower(-.25);
                rightRear.setPower(-.25);
            }
            while (opModeIsActive() && (getRuntime() > 2.2 ) && (getRuntime() < 3.2))
            {
                fGrabLeft.setPosition(0);
                fGrabRight.setPosition(90);
            }



            //This has the robot move the plate into the appropriate zone
            while (opModeIsActive() && (getRuntime() > 3.2 ) && (getRuntime() < 5.7))
            {
                leftFront.setPower(.25);
                rightFront.setPower(.25);
                leftRear.setPower(.25);
                rightRear.setPower(.25);
            }
            //This has the robot strafe over to the parking zone
            while (opModeIsActive() && (getRuntime() > 5.7 ) && (getRuntime() < 11.7))
            {
                fGrabLeft.setPosition(90);
                fGrabRight.setPosition(0);
                leftFront.setPower(.25);
                rightFront.setPower(-.25);
                leftRear.setPower(-.25);
                rightRear.setPower(.25);
            }













    }
}



