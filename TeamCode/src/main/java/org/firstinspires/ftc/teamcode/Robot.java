package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    public DcMotor leftBack = null;

    private HardwareMap hwMap = null;

    public void init(OpMode opMode) {
        hwMap = opMode.hardwareMap;

        leftBack = hwMap.get(DcMotor.class, "left_back");

        leftBack.setDirection(DcMotor.Direction.FORWARD);
    }

    public void setPower(double power) {
        leftBack.setPower(power);
    }


}
