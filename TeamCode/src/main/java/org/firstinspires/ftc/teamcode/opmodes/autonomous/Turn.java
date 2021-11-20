package org.firstinspires.ftc.teamcode.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="Turn", group="main")
public class Turn extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(this);
        robot.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();

        robot.turn(90);
        sleep(1000);
    }
}
