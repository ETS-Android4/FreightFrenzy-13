package org.firstinspires.ftc.teamcode.baloney.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

@Autonomous(name="\uD83D\uDD3A Carousel-only", group="baloney")
@Disabled
public class RedCarouselOnly extends LinearOpMode {
    private Baloney robot;

    @Override
    public void runOpMode() {
        robot = new Baloney(this);
        waitForStart();

        robot.travelFor(350, -0.4);
        robot.setPower(-0.5, 0);
        sleep(1500);
        robot.setPower(0);

        robot.spinFor(6000, -0.3);
        robot.travelFor(250, 0.35);

    }
}
