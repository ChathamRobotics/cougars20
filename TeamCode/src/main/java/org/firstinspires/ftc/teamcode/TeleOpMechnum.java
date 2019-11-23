package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import java.lang.*;

//11248 //Cougars Property >:D

@TeleOp(name = "TeleOpMechnum", group = "LinearOpMode")

public class TeleOpMechnum extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront, rightFront, leftRear, rightRear, intakeMotor1, intakeMotor2, liftmotorLeft, liftmotorRight;
    private Servo iHold, fGrab1, fGrab2, claw, fBar1, fBar2;
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
        intakeMotor1 = hardwareMap.get(DcMotor.class, "intakeMotor1");
        intakeMotor2 = hardwareMap.get(DcMotor.class, "intakeMotor2");
        intakeMotor1.setDirection(DcMotor.Direction.REVERSE);
        intakeMotor2.setDirection(DcMotor.Direction.FORWARD);

        //Lift hardware mapping
        liftmotorLeft = hardwareMap.get(DcMotor.class, "liftmotorLeft");
        liftmotorRight = hardwareMap.get(DcMotor.class, "liftmotorRight");
        liftmotorLeft.setDirection(DcMotor.Direction.REVERSE);
        liftmotorRight.setDirection(DcMotor.Direction.FORWARD);

        //Servo hardware mapping
        iHold = hardwareMap.get(Servo.class, "iHold");
        fGrab1 = hardwareMap.get(Servo.class, "fGrab1");
        fGrab2 = hardwareMap.get(Servo.class, "fGrab2");
        claw = hardwareMap.get(Servo.class, "claw");
        fBar1 = hardwareMap.get(Servo.class, "fBar1");
        fBar2 = hardwareMap.get(Servo.class, "fBar2");



        waitForStart();
        runtime.reset();

        telemetry.addData("init","init");
        telemetry.update();

        while (opModeIsActive()){
            //turn using gamepad 1 bumpers.
            if (gamepad1.right_bumper) {
                leftFront.setPower(.8);
                rightFront.setPower(.8);
                leftRear.setPower(.8);
                rightRear.setPower(.8);
            } else if (gamepad1.left_bumper) {
                leftFront.setPower(-.8);
                rightFront.setPower(-.8);
                leftRear.setPower(-.8);
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
                leftFront.setPower(-gamepad1.right_stick_x);
                leftRear.setPower(-gamepad1.right_stick_x);
                rightFront.setPower(-gamepad1.right_stick_x);
                rightRear.setPower(gamepad1.right_stick_x);
            }
              //intake system is controlled here
                if(gamepad2.right_trigger !=0)
                {
                    intakeMotor1.setPower(1);
                    intakeMotor2.setPower(1);
                }
                else if(gamepad2.right_bumper)
                {
                    intakeMotor1.setPower(-1);
                    intakeMotor2.setPower(-1);
                }
                else
                {
                    intakeMotor1.setPower(0);
                    intakeMotor2.setPower(0);
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

                if(gamepad2.y) {
                    if (iHold.getPosition() != 0) {
                        iHold.setPosition(0);
                    } else {
                        iHold.setPosition(45);
                    }
                    sleep(200);
                }
                    if(gamepad2.b) {

                        if (fGrab1.getPosition() != 0 || fGrab2.getPosition() != 0) {
                            fGrab1.setPosition(0);
                            fGrab2.setPosition(0);
                        }
                        else
                        {
                            fGrab1.setPosition(-90);
                            fGrab2.setPosition(-90);
                        }
                        sleep(200);
                    }
                    if(gamepad2.x)
                    {
//                        if (fBar1.getPosition() != -5 || fBar2.getPosition() != 0)
//                        {
//                            fBar1.setPosition(-5);
//                            fBar2.setPosition(0);
//                        }
//                        else {
//                            fBar1.setPosition(-5);
//                            fBar2.setPosition(0);
//                        }
                        fBar1.setPosition(fBar1.getPosition()+2);
                        fBar2.setPosition(fBar2.getPosition()-2);
                        sleep(200);
                    }
                    if(gamepad2.a)
                    {
                        if (claw.getPosition() !=0)
                        {
                            claw.setPosition(0);
                        }
                        else {
                            claw.setPosition(90);
                        }
                        sleep(200);
                    }












        }
    }}

