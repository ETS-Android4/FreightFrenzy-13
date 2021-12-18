package org.firstinspires.ftc.teamcode.baloney.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

@Autonomous(name="\uD83D\uDD35 Carousel-only", group="baloney")
//@Disabled
public class BlueCarouselOnly extends LinearOpMode {
    private Baloney robot;

    @Override
    public void runOpMode() {
        robot = new Baloney(this);
        robot.team(robot.BLUE);

        robot.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();

        robot.travelFor(450, -0.5);

        robot.spinFor(6000, 0.3);

    }
}
