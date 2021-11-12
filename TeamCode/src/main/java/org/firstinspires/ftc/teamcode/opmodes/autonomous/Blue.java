package org.firstinspires.ftc.teamcode.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="Blue", group="main")
public class Blue extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(this);

        waitForStart();

        robot.travelFor(500);
        robot.turn(90);
        robot.travelFor(1500);
    }
}
