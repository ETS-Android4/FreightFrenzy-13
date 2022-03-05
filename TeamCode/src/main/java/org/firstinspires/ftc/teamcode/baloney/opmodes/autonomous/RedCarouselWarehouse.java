package org.firstinspires.ftc.teamcode.baloney.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

import disabled.doggy4.Robot;

@Autonomous(name="\uD83D\uDD3A Carousel-Warehouse", group="baloney")
@Disabled
public class RedCarouselWarehouse extends LinearOpMode {
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

        sleep(15000);

        robot.travelFor(250, 0.5);
        robot.setPower(0.7, 0);
        sleep(800);
        robot.setPower(0.7, 0.7);
        sleep(500);
        robot.setPower(0.4, 0.7);
        sleep(500);
        robot.setPower(0.7);
        sleep(2200);
        robot.setPower(0);
//
//        robot.travelFor(1000, -0.5);
//        robot.turn(90);

    }
}
