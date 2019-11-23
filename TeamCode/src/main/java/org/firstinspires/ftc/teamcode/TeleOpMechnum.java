package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;

import java.lang.*;

//11248 //Cougars Property >:D

@TeleOp(name = "TeleOpMechnum", group = "LinearOpMode")

public class TeleOpMechnum extends LinearOpMode {

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
        runtime.reset();

        telemetry.addData("init","init");
        telemetry.update();

        while (opModeIsActive()){
            //turn using gamepad 1 bumpers.
            if (gamepad1.right_bumper) {
                leftFront.setPower(-.8);
                rightFront.setPower(.8);
                leftRear.setPower(-.8);
                rightRear.setPower(.8);
            } else if (gamepad1.left_bumper) {
                leftFront.setPower(.8);
                rightFront.setPower(-.8);
                leftRear.setPower(.8);
                rightRear.setPower(-.8);


                //strafe using gamepad 1 triggers.
            } else if (gamepad1.right_trigger != 0) {
                leftFront.setPower(-1);
                rightFront.setPower(1);
                leftRear.setPower(1);
                rightRear.setPower(-1);
            } else if (gamepad1.left_trigger != 0) {
                leftFront.setPower(1);
                rightFront.setPower(-1);
                leftRear.setPower(-1);
                rightRear.setPower(1);

            } else {
                //gamepad 1 lift joystick up and down = drive foward backward

                leftFront.setPower(gamepad1.left_stick_y);
                rightFront.setPower(gamepad1.left_stick_y);
                leftRear.setPower(gamepad1.left_stick_y);
                rightRear.setPower(gamepad1.left_stick_y);
                //gamepad 1 right joystick left and right = turn

                }
              //intake system is controlled here
                if(gamepad2.right_trigger !=0)
                {
                    intakeMotorLeft.setPower(1);
                    intakeMotorRight.setPower(1);
                }
                else if(gamepad2.right_bumper)
                {
                    intakeMotorLeft.setPower(-1);
                    intakeMotorRight.setPower(-1);
                }
                else
                {
                    intakeMotorLeft.setPower(0);
                    intakeMotorRight.setPower(0);
                }

                //lift system controlled here
                if(gamepad2.left_trigger !=0)
                {
                    liftmotorLeft.setPower(1);
                    liftmotorRight.setPower(1);
                }

                else if(gamepad2.left_bumper)
                {
                    liftmotorLeft.setPower(-1);
                    liftmotorRight.setPower(-1);
                }
                else
                {
                    liftmotorLeft.setPower(0);
                    liftmotorRight.setPower(0);
                }

                //intake holder movement
                if(gamepad2.dpad_left) {
                    iHold.setPosition(0);
                    sleep(50);
                }
                if(gamepad2.dpad_right) {
                    iHold.setPosition(.5);
                }

                //grabber movement
                if(gamepad2.dpad_up) {
                    fGrabLeft.setPosition(90);
                    fGrabRight.setPosition(0);
                }
                if(gamepad2.dpad_down) {
                    fGrabLeft.setPosition(0);
                    fGrabRight.setPosition(90);
                }

                // bar movement
                if(gamepad2.x) {
                    fBarLeft.setPosition(fBarLeft.getPosition()+.05);
                    fBarRight.setPosition(fBarRight.getPosition()-.05);
                }
                if(gamepad2.b) {
                    fBarLeft.setPosition(fBarLeft.getPosition()-.05);
                    fBarRight.setPosition(fBarRight.getPosition()+.05);
                    sleep(1);
                }



                //claw movement
                if(gamepad2.a) {
                    claw.setPosition(0);
                }
                if(gamepad2.y) {
                    claw.setPosition(90);
                }












        }
    }}

