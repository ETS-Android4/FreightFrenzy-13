package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name="DriverControlled", group="Linear Opmode")
public class DriverControlled extends LinearOpMode {

    // Declare OpMode members.
    private final Robot robot = new Robot(this);

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        while (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y - gamepad1.right_stick_y;
            double turn = gamepad1.left_stick_x;
            double strafe = gamepad1.right_stick_x;
            robot.setPower(
                    drive + turn - strafe,
                    drive - turn + strafe,
                    drive + turn + strafe,
                    drive - turn - strafe);

            if (gamepad1.dpad_up) {
                robot.extender.setPower(1.0);
            } else if (gamepad1.dpad_down) {
                robot.extender.setPower(-1.0);
            } else
                robot.extender.setPower(0.0);


            if (gamepad1.dpad_right) {
                robot.grabber.setPosition(0.5);
            } else if (gamepad1.dpad_left) {
                robot.grabber.setPosition(1.0);
            }

            if (gamepad1.right_bumper) {
                robot.spinner.setPower(1.0);
            } else if (gamepad1.left_bumper) {
                robot.spinner.setPower(-1.0);
            } else
                robot.spinner.setPower(0);


        }
    }
}
