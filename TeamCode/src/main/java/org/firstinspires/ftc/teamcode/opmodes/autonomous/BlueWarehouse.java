package org.firstinspires.ftc.teamcode.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="BlueWarehouse", group="main")
public class BlueWarehouse extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(this);

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

        robot.travelFor(500);
        robot.turn(90);
        robot.travelFor(1500);
    }
}
