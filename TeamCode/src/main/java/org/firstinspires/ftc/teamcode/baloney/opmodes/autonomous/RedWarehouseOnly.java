package org.firstinspires.ftc.teamcode.baloney.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import disabled.doggy4.Robot;

@Autonomous(name="\uD83D\uDD3A Warehouse-only", group="baloney")
//@Disabled
@Disabled

public class RedWarehouseOnly extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(this);
        robot.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        int i = robot.recognize();
        //move to grabby thing
        switch(i) {
            case -1:
                break;
            case 0:

                break;
            case 1:
                break;
            case 2:
                break;
        }

        robot.travelFor(400);
        robot.travelFor(100, -0.5);
        sleep(50);
        robot.turn(90);
        robot.travelFor(1500);
    }
}
