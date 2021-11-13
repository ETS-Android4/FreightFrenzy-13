package org.firstinspires.ftc.teamcode.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

public class BlueCarousel extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(this);
        waitForStart();

        int index = robot.recognize();
        switch(index) {
            case -1:
                break;
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }

        robot.spinner.setPower(1.0);
        sleep(3000);
        robot.spinner.setPower(0.0);
    }
}
