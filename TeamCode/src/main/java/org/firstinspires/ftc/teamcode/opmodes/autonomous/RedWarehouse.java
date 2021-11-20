package org.firstinspires.ftc.teamcode.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="RedWarehouse", group="main")
public class RedWarehouse extends LinearOpMode {
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
