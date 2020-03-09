package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.robotcore.external.ClassFactory;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;

import org.firstinspires.ftc.robotcore.external.matrices.VectorF;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

import java.util.ArrayList;

import java.util.List;



import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;

import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;

import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.YZX;

import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;

import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;



@Autonomous(name="AutoVI", group ="Concept")


public class AutoVI extends LinearOpMode {

    WebcamName webcamName;




    private static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;

    private static final boolean PHONE_IS_PORTRAIT = false;





    private static final String VUFORIA_KEY =

            "AaHZ4HX/////AAABmUKBS4vEjk9Fklm446e72CEUymsNs4n0biEwDRp9JLz8IgtE2EbmyEkbvBRbIbKpGOZzksOpIMsyCxjkM/rXcyML+HagK0BS3rm/G1q0mHa7fR4cVrv+6cThrohhh7tOCglAxVaUnV/GaLIrghdTdam+QazAsRudGYNsS7/KctcjPg7A2CCsLpKw9B1PVvAwaLGOTbSdDetdDTCvbydmJEqJwaXzNKRH01i+RYc3PbtLmlYKym9upNH/Bgumo03oPBJz0hZM59B1tr1DZqfZEwOUSfSljoJ3jEq875srZ1VnVUX8KP1ZoIjn8wPS4gN6JHaDUEhprDMm0hINm9c2CTsUjUGNohdk+ZtnJlJ6fMLY";





    private static final float mmPerInch        = 25.4f;


    private DcMotor leftFront, rightFront, leftRear, rightRear, intakeMotorLeft, intakeMotorRight, liftmotorLeft, liftmotorRight;
    private Servo iHold, fGrabLeft, fGrabRight, claw, fBarLeft, fBarRight;


    private VuforiaLocalizer vuforia = null;

    private float phoneXRotate    = 0;

    private float phoneYRotate    = 0;

    private float phoneZRotate    = 0;



    @Override public void runOpMode() {


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


        webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.cameraName = webcamName;







        parameters.vuforiaLicenseKey = VUFORIA_KEY;

        parameters.cameraDirection   = CAMERA_CHOICE;





        vuforia = ClassFactory.getInstance().createVuforia(parameters);





        VuforiaTrackables targetsSkyStone = this.vuforia.loadTrackablesFromAsset("Skystone");



        VuforiaTrackable stoneTarget = targetsSkyStone.get(0);

        stoneTarget.setName("Stone Target");





        List<VuforiaTrackable> allTrackables = new ArrayList<VuforiaTrackable>();

        allTrackables.addAll(targetsSkyStone);












        /* Notes: The robot's "forward" direction is facing out along X axis, with the LEFT side facing out along the Y axis.
         Z is UP on the robot.  This equates to a bearing angle of Zero degrees. */





        if (CAMERA_CHOICE == BACK) {

            phoneYRotate = -90;

        } else {

            phoneYRotate = 90;

        }



        // Rotate the phone vertical about the X axis if it's in portrait mode

        if (PHONE_IS_PORTRAIT) {

            phoneXRotate = 90 ;

        }







        final float CAMERA_FORWARD_DISPLACEMENT  = 20.5f * mmPerInch;   //Inches in front of robot center

        final float CAMERA_VERTICAL_DISPLACEMENT = 20.5f * mmPerInch;   //above ground

        final float CAMERA_LEFT_DISPLACEMENT     = 21.5f * mmPerInch;



        OpenGLMatrix robotFromCamera = OpenGLMatrix

                .translation(CAMERA_FORWARD_DISPLACEMENT, CAMERA_LEFT_DISPLACEMENT, CAMERA_VERTICAL_DISPLACEMENT)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, YZX, DEGREES, phoneYRotate, phoneZRotate, phoneXRotate));





        for (VuforiaTrackable trackable : allTrackables) {

            ((VuforiaTrackableDefaultListener) trackable.getListener()).setPhoneInformation(robotFromCamera, parameters.cameraDirection);

        }







        waitForStart();







        targetsSkyStone.activate();

        while (!isStopRequested()) {





            if (((VuforiaTrackableDefaultListener) stoneTarget.getListener()).isVisible()) {

                // express position (translation) of stone in millimeters.

                OpenGLMatrix stonePosition = ((VuforiaTrackableDefaultListener) stoneTarget.getListener()).getPose();

                VectorF translation = stonePosition.getTranslation();

                telemetry.addData("Pos (mm)", "{X, Y, Z} = %.1f, %.1f, %.1f",

                        translation.get(0), translation.get(1), translation.get(2));



                // express the rotation of the robot in degrees.

                Orientation rotation = Orientation.getOrientation(stonePosition, EXTRINSIC, XYZ, DEGREES);

                telemetry.addData("Rot (deg)", "{X, Y, Z} = %.0f, %.0f, %.0f", rotation.firstAngle, rotation.secondAngle, rotation.thirdAngle);

            }

            else {

                telemetry.addData("Visible Target", "none");

            }

            telemetry.update();

        }



        // Disable Tracking when we are done;

        targetsSkyStone.deactivate();

    }

}