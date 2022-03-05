package org.firstinspires.ftc.teamcode.aaa;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="AaaPark", group="aaa")
public class Park extends LinearOpMode {
    private Aaa robot;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Aaa(this);

        waitForStart();

        robot.setPower(0.75);
        sleep(2000);
        robot.setPower(0);
    }
}
