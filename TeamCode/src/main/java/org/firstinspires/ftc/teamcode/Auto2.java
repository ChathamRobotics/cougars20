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

        ElapsedTime runtime = new ElapsedTime();

            while (opModeIsActive() && (runtime.seconds() <= 0.95 ))
            {
                fGrabLeft.setPosition(0);
                fGrabRight.setPosition(90);
                leftFront.setPower(.75);
                rightFront.setPower(.75);
                leftRear.setPower(.75);
                rightRear.setPower(.75);
            }
            while (opModeIsActive() && (runtime.seconds() > 0.95 ) && (runtime.seconds() <= 3))
            {
                leftFront.setPower(0);
                rightFront.setPower(0);
                leftRear.setPower(0);
                rightRear.setPower(0);
                sleep(100);
                fGrabLeft.setPosition(90);
                fGrabRight.setPosition(0);

            }
            //This has the robot move the plate into the appropriate zone
            while (opModeIsActive() && (runtime.seconds() > 3) && (runtime.seconds() <= 4.9))
            {
                leftFront.setPower(-.5);
                rightFront.setPower(-.5);
                leftRear.setPower(-.5);
                rightRear.setPower(-.5);
            }
        while (opModeIsActive() && (runtime.seconds() > 4.9 ) && (runtime.seconds() <= 5.65)) {
            fGrabLeft.setPosition(0);
            fGrabRight.setPosition(90);
        }
        /*
            //This has the robot strafe over to the parking zone
            while (opModeIsActive() && (runtime.seconds() > 5.65 ) && (runtime.seconds() <= 10.65))
            {
                leftFront.setPower(1);
                rightFront.setPower(-1);
                leftRear.setPower(-1);
                rightRear.setPower(1);
            }
*/












    }
}



