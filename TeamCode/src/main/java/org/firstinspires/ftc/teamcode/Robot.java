package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    public DcMotor frontLeft, frontRight, backLeft, backRight;

    private HardwareMap hwMap;

    public Robot(OpMode opMode) {
        hwMap = opMode.hardwareMap;

        frontLeft = hwMap.get(DcMotor.class, "frontLeft");
        frontRight = hwMap.get(DcMotor.class, "frontRight");
        backLeft = hwMap.get(DcMotor.class, "backLeft");
        backRight = hwMap.get(DcMotor.class, "backRight");

        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);
    }

    public void setPower(double power) {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }


}
