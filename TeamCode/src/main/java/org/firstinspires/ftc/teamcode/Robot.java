package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

import minipid.MiniPID;

public class Robot {
    public DcMotor frontLeft, frontRight, backLeft, backRight;
    public DcMotor lifter;
    public CRServo grabber;
    public CRServo spinner;
    public BNO055IMU imu;

    private LinearOpMode opMode;
    private MiniPID pid, rpid;

    private static final String VUFORIA_KEY =
            "AV1AlC//////AAABmZ8844uwbEHrg1LUsHVFKxlStW4C7oPMwyIXaVB2lFgVrXI7AcN37g06/oHM+7Smo0UtpZXtGANu2IWFTeqOdHO83zy8s3nw7ZfZ60OUz9L230sZ0liJbP8aeIKa0a0ibeL+mH4zJTOHU/3rdfcv8PbufYdeMh1ImaoFXTXQkMqiELuxK32/kvH/sRyvMg5JmoQDxKgSgNhN/Vle754F6hCOVk1alZE7H5gXHifhPtL0Gf+AhkrfsbKi+zeZ3gRoGLzX54Qq8EUmOhlm5+ZMbdYkx1F4u8FoLczDK+Qt4J23kEqkbCA5HyDJJsmyA30/fEIYDEepO9f86U96LfOCIFt8Q3vFCWSq4IJZphMlVOF7";
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;

    public Robot(LinearOpMode opMode) {
        this.opMode = opMode;

        initPID();
        initMotors();
        initServos();
        initIMU();
//        initVuforia();
//        initTfod();
    }

    private void initPID() {
        pid = new MiniPID(1, 0, 0);
        pid.setOutputLimits(-1.0, 1.0);
        pid.setOutputFilter(0.1);
        rpid = new MiniPID(1, 0, 0);
        rpid.setOutputFilter(0.1);

    }

    private void initMotors() {
        frontLeft = opMode.hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = opMode.hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = opMode.hardwareMap.get(DcMotor.class, "backLeft");
        backRight = opMode.hardwareMap.get(DcMotor.class, "backRight");

        lifter = opMode.hardwareMap.get(DcMotor.class, "lifter");

        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);
    }

    private void initServos() {
        grabber = opMode.hardwareMap.get(CRServo.class, "grabber");
        spinner = opMode.hardwareMap.get(CRServo.class, "spinner");
    }

    private void initIMU() {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu = opMode.hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }

    private void initTfod() {
        int tfodMonitorViewId = opMode.hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", opMode.hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.8f;
        tfodParameters.isModelTensorFlow2 = true;
        tfodParameters.inputSize = 320;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset("FreightFrenzy_BCDM.tflite", "Ball", "Cube", "Duck", "Marker");
        tfod.activate();
    }

    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = opMode.hardwareMap.get(WebcamName.class, "Webcam 1");

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

    /**
     * drive power only
     */
    public void setPower(double power) {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    public void setPower(double fl, double fr, double bl, double br) {
        frontLeft.setPower(fl);
        frontRight.setPower(fr);
        backLeft.setPower(bl);
        backRight.setPower(br);
    }

    public void travelFor(long millis) {
        travelFor(millis, 0.75);
    }

    public void travelFor(long millis, double power) {
        setPower(power);
        opMode.sleep(millis);
        setPower(0);
    }

    public void travelPID(double inches) {
        pid.reset();
        int steps = (int)inches * 1000;
        int old = currentPosition();
        int goal = old + steps;

        long until = now() + 1000;
        while(now() < until && Math.abs(currentPosition() - goal) > 10 && active()) {
            int diff = currentPosition() - goal;

            double output = pid.getOutput(diff, goal);
            setPower(output);
            opMode.sleep(50);
        }
        while(now() < until && active()) {
            int diff = currentPosition() - goal;

            double output = pid.getOutput(diff, goal);
            setPower(output);
            opMode.sleep(50);
        }
    }

    private int currentPosition() {
        return (frontLeft.getCurrentPosition() + frontRight.getCurrentPosition() + backLeft.getCurrentPosition() + backRight.getCurrentPosition())/4;
    }

    private long now() {
        return System.currentTimeMillis();
    }
    private boolean active() {
        return opMode.opModeIsActive();
    }

    private double currentHeading() {
        return -imu.getAngularOrientation().firstAngle;
    }

    public void turn(double degrees) {
        double goal = currentHeading() + degrees;
        rpid.reset();

        long until = now() + 1000;
        while(now() < until && Math.abs(currentHeading() - goal) > 10 && active()) {
            double diff = currentPosition() - goal;

            double output = pid.getOutput(diff, goal);
            setPower(output, -output, output, -output);
            opMode.sleep(50);
        }
        while(now() < until && active()) {
            double diff = currentPosition() - goal;

            double output = pid.getOutput(diff, goal);
            setPower(output, -output, output, -output);
            opMode.sleep(50);
        }
    }

    public void recognize() {
        List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
        for (Recognition recognition : updatedRecognitions) {
            if(recognition.getLabel().equals("hi")) {
                double angle = recognition.estimateAngleToObject(AngleUnit.DEGREES);
            }

        }
    }
}
