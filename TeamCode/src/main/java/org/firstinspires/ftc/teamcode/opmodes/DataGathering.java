package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

import java.util.Locale;

@TeleOp(name="DataGathering", group="testing")
public class DataGathering extends LinearOpMode {
    public Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(this);
        waitForStart();
        while(opModeIsActive()) {
            telemetry.addData("IMU", robot.imu.getAngularOrientation());
            telemetry.addData("FL", robot.frontLeft.getCurrentPosition());
            telemetry.addData("FR", robot.frontRight.getCurrentPosition());
            telemetry.addData("BL", robot.backLeft.getCurrentPosition());
            telemetry.addData("BR", robot.backRight.getCurrentPosition());

            telemetry.update();
        }
    }
}
