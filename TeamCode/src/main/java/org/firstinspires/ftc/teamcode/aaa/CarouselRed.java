package org.firstinspires.ftc.teamcode.aaa;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="AaaCarouselRed", group="aaa")
public class CarouselRed extends LinearOpMode {
    private Aaa robot;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Aaa(this);

        waitForStart();

        robot.setPower(-0.5);
        sleep(1000);
        robot.setPower(0);
    }
}
