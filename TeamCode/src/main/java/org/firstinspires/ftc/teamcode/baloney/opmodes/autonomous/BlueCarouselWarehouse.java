package org.firstinspires.ftc.teamcode.baloney.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

import disabled.doggy4.Robot;

@Autonomous(name="\uD83D\uDD35 Carousel-Warehouse", group="baloney")
@Disabled
public class BlueCarouselWarehouse extends LinearOpMode {
    private Baloney robot;

    @Override
    public void runOpMode() {
        robot = new Baloney(this);
        robot.team(robot.BLUE);
        waitForStart();

        //region Spin Carousel
        robot.setPower(0.0, -0.5);
        sleep(500);
        robot.setPower(0);

        robot.spinFor(6000, 0.3);
        //endregion
        sleep(15000);
        //region Drive to Warehouse
        robot.travelFor(1500,0.7);
        robot.setPower(0.5, 0.7);
        sleep(1500);
        robot.setPower(0);
        //endregion


    }
}
