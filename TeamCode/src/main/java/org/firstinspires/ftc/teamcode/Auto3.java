package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous(name = "Auto3", group = "LinearOpMode")
public class Auto3 extends LinearOpMode {
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
        //move forward for .25 sec and lift grabbers
        while (opModeIsActive() && (runtime.seconds() <= 0.25 ))
        {
            fGrabLeft.setPosition(0);
            fGrabRight.setPosition(90);
            leftFront.setPower(.5);
            rightFront.setPower(.5);
            leftRear.setPower(.5);
            rightRear.setPower(.5);
        }

        //turn left for .25 sec

            //turn right for .25 sec
            while (opModeIsActive()&&(runtime.seconds() <= 0.6 ))
            {
                leftFront.setPower(.5);
                rightFront.setPower(-.5);
                leftRear.setPower(.5);
                rightRear.setPower(-.5);
            }

        //move forward for .25 sec

            while (opModeIsActive() && (runtime.seconds() <= 1.25 ))
            {

                leftFront.setPower(.5);
                rightFront.setPower(.5);
                leftRear.setPower(.5);
                rightRear.setPower(.5);
            }

        //turn right for .25 sec

            //turn left for .25 sec
            while (opModeIsActive() && (runtime.seconds() <= 1.5))
            {

                leftFront.setPower(-.5);
                rightFront.setPower(.5);
                leftRear.setPower(-.5);
                rightRear.setPower(.5);
            }

        //move forward to build plate for .8 sec

            while (opModeIsActive() &&(runtime.seconds() <= 2.3 ))
            {

                leftFront.setPower(.5);
                rightFront.setPower(.5);
                leftRear.setPower(.5);
                rightRear.setPower(.5);
            }

        //grab build plate for .7 sec

            //grab build plate for .8 sec
            while (opModeIsActive() && (runtime.seconds() <= 2.8))
            {
                leftFront.setPower(0);
                rightFront.setPower(0);
                leftRear.setPower(0);
                rightRear.setPower(0);
                sleep(100);
                fGrabLeft.setPosition(90);
                fGrabRight.setPosition(0);

            }

        //This has the robot move the plate into the appropriate zone - moves backwards for 2.8 sec

            while (opModeIsActive() && (runtime.seconds() <= 4.5))
            {
                leftFront.setPower(-.5);
                rightFront.setPower(-.5);
                leftRear.setPower(-.5);
                rightRear.setPower(-.5);
            }
        while (opModeIsActive() && (runtime.seconds() <= 5.8))
        {
            leftFront.setPower(.5);
            rightFront.setPower(-.5);
            leftRear.setPower(.5);
            rightRear.setPower(-.5);
        }

        //lift up grabbers for .7 sec
        while (opModeIsActive() &&  (runtime.seconds() <= 6)) {
            fGrabLeft.setPosition(0);
            fGrabRight.setPosition(90);
        }
        while (opModeIsActive() && (runtime.seconds() <= 6.4))
        {
            leftFront.setPower(.5);
            rightFront.setPower(-.5);
            leftRear.setPower(.5);
            rightRear.setPower(-.5);
        }
        while (opModeIsActive() && (runtime.seconds() <= 7.7)) {
            leftFront.setPower(-.5);
            rightFront.setPower(-.5);
            leftRear.setPower(-.5);
            rightRear.setPower(-.5);
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
