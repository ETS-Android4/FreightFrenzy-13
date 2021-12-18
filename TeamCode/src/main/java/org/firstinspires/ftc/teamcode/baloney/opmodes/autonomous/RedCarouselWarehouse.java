package org.firstinspires.ftc.teamcode.baloney.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

import disabled.doggy4.Robot;

@Autonomous(name="\uD83D\uDD3A Carousel-Warehouse", group="baloney")
//@Disabled
public class RedCarouselWarehouse extends LinearOpMode {
    private Baloney robot;

    @Override
    public void runOpMode() {
        robot = new Baloney(this);
        robot.team(robot.RED);

        robot.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();

        robot.travelFor(450, -0.5);

        robot.spinFor(6000, 0.3);

        sleep(15000);

        robot.travelFor(2000,0.7);
//
//        robot.travelFor(1000, -0.5);
//        robot.turn(90);

    }
}
