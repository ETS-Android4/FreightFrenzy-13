package org.firstinspires.ftc.teamcode.baloney.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

import disabled.doggy4.Robot;

@Autonomous(name="Park", group="baloney")
@Disabled
public class Park extends LinearOpMode {
    private Baloney robot;

    @Override
    public void runOpMode() {
        robot = new Baloney(this);
        robot.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        robot.travelFor(400);
    }
}
