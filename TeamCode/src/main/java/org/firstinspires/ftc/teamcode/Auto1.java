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

@Autonomous(name = "Auto1", group = "LinearOpMode")

public class Auto1 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private int McEvoyContainer;
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

        ElapsedTime runtime = new ElapsedTime();

        while (opModeIsActive() && (runtime.seconds() <= 0.5 ))
        {
            fGrabLeft.setPosition(0);
            fGrabRight.setPosition(90);
            leftFront.setPower(.5);
            rightFront.setPower(.5);
            leftRear.setPower(.5);
            rightRear.setPower(.5);
        }













    }
}



