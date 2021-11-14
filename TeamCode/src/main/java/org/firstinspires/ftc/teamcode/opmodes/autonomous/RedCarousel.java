package org.firstinspires.ftc.teamcode.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="RedCarousel", group="main")
public class RedCarousel extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(this);
        robot.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
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
