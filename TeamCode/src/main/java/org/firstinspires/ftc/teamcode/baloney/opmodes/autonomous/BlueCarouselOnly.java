package org.firstinspires.ftc.teamcode.baloney.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

@Autonomous(name="\uD83D\uDD35 Carousel-only", group="baloney")
@Disabled
public class BlueCarouselOnly extends LinearOpMode {
    private Baloney robot;

    @Override
    public void runOpMode() {
        robot = new Baloney(this);
        robot.team(robot.BLUE);
        waitForStart();

        robot.setPower(0.0, -0.5);
        sleep(500);
        robot.setPower(0);

        robot.spinFor(6000, 0.3);
        robot.travelFor(250, 0.35);

    }
}
