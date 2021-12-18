package org.firstinspires.ftc.teamcode.baloney.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

@Autonomous(name="\uD83D\uDD35 Carousel-Warehouse-Turn", group="baloney")
//@Disabled
public class BlueCarouselWarehouseTurn extends LinearOpMode {
    private Baloney robot;

    @Override
    public void runOpMode() {
        robot = new Baloney(this);
        robot.team(robot.BLUE);

        robot.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();

        robot.travelFor(450, -0.5);

        robot.spinFor(6000, 0.3);

        sleep(15000);

        robot.turnFor(300, 0.3);

        robot.travelFor(500,0.5);

        robot.turnFor(400, -0.3);

        robot.travelFor(1500,0.7);
//
//        robot.travelFor(1000, -0.5);
//        robot.turn(90);

    }
}
