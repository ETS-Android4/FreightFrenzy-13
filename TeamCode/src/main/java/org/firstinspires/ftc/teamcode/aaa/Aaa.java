package org.firstinspires.ftc.teamcode.aaa;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Aaa {
    public DcMotor frontLeft, frontRight, backLeft, backRight;
    public DcMotor lifter;
    public CRServo grabber, flipper;
    public DcMotor spinner;

    private LinearOpMode opMode;

    public Aaa(LinearOpMode opMode) {
        this.opMode = opMode;

        initMotors();
        initServos();
    }

    public void initMotors() {
        frontLeft = getMotor("front_left");
        frontRight = getMotor("front_right");
        backLeft = getMotor("back_left");
        backRight = getMotor("back_right");

        lifter = getMotor("lifter");
        spinner = getMotor("spinner");

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        lifter.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private DcMotor getMotor(String name) {
        return opMode.hardwareMap.get(DcMotor.class, name);
    }

    public void initServos() {
        grabber = getServo("grabber");
        flipper = getServo("flipper");
    }

    private CRServo getServo(String name) {
        return opMode.hardwareMap.get(CRServo.class, name);
    }

    public void setPower(double power) {
        setPower(power, power, power, power);
    }

    public void setPower(double fl, double fr, double bl, double br) {
        frontLeft.setPower(fl);
        frontRight.setPower(fr);
        backLeft.setPower(bl);
        backRight.setPower(br);
    }
}
